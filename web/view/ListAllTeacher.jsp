<%-- 
    Document   : ListAllTeacher
    Created on : Feb 10, 2022, 7:37:51 AM
    Author     : Duc Minh
--%>

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
        <link rel="stylesheet" href="../assets/css/requestMain.css" />
        <link rel="stylesheet" href="../assets/css/listAllTeacher.css" />

        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Teacher Ranking</title>
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

        <li class="nav-item active">
          <a class="nav-link" href="listAllTeacher.html">
            <i class="fas fa-fw fa-table"></i>
            <span>Teacher List</span></a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link" href="requestListStu.html">
            <i class="fas fa-fw fa-table"></i>
            <span>Request List</span>
          </a>
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

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
              <h1>Teacher Ranking</h1>
              <p>List of all the teachers in our system is sorted by student-rated reputation.</p>
              <div class="card-body">
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
                        <th>Request</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Reputation</th>
                        <th>Subject</th>
                        <th>CV</th>
                        <th>Request</th>
                      </tr>
                    </tfoot>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>
                          <a class="teacherInfo" href="#"
                            ><img
                              class="teacherAvt"
                              src="./assets/img/teacher_81762259.jpg"
                              alt=""
                            />Nguyen Lan Anh</a
                          >
                        </td>
                        <td>4.6</td>
                        <td>Math</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="./assets/img/cv_template_1.jpg"
                            alt=""
                          />
                        </td>
                        <td>
                          <a href="#"><i class="far fa-share-square"></i></a>
                        </td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>
                          <a class="teacherInfo" href="">
                            <img
                              class="teacherAvt"
                              src="./assets/img/teacher_81762259.jpg"
                              alt=""
                            />Bui Thi Van
                          </a>
                        </td>
                        <td>4.6</td>
                        <td>Math</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="./assets/img/cv_template_1.jpg"
                            alt=""
                          />
                        </td>
                        <td>
                          <a href="#"><i class="far fa-share-square"></i></a>
                        </td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>
                          <a class="teacherInfo" href="">
                            <img
                              class="teacherAvt"
                              src="./assets/img/teacher_81762259.jpg"
                              alt=""
                            />Nguyen Thi Trang
                          </a>
                        </td>
                        <td>4.6</td>
                        <td>Math</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="./assets/img/cv_template_1.jpg"
                            alt=""
                          />
                        </td>
                        <td>
                          <a href="#"><i class="far fa-share-square"></i></a>
                        </td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>
                          <a class="teacherInfo" href="">
                            <img
                              class="teacherAvt"
                              src="./assets/img/teacher_81762259.jpg"
                              alt=""
                            />Hoang Ngoc Anh
                          </a>
                        </td>
                        <td>4.6</td>
                        <td>Math</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="./assets/img/cv_template_1.jpg"
                            alt=""
                          />
                        </td>
                        <td>
                          <a href="#"><i class="far fa-share-square"></i></a>
                        </td>
                      </tr>
                      <tr>
                        <td>5</td>
                        <td>
                          <a class="teacherInfo" href="">
                            <img
                              class="teacherAvt"
                              src="./assets/img/teacher_81762259.jpg"
                              alt=""
                            />Nguyen Thuy Van
                          </a>
                        </td>
                        <td>4.6</td>
                        <td>Math</td>
                        <td>
                          <img
                            class="teacherCv imgZoom"
                            src="./assets/img/cv_template_1.jpg"
                            alt=""
                          />
                        </td>
                        <td>
                          <a href="#"><i class="far fa-share-square"></i></a>
                        </td>
                      </tr>
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
    <!-- Modal Image -->
    <div id="myModal" class="modal--Img">
      <span class="close--Img">&times;</span>
      <img class="modal-content--Img" id="img01" />
      <div id="caption"></div>
    </div>
    
    <!-- Datatable Jquery library -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>

    <script src="../assets/js/requestMain.js"></script>
    <script src="../assets/js/listAllTeacher.js"></script>
    </body>
</html>
