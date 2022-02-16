/* 
 * Check value of input form in jsp file, use javascript
 * Author Dajtvox
 * @type @jQuery
 */

var stepper = new Stepper(document.querySelector("#stepper"));
function next() {
    stepper.next();
}
function previous() {
    stepper.previous();
}

$(document).ready(function () {
    $('#submitmail-form').ajaxForm({
        // success identifies the function to invoke when the server response 
        // has been received 
        success: processMailVerify
    });
});
$(document).ready(function () {
    $('#verifytoken-form').ajaxForm({
        // success identifies the function to invoke when the server response 
        // has been received 
        success: processTokenVerify
    });
});
$(document).ready(function () {
    $('#forgotPassword-form').ajaxForm({
        // success identifies the function to invoke when the server response 
        // has been received 
        success: processResetPassword
    });
});
$(document).ready(function () {
    $('#resend-btn').click(function () {
        var email = $('#email').val();
        $.ajax({
            url: 'ResendToken',
            data: {"email_reset": email},
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
function processResetPassword(data) {
    if (data === 'success') {
        next();
    } else {
        $('#resetPw-noti').empty().html(data);
    }
}
function processTokenVerify(data) {
    if (data === 'success') {
        next();
    } else {
        $('#captcha').addClass('invalid');
        $('#notiCaptcha').empty().html(data);
    }
}

function processMailVerify(data) {
    if (data === 'success') {
        next();
    } else {
        $('#email').addClass('invalid');
        $('#notiExistMail').empty().html(data);
    }
}
            