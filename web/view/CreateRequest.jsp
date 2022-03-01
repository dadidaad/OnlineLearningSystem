<%-- 
    Document   : CreateRequest
    Created on : Feb 10, 2022, 5:10:23 PM
    Author     : Duc Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/CreateRequest.css" />">
       
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Create Request</title>
    </head>
    <body>
         <!-- Include header of web site from general-->
         <jsp:include page="./header.jsp"></jsp:include>
        <!--Main Content--> 
         <div id="wrapper" class="d-flex">
      <!-- Sidebar -->
      <ul
        class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
        id="accordionSidebar"
      >
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
          <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-users-cog"></i>
          </div>
          <div class="sidebar-brand-text mx-3">REQUEST</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0" />

        <!-- Nav Item  -->

        <li class="nav-item">
          <a class="nav-link" href="ListAllTeacher">
            <i class="fas fa-fw fa-table"></i>
            <span>Teacher List</span></a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListAllRequest">
            <i class="fas fa-fw fa-table"></i>
            <span>Request List</span>
          </a>
        </li>

        <li class="nav-item active">
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
              <h3>Creare Request</h3>
            </div>
            <div class="backBtn-container">
              <a class="backBtn" href="ListAllRequest"
                ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
              >
            </div>
            <hr />
            <!-- Create Container -->
            <div class="create-container">
              <!-- Request Info -->
              <div class="createContent mb-4">
                <form action="CreateRequest" method="post" id="createFrom" class="form">
                   
                  <div class="card p-2 mb-4">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">1. Infomation</h5>
                      
                      <div class="form-group">
                <!--Title Section-->          
                        <label for="rqTitle" class="d-block">Request Title: </label>
                        <span style="font-size: 12px;color: red;">*Required</span>
                        <input type="text" id="rqTitle" name="rqTitle" class="form-control" /><br />
                        <span class="form-message"></span>
                      </div> 
                      <div class="row">
                        <div class="form-group col-sm-6">
                <!--Subject Section-->
                          <label for="rqSubject">Subject: </label>
                          <span style="font-size: 12px;color: red;">*Required</span>
                          <select class="form-control" id="rqSubject" name="rqSubject" required>
                            <option value="" disabled selected>Select Subject</option>
                          <c:forEach items="${requestScope.subjects}" var ="s" varStatus="loop">    
                            <option value="${s.getSubjectID()}">${s.getSubjectName()}</option>
                          </c:forEach>  
                          </select>
                          <span class="form-message"></span>
                        </div>
                        <div class="form-group col-sm-6">
                <!--Level Section-->            
                          <label for="rqLevel">Grade: </label>
                          <span style="font-size: 12px;color: red;">*Required</span>
                          <select class="form-control" id="rqLevel" name="rqLevel" required>
                            <option value="" disabled selected>Select Class</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                          </select>
                          <span class="form-message"></span>
                        </div>
                        <div class="form-group col-sm-6">
                <!--Price Section-->             
                          <label for="rqPrice">Price: </label>
                          <span style="font-size: 12px;color: red;">*Required</span>
                          <select class="form-control" id="rqPrice" name="rqPrice" required>
                            <option value="" disabled selected>Select Price</option>
                            <option value="5000">5.000 <span>VND</span></option>
                            <option value="10000">10.000 <span>VND</span></option>
                            <option value="15000">15.000 <span>VND</span></option>
                            <option value="20000">20.000 <span>VND</span></option>
                            <option value="25000">25.000 <span>VND</span></option>
                            <option value="30000">30.000 <span>VND</span></option>
                            <option value="40000">40.000 <span>VND</span></option>
                            <option value="50000">50.000 <span>VND</span></option>
                          </select>
                          <span class="form-message"></span>
                        </div>
                      </div>
                      <br />
                      <fieldset class="mr-5 mb-4 form-group">
                <!--Teacher Recommend-->          
                        <legend class="text-bold2 mb-12px h6">Teacher Recommend</legend>
                        <c:if test = "${requestScope.rqTeacherRcmFromList==null}">
                        <div class="offline-box flex-box align-items-start">
                          <div class="mr-5 form-check">
                            <label class="mb-0 cursor-pointer text-nowrap false"
                              ><input
                                name="teacherRcmCheck"
                                type="radio"
                                class="form-check-input"
                                checked=""
                                value="0"
                              />None</label
                            >
                          </div>
                          <div class="form-check">
                            <label class="mb-12px cursor-pointer text-grey"
                              ><input
                                name="teacherRcmCheck"
                                type="radio"
                                class="form-check-input teacherOption"
                                value="1"
                              />Yes</label
                            >
                           
                            <a style="text-decoration: none" href="#" class="teacherRecommend--name"></a>
                            
                            
                          
                            <input type="hidden" id="teacherUsernameRcm" name="rqTeacherRcm" readonly >
                            <input type="hidden" id="studentSent" name="studentSent" value=${sessionScope.user.getUsername()}>  
                          </div>
                          <button
                            type="button"
                            class="btn btn-primary mt-3 teacherRecommend--btn"
                            data-toggle="modal"
                            data-target="#teacherListModal"
                          >
                            Find Teacher...
                          </button>
                        </div>
                        </c:if>
                        <c:if test = "${requestScope.rqTeacherRcmFromList!=null}">
                                <input type="text" id="teacherUsernameRcmfrList" name="rqTeacherRcmFromList" readonly value="${rqTeacherRcmFromList}">
                        </c:if>
                      </fieldset>
                    </div>
                  </div>
                    
                <!--Content Section-->    
                  <div class="card shadow p-2">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">2. Content</h5>
                      <span style="font-size: 12px;color: red;">*Required</span>
                      <div class="form-group responseContent--text mt-3">
                        <label for="TopicTextArea">Topic</label>
                        <textarea class="TopicTextArea" name="content" style="width: 100%" id="message" type="text" value="" minlength="10" maxlength="1000" rows="5" cols="30" dir="ltr" required></textarea>
           
                        <span class="form-message"></span>
                      </div>
                      <div class="form-group">
                      <label for="formFile" class="form-label"> Image attachment </label>
                      <input class="form-control" type="file" id="formFile" name="imgContent"/>
                      <span class="form-message"></span>
                      </div>
                    </div>
                  </div>
                  <input type="submit" class="btn btn-primary mt-3" value="Send Request" />
                </form>

              </div>
            </div>
          </div>
        </div>
        
        <!-- End of Content Wrapper -->
      </div>

      <!-- End of Page Wrapper -->
    </div>
    
    <!-- Footer -->
    <%@include file="./footer.jsp" %>
    <!-- End of Footer -->
    
    <!-- Modal Image -->
    <div id="myModal" class="modal--Img">
      <span class="close--Img">&times;</span>
      <img class="modal-content--Img" id="img01" />
      <div id="caption"></div>
    </div>
    <!-- Modal Teacher List -->
    <div
      class="modal fade"
      id="teacherListModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header float-right">
            <h5>User details</h5>
            <div class="text-right">
              <i data-dismiss="modal" aria-label="Close" class="fa fa-close"></i>
            </div>
          </div>
          <div class="modal-body">
            <div class="table-responsive">
              <table
                class="table table-hover tableTeacher"
                id="dataTable"
                width="100%"
                cellspacing="0"
              >
                <thead>
                  <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Reputation</th>
                    <th>Subject</th>
                    <th></th>
                    <th>Request</th>
                  </tr>
                </thead>

                <tbody>

                 <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop"> 
                    <c:if test = "${requestScope.teachers.size()==0}">
                        <tr>List Empty</tr>
                    </c:if>
                      <tr>
                        <td>${loop.index+1}</td>
                        <td>
                          <a class="teacherInfo" href="#"
                            ><img
                              class="teacherAvt"
                              src="<i:ReadUrlFromContext url="${t.getAvatar()}"/>"
                              alt=""
                            />${t.getDisplayName()}</a
                          >
                        </td>
                        <td>4.1</td>
                        <td>${requestScope.subjectNames.get(t.getSubjectId())}</td>
                        <td>
                          <input type="hidden" id="teacherUsername" value="${t.getUsername()}"> 
                        </td>
                        <td>
                        <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="${t.getUsername()}"
                        aria-label="Close"
                        id="closemodal"
                        >
                        Select
                        </button>
                        </td>
                      </tr>
                      
                      </c:forEach> 
                </tbody>
              </table>
            </div>
          </div>
          <button type="button" class="btn btn-primary saveBtn mb-4" data-dismiss="modal">
            Save
          </button>
        </div>
      </div>
    </div>
     
     <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>

    <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidatorRequest.js"/>"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
    <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->

    <!-- Datatable Jquery library -->
    <!--<script src="https://code.jquery.com/jquery-3.5.1.js"></script>-->
    <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>

    
    <!-- link to java script file -->
    <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
    
    <script src="<i:ReadUrlFromContext url="/assets/js/CreateRequest.js"/>"></script>
    
    
    </body>
</html>

