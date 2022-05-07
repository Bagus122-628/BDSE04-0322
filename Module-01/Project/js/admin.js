const sideMenu = document.getElementById("side-menu");
const menuBar = document.getElementById("bar-menu");

menuBar.addEventListener("click", () => {
  sideMenu.classList.toggle("collapse");
});

if (localStorage.getItem("formData") != null) {
  let jsonFormData = JSON.parse(localStorage.getItem("formData"));

  let table = `<tr>`;
  jsonFormData.map((value, index) => {
    table += `<td style="text-align: center;">${index + 1}</td>
              <td>${value.firstName} ${value.lastName}</td>
              <td>${value.email}</td>
              <td>${value.address}</td>
              <td>${value.phone}</td>
              <td>${value.selectCourse}</td>
              <td>
                <button id="${index}" class="btn btn-edit">Edit</button>
                <button id="${index}" class="btn btn-delete">Delete</button>
              </td>
              </tr>`;
  });

  document.getElementById("data-table").insertAdjacentHTML("beforeend", table);
}

// Add Data
const overlayAddData = document.querySelector(".overlay-add-data");
const formAddData = document.querySelector(".add-data");
const btnAdd = document.querySelector(".btn-add");
const btnCancel = document.querySelector(".btn-cancel");

btnAdd.addEventListener("click", () => {
  overlayAddData.classList.add("show");

  formAddData.addEventListener("submit", (event) => {
    event.preventDefault();
    handleLocalStorageData();
    overlayAddData.classList.remove("show");
    formAddData.reset();
    location.reload();
  });
});

btnCancel.addEventListener("click", (event) => {
  event.preventDefault();
  overlayAddData.classList.remove("show");
  formAddData.reset();
});

function handleLocalStorageData() {
  if (localStorage.getItem("formData") === null) {
    let formData = [];

    formData.push({
      firstName: $("#first-name").val(),
      lastName: $("#last-name").val(),
      email: $("#email").val(),
      address: $("#address").val(),
      phone: $("#phone").val(),
      selectCourse: $("#select").val(),
    });

    localStorage.setItem("formData", JSON.stringify(formData));
  } else {
    let storedData = JSON.parse(localStorage.getItem("formData"));

    const formData = {
      firstName: $("#first-name").val(),
      lastName: $("#last-name").val(),
      email: $("#email").val(),
      address: $("#address").val(),
      phone: $("#phone").val(),
      selectCourse: $("#select").val(),
    };

    storedData.push(formData);
    localStorage.setItem("formData", JSON.stringify(storedData));
  }
}

// Delete Data
if (localStorage.getItem("formData") != null) {
  const btnDelete = document.getElementsByClassName("btn-delete");

  for (let btn of btnDelete) {
    btn.addEventListener("click", (event) => {
      const dataID = event.target.id;
      deleteData(dataID);
    });
  }
}

function deleteData(ID) {
  let storedData = JSON.parse(localStorage.getItem("formData"));
  storedData.splice(ID, 1);
  localStorage.setItem("formData", JSON.stringify(storedData));
  location.reload();
}

// Edit Data
if (localStorage.getItem("formData") != null) {
  const btnEdit = document.getElementsByClassName("btn-edit");

  for (let btn of btnEdit) {
    btn.addEventListener("click", (event) => {
      overlayAddData.classList.add("show");
      const dataID = event.target.id;

      editData(dataID);
    });
  }
}

function editData(ID) {
  let storedData = JSON.parse(localStorage.getItem("formData"));

  const { firstName, lastName, email, address, phone, selectCourse } =
    storedData[ID];

  $("#first-name").val(firstName);
  $("#last-name").val(lastName);
  $("#email").val(email);
  $("#address").val(address);
  $("#phone").val(phone);
  $("#select").val(selectCourse);

  formAddData.addEventListener("submit", (event) => {
    event.preventDefault();
    overlayAddData.classList.remove("show");

    storedData[ID] = {
      firstName: $("#first-name").val(),
      lastName: $("#last-name").val(),
      email: $("#email").val(),
      address: $("#address").val(),
      phone: $("#phone").val(),
      selectCourse: $("#select").val(),
    };

    localStorage.setItem("formData", JSON.stringify(storedData));
    formAddData.reset();
    location.reload();
  });
}
