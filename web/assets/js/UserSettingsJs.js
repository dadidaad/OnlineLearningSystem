/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var lines = 10;
    $('#bio-text').keydown(function (e) {
        newLines = $(this).val().split("\n").length;
        if (e.keyCode === 13 && newLines >= lines) {
            $('#alertBio').html('Lines limit exceeded');
            return false;
        } else if ($(this).val().length >= 200 && e.keyCode !== 8) {
            $('#alertBio').html('Max 200 characters');
            return false;
        } else {
            $('#alertBio').empty();
        }
    });
    $('#editProfile').click(function () {
        $('#bio-text').attr('disabled', false);
        $('#dob').attr('disabled', false);
        $('#displayName').attr('disabled', false);
        $('.btn-edit').css('display', 'block');
        $('#avaUpload').attr('disabled', false);
        $('.uploadImg_label').css('display', 'flex');
    });
    $('#cancel').click(function () {
        window.location.href = "ViewProfile";
    });
});
function readURL() {
    var $input = $(this);
    var $newinput = $(this).parent().parent().parent().find('.bigAvatar');
    if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $newinput.attr('src', e.target.result).show();
        };
        reader.readAsDataURL(this.files[0]);
    }
}
$("#avaUpload").change(readURL);
$(document).ready(function () {
    $('#changepw-form').ajaxForm({
        success: function (result) {
            $('#changepw-noti').html(result);
        }
    });
});
$(document).ready(function () {
    $('#becometutor-form').ajaxForm({
        success: function (result) {
            $('.modal-body').empty().append('<div id="becomeTutor-noti" class="text-success fs-4">' + result + '</div>');
                    setTimeout(location.reload(), 5000);
        }
    });
});