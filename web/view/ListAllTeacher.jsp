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
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/StarRating.css"/>"/>    
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title>Teacher Ranking</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <div class="container">
            <jsp:include page="./header.jsp"></jsp:include>
            </div>

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
                                <a href="<i:ReadUrlFromContext url="/ListAllTeacher"/>">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Teacher Ranking</span>
                                </a>
                            </li>
                            <c:if test="${sessionScope.user ne null}">
                                <c:choose>
                                    <c:when test="${sessionScope.user.role eq 'Admin'}">
                                        <li class="nav-link">
                                            <a href="<i:ReadUrlFromContext url="/TeacherRequest"/>">
                                                <i class='bx bx-table icon' ></i>
                                                <span class="text nav-text">View Teacher Request</span>
                                            </a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="nav-link">
                                            <a href="<i:ReadUrlFromContext url="/ListAllRequest"/>">
                                                <i class='bx bx-table icon' ></i>
                                                <span class="text nav-text">My Request</span>
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>

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
            <div id="content-wrapper" class="maincontent d-flex flex-column">
                <!-- Main Content -->
                <div id="content">
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <div class="card--top"></div>

                        <!-- Requests DataTales -->
                        <div class="card shadow mb-4" id="cardTop">
                            <h1>Teacher Ranking</h1>
                            <p>List of all the teachers in our system is sorted by student-rated reputation.</p>
                            <div class="card-body">
                                <!--Search Data-->          
                                <div class="row mt-3 mb-3" style="margin-left:10px;">
                                    <div class="col-sm-6 col-md-6">
                                        <c:if test="${requestScope.searchMode!=null}">
                                            <h3 class="col-3 mt-5 ml-5">Find ${totalsearch} results for "${searchString}"</h3>
                                        </c:if>
                                        <div class="d-flex align-items-baseline">
                                            <i class="fas fa-filter"></i>
                                            <form action="ListAllTeacher" method="get" id="filter-form">
                                                <input type="radio" value="allTeacher" id="all-select" name="filterTeacher" >
                                                <label for="all-select">All</label>
                                                <input type="radio" value="onlineTeacher" id="online-select" name="filterTeacher">
                                                <label for="online-select">Online</label>
                                                <input type="submit" value="Filter" class="btn btn-outline-dark">
                                            </form>
                                        </div>
                                        <c:set var="filterTeacher" value="${requestScope.filterTeatcher}"></c:set>
                                        <c:if test="${filterTeacher == 'onlineTeacher'}">
                                            <script>
                                                document.getElementById("online-select").checked = true;
                                            </script>
                                        </c:if>
                                        <c:if test="${filterTeacher eq 'allTeacher' or filterTeacher eq null}">
                                            <script>
                                                document.getElementById("all-select").checked = true;
                                            </script>
                                        </c:if>
                                    </div>
                                    <div class="col-sm-6 col-md-6">
                                        <div id="dataTable_filter" class="dataTables_filter">
                                            <form action="ListTeacherSearch" method="GET">
                                                <label></label>    
                                                <input
                                                    type="search"
                                                    class="form-control"
                                                    name ="searchString"
                                                    placeholder="Enter Name of Teacher"
                                                    value="${searchString}"
                                                    aria-controls="dataTable"
                                                    />
                                                <input type="submit" class="btn btn-secondary mt-3" value="Search"/>
                                                <c:if test="${requestScope.searchMode!=null}">
                                                    <a href="ListAllTeacher" class="btn btn-secondary mt-3" style="margin-left:16px;">Back</a>
                                                </c:if>
                                            </form>
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
                                                    <c:if test = "${fn:toLowerCase(userRole) ne 'teacher'}">
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
                                                    <td>
                                                        <div id="rating">
                                                            <input type="radio" id="star5${loop.index+1}" name="rating${loop.index+1}" value="5" disabled/>
                                                            <label class="full" for="star5${loop.index+1}" title="Awesome - 5 stars"></label>

                                                            <input type="radio" id="star4half${loop.index+1}" name="rating${loop.index+1}" value="4 and a half" disabled/>
                                                            <label class="half" for="star4half${loop.index+1}" title="Pretty good - 4.5 stars"></label>

                                                            <input type="radio" id="star4${loop.index+1}" name="rating${loop.index+1}" value="4" disabled/>
                                                            <label class="full" for="star4${loop.index+1}" title="Pretty good - 4 stars"></label>

                                                            <input type="radio" id="star3half${loop.index+1}" name="rating${loop.index+1}" value="3 and a half" disabled/>
                                                            <label class="half" for="star3half${loop.index+1}" title="Meh - 3.5 stars"></label>

                                                            <input type="radio" id="star3${loop.index+1}" name="rating${loop.index+1}" value="3" disabled/>
                                                            <label class="full" for="star3${loop.index+1}" title="Meh - 3 stars"></label>

                                                            <input type="radio" id="star2half${loop.index+1}" name="rating${loop.index+1}" value="2 and a half" disabled/>
                                                            <label class="half" for="star2half${loop.index+1}" title="Kinda bad - 2.5 stars"></label>

                                                            <input type="radio" id="star2${loop.index+1}" name="rating${loop.index+1}" value="2" disabled/>
                                                            <label class="full" for="star2${loop.index+1}" title="Kinda bad - 2 stars"></label>

                                                            <input type="radio" id="star1half${loop.index+1}" name="rating${loop.index+1}" value="1 and a half" disabled/>
                                                            <label class="half" for="star1half${loop.index+1}" title="Meh - 1.5 stars"></label>

                                                            <input type="radio" id="star1${loop.index+1}" name="rating${loop.index+1}" value="1" disabled/>
                                                            <label class="full" for="star1${loop.index+1}" title="Sucks big time - 1 star"></label>

                                                            <input type="radio" id="starhalf${loop.index+1}" name="rating${loop.index+1}" value="half" disabled/>
                                                            <label class="half" for="starhalf${loop.index+1}" title="Sucks big time - 0.5 stars"></label>
                                                        </div>
                                                    </td>
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
                                                            <a href="CreateRequest?teacherRcmFromList=${t.getUsername()}&subjectId=${t.getSubjectId()}"><i class="far fa-share-square"></i></a>
                                                        </td>
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
                                                            <a href="ListTeacherSearch?page=${pageindex-1}&searchString=${searchString}" class="page-link">Previous</a>
                                                        </li>
                                                    </c:if>     
                                                    <c:forEach begin="1" end="${totalpage}" var="i">
                                                        <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                            <a href="ListTeacherSearch?page=${i}&searchString=${searchString}" class="page-link">${i}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <c:if test="${pageindex<totalpage}">   
                                                        <li class="paginate_button page-item next" id="dataTable_next">
                                                            <a href="ListTeacherSearch?page=${pageindex+1}&searchString=${searchString}" class="page-link" >Next</a>
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
                                                            <a href="ListAllTeacher?page=${pageindex-1}<c:if test="${requestScope.filterTeacher eq 'onlineTeacher'}">&filterTeacher=onlineTeacher</c:if>" class="page-link">Previous</a>
                                                            </li>
                                                    </c:if>     
                                                    <c:forEach begin="1" end="${totalpage}" var="i">
                                                        <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                            <a href="ListAllTeacher?page=${i}<c:if test="${requestScope.filterTeacher eq 'onlineTeacher'}">&filterTeacher=onlineTeacher</c:if>" class="page-link">${i}</a>
                                                            </li>
                                                    </c:forEach>
                                                    <c:if test="${pageindex<totalpage}">   
                                                        <li class="paginate_button page-item next" id="dataTable_next">
                                                            <a href="ListAllTeacher?page=${pageindex+1}<c:if test="${requestScope.filterTeacher eq 'onlineTeacher'}">&filterTeacher=onlineTeacher</c:if>" class="page-link" >Next</a>
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


        <!-- Modal Image -->
        <div id="myModal" class="modal--Img">
            <span class="close--Img">&times;</span>
            <img class="modal-content--Img" id="img01" />
            <div id="caption"></div>
        </div>
        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/RequestMain.js"/>"></script>
        <script>

            <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop">
                                                window.document.onload = calcRate(${t.getReputation()}, ${loop.index+1});
            </c:forEach>

                                                function calcRate(r, num) {
                                                    const f = ~~r, // = Math.floor(r)
                                                            id = "star" + f + (r % f ? "half" + num : "" + num);
                                                    id && (document.getElementById(id).checked = !0);
                                                }

        </script> 
        <script>
            // Onload event
            $(document).ready(function () {
                console.log("load");
                $("#cardTop")[0].scrollIntoView({
                    behavior: "smooth", // or "auto" or "instant"
                    block: "start" // or "end"
                });
            });

        </script>
    </body>
</html>
