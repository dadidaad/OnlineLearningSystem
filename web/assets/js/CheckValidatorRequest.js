/* 
    Created on : March 10, 2022, 7:45:38 AM
    Author     : Duc Minh
    @type @jQuery
*/
$(document).ready(function () {
    
$.validator.addMethod("noSpace", function (value, element) {
    return !value.trim()=='';
}, "No space please and don't leave it empty");   
$.validator.addMethod("minLength", function (value, element, param) {
    return this.optional(element) || value.trim().length > param;
}, "Please enter at least 10 characters.");   
$.validator.addMethod("maxLength", function (value, element, param) {
    return this.optional(element) || value.trim().length < param;
}, "Please enter no more than 1000 characters.");  


  $("#createFrom").validate({
   onblur : true,
    rules: {
      rqTitle: {
        required: true,
        noSpace: true,
        minLength: 10,
        maxlength: 100
       
      },
      rqLevel: {
        required: true
      },
      rqPrice: {
        required: true
      },
      message:{
        required : true,
        noSpace: true,
        minLength: 10,
        maxlength: 1000
      }
      
    },

    messages: {
       rqTitle: {
        required: "Please provide a Title"
      },
      rqLevel: {
        required: "Please provide a Level"
      },
      rqPrice: {
        required: "Please provide a Price"
      },
      message: {
        required: "Please fill this Content"
      }
    }
  });
  
  $("#updateFrom").validate({
   onblur : true,
    rules: {
      rqTitle: {
        required: true,
        noSpace: true,
        minLength: 10,
        maxLength: 100
      },
      rqLevel: {
        required: true
      },
      rqPrice: {
        required: true
      },
      message:{
        required : true,
        noSpace: true,
        minLength: 10,
        maxLength: 1000
      }
      
    },

    messages: {
       rqTitle: {
        required: "Please provide a Title"
      },
      rqLevel: {
        required: "Please provide a Level"
      },
      rqPrice: {
        required: "Please provide a Price"
      },
      message: {
        required: "Please fill this Content"
      }
    }
  });
});
