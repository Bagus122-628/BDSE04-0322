$(document).ready(function () {
  $("form").on("submit", function (event) {
    event.preventDefault();
    const valid = validateRegisForm();

    if (valid === true) {
      if (confirm("Submit Form?")) {
        $.post("load_page.jsp", function () {
          loadPage("#user/thank-you");
        });
      }
    }
  });
});

function validateRegisForm() {
  const fullName = $("#full-name-regis");
  const userName = $("#username-regis");
  const email = $("#email-regis");
  const phone = $("#phone-regis");
  const password = $("#password-regis");

  const inputFullName = $("#full-name-regis").val().trim();
  const inputUserName = $("#username-regis").val().trim();
  const inputEmail = $("#email-regis").val().trim();
  const inputPhone = $("#phone-regis").val().trim();
  const inputPassword = $("#password-regis").val().trim();

  // Full Name
  if (inputFullName === null || inputFullName === "") {
    fullName.addClass("error-border").addClass("error-message");
    fullName.attr("placeholder", "Please fill your full name");
    return false;
  } else {
    fullName.removeClass("error-border");
  }

  // Username
  if (inputUserName === null || inputUserName === "") {
    userName.addClass("error-border").addClass("error-message");
    userName.attr("placeholder", "Please fill your username");
    return false;
  } else {
    userName.removeClass("error-border");
  }

  // Email
  if (inputEmail === null || inputEmail === "") {
    email.addClass("error-border").addClass("error-message");
    email.attr("placeholder", "Please fill your email");
    return false;
  } else {
    email.removeClass("error-border");
  }

  // Phone Number
  if (inputPhone === "") {
    phone.addClass("error-border").addClass("error-message");
    phone.attr("placeholder", "Please fill your phone number");
    return false;
  } else {
    phone.removeClass("error-border");
  }

  // Password
  if (inputPassword === "") {
    password.addClass("error-border").addClass("error-message");
    password.attr("placeholder", "Please input your password");
    return false;
  } else if (inputPassword.length <= 6) {
    password.addClass("error-border");
    $(".validator-password")
      .html("Password should be more than 6 characters")
      .css("display", "block");
    return false;
  } else {
    password.removeClass("error-border");
    $(".validator-password").css("display", "none");
  }

  return true;
}
