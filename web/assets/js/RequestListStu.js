// top NavBar
var navItems = document.querySelectorAll(".navbar--top .nav-item");
for (var i = 0; i < navItems.length; i++) {
    navItems[i].addEventListener("click", function () {
        var current = document.querySelector(".navbar--top .active");
        current.className = current.className.replace(" active", "");
        this.className += " active";
    });
}
// DataTable
$(document).ready(function () {
    $("#dataTable").DataTable();
});
$(function () {
    $("#navbarNav a").click(function () {
        var status = $(this).attr('value');

        $.ajax({type: "GET",
            url: "/OnlineLearningSystem/ChangeRequestByAjax",
            data: {"rqStatus": status},
            type: "GET",
            success: function (result)
            {
                console.log(result);
                $('#changeData').empty();
                $('#changeData').html(result);
//            alert(status);
                // This will show the values. Change "alert" for $('div#mydiv').html(value) or so
            }
        });
    });
});