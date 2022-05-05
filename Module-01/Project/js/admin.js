let json = [];

getLocalStorageData();

function getLocalStorageData() {
  for (let i = 0; i < localStorage.length; i++) {
    const formData = localStorage.getItem(localStorage.key(i));

    json.push(JSON.parse(formData));
  }
}
