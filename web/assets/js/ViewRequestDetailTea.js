var answerSection = document.querySelector(".answerCard"),
  acceptBtn = document.querySelector(".acceptBtn"),
  doneBtn = document.querySelector(".doneBtn");

acceptBtn.addEventListener("click", () => {
  answerSection.style.display = "block";
  doneBtn.style.display = "block";
});
