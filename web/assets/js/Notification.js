/* 
    Created on : March 10, 2022, 7:45:38 AM
    Author     : Duc Minh
    @type @jQuery
*/
$(document).ready(function() {
    

/*Notification on header*/
if ($(".notiUnread").text() === "0")
    clearNotiTag();

$(".notifications .icon_wrap").click(function () {
    $(this).parent().toggleClass("active");
});
$(document).click(function (event) {
    if ($('.notifications').hasClass('active') && $(event.target).closest(".notifications").length === 0) {
        $('.notifications').toggleClass('active');
        $.ajax({
            url: "ReadNotification",

            type: "GET",
            success: function (result)
            {
                clearNotiTag();
            }
        });
    }
});
/*Read notification */
var clickth = 0;
$(".notifications .icon_wrap").on('click', function () {
    clickth++;
    if (clickth % 2 === 0) {
        $.ajax({
            url: "ReadNotification",
            type: "GET",
            success: function (result)
            {
                clearNotiTag();
            }
        });
    }
});
function clearNotiTag() {
    $(".notiUnread").css("display", "none");
}



/*Notification in user Setting*/

var numberOfCurentItem = parseInt($("#v-pills-notification .noti-item").length);
var totalItem = parseInt($("#v-pills-notification #totalNoti").val());
displayButtonShowmore();
var optionNav = parseInt($("#optionNav").val());
if (isNaN(optionNav))
    optionNav = 0;
$(".nav .navButton").each(function (index) {
    if (index !== optionNav) {
        $(this).removeClass('active');
        $(this).attr('aria-selected', false);
    } else {
        $(this).addClass('active');
        $(this).attr('aria-selected', true);
    }
});
$(".tab-pane").each(function (index) {
    if (index !== optionNav) {
        $(this).removeClass('active');
        $(this).removeClass('show');
    } else {
        $(this).addClass('active');
        $(this).addClass('show');
    }
});
$("#v-pills-notification .btn-close").each(function () {
    $(this).on("click", function () {
        var notiId = ($(this).val());
        $.ajax({
            data: {"notiId": notiId},
            url: "DeleteNotification",
            type: "GET",
            success: function (result)
            {
                totalItem--;
                $("#v-pills-notification #totalNoti").val(totalItem);
                displayButtonShowmore();
            }
        });
    });
});
$("#v-pills-notification #showmoreBtn").click(function () {
    var index = $("#v-pills-notification .noti-item").length;
    $.ajax({
        data: {"index": index},
        url: "ShowmoreNotification",
        type: "GET",
        success: function (result)
        {
            $("#content-noti").append(result);
            $("#v-pills-notification .btn-close").each(function () {
                $(this).on("click", function () {
                    var notiId = ($(this).val());
                    console.log(notiId);
                    $.ajax({
                        data: {"notiId": notiId},
                        url: "DeleteNotification",
                        type: "GET",
                        success: function (result)
                        {
                            totalItem--;
                            $("#v-pills-notification #totalNoti").val(totalItem);
                            displayButtonShowmore();
                        }
                    });
                });
            });
            displayButtonShowmore();
        }
    });
});



function displayButtonShowmore() {
    numberOfCurentItem = parseInt($("#v-pills-notification .noti-item").length);
    totalItem = parseInt($("#v-pills-notification #totalNoti").val());
    if (numberOfCurentItem >= totalItem) {
        $("#v-pills-notification #showmoreBtn").css("display", "none");
    } else if ($("#v-pills-notification .noti-item").length < $("#v-pills-notification #showmoreBtn").attr('value')) {
        $("#v-pills-notification #showmoreBtn").css("display", "block");
    }
}
});