<%-- 
    Document   : ListAllRequestTea
    Created on : Feb 10, 2022, 5:01:52 PM
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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/RequestListStu.css" />">
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title>Request List</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <jsp:include page="./header.jsp"></jsp:include>
            <!--Main Content--> 
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
                            <li class="nav-link">
                                <a href="#">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Notification</span>
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
                        <p>List of all the request in our system is sorted by student-rated reputation.</p>
                        <div class="card--top--menu d-flex">
                            <h3 >Request List</h3>
                        </div>

                        <!--Top NavigatorTab-->   
                        <div class="card shadow mb-4">
                            <div class="navbar--top__container" id="navbarNav">
                                <c:set var="status" value="${requestScope.status}"/>
                                <ul class="navbar--top">
                                    <li class="nav-item <c:if test="${fn:toLowerCase(status) == 'waiting' || status ==null}">active</c:if>">
                                            <a class="nav-link" href="ListAllRequest?rqStatus=Waiting" value="Waiting">Pending Request</span></a>
                                        </li>
                                        <li class="nav-item <c:if test="${fn:toLowerCase(status) == 'approved'}">active</c:if>">
                                            <a class="nav-link" href="ListAllRequest?rqStatus=Approved" value="Approved">Done Request</a>
                                        </li>
                                        <li class="nav-item <c:if test="${fn:toLowerCase(status) == 'report'}">active</c:if>">
                                            <a class="nav-link" href="ListAllRequest?rqStatus=Report" value="Report">Report Processing</a>
                                        </li>

                                    </ul>
                                </div>
                                <!--Request List Table-->        
                                <div class="card-body">
                                    <!--Search Data-->          
                                    <div class="row mt-3 mb-3" style="margin-left:10px;">
                                        <div class="col-sm-6 col-md-6">
                                        <c:if test="${requestScope.searchMode!=null}">
                                            <h3 class="mt-5 ml-5">Find ${totalsearch} results for "${searchString}"</h3>
                                        </c:if>
                                    </div>
                                    <div class="col-sm-6 col-md-6">
                                        <div id="dataTable_filter" class="dataTables_filter">
                                            <form action="ListRequestSearch" method="GET">
                                                <label></label>    
                                                <input
                                                    type="search"
                                                    class="form-control"
                                                    name ="searchString"
                                                    placeholder="Enter Title of request"
                                                    value="${searchString}"
                                                    aria-controls="dataTable"
                                                    />
                                                <input type="hidden" id="rqStatus" name="rqStatus" value=${requestScope.status}>  
                                                <input type="submit" class="btn btn-secondary mt-3" value="Search"/>
                                                <c:if test="${requestScope.searchMode!=null}">
                                                    <a href="ListAllRequest" class="btn btn-secondary mt-3" style="margin-left:16px;">Back</a>
                                                </c:if>
                                            </form>
                                        </div>
                                    </div>
                                </div> 
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
                                <!--Paging-->
                                <div class="row mb-5">
                                    <div class="col-sm-12 col-md-5"></div>
                                    <div class="col-sm-12 col-md-7">
                                        <c:set var="searchMode" value="${requestScope.searchMode}"/>
                                        <c:if test="${fn:toLowerCase(searchMode) == 'on'}">
                                            <div class="mt-3" id="dataTable_paginate">
                                                <ul class="pagination">
                                                    <c:if test="${pageindex>1}">   
                                                        <li class="paginate_button page-item previous" id="dataTable_previous">
                                                            <a href="ListRequestSearch?page=${pageindex-1}&searchString=${searchString}&rqStatus=${requestScope.status}" class="page-link">Previous</a>
                                                        </li>
                                                    </c:if>     
                                                    <c:forEach begin="1" end="${totalpage}" var="i">
                                                        <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                            <a href="ListRequestSearch?page=${i}&searchString=${searchString}&rqStatus=${requestScope.status}" class="page-link">${i}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <c:if test="${pageindex<totalpage}">   
                                                        <li class="paginate_button page-item next" id="dataTable_next">
                                                            <a href="ListRequestSearch?page=${pageindex+1}&searchString=${searchString}&rqStatus=${requestScope.status}" class="page-link" >Next</a>
                                                        </li>
                                                    </c:if>     
                                                </ul>
                                            </div>    
                                        </c:if>
                                        <c:if test="${requestScope.searchMode==null}">
                                            <div class="mt-3" id="dataTable_paginate">
                                                <ul class="pagination">
                                                    <c:if test="${pageindex>1}">   
                                                        <li class="paginate_button page-item previous" id="dataTable_previous">
                                                            <a href="ListAllRequest?page=${pageindex-1}&rqStatus=${requestScope.status}" class="page-link">Previous</a>
                                                        </li>
                                                    </c:if>     
                                                    <c:forEach begin="1" end="${totalpage}" var="i">
                                                        <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                            <a href="ListAllRequest?page=${i}&rqStatus=${requestScope.status}" class="page-link">${i}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <c:if test="${pageindex<totalpage}">   
                                                        <li class="paginate_button page-item next" id="dataTable_next">
                                                            <a href="ListAllRequest?page=${pageindex+1}&rqStatus=${requestScope.status}" class="page-link" >Next</a>
                                                        </li>
                                                    </c:if>     
                                                </ul>
                                            </div>
                                        </c:if>
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

        <!--Ajax Library-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestListTea.js"/>"></script>
        

    </body>
</html>
