<%-- 
    Document   : AdminRecommend
    Created on : Mar 10, 2022, 2:59:40 PM
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/AdminSubjectStyle.css" />">
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

        <main>
            <section class="recent">
                <div class="activity-grid">
                    <div class="activity-card">
                        <h3 class="">Browser for Knowledge Recommends</h3> 
                        <span class="new-subject"><a href="AdminRecommendController?action=new">New Knowledge</a></span>
                        <span class="new-subject" style="transform: translate(-110%, 25%)"><a href="AdminRecommendController?action=update">Update Knowledge</a></span>
                        <table borders="1">
                            <thead>
                                <tr>
                                    <th>Recommend</th>
                                    <th>Username</th>
                                    <th>Subject</th>
                                    <th>Description</th>
                                    <th style="min-width: 150px;">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.recommends}" var="recommend" varStatus="loop">
                                <tr>
                                    <td class="id-name" style="text-align: left;">${recommend.getRecommendID()}</td>
                                    <td class="id-name" style="text-align: left;">${recommend.getUsername()}</td>
                                    <td class="id-name" style="text-align: left;">${requestScope.subjects[loop.index]}</td>
                                    <td class="rec-description" style="text-align: left;">${recommend.getDescription()}</td>
                                    <c:if test="${recommend.getStatus() eq 'waiting'}">
                                    <td>
                                        <a href="ChangeRecStatusController?status=accept&recId=${recommend.getRecommendID()}&action=${requestScope.action}&username=${recommend.getUsername()}"><i class="fas fa-check fa-2x" style="margin-bottom: 10px; color: green; cursor: pointer;" id="accept"></i></a>
                                        <a href="ChangeRecStatusController?status=decline&recId=${recommend.getRecommendID()}&action=${requestScope.action}&username=${recommend.getUsername()}"><i class="fas fa-times fa-2x" style="color: red; cursor: pointer;" id="decline"></i></a>
                     
                                    </td>
                                    </c:if>
                                    <c:if test="${recommend.getStatus() eq 'accept'}">
                                    <td>
                                        <a href="ChangeRecStatusController?status=accept&recId=${recommend.getRecommendID()}&action=${requestScope.action}"><i class="fas fa-check fa-2x" style="margin-bottom: 10px; color: green; cursor: pointer;" id="accept"></i></a>
                                        <span id ="check-edit" style="cursor: pointer;"><a style="color: #000;" href="ChangeRecStatusController?status=waiting&recId=${recommend.getRecommendID()}&action=${requestScope.action}&username=${recommend.getUsername()}">Edit</a></span>
                                    </td>
                                    </c:if>
                                    <c:if test="${recommend.getStatus() eq 'decline'}">
                                    <td>
                                        <a href="ChangeRecStatusController?status=decline&recId=${recommend.getRecommendID()}&action=${requestScope.action}"><i class="fas fa-times fa-2x" style="color: red; cursor: pointer;" id="decline"></i></a>
                                        <span id ="check-edit" style="cursor: pointer;"><a style="color: #000;" href="ChangeRecStatusController?status=waiting&recId=${recommend.getRecommendID()}&action=${requestScope.action}&username=${recommend.getUsername()}">Edit</a></span>
                                    </td>
                                    </c:if>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </section>
        </main>

        <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
    </body>
    <script>
    let accept = document.getElementById("accept");
    let decline = document.getElementById("decline");
    let check = document.getElementById("check-edit");
    accept.addEventListener("click", ()=>{
        decline.style.display="none";
        check.style.display="inline";
    })
    decline.addEventListener("click", ()=>{
        accept.style.display="none";
        check.style.display="inline";
    })
    check.addEventListener("click", ()=>{
        accept.style.display="inline";
        decline.style.display="inline";
        check.style.display="none";
    })
    </script>
</html>

