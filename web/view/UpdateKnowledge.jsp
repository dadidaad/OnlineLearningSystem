<%-- 
    Document   : CreateKnowledge
    Created on : Feb 25, 2022, 8:00:58 PM
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
        
        <!--Create New Knowledge-->
        <div class="container">
            <div class="title">Update Knowledge</div>
            <form action="KnowledgeUpdateController" id="form" method="Post" enctype="multipart/form-data">
                <div class="user-detail">
                    <div class="input-box">
                        <span class="details">KnowledgeID</span>
                        <input type="text" id="subId" name="knowledgeId" placeholder="Knowledge ID here" required value="${requestScope.knowledge.getKnowledgeID()}" readonly="true">
                    </div>

                    <div class="input-box">
                        <span class="details" >Knowledge Name</span>
                        <input type="text" id="subName" placeholder="Knowledge Name here" name="knowledgeName" value="${requestScope.knowledge.getKnowledgeName()}">
                        <input type="text" name="currentName" value="${requestScope.knowledge.getKnowledgeName()}" hidden="true">
                        <input type="text" name="chapId" value="${requestScope.knowledge.getChapterID()}" hidden="true">
                    </div>
                        
                    <div class="input-box">
                        <span class="details">Knowledge Content</span>
                        <input type="file" name="Image">
                        <input type="text" name="currentKnowledge" value="${requestScope.knowledge.getKnowledgeContent()}" hidden="true">
                        <img src="${requestScope.knowledge.getKnowledgeContent()}" style="width: 400px; height:200px;  margin-top: 10px;">
                    </div>
                        
                    <span class="error">Error message</span>
                    <c:if test="${requestScope.check eq false}"> <span class="final-error">This Knowledge Name has been existing</span></c:if>
                        <div class="button">
                            <input type="submit" value="Update Knowledge">
                        </div>
                    </div>
                </form>
            </div>

            <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CreateSubjectScript.js"/>"></script>
    </body>
</html>
