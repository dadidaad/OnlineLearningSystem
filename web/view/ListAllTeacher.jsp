<%-- 
    Document   : ListAllTeacher
    Created on : Feb 10, 2022, 7:37:51 AM
    Author     : Duc Minh
--%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestMain.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListAllTeacher.css" />">


        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Teacher Ranking</title>
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

       <li class="nav-item active">
              <a class="nav-link" href="ListAllTeacher">
                <i class="fas fa-fw fa-table"></i>
                <span>Teacher List</span></a
              >
        </li>
        <li class="nav-item">
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
            <div class="card--top"></div>
            
        <!-- Requests DataTales -->
            <div class="card shadow mb-4">
              <h1>Teacher Ranking</h1>
              <p>List of all the teachers in our system is sorted by student-rated reputation.</p>
              <div class="card-body">
                <div class="row">
                  <div class="col-sm-12 col-md-6"></div>
                  <div class="col-sm-12 col-md-6">
                    <div id="dataTable_filter" class="dataTables_filter">
                      <label
                        >Search:<input
                          type="search"
                          class="form-control form-control-sm"
                          placeholder=""
                          id="SearchInput"
                          aria-controls="dataTable"
                      /></label>
                    </div>
                  </div>
                </div>
                <div class="table-responsive">
                  <table
                    class="table table-striped tableTeacher"
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
                        <th>CV</th>
                      <c:if test = "${!sessionScope.user.getRole().equalsIgnoreCase("teacher")}">
                        <th>Request</th>
                      </c:if>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Reputation</th>
                        <th>Subject</th>
                        <th>CV</th>
                      <c:if test = "${!sessionScope.user.getRole().equalsIgnoreCase("teacher")}">
                        <th>Request</th>
                      </c:if>  
                      </tr>
                    </tfoot>
                    <tbody id="tbBody">
                    <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop"> 

                      <tr>
                        <td>${loop.index+1}</td>
                        <td>
                          <a class="teacherInfo" href="#">
                              <img id="teacheravt" class="teacherAvt" src="${t.getAvatar()}"/>
                              ${t.getDisplayName()}
                          </a>
                        </td>
                        <td>4.1</td>
                        <td>${requestScope.subjectNames.get(t.getSubjectId())}</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="${t.getCvImg()}"
                            alt=""
                          />
                        </td>
                        <c:if test = "${!sessionScope.user.getRole().equalsIgnoreCase("teacher")}">
                        <td>
                          <a href="CreateRequest?teacherRcmFromList=${t.getUsername()}"><i class="far fa-share-square"></i></a>
                        </td>
                        </c:if>
                      </tr>
                      
                      </c:forEach>   
                      
                    </tbody>
                  </table>
                </div>
                <div class="row">
                  <div class="col-sm-12 col-md-4"></div>
                  <div class="col-sm-12 col-md-8">
                    <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                      <ul class="pagination">
                        <li
                          class="paginate_button page-item previous disabled"
                          id="dataTable_previous"
                        >
                          <a
                            href="#"
                            aria-controls="dataTable"
                            data-dt-idx="0"
                            tabindex="0"
                            class="page-link"
                            >Previous</a
                          >
                        </li>
                        <li class="paginate_button page-item active">
                          <a
                            href="#"
                            aria-controls="dataTable"
                            data-dt-idx="1"
                            tabindex="0"
                            class="page-link"
                            >1</a
                          >
                        </li>
                        <li class="paginate_button page-item next disabled" id="dataTable_next">
                          <a
                            href="#"
                            aria-controls="dataTable"
                            data-dt-idx="2"
                            tabindex="0"
                            class="page-link"
                            >Next</a
                          >
                        </li>
                      </ul>
                    </div>
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
    <!-- End of Page Wrapper -->
        
    <!-- Footer -->
    <%@include file="./footer.jsp" %>
    <!-- End of Footer -->
    
    
    <!-- Modal Image -->
    <div id="myModal" class="modal--Img">
      <span class="close--Img">&times;</span>
      <img class="modal-content--Img" id="img01" />
      <div id="caption"></div>
    </div>
     <!--Ajax Library-->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <!-- link to java script file -->
    <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
    <script src="<i:ReadUrlFromContext url="/assets/js/ListAllTeacherSearchUsingAjax.js"/>"></script>
    
    </body>
</html>
