$(document).ready(function () {
  $("#header1").on("click", () => {
    $("#schedule1").addClass("active");
    $("#schedule2").removeClass("active");
    $("#schedule3").removeClass("active");

    $(".arrow.a").addClass("active");
    $(".arrow.b").removeClass("active");
    $(".arrow.c").removeClass("active");
  });

  $("#header2").on("click", () => {
    $("#schedule2").addClass("active");
    $("#schedule1").removeClass("active");
    $("#schedule3").removeClass("active");

    $(".arrow.b").addClass("active");
    $(".arrow.a").removeClass("active");
    $(".arrow.c").removeClass("active");
  });

  $("#header3").on("click", () => {
    $("#schedule3").addClass("active");
    $("#schedule1").removeClass("active");
    $("#schedule2").removeClass("active");

    $(".arrow.c").addClass("active");
    $(".arrow.a").removeClass("active");
    $(".arrow.b").removeClass("active");
  });
});
