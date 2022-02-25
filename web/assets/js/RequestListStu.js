// top NavBar
var navItems = document.querySelectorAll(".navbar--top .nav-item");
for (var i = 0; i < navItems.length; i++) {
    navItems[i].addEventListener("click", function () {
        var current = document.querySelector(".navbar--top .active");
        current.className = current.className.replace(" active", "");
        this.className += " active";
    });
}
