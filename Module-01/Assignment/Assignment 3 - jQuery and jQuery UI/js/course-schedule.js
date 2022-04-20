$(document).ready(function () {
  $("#header1").on("click", () => {
    $("#schedule1").toggleClass("active");
    $("#schedule2").removeClass("active");
    $("#schedule3").removeClass("active");
    $(".arrow.a").toggleClass("active");
  });

  $("#header2").on("click", () => {
    $("#schedule2").toggleClass("active");
    $("#schedule1").removeClass("active");
    $("#schedule3").removeClass("active");
    $(".arrow.b").toggleClass("active");
  });

  $("#header3").on("click", () => {
    $("#schedule3").toggleClass("active");
    $("#schedule1").removeClass("active");
    $("#schedule2").removeClass("active");
    $(".arrow.c").toggleClass("active");
  });
});
