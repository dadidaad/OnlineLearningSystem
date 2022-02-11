/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * 
 * @type jQuery
 * Check validator of password
 */


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
$.validator.addMethod("usernamecheck", function (value){
   return /^[a-zA-Z1-9]+$/.test(value); 
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