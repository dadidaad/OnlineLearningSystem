<%-- 
    Document   : ListAllRequestTea
    Created on : Feb 10, 2022, 5:01:52 PM
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestListStu.css" />">
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Request List</title>
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
              <h3 >Request List</h3>
             </div>
            
        <!--Top NavigatorTab-->   
            <div class="card shadow mb-4">
              <div class="navbar--top__container" id="navbarNav">
                <ul class="navbar--top">
                   <li class="nav-item active">
                    <a class="nav-link" href="#" value="Waiting">Pending Request</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#" value="Approved">Done Request</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#" value="Report">Report Processing</a>
                  </li>
                  
                </ul>
              </div>
        <!--Request List Table-->        
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table requestTable" id="dataTable" width="100%" cellspacing="0" >
                    <thead>
                      <tr>
                        <th>No</th> 
                        <th>Time Create</th>
                        <th>Author</th>
                        <th>Title</th>
                        <th>Level</th>
                        <th>Price</th>
                        <th>Detail</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>No</th> 
                        <th>Time Create</th>
                        <th>Author</th>
                        <th>Title</th>
                        <th>Level</th>
                        <th>Price</th>
                        <th>Detail</th>
                        <th></th>
                      </tr>
                    </tfoot>
                    <tbody id="changeData">
                       <c:forEach items="${requestScope.requests}" var ="r" varStatus="loop">   
                      <tr>
                        <td>${loop.index+1}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value = "${r.getCreatedTime()}" /></td>
                        <td>${requestScope.displayNames.get(r.getStudentSent())}</td>
                        <td>${r.getTitle()}</td>
                        <td>Class ${r.getLevel()}</td>
                        <td>${r.getCost()} <Span>VND</Span></td>
                        <td>
                          <a href="ViewRequestTea?requestId=${r.getRequestID()}"><i class="far fa-eye"></i></a>
                        </td>
                        <c:if test = "${sessionScope.user.getUsername().equalsIgnoreCase(r.getTutorGet())}">
                        <td><i class="far fa-star"></i></td>
                        </c:if>
                        <c:if test = "${!sessionScope.user.getUsername().equalsIgnoreCase(r.getTutorGet())}">
                        <td></td>
                        </c:if>
                      </tr> 
                      </c:forEach>
                      
                    </tbody>
                  </table>
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

    <!--Ajax Library-->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
    <!-- link to java script file -->
    <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
    <script src="<i:ReadUrlFromContext url="/assets/js/RequestListTea.js"/>"></script>
    <script src="<i:ReadUrlFromContext url="/assets/js/ChangeRequestByAjax.js"/>"></script>
    
    <!-- Datatable Jquery library -->    
<!--      <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
      <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>-->

    </body>
</html>
