<%-- 
    Document   : ViewRequestDetailTea
    Created on : Feb 11, 2022, 9:41:09 PM
    Author     : Duc Minh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>"/>
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestMain.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ViewRequestDetailTea.css" />">

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
                                    <span class="text nav-text">Request List</span>
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
                        <div class="card--top--menu d-flex" id="cardTop">
                            <h3>Request Handling</h3>
                        </div>
                        <div class="backBtn-container">
                            <a class="backBtn" href="ListAllRequest"
                               ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
                            >
                        </div>
                        <hr />
                        <!-- Handle Container -->
                        <div class="create-container">

                            <!-- Request Info Section-->
                            <div class="createContent mb-4">
                                <form action="CreateRequestReply" method="post" id="replyForm">
                                    <div class="card p-2 mb-4">
                                        <div class="card-body">

                                            <h4 class="text-hightlight1 mb-32px">1. Infomation</h4>
                                            <!--Request's Infomation-->               
                                            <input type="hidden" id="requestId" name="requestId" value="${requestScope.request.getRequestID()}">  
                                            <input type="hidden" id="custId" name="studentSent" value="${requestScope.request.getStudentSent()}">  
                                            <label for="reTitle" class="d-block">Request Title: </label>
                                            <input
                                                type="text"
                                                id="reTitle"
                                                name="reTitle"
                                                class="form-control"
                                                value="${requestScope.request.getTitle()}"
                                                readonly
                                                /><br />
                                            <div class="row">
                                                <div class="form-group col-sm-6">
                                                    <label for="reSubject">Subject: </label>
                                                    <select class="form-control" id="reSubject" disabled>
                                                        <option>${requestScope.subjectNames.get(request.getSubjectID())}</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-sm-6">
                                                    <label for="reClass">Class: </label>
                                                    <select class="form-control" id="reClass" disabled>
                                                        <option value="">${requestScope.request.getLevel()}</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-sm-6">
                                                    <label for="rePrice">Price: </label>
                                                    <select class="form-control" id="rePrice" disabled>
                                                        <option value="">${requestScope.request.getCost()}</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <br />
                                            <fieldset class="mr-5 mb-4 form-group">
                                                <legend class="text-bold2 mb-12px h6">Teacher Recommend</legend>
                                                <div class="offline-box flex-box align-items-start">
                                                    <c:if test = "${requestScope.request.getTutorGet()==null}">
                                                        <div class="mr-5 form-check">
                                                            <label class="mb-0 cursor-pointer text-nowrap false"
                                                                   ><input
                                                                    type="checkbox"
                                                                    checked
                                                                    disabled
                                                                    />None</label
                                                            >
                                                        </div>
                                                    </div>      
                                                    <div class="offline-box flex-box align-items-start">
                                                    </c:if>  
                                                    <c:if test = "${requestScope.request.getTutorGet()!=null}">
                                                        <div class="form-check">
                                                            <label class="mb-12px cursor-pointer text-grey"
                                                                   ><input
                                                                    type="checkbox"
                                                                    checked
                                                                    disabled
                                                                    />Yes</label
                                                            >
                                                            <a href="#" style="text-decoration: none" class="">${requestScope.displayNames.get(requestScope.request.getTutorGet())}</a>
                                                        </div>
                                                    </c:if>  
                                                    <input type="hidden" id="custId" name="teacherSent" value="${sessionScope.user.getUsername()}">

                                                </div>
                                            </fieldset>
                                        </div>
                                    </div>
                                    <div class="card shadow p-2">
                                        <div class="card-body">
                                            <!--Request's Content-->               
                                            <h4 class="text-hightlight1 mb-32px">2. Content</h4>
                                            <div class="responseContent--text mt-3">
                                                <label for="AnswerTextarea">Topic: </label>
                                                <textarea
                                                    class="AnswerTextarea"
                                                    id="AnswerTextarea"
                                                    rows="5"
                                                    style="width: 100%"
                                                    readonly
                                                    >${requestScope.request.getContent()}</textarea>
                                            </div>
                                            <label for="formFile" class="form-label"> Image attachment: </label>
                                            <img
                                                class="d-block imgZoom"
                                                src="${requestScope.request.getImageLink()}"
                                                alt=""
                                                style="max-width: 600px; max-height: 600px"
                                                />
                                        </div>
                                    </div>
                                    <c:set var="rqStatus" value="${requestScope.request.getStatus()}"/>            
                                    <!--Request Decision-->    
                                    <c:if test = "${fn:toLowerCase(rqStatus) == 'waiting'}">
                                        <a href="#answerCard" class="btn btn-primary mt-3 mb-5 acceptBtn" id="accept-btn">
                                            Accept Request
                                        </a>
                                        <a href="ListAllRequest" class="btn btn-secondary mt-3 mb-5">Reject Request</a>
                                    </c:if>         
                                    <p class="text-success" id="noti-accept"></p>
                                    <div class="card shadow answerCard p-2 mt-3" id="answerCard">
                                        <div class="card-body">
                                            <h4 class="text-hightlight1 mb-32px">3.Answer</h4>
                                            <div class="responseContent--text mt-3">
                                                <label for="AnswerTextarea">Content: </label>
                                                <span style="font-size: 12px;color: red;">*Required</span>
                                                <textarea class="TopicTextArea" name="contentReply" style="width: 100%" id="message" type="text" value="" minlength="10" maxlength="1000" rows="5" cols="30" dir="ltr" required></textarea>
                                            </div>
                                            <label for="formFile" class="form-label"> Image attachment: </label>
                                            <input class="form-control" type="file" id="formFile" name="imgReply" />
                                        </div>
                                    </div>

                                    <input type="submit" class="btn btn-primary mt-3 mb-5 doneBtn" value="Done" onclick="submit_form();"/>
                                </form>
                                <!--The Answer of Request-->        
                                <c:if test = "${requestScope.requestReply!=null}">
                                    <div class="card shadow p-2" id="answerCard">
                                        <div class="card-body">
                                            <h4 class="text-hightlight1 mb-32px">3.Answer</h4>
                                            <div class="responseContent--text mt-3">
                                                <label for="AnswerTextarea">Content: </label>

                                                <textarea class="TopicTextArea" name="contentReply" style="width: 100%" id="message" type="text" value="" minlength="10" maxlength="1000" rows="5" cols="30" dir="ltr" readonly>${requestScope.requestReply.getContentReply()}</textarea>
                                            </div>
                                      
                                            <em class="d-block">Image: (if exist)</em><span></span>
                                            <img
                                                class="imgZoom mt-3"
                                                src="<i:ReadUrlFromContext url="${requestScope.requestReply.getImageLinkReply()}"/>"
                                                alt=""
                                                style="box-shadow: 0 0 0 1px graytext;"
                                                />
                                        </div>
                                    </div>
                                                
                                </c:if>    
                            </div>
                        </div>
                    </div>
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

        <!-- link to java script file -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/ViewRequestDetailTea.js"/>"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidatorRequest.js"/>"></script>
        <script>
                                        $(document).ready(function () {
                                            $('#accept-btn').click(function () {
                                                var requestId = $('#requestId').val();
                                                $.ajax({
                                                    url: 'ChangeStatusRequest',
                                                    data: {"requestId": requestId},
                                                    type: 'POST',
                                                    success: function (result) {
                                                        $('#noti-accept').html(result);
                                                    }
                                                });
                                            });
                                        });
        </script>
        <script>
            $(document).ready(function () {

                $.validator.addMethod("noSpace", function (value, element) {
                    return !value.trim() == '';
                }, "No space please and don't leave it empty");
                $.validator.addMethod("minLength", function (value, element, param) {
                    return this.optional(element) || value.trim().length > param;
                }, "Please enter at least 10 characters.");
                $.validator.addMethod("maxLength", function (value, element, param) {
                    return this.optional(element) || value.trim().length < param;
                }, "Please enter no more than 1000 characters.");
                $("#replyForm").validate({
                    onblur: true,
                    rules: {
                        message: {
                            required: true,
                            noSpace: true,
                            minLength: 10,
                            maxLength: 1000
                        }
                    },
                    messages: {
                        message: {
                            required: "Please fill this Content"
                        }
                    }
                });
            });
        </script>
        <script>
            var content = document.querySelector("#message");
            var submitBtn = document.querySelector(".doneBtn")
            submitBtn.addEventListener('click', function (e) {
                if (content.value.trim() == "") {
                    e.preventDefault();
                    alert('You must not enter only the full distance in this field!');
                }
            });
        </script>
        <script>
            $(document).ready(function () {
                $("#cardTop")[0].scrollIntoView({
                    behavior: "smooth", // or "auto" or "instant"
                    block: "start" // or "end"
                });
            });
        </script>
    </body>
</html>
