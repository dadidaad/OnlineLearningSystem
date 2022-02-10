// Data Table
$(document).ready(function () {
  $("#dataTable").DataTable();
});

//   Select Teacher
var findTeacherButton = document.querySelector(".teacherRecommend--btn"),
  teacherRecommendName = document.querySelector(".teacherRecommend--name"),
  teacherOptions = document.querySelectorAll(".form-check-input"),
  teacherNames = document.getElementsByClassName("teacherName"),
  requestTeacherBtns = document.querySelectorAll(".requestBtn");

teacherOptions.forEach((element) => {
  element.addEventListener("click", function () {
    console.log(element.getAttribute("value"));
    if (element.getAttribute("value") === "1") {
      yesOption();
    } else noOption();
  });
});
function yesOption() {
  findTeacherButton.style.display = "block";
  setTeacherRecommend();
}
function noOption() {
  findTeacherButton.style.display = "none";
  teacherRecommendName.style.display = "none";
  teacherRecommendName.innerHTML = null;
}
function setTeacherRecommend() {
  teacherRecommendName.style.display = "inline";

  requestTeacherBtns.forEach((element) => {
    element.addEventListener("click", (element) => {
      requestTeacherBtns.forEach((element) => {
        element.classList.remove("select");
      });

      element.target.classList.add("select");
      teacherRecommendName.innerHTML = element.target.getAttribute("value");
    });
  });
}
