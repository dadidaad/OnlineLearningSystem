<%-- 
    Document   : AccountManager
    Created on : Feb 25, 2022, 4:44:44 PM
    Author     : Duc Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListSubjectStyle.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/AccountManagerStyle.css" />">
        <title>Account Manager</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <%@include file="./header.jsp" %>
        <div id="content-wrapper" class="">
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
                            <hr class="sidebar-divider my-0" />

                            <!-- Nav Item - Dashboard -->
                            <li class="nav-item">
                                <a class="nav-link" href="Dashboard">
                                    <i class="fas fa-fw fa-tachometer-alt icon"></i>
                                    <span class="text nav-text">Dashboard</span></a
                                >
                            </li>

                            <!-- Divider -->
                            <hr class="sidebar-divider" />
                            <!-- This link for look Up table-->
                            <li class="nav-link">
                                <a href="AccountManager">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Account Manager</span>
                                </a>
                            </li>
                            <li class="nav-link">
                                <a href="TeacherRequest">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Teacher Apply</span>
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

            <!-- Main Content -->
            <div id="content" class="maincontent d-flex flex-column">

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Account Tables</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">

                        <!--Search Data-->          
                        <div class="row mt-3 mb-3" style="margin-left:10px;">

                            <div class="col-sm-12 col-md-6">
                                <div id="dataTable_filter" class="dataTables_filter">
                                    <form action="AccountManagerSearch" method="POST">
                                        <label></label>    
                                        <input
                                            type="search"
                                            class="form-control form-control-sm"
                                            name ="searchString"
                                            placeholder="Enter Name or Email"
                                            value="${searchString}"
                                            aria-controls="dataTable"
                                            />
                                        <input type="submit" class="btn btn-secondary mt-3" value="Search"/>
                                        <c:if test="${requestScope.searchMode!=null}">
                                        <a href="AccountManager" class="btn btn-secondary mt-3" style="margin-left:16px;">Back</a>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>   
                        <div class="card-body" id="cardBody">        
                            <!--Data Table-->            
                            <div class="table-responsive">
                                <table class="table table-bordered" id="accountTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Name</th>
                                            <th>Role</th>
                                            <th>Email</th>
                                            <th>Sex</th>
                                            <th>Budget</th>
                                            <th>Status</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>No</th>
                                            <th>Name</th>
                                            <th>Role</th>
                                            <th>Email</th>
                                            <th>Sex</th>
                                            <th>Budget</th>
                                            <th>Status</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </tfoot>
                                    <tbody id="tbBody">
                                        <c:if test = "${requestScope.accounts.size()==0}">
                                            <tr>List Empty</tr>
                                        </c:if>
                                        <c:forEach items="${requestScope.accounts}" var ="a" varStatus="loop"> 
                                            <tr>
                                                <td>${loop.index+1}</td>
                                                <td>${a.getDisplayName()}</td>
                                                <td>${a.getRole()}</td>
                                                <td>${a.getMail()}</td>
                                                <c:if test = "${a.getSex()}">
                                                    <td>Male</td>
                                                </c:if>
                                                <c:if test = "${!a.getSex()}">
                                                    <td>Female</td>
                                                </c:if>    

                                                <td><fmt:formatNumber type = "number"  minFractionDigits = "0" value = "${a.getCash()}" /> VND</td>
                                                <td>${a.getStatus()}</td>
                                                <td>
                                                    <a href="#editCard" class="editBtn" value="${a.getUsername()}"><i class="far fa-edit"></i></a>
                                                </td>
                                                <td>
                                                    <a href="DeleteAccount?username=${a.getUsername()}" onclick ="return confirm('Are you need to delete this account?');" class="deleteBtn" value="${a.getUsername()}"><i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>

                                        </c:forEach>   


                                    </tbody>
                                </table>
                            </div>
                            <!--Paging-->
                            <div class="row">
                                <div class="col-sm-12 col-md-4"></div>
                                <div class="col-sm-12 col-md-8">
                                    <c:set var="searchMode" value="${requestScope.searchMode}"/>
                                    <c:if test="${fn:toLowerCase(searchMode) == 'on'}">
                                        <div class="mt-3" id="dataTable_paginate">
                                            <ul class="pagination">
                                                <c:if test="${pageindex>1}">   
                                                    <li class="paginate_button page-item previous" id="dataTable_previous">
                                                        <a href="AccountManagerSearch?page=${pageindex-1}&searchString=${searchString}" class="page-link">Previous</a>
                                                    </li>
                                                </c:if>     
                                                <c:forEach begin="1" end="${totalpage}" var="i">
                                                    <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                        <a href="AccountManagerSearch?page=${i}&searchString=${searchString}" class="page-link">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <c:if test="${pageindex<totalpage}">   
                                                    <li class="paginate_button page-item next" id="dataTable_next">
                                                        <a href="AccountManagerSearch?page=${pageindex+1}&searchString=${searchString}" class="page-link" >Next</a>
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
                                                        <a href="AccountManager?page=${pageindex-1}" class="page-link">Previous</a>
                                                    </li>
                                                </c:if>     
                                                <c:forEach begin="1" end="${totalpage}" var="i">
                                                    <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                        <a href="AccountManager?page=${i}" class="page-link">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <c:if test="${pageindex<totalpage}">   
                                                    <li class="paginate_button page-item next" id="dataTable_next">
                                                        <a href="AccountManager?page=${pageindex+1}" class="page-link" >Next</a>
                                                    </li>
                                                </c:if>     
                                            </ul>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--------------- Edit Detail ----------------->
                    <div class="editDeital card shadow" id="editCard">

                    </div>
                    <!--------------- End of edit Detail ---------->

                    <!-- /.container-fluid -->
                </div>
                <!-- End of Main Content -->


            </div>

            <!-- End of Page Wrapper -->            
        </div>    


        <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/AccountManager.js"/>"></script> 
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
            crossorigin="anonymous">
    </script> 
    <!--Ajax Library-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</html>
