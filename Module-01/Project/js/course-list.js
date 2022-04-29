$(function () {
  $("#tabs1").tabs();
});
$(function () {
  $("#tabs2").tabs();
});

function frontEndList() {
  document.querySelector(".tab-frontend").style.display = "block";
  document.querySelector(".tab-backend").style.display = "none";
}

function backEndList() {
  document.querySelector(".tab-frontend").style.display = "none";
  document.querySelector(".tab-backend").style.display = "block";
}
