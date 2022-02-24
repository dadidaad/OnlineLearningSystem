<%-- 
    Document   : CallAjaxToResetPw
    Created on : Feb 13, 2022, 6:43:19 PM
    Author     : Dajtvox
--%>
<script>
    var stepper = new Stepper(document.querySelector("#stepper"));
    function next() {
        if (validateForm() == false) {
            return false;
        }
        stepper.next();
    }
    function previous() {
        stepper.previous();
    }
    function validateForm() {
        if ($('.invalid').length != 0)
            return false;
        var x, y, i, valid = true;
        x = document.getElementsByClassName("content");
        y = x[stepper._currentIndex].getElementsByClassName("form__field");
        // A loop that checks every input field in the current tab:
        for (i = 0; i < y.length; i++) {
            // If a field is empty...
            if (y[i].value == "") {
                // add an "invalid" class to the field:
                y[i].className += " invalid";
                // and set the current valid status to false:
                valid = false;
            }
        }
        return valid;
    }
    $(document).ready(function () {
        $("#email").blur(function () {
            var mail = $("#email").val();
            $.ajax({
                url: '<i:ReadUrlFromContext url="/CheckMailExist"/>',
                data: {"email": mail},
                type: 'POST',
                success: function (result) {
                    if (result === 'not exist') {
                        $('#notiExistMail').removeClass('text-success');
                        $('#email').removeClass('valid');
                        $('#notiExistMail').addClass('text-danger');
                        $('#email').addClass('invalid');
                        $('#notiExistMail').empty();
                        $('#notiExistMail').html('Email not exist');
                    } else {
                        $('#email').removeClass('invalid');
                        $('#email').addClass('valid');
                        $('#notiExistMail').removeClass('text-danger');
                        $('#notiExistMail').addClass('text-success');
                        $('#notiExistMail').empty();
                        $('#notiExistMail').html('Email ok!');
                    }
                }
            });
        });
    });
    $(document).ready(function () {
        $('#verifymail-btn').click(function () {
            if (validateForm() != false) {
                var email = $('#email').val();
                next();
                $.ajax({
                    type: 'POST',
                    url: '<i:ReadUrlFromContext url="/VerifyCaptcha"/>',
                    data: {"email": email},
                    success: function (result) {
                        $('#captcha').blur(function () {
                            var inputCaptcha = $('#captcha').val();
                            if (inputCaptcha !== result) {
                                $('#captcha').removeClass('valid');
                                $('#captcha').addClass('invalid');
                                $('#notiCaptcha').removeClass('text-success');
                                $('#notiCaptcha').addClass('text-danger');
                                $('#notiCaptcha').empty();
                                $('#notiCaptcha').html('Invalid captcha');
                            } else {
                                $('#captcha').removeClass('invalid');
                                $('#captcha').addClass('valid');
                                $('#notiCaptcha').removeClass('text-danger');
                                $('#notiCaptcha').addClass('text-success');
                                $('#notiCaptcha').html('Valid captcha');
                            }
                        });
                    }
                });
            } else {
                return false;
            }
        });
    });
    $(document).ready(function () {
        $('#resend-btn').click(function () {
            var email = $('#email').val();
            $('#resend-btn').prop("disabled", true);
            setTimeout(function () {
                $('#resend-btn').prop("disabled", false);
            }, 10000);
            $.ajax({
                type: 'POST',
                url: '<i:ReadUrlFromContext url="/VerifyCaptcha"/>',
                data: {"email": email},
                success: function (result) {
                    $('#captcha').blur(function () {
                        var inputCaptcha = $('#captcha').val();
                        if (inputCaptcha !== result) {
                            $('#captcha').removeClass('valid');
                            $('#captcha').addClass('invalid');
                            $('#notiCaptcha').removeClass('text-success');
                            $('#notiCaptcha').addClass('text-danger');
                            $('#notiCaptcha').empty();
                            $('#notiCaptcha').html('Invalid captcha');
                        } else {
                            $('#captcha').removeClass('invalid');
                            $('#captcha').addClass('valid');
                            $('#notiCaptcha').removeClass('text-danger');
                            $('#notiCaptcha').addClass('text-success');
                            $('#notiCaptcha').html('Valid captcha');
                        }
                    });
                }
            });
        });
    });
    $(document).ready(function () {
        $('#changePass-btn').click(function () {
            if (validateForm() == false) {
                return false;
            } else {
                var pw = $('#password_reset').val();
                var email = $('#email').val();
                next();
                $.ajax({
                    type: 'POST',
                    url: '<i:ReadUrlFromContext url="/ResetPassword"/>',
                    data: {"password": pw, "email": email},
                    success: function (result) {
                        $('#reset-noti').html(result);
                    }
                });
            }

        });
    });
</script>