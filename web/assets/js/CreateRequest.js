// Data Table
$(document).ready(function () {
  $("#dataTable").DataTable();
});

//   Select Teacher
var findTeacherButton = document.querySelector(".teacherRecommend--btn"),
        findTeacherButton1 = document.querySelector(".teacherRecommend--btn1"),
  teacherRecommendName = document.querySelector(".teacherRecommend--name"),
  teacherUsernameRcmInput1 = document.getElementById("teacherUsernameRcm1");
  teacherOptions = document.querySelectorAll(".form-check-input"),
  teacherNames = document.getElementsByClassName("teacherName"),
  requestTeacherBtns = document.querySelectorAll(".requestBtn"),
  teacherUsernameRcmInput = document.getElementById("teacherUsernameRcm");


teacherOptions.forEach((element) => {
  element.addEventListener("click", function () {
    console.log(element.getAttribute("value"));
    if (element.getAttribute("value") === "1") {
      yesOption();

    } else noOption();
  });
});
console.log(teacherUsernameRcmInput.getAttribute("value"));
console.log("minh");
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
      teacherUsernameRcmInput.value=element.target.value;
      teacherRecommendName1.value=element.target.value;
    });
  });
}

findTeacherButton1.addEventListener("click",() =>{
    requestTeacherBtns.forEach((element) => {
    element.addEventListener("click", (element) => {
      requestTeacherBtns.forEach((element) => {
        element.classList.remove("select");
      });

      element.target.classList.add("select");
      teacherRecommendName.innerHTML = element.target.getAttribute("value");
      teacherUsernameRcmInput1.value=element.target.value;
//      teacherRecommendName1.value=element.target.value;
    });
  });
});


