<%-- 
    Document   : AlreadyAccepArticle
    Created on : Feb 8, 2022, 5:07:15 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Manager article</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Link to bootstrap fontawesome and Boxicon -->

        <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
              crossorigin="anonymous"/>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ListSubjectStyle.css" />">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/AdminSubjectStyle.css" />">
        <title>TutorDuo</title>
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

                            <li class="nav-link">
                                <a href="loadalreadyarticle">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Manager Article</span>
                                </a>
                            </li>
                            <li class="nav-link">
                                <a href="loadpreparearticle">
                                    <i class='bx bx-table icon' ></i>
                                    <span class="text nav-text">Waitting Article</span>
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
                         <div class="row">
                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-4 col-md-4 mb-4" style="margin-left: 200px;">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Total number of article
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${articlenumber}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-4 col-md-4 mb-4" style="margin-left: 200px;">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                           Total view 
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${viewnumber}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fa fa-eye fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-4 col-md-4 mb-4" style="margin-left: 200px;">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                Total number of comment
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"> ${commentnumber}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- Include container of web site from general-->
            <div class="container">
                <h2>Manager article</h2>

                <form method="post" action="searchiinalreadyarticle" style="width: 30%;" onsubmit="return FormValidate();" >

                    <div class="input-group mb-3">
                        <input class="form-control" type="name" id="name" name="name" value="${txtS}"
                               placeholder="Enter title" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit">Search</button>
                        </div>
                    </div>

                </form>
                <table class="table table-striped" >
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Author</th>
                            <th>CreateDay</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Action
                            </th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td hidden>${o.id}</td>    
                                <td>
                                    <img src="${o.image}">
                                    <style>
                                        .table-striped img{
                                            width: 100px;
                                            height: 100px;
                                        }
                                    </style>
                                </td>
                                <th>${o.createName}</th>
                                <td>${o.pulished}</td>  
                                <td>${o.title}</td>
                                <td>${o.description}</td>
                                <td><a href="alreadyarticledetail?pid=${o.id}"
                                       class="btn btn-info" role="button">Update</a>
                                       <br>
                                       <a class="btn btn-info" role="button"  onclick="showMessage(${o.id})" style="margin-top: 10px; width: 101%;">Delete</a>
                                       </td>
                             
                            </tr>

                        </c:forEach>
                    <h1 style="color:red; text-align: center">${message}</h1>
                    </tbody>
                </table> 
                <ul class="pagination" style="margin-top: 25px; margin-left: 15px;">
                    <c:if test="${tag>1}">
                        <li class="page-item"><a href="loadalreadyarticle?index=${tag-1}" class="page-link">Previous</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${endP}" var="i">
                        <li class="page-item ${tag==i?"active":""}"><a href="loadalreadyarticle?index=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                        <c:if test="${tag<endP}">
                        <li class="page-item"><a href="loadalreadyarticle?index=${tag+1}" class="page-link">Next</a></li>
                        </c:if>
                </ul>

            </div>
            <div id="modal-update" class="modal-update">

            </div>
            <script>
                function showMessage(id) {
                    var result = confirm("Want to delete?");
                    if (result === true) {
                        window.location.href = 'deletealreadyarticle?pid=' + id;
                    }
                }
                function FormValidate() {
                    var name = document.getElementById('name').value.trim();
                    var errorName = document.getElementById('errorName');
                    if (name == '' || name == null) {
                        errorName.innerHTML = "Please enter title";
                    } else {
                        return name;
                    }
                    return false;
                }


            </script>   
            <%@include file="./footer.jsp" %>

            <!-- link to java script file -->
            <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
            <script src="<i:ReadUrlFromContext url="/assets/js/AccountManager.js"/>"></script> 
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
                    crossorigin="anonymous">
            </script> 
            <!--Ajax Library-->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>

