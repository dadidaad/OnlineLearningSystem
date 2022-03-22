/* 
 * Check value of input form in jsp file, use javascript
 * Author Dajtvox
 * @type @jQuery
 */


var stepper = new Stepper(document.querySelector("#stepper"));
function previous() {
    stepper.previous();
}
function next() {
    stepper.next();
}
$(document).ready(function () {
    $('#signup-form').ajaxForm({
        // dataType identifies the expected content type of the server response 
        dataType: 'json',

        // success identifies the function to invoke when the server response 
        // has been received 
        success: processJson
    });
});
$(document).ready(function () {
    $('#verifytoken-form').ajaxForm({
        success: finishRes
    });
});
$(document).ready(function () {
    $('#resend-btn').click(function () {
        var uname = $('#username').val().trim();
        var email = $('#email').val().trim();
        var sex = $('#sex').val().trim();
        var pw = $('#password_reg').val().trim();
        $.ajax({
            url: 'ResendToken',
            data: {"username": uname, "email": email, "sex": sex, "password": pw},
            type: 'POST',
            success: resendReply
        });
    });
});
function resendReply(data) {
    $('#notiCaptcha').removeClass('text-success').empty().html(data);
    $('#resend-btn').prop('disabled', true);
    setTimeout(function () {
        $('#resend-btn').prop("disabled", false);
    }, 10000);
}
function finishRes(data) {
    if (data === 'success') {
        next();
        $('#notiRegister').html('Sign up successfully');
    } else {
        $('#captcha').addClass('invalid');
        $('#notiCaptcha').html(data);
    }
}
function processJson(data) {
    if (data.hasOwnProperty("userInvalid")) {
        $('#notiExistUser').html(data.userInvalid);
        $('#username').addClass('invalid').removeClass('valid');
    } else {
        $('#notiExistUser').empty();
    }
    if (data.hasOwnProperty("mailInvalid")) {
        $('#notiExistMail').html(data.mailInvalid);
        $('#email').addClass('invalid').removeClass('valid');
    } else {
        $('#notiExistMail').empty();
    }
    if (data.hasOwnProperty("notiRes")) {
        if (data.notiRes === 'error') {
            $('notiRes').html('Fail to send captcha mail, try again!!');
        } else {
            next();
        }
    }
}
