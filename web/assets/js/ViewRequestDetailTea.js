/* 
    Created on : March 10, 2022, 7:45:38 AM
    Author     : Duc Minh
    @type @Javascript
*/
var answerSection = document.querySelector(".answerCard"),
  acceptBtn = document.querySelector(".acceptBtn"),
  doneBtn = document.querySelector(".doneBtn");

acceptBtn.addEventListener("click", () => {
  answerSection.style.display = "block";
  doneBtn.style.display = "block";
});
