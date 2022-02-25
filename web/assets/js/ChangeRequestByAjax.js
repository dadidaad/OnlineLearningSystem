$(document).ready(function () {
    $("#navbarNav a").click(function () {
        var status = $(this).attr('value');
        console.log("result");
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

