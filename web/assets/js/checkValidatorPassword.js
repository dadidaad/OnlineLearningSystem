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


var value = $("#password_reg").val();

$.validator.addMethod("checklower", function(value) {
  return /[a-z]/.test(value);
});
$.validator.addMethod("checkupper", function(value) {
  return /[A-Z]/.test(value);
});
$.validator.addMethod("checkdigit", function(value) {
  return /[0-9]/.test(value);
});
$.validator.addMethod("pwcheck", function(value) {
  return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) && /[a-z]/.test(value) && /\d/.test(value) && /[A-Z]/.test(value);
});

$('#signup-form').validate({
  rules: {
    password: {
      minlength: 6,
      maxlength: 30,
      required: true,
      //pwcheck: true,
      checklower: true,
      checkupper: true,
      checkdigit: true
    },
    confirmPassword: {
      equalTo: "#password_reg",
    },
  },
  messages: {
    password: {
      pwcheck: "Password is not strong enough",
      checklower: "Need at least 1 lowercase alphabet",
      checkupper: "Need at least 1 uppercase alphabet",
      checkdigit: "Need at least 1 digit"
    }
  },
  highlight: function(element) {
    $(element).closest('.form__group').removeClass('has-success').addClass('has-error');
  },
  unhighlight: function(element) {
    $(element).closest('.form__group').removeClass('has-error').addClass('has-success');
    $('#confirmPassword').attr('disabled', false);
  },
  errorElement: 'div',
  errorClass: 'validate_cus',
  errorPlacement: function(error, element) {
    x = element.length;
    if (element.length) {
      error.insertAfter(element);
    } else {
      error.insertAfter(element);
    }
  }

});