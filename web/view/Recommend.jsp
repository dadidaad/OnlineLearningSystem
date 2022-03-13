<%-- 
    Document   : Recommend
    Created on : Mar 9, 2022, 8:16:56 PM
    Author     : Phong Vu
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/CreateRecommendStyle.css" />">
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
                        <img src="<i:ReadUrlFromContext url="/assets/image/259151762_463419805435533_5232999905401287810_n.png" />" alt="">
                    </span>

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
                            <a href="<i:ReadUrlFromContext url="/ConstantTableController" />">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Learning Manage</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Account manager</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Teacher Apply</span>
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
            <div class="title">Your Recommend</div>
            <form action="RecomendController" id="form" method="Post">
                <div class="user-detail">
                    <input type="hidden" value="${sessionScope.user.getUsername()}" name="username">
                    <div class="input-box">
                        <span class="details">Choose subject</span>
                        <select name="subject-select">
                            <c:forEach items="${requestScope.subjects}" var="s">
                                <option value="${s.getSubjectID()}">${s.getSubjectName()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="input-box">
                        <span class="details">Action</span>
                        <select name="action-select">
                            <option value="1">New Knowledge</option>
                            <option value="0">Update Knowledge</option>
                        </select>
                    </div>

                    <div class="input-box">
                        <span class="details">Description</span>
                        <textarea name="description" id="description" cols="75" rows="5"></textarea>
                    </div>

                    <span class="error">Error message</span>
                    <div class="button">
                        <input type="submit" value="Add Subject">
                    </div>
                </div>
            </form>
        </div>
                                
        <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>
        
        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/RecommendScript.js"/>"></script>
    </body>
</html>
