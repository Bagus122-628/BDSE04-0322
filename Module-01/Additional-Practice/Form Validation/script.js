const form = document.getElementById("form");
const firstName = document.getElementById("fname");
const lastName = document.getElementById("lname");
const email = document.getElementById("email");
const number = document.getElementById("number");
const program = document.getElementById("program");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  checkValidation();
  clearValues();
});

function checkValidation() {
  const inputName = firstName.value;
  const inputEmail = email.value;
  const inputNumber = number.value;
  const inputProgram = program.value;

  // Name
  if (inputName === "" || inputName === null) {
    document.querySelector(".errorFname").style.display = "block";
    firstName.classList.add("error-border");
  } else {
    document.querySelector(".errorFname").style.display = "none";
    firstName.classList.remove("error-border");
  }

  // Email
  if (inputEmail === "") {
    document.querySelector(".errorEmail").style.display = "block";
    email.classList.add("error-border");
  } else {
    document.querySelector(".errorEmail").style.display = "none";
    email.classList.remove("error-border");
  }

  // Phone Number
  if (inputNumber === "") {
    document.querySelector(".errorNumber").style.display = "block";
    number.classList.add("error-border");
  } else {
    document.querySelector(".errorNumber").style.display = "none";
    number.classList.remove("error-border");
  }

  // Program
  if (inputProgram === "") {
    document.querySelector(".errorProgram").style.display = "block";
    program.classList.add("error-border");
  } else {
    document.querySelector(".errorProgram").style.display = "none";
    program.classList.remove("error-border");
  }
}

function clearValues() {
  firstName.value = "";
  lastName.value = "";
  email.value = "";
  number.value = "";
  program.value = "";
}
