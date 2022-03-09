$(document).ready(function () {
    $(".form-check-input").each(function () {
        $(this).on("click", function () {
            var rcmDecision = ($(this).val());
            if (rcmDecision === "1") {
                yesOption();
            } else if (rcmDecision === "0")
                noOption();
        });

    });
    function yesOption() {
        $(".teacherRecommend--btn").css("display", "block");
        $(".teacherRecommend--name").css("display", "inline");
        selectTeacher();
    }
    function noOption() {
        $(".teacherRecommend--btn").css("display", "none");
        $(".teacherRecommend--name").css("display", "none");
        $("#teacherUsernameRcm").val(null);
    }
    function selectTeacher() {
        $("#dataTable .requestBtn").click(function () {
            $('#dataTable .requestBtn.select').not(this).removeClass('select');
            $(this).toggleClass('select');
            var teacherUsername = ($(this).val());
            $("#teacherUsernameRcm").val(teacherUsername);
            $(".teacherRecommend--name").html(teacherUsername);
            $("#teacherRcmName").html($(this).attr("data"))
        });
    }
    function checkTeacher() {
        $('#tbBody tr .requestBtn').each(function () {
            if ($(this).val() === $("#teacherUsernameRcm").val()) {
                $(this).toggleClass("select");
            }
        });
    }
    $("#searchString").on('keyup', function () {
        var searchString = $(this).val();
        var subjectId = $("#rqSubject option:selected").val();
        $.ajax({
            url: "TeacherRecommendSearch",
            data: {"searchString": searchString,
                "subjectId": subjectId},
            type: "POST",
            success: function (result)
            {
                console.log(result);
                $('#dataTable #tbBody').empty();
                $('#dataTable #tbBody').append(result);
                checkTeacher();
                selectTeacher();
            }
        });
    });
});