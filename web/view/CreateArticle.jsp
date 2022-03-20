<%-- 
    Document   : Creator
    Created on : Oct 14, 2020, 4:11:57 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
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
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
              crossorigin="anonymous"/>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListSubjectStyle.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/CreateSubjectStyle.css" />">
        <title>TutorDuo</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <%@include file="./header.jsp" %>

        <!--Side Bar-->
        <nav class="sidebar close">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="<i:ReadUrlFromContext url="/assets/image/259151762_463419805435533_5232999905401287810_n.png" />" alt="">                </span>

                <div class="text logo-text">
                    <span class="name">TutorDuo</span>
                    <span class="profession">Online Learning</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>

        <!--Main Side Bar-->
        <div class="menu-bar">
            <div class="menu">
                <ul class="menu-links">

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-calendar-check icon'></i>
                            <span class="text nav-text">Learning Management</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-calendar-check icon'></i>
                            <span class="text nav-text">Learning Management</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                           <i class='bx bx-calendar-check icon'></i>
                            <span class="text nav-text">Learning Management</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-calendar-check icon'></i>
                            <span class="text nav-text">Learning Management</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bx-calendar-check icon'></i>
                            <span class="text nav-text">Learning Management</span>
                        </a>
                    </li>

                </ul>
            </div>
            
            <div class="bottom-content">
                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Dark mode</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>

            </div>
        </div>
    </nav>
        <div class="container">
            
            <!--begin of form-->
            
            <form class="col-sm-12" action="/OnlineLearningSystem/createarticle" method="post" name="myForm">
                <h2>Create new article</h2>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Link image</label>
                    <input name="image" type="text" class="form-control" id="exampleFormControlInput1" placeholder="https://genk.mediacdn.vn/thumb_w/660/139269124445442048/2020/10/14/jxcvj-16026312062441713789234.jpg">
                </div>
                <label for="image"><span style="color: red;" id="errorImage"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Tittle</label>
                    <textarea name="title" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                <label for="image"><span style="color: red;" id="errorTitle"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
                </div>
                 <label for="image"><span style="color: red;" id="errordes"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">CreateName</label>
                    <textarea name="createname" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                  <label for="image"><span style="color: red;" id="errorName"></span></label> 
                <button  onClick="return FormValidate();" type="submit" class="btn btn-primary">Create</button>
                <label style="color: red;"><span>${message}</span></label> 
            </form>
            
            <!--end of form-->
           
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
     <script type="text/javascript">
            function FormValidate() {
               var image = document.myForm.image.value.trim();
                var errorImage = document.getElementById('errorImage');
                 var errorTitle = document.getElementById('errorTitle');
                  var errordes = document.getElementById('errordes');
                   var errorName = document.getElementById('errorName');
               if(image==""||image==null){
                   errorImage.innerHTML = "Please enter image";
                   return false;
               }
                var title = document.myForm.title.value.trim();
                if(title==""||title==null){
                   errorTitle.innerHTML = "Please enter title";
                   return false;
               }
               if(title.length>100){
                   errorTitle.innerHTML = "Please enter title<100character";
                   return false;
               }
               var description = document.myForm.description.value.trim();
                if(description==""||description==null){
                   errordes.innerHTML = "Please enter description";
                   return false;
               }
                var createname = document.myForm.createname.value.trim();
                if(createname==""||createname==null){
                   errorName.innerHTML = "Please enter create name";
                   return false;
               }
            }

        </script>
         <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CreateSubjectScript.js"/>"></script>
    </body>
</html>
