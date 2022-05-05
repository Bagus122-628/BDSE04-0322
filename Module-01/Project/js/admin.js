let json = [];

getLocalStorageData();

function getLocalStorageData() {
  for (let i = 0; i < localStorage.length; i++) {
    const formData = localStorage.getItem(localStorage.key(i));

    json.push(JSON.parse(formData));
  }
}

let table = `<tr>`;
json.map((value, index) => {
  table += `<td>${index + 1}</td>
            <td>${value.firstName} ${value.lastName}</td>
            <td>${value.email}</td>
            <td>${value.address}</td>
            <td>${value.phone}</td>
            <td>${value.selectCourse}</td>
            <td>
              <button>Edit</button>
              <button>Delete</button>
            </td>
            </tr>`;
});

document.getElementById("data-table").insertAdjacentHTML("beforeend", table);
