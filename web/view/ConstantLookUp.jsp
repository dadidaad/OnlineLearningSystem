<%-- 
    Document   : ConstantLookUp
    Created on : Feb 22, 2022, 4:07:25 PM
    Author     : Doan Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ConstantLookUpStyle.css" />">
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
                            <a href="#">
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
                        <h1>Searching <span class="text-warning">Important Constant</span></h1>
                        <p class="lead my-5">
                            Throughout the high school curriculum, the natural sciences have a lot 
                            of important constants that students need to remember, but unfortunately, 
                            those are long numbers and it's hard to remember. This will be where you 
                            can see those important constants. Also, you can look up the constants you 
                            want to search for.
                        </p>
                    </div>
                    <img class="img-fluid w-50 mx-3 d-none d-sm-block" src="<i:ReadUrlFromContext url="/assets/image/istockphoto-1206750602-1024x1024.jpg" />" alt="">
                </div>
            </div>
        </section>

        <!--Lookup header -->
        <div class="lookup-header"><h1 data-text="Constant" class="text-head">Constant</h1></div>
        <div class="lookup">
            
            <!-- Search -->
            <div class="search-container">
                <div class="header-search">
                    <h2>Searching Constant</h2>
                </div>
                <form action="ConstantTableController" method="Post" id="form1">
                    <div class="search-box">
                        <span>Name</span>
                        <div class="search active">
                            <div class="sIcon"></div>
                            <div class="input">
                                <input type="text" name="name" placeholder="Search" class="mysearch" id="searchName">
                            </div>
                            <span class="clear"></span>
                        </div>
                    </div>

                    <div class="search-box">
                        <span>Signn</span>
                        <div class="search active">
                            <div class="sIcon"></div>
                            <div class="input">
                                <input type="text" name="sign" placeholder="Search" class="mysearch" id="searchSign">
                            </div>
                            <span class="clear"></span>
                        </div>
                    </div>
                    <span class="error">Error message</span>
                    <button type="submit">Search</button>
                </form>
            </div>
            
            <!-- Lookup table-->
            <div class="table">
                <table>
                    <thead>
                        <tr>
                            <th>Const No</th>
                            <th>Name</th>
                            <th>Sign</th>
                            <th>Value</th>
                            <th>Unit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.constants}" var="c" varStatus="loop">
                            <tr>
                                <td>${c.getConstantID()}</td>
                                <td class="name">${c.getConstantName()}
                                    <span class="tooltip1">
                                        <div class="tooltip-header">
                                            <h4>Kí hiệu: ${c.getSign()}</h4>
                                        </div>
                                        <p>${c.getDescription()}</p>
                                    </span>
                                </td>
                                <td>${c.getSign()}</td>
                                <td>${c.getValue()}</td>
                                <td>${c.getUnit()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/ConstantLookUpScript.js"/>"></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
    crossorigin="anonymous"></script>
</html>
