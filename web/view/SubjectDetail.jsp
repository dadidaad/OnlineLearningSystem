<%-- 
    Document   : SubjectDetail
    Created on : Feb 10, 2022, 4:28:19 PM
    Author     : Doan Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<!DOCTYPE html>
<html lang="en">
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/SubjectDetailStyle.css" />">
        <title>TutorDuo</title>
</head>
<body>
    <!-- Include header of web site from general-->
    <%@include file="./header.jsp" %>
    
    <!--Side Bar-->
    <nav class="sidebar close">
            <!-- Side Bar header-->
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

            <!-- Main Menu of Side Bar-->
            <div class="menu-bar">
                <div class="menu">
                    <ul class="menu-links">

                        <!-- This link for look Up table-->
                        <li class="nav-link">
                            <a href="<i:ReadUrlFromContext url="/ConstantTableController" />">
                                <i class='bx bx-table icon' ></i>
                                <span class="text nav-text">Lookup table</span>
                            </a>
                        </li>

                        <!--These link for all subject use c:forEach of JSTL -->
                        <c:forEach items="${requestScope.subjects}" var ="s" varStatus="loop">
                            <li class="nav-link">
                                <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${s.getSubjectID()}" />">
                                    <c:if test="${s.getSubjectID() eq 1}"><i class='bx bx-math icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 2}"><i class='bx bx-math icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 3}"><i class='bx bx-math icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 4}"><i class='bx bx-atom icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 5}"><i class='bx bx-atom icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 6}"><i class='bx bx-atom icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 7}"><i class='bx bx-atom icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 8}"><i class='bx bx-test-tube icon' ></i></c:if>
                                    <c:if test="${s.getSubjectID() eq 9}"><i class='bx bx-test-tube icon' ></i></c:if>
                                    <span class="text nav-text">${s.getSubjectName()}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <!-- Dark/light mode-->
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
                    
   <!-- Show Case -->                 
    <section class="bg-dark text-light p-5 text-center text-sm-start showcase">
        <div class="container">
            <div class="d-sm-flex align-items-center justif-content-between">
                <div>
                    <h1>Introduction<span class="text-warning"> The Subject</span></h1>
                    <p class="lead my-5">
                       Here are the most overview of the subject, you will understand 
                       what areas of knowledge this subject will focus on. In addition, 
                       we will also introduce the learning path of the subject, 
                       each subject will be divided into chapters with important knowledge, 
                       helping you to systemize in the most complete way.
                    </p>
                </div>
                <img class="img-fluid w-50 mx-3 d-none d-sm-block" src="<i:ReadUrlFromContext url="/assets/image/primary-school-tutoring-online_orig.png" />" alt="">
            </div>
        </div>
    </section>
            
    <!--Accordion is used to introduce the most basic parts of this subject -->  
    <div class="accordion">
        <!-- Image box for accordion-->
        <div class="image-box">
            <img src="<i:ReadUrlFromContext url="/${requestScope.currentSubject.getSubjectImage()}" />" alt="">
        </div>
        <!--Accordion for detail of Subject -->
        <div class="accordion-text">
            <div class="title">${requestScope.currentSubject.getSubjectName()}</div>
        <ul class="faq-text">
            <li>
                <div class="question-arrow">
                    <span class="question">What will you learn in this subject?</span>
                    <i class="bx bxs-chevron-down arrow"></i>
                </div>
                <p>${requestScope.currentSubject.getDescription()}</p>
                <span class="line"></span>
            </li>
            <c:forEach items="${requestScope.chapters}" var ="c" varStatus="loop">
            <li>
                <div class="question-arrow">
                    <span class="question">${c.getChapterName()}</span>
                    <i class="bx bxs-chevron-down arrow"></i>
                </div>
                    <p>${c.getChapterContent()}   <span><a href="<i:ReadUrlFromContext url="/Knowledge?chapId=${c.getChapterID()}" />" style="color: steelblue;">  Explore</a></span></p>
                
                <span class="line"></span>
            </li>
            </c:forEach>
        </ul>
        </div>
    </div>
            
    <!-- Include footer of web site from general -->
    <%@include file="./footer.jsp" %>
    <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
    <script src="<i:ReadUrlFromContext url="/assets/js/SubjectDetailScript.js"/>"></script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
crossorigin="anonymous"></script>
</html>
