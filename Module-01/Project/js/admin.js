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

if (
  localStorage.getItem("formData") == "[]" ||
  localStorage.getItem("formData") == null
) {
  const noContent = `<tr><td colspan="7" align="center">No Data</td></tr>`;
  document
    .getElementById("data-table")
    .insertAdjacentHTML("beforeend", noContent);
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
    const valid = adminFormValidation();

    if (valid == true) {
      handleLocalStorageData();
      overlayAddData.classList.remove("show");
      formAddData.reset();
      location.reload();
    }
  });
});

btnCancel.addEventListener("click", (event) => {
  event.preventDefault();
  overlayAddData.classList.remove("show");
  formAddData.reset();
});

function handleLocalStorageData() {
  if (localStorage.getItem("formData") != null) {
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
  } else {
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
  }
}

// Delete Data
if (localStorage.getItem("formData") != null) {
  const btnDelete = document.getElementsByClassName("btn-delete");

  for (let btn of btnDelete) {
    btn.addEventListener("click", (event) => {
      const dataID = event.target.id;
      if (confirm("Delete Data?")) {
        deleteData(dataID);
      }
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

    const valid = adminFormValidation();

    if (valid == true) {
      storedData[ID] = {
        firstName: $("#first-name").val(),
        lastName: $("#last-name").val(),
        email: $("#email").val(),
        address: $("#address").val(),
        phone: $("#phone").val(),
        selectCourse: $("#select").val(),
      };

      localStorage.setItem("formData", JSON.stringify(storedData));
      overlayAddData.classList.remove("show");
      formAddData.reset();
      location.reload();
    }
  });
}

// Search / Filter Table
const searchBar = document.querySelector(".search-bar");
searchBar.addEventListener("keyup", () => {
  searchByName();
});

function searchByName() {
  const filter = searchBar.value.toLowerCase();
  const table = document.getElementById("data-table");
  const tr = table.getElementsByTagName("tr");

  for (let i = 0; i < tr.length; i++) {
    const td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      const txtValue = td.textContent || td.innerText;
      if (txtValue.toLowerCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

// Validation
function adminFormValidation() {
  const firstName = $("#first-name");
  const lastName = $("#last-name");
  const email = $("#email");
  const address = $("#address");
  const phone = $("#phone");

  const inputFirstName = firstName.val().trim();
  const inputLastName = lastName.val().trim();
  const inputEmail = email.val().trim();
  const inputAddress = address.val().trim();
  const inputPhone = phone.val().trim();

  // First Name
  if (inputFirstName === null || inputFirstName === "") {
    firstName.addClass("error-border").addClass("error-message");
    firstName.attr("placeholder", "Please fill your first name");
    return false;
  } else {
    firstName.removeClass("error-border");
  }

  // Last Name
  if (inputLastName === null || inputLastName === "") {
    lastName.addClass("error-border").addClass("error-message");
    lastName.attr("placeholder", "Please fill your last name");
    return false;
  } else {
    lastName.removeClass("error-border");
  }

  // Email
  if (inputEmail === null || inputEmail === "") {
    email.addClass("error-border").addClass("error-message");
    email.attr("placeholder", "Please fill your email");
    return false;
  } else {
    email.removeClass("error-border");
  }

  // Address
  if (inputAddress === null || inputAddress === "") {
    address.addClass("error-border").addClass("error-message");
    address.attr("placeholder", "Please fill your address");
    return false;
  } else {
    address.removeClass("error-border");
  }

  // Phone Number
  if (inputPhone === "") {
    phone.addClass("error-border").addClass("error-message");
    phone.attr("placeholder", "Please fill your phone number");
    return false;
  } else {
    phone.removeClass("error-border");
  }

  return true;
}
