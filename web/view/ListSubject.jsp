<%-- 
    Document   : ListSubject
    Created on : Feb 8, 2022, 4:19:04 PM
    Author     : Doan Tu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListSubjectStyle.css" />">
        <title>TutorDuo</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <%@include file="./header.jsp" %>

        <!--Side Bar  -->
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

        <!-- Show case -->
        <section class="bg-dark text-light p-5 text-center text-sm-start showcase">
            <div class="container">
                <div class="d-sm-flex align-items-center justif-content-between">
                    <div>
                        <h1>Leaning <span class="text-warning">Important Knowledge</span></h1>
                        <p class="lead my-5">
                            This is where you can learn many knowledge about Math, Physic, Chemistry
                            You can also search important constant, term in high school education program
                            We will summarize the most important knowledge parts of the math, physics, 
                            chemistry in the high school program, these knowledge are the foundation and 
                            they are arranged in the order of the course syllabus, not the division.    
                            Coordinate the current program.
                        </p>
                        <c:if test="${sessionScope.user.getRole() eq 'Student'}"><button class="btn btn-primary btn-lg"> <a href="RecommendController"> Start learning </a></button></c:if>
                        <c:if test="${sessionScope.user.getRole() eq 'Student'}"><button class="btn btn-primary btn-lg"> <a href="RecommendHistoryCOntroller"> Start learning </a></button></c:if>
                    </div>
                    <img class="img-fluid w-50 mx-3 d-none d-sm-block" src="<i:ReadUrlFromContext url="/assets/image/istockphoto-1206750602-1024x1024.jpg" />" alt="">
                </div>
            </div>
        </section>


        <!-- Boxes -->
        <section class="p-5" id="subject-list">
            <div class="container boxes">
                <div class="row text-center">
                    <div class="col-md my-3">
                        <div class="card bg-secondary text-light">
                            <div class="card-body text-center">
                                <i class="far fa-calculator fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[0].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[0].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[0].getSubjectID()}"/>" class="btn btn-dark"> Read More</a>
                        </div>
                    </div>
                    <div class="col-md my-3">
                        <div class="card bg-dark text-light">
                            <div class="card-body text-center">
                                <i class="far fa-calculator fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[1].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[1].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[1].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                        </div>
                    </div>

                    <div class="col-md my-3">
                        <div class="card bg-secondary text-light">
                            <div class="card-body text-center">
                                <i class="far fa-calculator fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[2].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[2].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[2].getSubjectID()}"/>" class="btn btn-dark"> Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="p-5">
        <div class="container boxes">
            <div class="row text-center">
                <div class="col-md my-3">
                    <div class="card bg-dark text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[3].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[3].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[3].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                    </div>
                </div>
                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[4].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[4].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[4].getSubjectID()}"/>" class="btn btn-dark"> Read More</a>
                    </div>
                </div>
                <div class="col-md my-3">
                    <div class="card bg-dark text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[5].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[5].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[5].getSubjectID()}"/>" class="btn btn-dark"> Read More</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="p-5">
        <div class="container boxes">
            <div class="row text-center">
                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-atom fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[6].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[6].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[6].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                    </div>
                </div>
                <div class="col-md my-3" >
                    <div class="card bg-dark text-light">
                        <div class="card-body text-center">
                            <i class="far fa-vial fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[7].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[7].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[7].getSubjectID()}"/>" class="btn btn-dark"> Read More</a>
                    </div>
                </div>
                <div class="col-md my-3">
                    <div class="card bg-secondary text-light">
                        <div class="card-body text-center">
                            <i class="far fa-vial fa-2x"></i>
                        </div>
                        <h3 class="card-title mb-3">${requestScope.subjects[8].getSubjectName()}</h3>
                        <p class="card-text">
                            ${requestScope.subjects[8].getDescription()}
                        </p>
                        <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[8].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <c:if test="${requestScope.subjects.size()>9}" >     
        <section class="p-5">
            <div class="container boxes">
                <div class="row text-center">
                    <div class="col-md my-3">
                        <div class="card bg-secondary text-light">
                            <div class="card-body text-center">
                                <i class="far fa-vial fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[9].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[9].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[9].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                        </div>
                    </div>

                    <div class="col-md my-3">
                        <div class="card bg-secondary text-light">
                            <div class="card-body text-center">
                                <i class="far fa-vial fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[10].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[10].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[10].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                        </div>
                    </div>

                    <div class="col-md my-3">
                        <div class="card bg-secondary text-light">
                            <div class="card-body text-center">
                                <i class="far fa-vial fa-2x"></i>
                            </div>
                            <h3 class="card-title mb-3">${requestScope.subjects[10].getSubjectName()}</h3>
                            <p class="card-text">
                                ${requestScope.subjects[10].getDescription()}
                            </p>
                            <a href="<i:ReadUrlFromContext url="/SubjectDescrip?subId=${requestScope.subjects[9].getSubjectID()}"/>" class="btn btn-primary"> Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </c:if>
    <!-- Include footer of web site from general -->
    <%@include file="./footer.jsp" %>

    <!-- link to java script file -->
    <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
crossorigin="anonymous"></script>
</html>
