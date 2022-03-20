<%-- 
    Document   : UpdateArticle
    Created on : Feb 27, 2022, 2:57:42 PM
    Author     : hoang ngoc long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListSubjectStyle.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/AccountManagerStyle.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
    </head>
    <body>
        <!-- Include header of web site from general-->
        <%@include file="./header.jsp" %>
        <div class="container">
            <!--begin of form-->
            <form class="col-sm-12" action="updatearticle" method="post" name="myForm">
                <h2 style="font-size: 40px;">Update article</h2>
                <div class="form-group">
                    <label for="exampleFormControlInput1" style="margin-top:10px;">Link image</label>
                    <input name="image" type="text" class="form-control" id="exampleFormControlInput1" value="${detail.image}">
                </div>
                <label for="image"><span style="color: red;" id="errorImage"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1" style="margin-top:10px;">Tittle</label>
                    <textarea name="title" class="form-control" id="exampleFormControlTextarea1" rows="3">${detail.title}</textarea>
                </div>
                 <label for="image"><span style="color: red;" id="errorTitle"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1" style="margin-top:10px;">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="10" >${detail.description}</textarea>
                </div>
                      <label for="image"><span style="color: red;" id="errordes"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlInput1" hidden>Link id</label>
                    <input name="id" type="text" class="form-control" id="exampleFormControlInput1" value="${detail.id}" hidden>
                      <label style="color: red;"><span>${message}</span></label> 
                </div>                    
                <button onClick="return FormValidate();" class="btn btn-primary" type="submit" style="margin-top:20px; margin-bottom: 20px;">Update</button>
              
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
         <!-- Include footer of web site from general -->
            <%@include file="./footer.jsp" %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>
