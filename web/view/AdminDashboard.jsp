<%-- 
    Document   : AdminDashborad
    Created on : Feb 27, 2022, 4:42:34 PM
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
        <title>Admin Dashboard</title>
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
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        
                    </div>

                    <!-- Content Row -->
                    <div class="row">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Total Accounts
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${requestScope.totalAccount}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Earnings
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">1, 215,000 VND</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                Online
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">23%</div>
                                                </div>
                                                <div class="col">
                                                    <div class="progress progress-sm mr-2">
                                                        <div
                                                            class="progress-bar bg-info"
                                                            role="progressbar"
                                                            style="width: 23%"
                                                            aria-valuenow="50"
                                                            aria-valuemin="0"
                                                            aria-valuemax="100"
                                                            ></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                Pending Requests
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${requestScope.totalRequest}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->
                    <div class="row">
                        <!-- Content Column -->
                        <div class="col-lg-6 mb-4">
                            <!-- Project Card Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Process</h6>
                                </div>
                                <div class="card-body">
                                    <h4 class="small font-weight-bold">
                                        Server Migration <span class="float-right">20%</span>
                                    </h4>
                                    <div class="progress mb-4">
                                        <div
                                            class="progress-bar bg-danger"
                                            role="progressbar"
                                            style="width: 20%"
                                            aria-valuenow="20"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            ></div>
                                    </div>
                                    <h4 class="small font-weight-bold">
                                        Sales Tracking <span class="float-right">40%</span>
                                    </h4>
                                    <div class="progress mb-4">
                                        <div
                                            class="progress-bar bg-warning"
                                            role="progressbar"
                                            style="width: 40%"
                                            aria-valuenow="40"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            ></div>
                                    </div>
                                    <h4 class="small font-weight-bold">
                                        Customer Database <span class="float-right">60%</span>
                                    </h4>
                                    <div class="progress mb-4">
                                        <div
                                            class="progress-bar"
                                            role="progressbar"
                                            style="width: 60%"
                                            aria-valuenow="60"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            ></div>
                                    </div>
                                    <h4 class="small font-weight-bold">
                                        Payout Details <span class="float-right">80%</span>
                                    </h4>
                                    <div class="progress mb-4">
                                        <div
                                            class="progress-bar bg-info"
                                            role="progressbar"
                                            style="width: 80%"
                                            aria-valuenow="80"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            ></div>
                                    </div>
                                    <h4 class="small font-weight-bold">
                                        Account Setup <span class="float-right">Complete!</span>
                                    </h4>
                                    <div class="progress">
                                        <div
                                            class="progress-bar bg-success"
                                            role="progressbar"
                                            style="width: 100%"
                                            aria-valuenow="100"
                                            aria-valuemin="0"
                                            aria-valuemax="100"
                                            ></div>
                                    </div>
                                </div>
                            </div>

                            
                        </div>

                        
                    </div>
                </div>
                <!-- /.container-fluid -->
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


</html>
