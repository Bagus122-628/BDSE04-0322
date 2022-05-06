$(document).ready(function () {
  $("form").on("submit", function (event) {
    event.preventDefault();
    const valid = validateRegisForm();

    if (valid === true) {
      if (confirm("Submit Form?")) {
        loadPage("#user/thank-you");
        handleLocalStorageData();
      }
    }
  });
});

function handleLocalStorageData() {
  if (localStorage.getItem("formData") === null) {
    let formData = [];

    formData.push({
      firstName: $("#first-name-regis").val(),
      lastName: $("#last-name-regis").val(),
      email: $("#email-regis").val(),
      address: $("#address-regis").val(),
      phone: $("#phone-regis").val(),
      selectCourse: $("#select-regis").val(),
    });

    localStorage.setItem("formData", JSON.stringify(formData));
  } else {
    let storedData = JSON.parse(localStorage.getItem("formData"));

    const formData = {
      firstName: $("#first-name-regis").val(),
      lastName: $("#last-name-regis").val(),
      email: $("#email-regis").val(),
      address: $("#address-regis").val(),
      phone: $("#phone-regis").val(),
      selectCourse: $("#select-regis").val(),
    };

    storedData.push(formData);
    localStorage.setItem("formData", JSON.stringify(storedData));
  }
}

function validateRegisForm() {
  const firstName = $("#first-name-regis");
  const lastName = $("#last-name-regis");
  const email = $("#email-regis");
  const address = $("#address-regis");
  const phone = $("#phone-regis");
  const selectCourse = $("#select-regis");

  const inputFirstName = firstName.val().trim();
  const inputLastName = lastName.val().trim();
  const inputEmail = email.val().trim();
  const inputAddress = address.val().trim();
  const inputPhone = phone.val().trim();
  const inputSelectCourse = selectCourse.val();

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

  // Select Course
  if (inputSelectCourse === "select-valid") {
    selectCourse.addClass("error-border");
    $(".select-validator").css("display", "block").html("Select any course");
    return false;
  }

  return true;
}
