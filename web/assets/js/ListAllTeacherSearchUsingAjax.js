$(document).ready(function () {
    $("#SearchInput").on('keyup', function () {
         
        var searchString = $("#SearchInput").val();
        console.log(searchString);
        $.ajax({
            url: "/OnlineLearningSystem//ListAllTeacherSearch",
            type: "POST",
            dataType: 'json',
            data:
                    {
                        searchString: searchString
                    },
            success: function (result) {
                console.log(result);
//                $('#tbBody').empty();
//                $('#tbBody').html(result);
            }
        });
    });

});



