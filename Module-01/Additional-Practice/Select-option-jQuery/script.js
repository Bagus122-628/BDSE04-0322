$(document).ready(function () {
  $("#btn-addBook").on("click", () => {
    const optionText = $("#book").val();
    const optionValue = $("#book").val();

    $("#select").append(
      `<option value="${optionValue}">${optionText}</option>`
    );
    $("#book").val("");
  });
});
