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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestMain.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ViewRequestDetailTea.css" />">

        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Request Handling</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <jsp:include page="./header.jsp"></jsp:include>
            <div id="wrapper" class="d-flex">
                <!-- Sidebar -->
                <ul
                    class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
                    id="accordionSidebar"
                    >

                    <!-- Divider -->
                    <hr class="sidebar-divider my-0" />


                    <!-- Nav Item  -->

                    <li class="nav-item">
                        <a class="nav-link" href="ListAllTeacher">
                            <i class="fas fa-fw fa-table"></i>
                            <span>Teacher List</span></a
                        >
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="ListAllRequest">
                            <i class="fas fa-fw fa-table"></i>
                            <span>Request List</span> </a
                        >
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fa-thin fa-newspaper"></i>
                            <span>Notification</span></a
                        >
                    </li>
                    <!-- Sidebar Toggler (Sidebar) -->
                    <div class="text-center d-none d-md-inline">
                        <button class="rounded-circle border-0" id="sidebarToggle"></button>
                    </div>
                </ul>
                <!-- End of Sidebar -->

                <!-- Content Wrapper -->
                <div id="content-wrapper" class="d-flex flex-column">
                    <!-- Main Content -->
                    <div id="content">
                        <!-- Begin Page Content -->
                        <div class="container-fluid">
                            <!-- Page Heading -->

                            <div class="card--top d-flex">
                                <h3>Request Handling</h3>
                            </div>
                            <div class="backBtn-container">
                                <a class="backBtn" href="ListAllRequest"
                                   ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
                                >
                            </div>
                            <hr />
                            <!-- Create Container -->
                            <div class="create-container">

                                <!-- Request Info Section-->
                                <div class="createContent mb-4">
                                    <form action="CreateRequestReply" method="post" id="replyForm">
                                        <div class="card p-2 mb-4">
                                            <div class="card-body">

                                                <h5 class="text-hightlight1 mb-32px">1. Infomation</h5>
                                                <!--Request's Infomation-->               
                                                <input type="hidden" id="custId" name="requestId" value="${requestScope.request.getRequestID()}">  
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
                                            <h5 class="text-hightlight1 mb-32px">2. Content</h5>
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
                                        <a href="#answerCard" class="btn btn-primary mt-3 mb-5 acceptBtn">
                                            Accept Request
                                        </a>
                                        <a href="ListAllRequest" class="btn btn-secondary mt-3 mb-5">Reject Request</a>
                                    </c:if>              
                                    <div class="card shadow answerCard p-2" id="answerCard">
                                        <div class="card-body">
                                            <h5 class="text-hightlight1 mb-32px">Answer</h5>
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
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/ViewRequestDetailTea.js"/>"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidatorRequest.js"/>"></script>
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
                                                        minLength:10,
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
            });

        </script>
    </body>
</html>

