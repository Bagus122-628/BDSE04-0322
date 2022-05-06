const sideMenu = document.getElementById("side-menu");
const menuBar = document.getElementById("bar-menu");
const contentTable = document.querySelector(".content-table");
menuBar.addEventListener("click", () => {
  sideMenu.classList.toggle("collapse");
  contentTable.classList.toggle("align-item-center");
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
                <button class="btn btn-edit">Edit</button>
                <button class="btn btn-delete">Delete</button>
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
});

btnCancel.addEventListener("click", (event) => {
  event.preventDefault();
  overlayAddData.classList.remove("show");
  formAddData.reset();
});

formAddData.addEventListener("submit", (event) => {
  event.preventDefault();
  handleLocalStorageData();
  overlayAddData.classList.remove("show");
  location.reload();
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
