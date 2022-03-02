<%-- 
    Document   : UpdateArticle
    Created on : Feb 27, 2022, 2:57:42 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
            <!--end of menu-->
            <!--begin of form-->
            <form class="col-sm-12" action="updatearticle" method="post" name="myForm">
                <h2>Create new article</h2>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Link image</label>
                    <input name="image" type="text" class="form-control" id="exampleFormControlInput1" value="${detail.image}">
                </div>
                <label for="image"><span style="color: red;" id="errorImage"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Tittle</label>
                    <textarea name="title" class="form-control" id="exampleFormControlTextarea1" rows="3">${detail.title}</textarea>
                </div>
                 <label for="image"><span style="color: red;" id="errorTitle"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="10" >${detail.description}</textarea>
                </div>
                      <label for="image"><span style="color: red;" id="errordes"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlInput1" hidden>Link id</label>
                    <input name="id" type="text" class="form-control" id="exampleFormControlInput1" value="${detail.id}" hidden>
                </div>
                <button onClick="return FormValidate();" class="btn btn-primary" type="submit">Update</button>
            </form>
            <!--end of form-->
        </div>
                <script type="text/javascript">
            function FormValidate() {
               var image = document.myForm.image.value.trim();
                var errorImage = document.getElementById('errorImage');
                 var errorTitle = document.getElementById('errorTitle');
                  var errordes = document.getElementById('errordes');
               if(image==""||image==null){
                   errorImage.innerHTML = "Please enter image";
                   return false;
               }
                var title = document.myForm.title.value.trim();
                if(title==""||title==null){
                   errorTitle.innerHTML = "Please enter title";
                   return false;
               }
               var description = document.myForm.description.value.trim();
                if(description==""||description==null){
                   errordes.innerHTML = "Please enter description";
                   return false;
               }
            }

        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>
