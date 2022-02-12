<%-- 
    Document   : ViewRequestDetailTea
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/requestMain.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/createRequest.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/viewRequestDetailTea.css" />">
            
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Request Handling</title>
    </head>
    <body>
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
              <a class="nav-link" href="listAllRequestStu">
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
              <a class="backBtn" href="listAllRequestTea"
                ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
              >
            </div>
            <hr />
            <!-- Create Container -->
            <div class="create-container">
              <!-- Request Info -->
              <div class="createContent mb-4">
                <form action="createRequestReply" method="post">
                  <div class="card p-2 mb-4">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">1. Infomation</h5>
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
                     <input type="hidden" id="custId" name="teacherSent" value="thuhuong">
                     
                        </div>
                      </fieldset>
                    </div>
                  </div>
                  <div class="card shadow p-2">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">2. Content</h5>
                      <div class="responseContent--text mt-3">
                        <label for="AnswerTextarea">Topic: </label>
                        <textarea
                          class="AnswerTextarea"
                          id="AnswerTextarea"
                          rows="5"
                          style="width: 100%"
                          readonly
                        >
${requestScope.request.getContent()}
                        </textarea>
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
                  <a href="#answerCard" class="btn btn-primary mt-3 mb-5 acceptBtn">
                    Accept Request
                  </a>
                  <a href="#" class="btn btn-primary mt-3 mb-5">Reject Request</a>

                  <div class="card shadow answerCard p-2" id="answerCard">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">Answer</h5>
                      <div class="responseContent--text mt-3">
                        <label for="AnswerTextarea">Content: </label>
                        <textarea
                          class="AnswerTextarea"
                          id="AnswerTextarea"
                          rows="5"
                          style="width: 100%"
                          name="contentReply"
                        >
                        </textarea>
                      </div>
                      <label for="formFile" class="form-label"> Image attachment: </label>
                      <input class="form-control" type="file" id="formFile" name="imgReply" />
                    </div>
                  </div>

                  <input type="submit" class="btn btn-primary mt-3 mb-5 doneBtn" value="Done" />
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
    
    <!-- Datatable Jquery library -->    
      <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
      <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>

     <!-- link to java script file -->
    <script src="<i:ReadUrlFromContext url="/assets/js/requestMain.js"/>"></script>
    <script src="<i:ReadUrlFromContext url="/assets/js/viewRequestDetailTea.js"/>"></script>

    </body>
</html>
