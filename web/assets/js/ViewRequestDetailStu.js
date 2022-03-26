/* 
    Created on : March 10, 2022, 7:45:38 AM
    Author     : Duc Minh
    @type @Javascript
*/
/* View More or Hide Topic */
var requestTopicMoreBtn = document.querySelector(".responseContent--info .requestTopicMore");

var requestTopicMoreContent = document.querySelector(".requestStuInfo li .requestStuInfo--topic");
requestTopicMoreBtn.addEventListener("click", function () {
  let hiddenCheck = document
    .querySelector(".requestStuInfo li .requestStuInfo--topic")
    .classList.contains("hiddenTopic");
  if (hiddenCheck) {
    displayAllTopic();
    requestTopicMoreBtn.innerHTML = "Hide";
  } else {
    hideTopic();
    requestTopicMoreBtn.innerHTML = "More";
  }
});
function displayAllTopic() {
  requestTopicMoreContent.classList.remove("hiddenTopic");
}
function hideTopic() {
  requestTopicMoreContent.classList.add("hiddenTopic");
}
