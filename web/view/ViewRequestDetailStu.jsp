<%-- 
    Document   : ViewRequestDetailStu
    Created on : Feb 11, 2022, 9:41:09 PM
    Author     : Duc Minh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />
        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestMain.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ViewRequestDetailStu.css" />">

        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title>Request Handling</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <jsp:include page="./header.jsp"></jsp:include>
            <div id="wrapper" class="d-flex">
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

                            <!-- This link for list all teacher table-->
                            <li class="nav-link">
                                <a href="ListAllTeacher">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Teacher Ranking</span>
                                </a>
                            </li>
                            <li class="nav-link">
                                <a href="ListAllRequest">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">My Request</span>
                                </a>
                            </li>
                           
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
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <div class="card--top"></div>
                        <h1>Request</h1>
                        <p>The request in our system contains exercise has sent by Student to Teacher in website.</p>
                        
                        <hr />
                        <div class="card--top--menu d-flex">
                            <h3>Response</h3>
                            <a class="createRequestBtn" href="CreateRequest">Creare Request</a>
                        </div>
                        <div class="backBtn-container">
                            <a class="backBtn" href="ListAllRequest"
                               ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
                            >
                        </div>
                        <hr />
                        <!-- Response Content for Request-->
                        <div class="response-container row">
                            <div class="responseContent--main col-sm-8">
                                <div class="responseContent--img">
                                    <img
                                        class="imgZoom"
                                        src="<i:ReadUrlFromContext url="${requestScope.requestReply.getImageLinkReply()}" />"
                                        alt=""
                                        />
                                    <c:if test = "${requestScope.requestReply==null}">
                                        <img
                                            src="<i:ReadUrlFromContext url="/assets/image/f1777bc40411988af0a87383e5f2fbde9c76ba9f.png" />"
                                            alt=""

                                            />
                                    </c:if>
                                </div>

                                <div class="responseContent--text form-group">
                                    <c:if test = "${requestScope.requestReply==null}">
                                        <p>Please waiting for teacher. Don't worry ^__^</p>
                                    </c:if>
                                    <c:if test = "${requestScope.requestReply!=null}"> 
                                        <label for="AnswerTextarea">Answer</label>
                                        <textarea class="AnswerTextarea" id="AnswerTextarea" rows="8" readonly>${requestScope.requestReply.getContentReply()}</textarea
                                        >
                                    </c:if>   
                                </div>

                                <c:if test = "${requestScope.requestReply!=null}">
                                    <div class="responseContent--btn">
                                        <button type="button" class="btn btn-success">Accept</button>
                                        <button type="button" class="btn btn-danger">Not Accept</button>
                                    </div>
                                </c:if>

                            </div>
                            <!-- Request Info -->
                            <div class="responseContent--info mb-4 col-sm-4">
                                <div class="card shadow p-2">
                                    <h5 class="text-center">Content Request</h5>
                                    <hr />
                                    <div class="card-body requestStuInfo">
                                        <ul>
                                            <li><em>Create Time: </em><span><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${request.getCreatedTime()}" /></span></li>
                                            <li><em>Title: </em><span>${requestScope.request.getTitle()}</span></li>
                                            <li><em>Subject: </em><span>${requestScope.subjectNames.get(request.getSubjectID())}</span></li>
                                            <li><em>Level: </em><span>Class ${requestScope.request.getLevel()}</span></li>
                                            <li><em>Price: </em><span>${requestScope.request.getCost()}</span><span> VND</span></li>
                                            <li><em>Status: </em><span>${requestScope.request.getStatus()}</span></li>
                                            <li><em>Teacher recommend: </em><span>${requestScope.displayNames.get(request.getTutorGet())}</span></li>
                                            <li>
                                                <em>Topic: </em
                                                ><span class="requestStuInfo--topic hiddenTopic"
                                                       >${requestScope.request.getContent()}</span
                                                >
                                                <a href="#" class="requestTopicMore">More</a>
                                            </li>
                                            <li>
                                                <em>Image: </em><span></span
                                                ><img
                                                    class="imgZoom"
                                                    src="<i:ReadUrlFromContext url="${requestScope.request.getImageLink()}"/>"
                                                    alt=""
                                                    />
                                            </li>
                                        </ul>
                                        <!--Update and Delete Request Button-->                  
                                        <div class="responseContent--btn">
                                            <a href="UpdateRequest?requestId=${requestScope.request.getRequestID()}" style="margin-right: 32px;" class="btn btn-update">
                                                <i class="far fa-edit"></i> Update</a
                                            ><a href="DeleteRequest?requestId=${requestScope.request.getRequestID()}" style="margin-right: 32px;" class="btn btn-delete">
                                                <i class="far fa-trash-alt"></i> Delete
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- End of Main Content -->


                </div>
                <!-- End of Content Wrapper -->
            </div>
            <!-- End of Content Wrapper -->
        </div>

        <!-- End of Page Wrapper -->
        <!-- Modal Image -->
        <div id="myModal" class="modal--Img">
            <span class="close--Img">&times;</span>
            <img class="modal-content--Img" id="img01" />
            <div id="caption"></div>
        </div>


        <!-- Footer -->
        <%@include file="./footer.jsp" %>
        <!-- End of Footer -->

        <!-- Datatable Jquery library -->    
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/ViewRequestDetailStu.js"/>"></script>

    </body>
</html>
