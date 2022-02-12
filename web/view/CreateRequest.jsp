<%-- 
    Document   : CreateRequest
    Created on : Feb 10, 2022, 5:10:23 PM
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
        <link rel="stylesheet" href="../assets/css/createRequest.css" />

        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <title>Create Request</title>
    </head>
    <body>
        <!--Header-->
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
              <a class="backBtn" href="requestListStu.html"
                ><i class="fas fa-arrow-left"></i>&nbsp;&nbsp;<span>Back</span></a
              >
            </div>
            <hr />
            <!-- Create Container -->
            <div class="create-container">
              <!-- Request Info -->
              <div class="createContent mb-4">
                <form action="#">
                  <div class="card p-2 mb-4">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">1. Infomation</h5>

                      <label for="reTitle" class="d-block">Request Title: </label>
                      <input type="text" id="reTitle" name="fname" class="form-control" /><br />
                      <div class="row">
                        <div class="form-group col-sm-6">
                          <label for="reSubject">Subject: </label>
                          <select class="form-control" id="reSubject">
                            <option>Select Subject</option>
                            <option>Math</option>
                            <option>Chemistry</option>
                            <option>Physics</option>
                          </select>
                        </div>
                        <div class="form-group col-sm-6">
                          <label for="reClass">Class: </label>
                          <select class="form-control" id="reClass">
                            <option value="">Select Class</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                          </select>
                        </div>
                        <div class="form-group col-sm-6">
                          <label for="rePrice">Price: </label>
                          <select class="form-control" id="rePrice">
                            <option value="">Select Price</option>
                            <option>5.000 <span>VND</span></option>
                            <option>10.000 <span>VND</span></option>
                            <option>15.000 <span>VND</span></option>
                            <option>20.000 <span>VND</span></option>
                            <option>25.000 <span>VND</span></option>
                            <option>35.000 <span>VND</span></option>
                          </select>
                        </div>
                      </div>
                      <br />
                      <fieldset class="mr-5 mb-4 form-group">
                        <legend class="text-bold2 mb-12px h6">Teacher Recommend</legend>
                        <div class="offline-box flex-box align-items-start">
                          <div class="mr-5 form-check">
                            <label class="mb-0 cursor-pointer text-nowrap false"
                              ><input
                                name="offlineFlag"
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
                                name="offlineFlag"
                                type="radio"
                                class="form-check-input teacherOption"
                                value="1"
                              />Yes</label
                            >
                            <a href="#" class="teacherRecommend--name"></a>
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
                      </fieldset>
                    </div>
                  </div>
                  <div class="card shadow p-2">
                    <div class="card-body">
                      <h5 class="text-hightlight1 mb-32px">2. Content</h5>
                      <div class="responseContent--text mt-3">
                        <label for="TopicTextArea">Topic</label>
                        <textarea
                          class="TopicTextArea"
                          id="TopicTextArea"
                          rows="5"
                          style="width: 100%"
                        >
                        </textarea>
                      </div>
                      <label for="formFile" class="form-label"> Image attachment </label>
                      <input class="form-control" type="file" id="formFile" />
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
                    <th>Request</th>
                  </tr>
                </thead>

                <tbody>
                  <tr>
                    <td>1</td>
                    <td>
                      <a class="teacherInfo" href="#"
                        ><img
                          class="teacherAvt"
                          src="./assets/img/teacher_81762259.jpg"
                          alt=""
                        /><span class="teacherName">Nguyen Lan Anh</span></a
                      >
                    </td>
                    <td>4.6</td>
                    <td>Math</td>

                    <td>
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                        /><span class="teacherName">Bui Thi Van</span>
                      </a>
                    </td>
                    <td>4.6</td>
                    <td>Math</td>

                    <td>
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Bui Thi Van"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                        /><span class="teacherName">Nguyen Thi Trang</span>
                      </a>
                    </td>
                    <td>4.6</td>
                    <td>Math</td>

                    <td>
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Thi Trang"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Hoang Ngoc Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Thuy Van"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Thuy Van"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
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
                      <button
                        type="button"
                        class="btn btn-primary requestBtn"
                        value="Nguyen Lan Anh"
                        aria-label="Close"
                        id="closemodal"
                      >
                        Select
                      </button>
                    </td>
                  </tr>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Datatable Jquery library -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>

    <script src="../assets/js/requestMain.js"></script>
    <script src="../assets/js/createRequest.js"></script>
    </body>
</html>
