$(function () {
  $("#tabs1").tabs();
});
$(function () {
  $("#tabs2").tabs();
});

function frontEndList() {
  document.querySelector(".header-CL h2").textContent =
    "Front-End Web Developer";
  document.querySelector(".tab-frontend").classList.add("show");
  document.querySelector(".tab-backend").classList.remove("show");
}

function backEndList() {
  document.querySelector(".header-CL h2").textContent = "Back-End Developer";
  document.querySelector(".tab-frontend").classList.remove("show");
  document.querySelector(".tab-backend").classList.add("show");
}
