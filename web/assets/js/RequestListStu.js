/* 
    Created on : March 10, 2022, 7:45:38 AM
    Author     : Duc Minh
    @type @jQuery
*/
/* top NavBar */
var navItems = document.querySelectorAll(".navbar--top .nav-item");
for (var i = 0; i < navItems.length; i++) {
    navItems[i].addEventListener("click", function () {
        var current = document.querySelector(".navbar--top .active");
        current.className = current.className.replace(" active", "");
        this.className += " active";
    });
}
