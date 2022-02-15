/* 
 * Check value of input form in jsp file, use javascript
 * Author Dajtvox
 * @type @jQuery
 * Author Dajvox
 */


function validateForm() {
    if ($('.invalid').length != 0)
        return false;
    var y, i, valid = true;
    y = document.getElementsByClassName("form__field");
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
var pw_reg_value = $("#password_reg").val();
var pw_login_value = $("#password_login").val();
$.validator.addMethod("checklower", function (value) {
    return /[a-z]/.test(value);
});
$.validator.addMethod("checkupper", function (value) {
    return /[A-Z]/.test(value);
});
$.validator.addMethod("checkdigit", function (value) {
    return /[0-9]/.test(value);
});
$.validator.addMethod("pwcheck", function (value) {
    return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) && /[a-z]/.test(value) && /\d/.test(value) && /[A-Z]/.test(value);
});
$.validator.addMethod("usernamecheck", function (value) {
    return /^[a-zA-Z0-9]+$/.test(value);
});
$.validator.addMethod("emailcheck", function (value) {
    return /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test(value);
});
$.validator.addMethod("captchacheck", function (value) {
    return /^[a-zA-Z0-9]+$/.test(value);
});
$('#verifytoken-form').validate({
    rules: {
        captcha: {
            minlength: 6,
            maxlength: 6,
            required: true,
            captchacheck: true
        }
    },
    messages: {
        captcha:{
            captchacheck: "only contains letters and numbers"
        }
    },
    highlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(id_attr).removeClass('valid').addClass('invalid');
    },
    unhighlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(id_attr).removeClass('invalid').addClass('valid');
    },
    errorElement: 'div',
    errorClass: 'validate_cus',
    errorPlacement: function (error, element) {
        x = element.length;
        if (element.length) {
            error.insertAfter(element);
        } else {
            error.insertAfter(element);
        }
    }

});
$('#signup-form').validate({
    rules: {
        password: {
            minlength: 6,
            maxlength: 20,
            required: true,
            //pwcheck: true,
            checklower: true,
            checkupper: true,
            checkdigit: true
        },
        confirmPassword: {
            equalTo: "#password_reg",
        },
        username: {
            minlength: 6,
            maxlength: 20,
            required: true,
            usernamecheck: true
        },
        email: {
            required: true,
            emailcheck: true
        }
    },
    messages: {
        password: {
            pwcheck: "Password is not strong enough",
            checklower: "Need at least 1 lowercase alphabet",
            checkupper: "Need at least 1 uppercase alphabet",
            checkdigit: "Need at least 1 digit"
        },
        username: {
            usernamecheck: "Must only contains alphabet and number"
        },
        email: {
            emailcheck: "Invalid format email"
        }
    },
    highlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(element).closest('.form__group').removeClass('has-success').addClass('has-error');
        $(id_attr).removeClass('valid').addClass('invalid');
    },
    unhighlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(element).closest('.form__group').removeClass('has-error').addClass('has-success');
        $(id_attr).removeClass('invalid').addClass('valid');
    },
    errorElement: 'div',
    errorClass: 'validate_cus',
    errorPlacement: function (error, element) {
        x = element.length;
        if (element.length) {
            error.insertAfter(element);
        } else {
            error.insertAfter(element);
        }
    }

});
$('#login-form').validate({
    rules: {
        password: {
            minlength: 6,
            maxlength: 20,
            required: true,
            //pwcheck: true,
            checklower: true,
            checkupper: true,
            checkdigit: true
        },
        username: {
            minlength: 6,
            maxlength: 20,
            required: true,
            usernamecheck: true
        },
    },
    messages: {
        password: {
            pwcheck: "Password is not strong enough",
            checklower: "Need at least 1 lowercase alphabet",
            checkupper: "Need at least 1 uppercase alphabet",
            checkdigit: "Need at least 1 digit"
        },
        username: {
            usernamecheck: "Must only contains alphabet and number"
        }
    },
    highlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(element).closest('.form__group').removeClass('has-success').addClass('has-error');
        $(id_attr).removeClass('valid').addClass('invalid');
    },
    unhighlight: function (element) {
        var id_attr = "#" + $(element).attr("id");
        $(element).closest('.form__group').removeClass('has-error').addClass('has-success');
        $(id_attr).removeClass('invalid').addClass('valid');
    },
    errorElement: 'div',
    errorClass: 'validate_cus',
    errorPlacement: function (error, element) {
        x = element.length;
        if (element.length) {
            error.insertAfter(element);
        } else {
            error.insertAfter(element);
        }
    }

});