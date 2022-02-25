<%-- 
    Document   : ListAllTeacher
    Created on : Feb 10, 2022, 7:37:51 AM
    Author     : Duc Minh
--%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>"/>
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestMain.css" />"/>
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListAllTeacher.css"/>"/>

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
                                    <div class="row mt-3 mb-3">
                                        <div class="col-sm-12 col-md-6"></div>
                                        <div class="col-sm-12 col-md-6">
                                            <div id="dataTable_filter" class="dataTables_filter">
                                                <label
                                                    >Search:<input
                                                        type="search"
                                                        class="form-control form-control-sm"
                                                        id ="searchString"
                                                        placeholder=""
                                                        aria-controls="dataTable"
                                                        /></label>
                                            </div>
                                        </div>
                                    </div>
                                <c:set var="userRole" value="${sessionScope.user.role}"/>
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
                                                    <c:if test = "${fn:toLowerCase(userRole) == 'teacher'}">
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
                                                    <c:if test = "${fn:toLowerCase(userRole) ne 'teacher'}">
                                                    <th>Request</th>
                                                    </c:if>  
                                            </tr>
                                        </tfoot>
                                        <tbody id="tbBody">
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
                                                        <img
                                                            class="teacherCv imgZoom"
                                                            src="<i:ReadUrlFromContext url="${t.getCvImg()}"/>"
                                                            alt=""
                                                            />
                                                    </td>
                                                    <c:if test = "${fn:toLowerCase(userRole) ne 'teacher'}">
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
                                        <div class="mt-3" id="dataTable_paginate">
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
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#searchString").on('keyup', function () {
                    var searchString = $(this).val();
                    console.log(searchString);
                    $.ajax({
                        url: "ListTeacherSearch",
                        data: {"searchString": searchString},
                        type: "POST",
                        success: function (result)
                        {
                            $('#dataTable #tbBody').empty();
                            $('#dataTable #tbBody').append(result);
                            
            //                $('#tbBody').empty();
            //                $('#tbBody').html(result);
            //            alert(status);
                            // This will show the values. Change "alert" for $('div#mydiv').html(value) or so
                        }
                    });
                });
            });
        </script>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <!--<script src="<i:ReadUrlFromContext url="/assets/js/ListAllTeacher.js"/>"></script>-->


    </body>
</html>
