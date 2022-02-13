// Side Bar
var sidebar = document.querySelector(".sidebar");
var sideBarBtn = document.getElementById("sidebarToggle");
sideBarBtn.addEventListener("click", function () {
  var toggledCheck = document.querySelector(".sidebar").classList.contains("toggled");
  if (toggledCheck) sidebar.classList.remove("toggled");
  else sidebar.classList.add("toggled");
});

// Modal Image
var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var imgs = document.querySelectorAll(".imgZoom");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
imgs.forEach((element) => {
  element.addEventListener("click", function (e) {
    modal.style.display = "block";
    modalImg.src = element.src;
    captionText.innerHTML = element.alt;
  });
});

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close--Img")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
};


