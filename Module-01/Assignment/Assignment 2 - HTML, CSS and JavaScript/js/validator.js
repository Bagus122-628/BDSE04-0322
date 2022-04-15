const form = document.getElementById("form");
const firstName = document.getElementById("fname");
const lastName = document.getElementById("lname");
const email = document.getElementById("email");
const textArea = document.getElementById("textArea");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  checkValidation();
  clearValues();
});

function checkValidation() {
  const inputFName = firstName.value.trim();
  const inputLName = lastName.value.trim();
  const inputEmail = email.value.trim();
  const inputText = textArea.value.trim();

  // First Name
  if (inputFName === null || inputFName === "") {
    document.querySelector(".errorFname").style.display = "block";
    firstName.classList.add("error-border");
    return false;
  } else {
    document.querySelector(".errorFname").style.display = "none";
    firstName.classList.remove("error-border");
  }

  // Last Name
  if (inputLName === null || inputLName === "") {
    document.querySelector(".errorLname").style.display = "block";
    lastName.classList.add("error-border");
    return false;
  } else {
    document.querySelector(".errorLname").style.display = "none";
    lastName.classList.remove("error-border");
  }

  // Email
  if (inputEmail === null || inputEmail === "") {
    document.querySelector(".errorEmail").style.display = "block";
    email.classList.add("error-border");
    return false;
  } else {
    document.querySelector(".errorEmail").style.display = "none";
    email.classList.remove("error-border");
  }

  // Text Area
  if (inputText === null || inputText === "") {
    document.querySelector(".errorText").style.display = "block";
    textArea.classList.add("error-border");
    return false;
  } else {
    document.querySelector(".errorText").style.display = "none";
    textArea.classList.remove("error-border");
  }

  return true;
}

function clearValues() {
  const valid = checkValidation();

  if (valid) {
    alert("Thanks For Your Message!");
    form.reset();
  }
}
