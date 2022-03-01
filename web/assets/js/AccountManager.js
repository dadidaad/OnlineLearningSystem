$(document).ready(function () {

//  Open Edit Account Card
    $("#accountTable .editBtn").click(function () {
        var username = $(this).attr('value');
        console.log(username);
        $.ajax({
            url: "/OnlineLearningSystem/ChangeStatusAccount",
            data: {"username": username},
            type: "GET",
            success: function (result)
            {
                console.log(result);
                $('#editCard').empty();
                $('#editCard').html(result);

            }
        });
    });

//  Search Account following Name or email
    $(".searchBtn").on('click', function () {
        var searchString = $("#searchString").val();
        console.log(searchString);
        $.ajax({
            url: "/OnlineLearningSystem/AccountManagerSearch",
            data: {"searchString": searchString},
            type: "GET",
            success: function (result)
            {
                console.log(result);
                $('#cardBody').empty();
                $('#cardBody').html(result);

            }
        });
    });
});




