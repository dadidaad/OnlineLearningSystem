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
        <title>Teacher Request</title>
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
                    <h1 class="h3 mb-2 text-gray-800">Teacher's Request to apply</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body" id="cardBody">        
                            <!--Data Table-->            
                            <div class="table-responsive">
                                <table class="table table-bordered" id="accountTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Subject</th>
                                            <th>Sex</th>
                                            <th>CV</th>
                                            <th>Accept</th>
                                            <th>Reject</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>No</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Subject</th>
                                            <th>Sex</th>
                                            <th>CV</th>
                                            <th>Accept</th>
                                            <th>Reject</th>
                                        </tr>
                                    </tfoot>
                                    <tbody id="tbBody">
                                        <c:if test = "${requestScope.teachers.size()==0}">
                                            <tr>List Empty</tr>
                                        </c:if>
                                        <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop"> 
                                            <c:if test = "${requestScope.teachers.size()==0}">
                                                <tr>List Empty</tr>
                                            </c:if>
                                            <tr>
                                                <td>${loop.index+1}</td>
                                                <td>${t.getDisplayName()}</td>
                                                <td>${t.getMail()}</td>
                                                <td>${requestScope.subjectNames.get(t.getSubjectId())}</td>
                                                <c:if test = "${t.getSex()}">
                                                    <td>Male</td>
                                                </c:if>
                                                <c:if test = "${!t.getSex()}">
                                                    <td>Female</td>
                                                </c:if>    
                                                <td><img
                                                        style="width: 30px; height: 40px; margin-right: 16px"
                                                        src="<i:ReadUrlFromContext url="${t.getCvImg()}"/>"
                                                        alt=""
                                                        class="imgZoom"
                                                        /><i class="fas fa-eye"></i></td>
                                                <td>
                                                    <a href="TeacherRequestHandle?type=accept&username=${t.getUsername()}" class="editBtn"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAWhJREFUSEvtlY0xBEEQRt9FQAaIgAwQATIgAyJABMhABoiAiwAREAIZqKd2Vd/amdkdP6fKddXV1e78vP2+6e6ZMKeYzInLAvxrzv9pqw+BlcaKZ+DiO2zJKV4FroCNDugB2AP8iOrIge+AzcTOjm1XUyFZTqq8L2y89hXVKcVbwG0BrGKVl2IZ2AUu48SfBgtVgA4eRHjujF+ApYScV8BNcxGhznuMiZoDa49Z3Rdm9XWG2gf1+BTzHqUG4uSTkN3T5rl7tlp51pSZ+7b2tkpnoEPApcRxXKggVVrj7bsktATW6h3ARhLDxqHNN81LgTqw3pnnmX5SmrM61bG66mMH68Kz0D7FbvA0IGPbjzBZbCT+t3DHkkpTinNtMnXesX22JfaRvalFMau1WLU1Mbp9RrDXnyVRE0fA+ZiFEWy9Ho9ZHOaeNvU9eHkE7wP+asILYOYSKG1S6lyl9dXjC3C1dWMX/j+r3wAjukAfG7eZWwAAAABJRU5ErkJggg=="/></a>
                                                </td>
                                                <td>
                                                    <a href="TeacherRequestHandle?type=reject&username=${t.getUsername()}" onclick ="return confirm('Are you sure to reject this apply?');" class="deleteBtn" value="${t.getUsername()}"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAepJREFUSEvNloExRDEQhv+rABWgAnRABagAFaACVIAKUMFRASpABZRABcxnsm82ufckL2cmtzOZuXmX5Nv9N9nNRI1s0oirGvC2pCVJm8HpV0mfkp7HBFEKBnIsaU/S8gAA+L2kC0kfOSdyYCCXkg5zGyX/30o6DUr0Lv0LTJRTSWtu5Z2kJ0nIy8CYx0CNXTeX/4/cvMiBITAbPTpZHySdFEiIk1fOAeTf6YP3gZH3xUWKZGw2xnCSFGFEDhwnOusDk5+DMKMGapt7OCmKzkkKRmKixZCXvM1jnHLL+7pPVQr20UYTK+nk/D2sjaJOweSB4jAjTSWYZRY1e6/YPh5MReIkY1wDosf4zhhjXDkGRm5vwm8O2e93Dyaf3Ftsy10B71ApvAOEO27nZj8oEIHPJZ2FnYeUqAGz5jsspJzCWQxwM6mbHS6kt+v0H8XDzoNdpy/fUhemgPiSiacc/3msuGQCadIkANMWaWWrIVS6zPXIsH1neguVL9sWYSA5pY26jSEZLTL3lqIp0Ietq3GguC32Wun8zz19AFrk5gDfiMI/fTYCzLdR5lCnZ6Bp5epTE9l5fdjDoFRxuhtyR/L6xblXps1FQmosEZn8qRPIihrMy6Wk+kGPEumD3tpgkSqlERdtNmZSM/APnsF6H5SvITgAAAAASUVORK5CYII="/></a>
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
                                    <div class="mt-3" id="dataTable_paginate">
                                        <ul class="pagination">
                                            <c:if test="${pageindex>1}">   
                                                <li class="paginate_button page-item previous" id="dataTable_previous">
                                                    <a href="TeacherRequest?page=${pageindex-1}" class="page-link">Previous</a>
                                                </li>
                                            </c:if>     
                                            <c:forEach begin="1" end="${totalpage}" var="i">
                                                <li class="paginate_button page-item ${pageindex==i?"active":""}">
                                                    <a href="TeacherRequest?page=${i}" class="page-link">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${pageindex<totalpage}">   
                                                <li class="paginate_button page-item next" id="dataTable_next">
                                                    <a href="TeacherRequest?page=${pageindex+1}" class="page-link" >Next</a>
                                                </li>
                                            </c:if>     
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Modal Image -->
                    <div id="myModal" class="modal--Img">
                        <span class="close--Img">&times;</span>
                        <img class="modal-content--Img" id="img01" />
                        <div id="caption"></div>
                    </div>
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
        <script>
        // Modal Image
        var modal = document.getElementById("myModal");

        // Get the image and insert it inside the modal - use its "alt" text as a caption
        var imgs = document.querySelectorAll(".imgZoom");
        var modalImg = document.getElementById("img01");
        var captionText = document.getElementById("caption");
        imgs.forEach((element) => {
          element.addEventListener("click", function (e) {
            modal.style.display = "block";
            modalImg.src = element.src;
            captionText.innerHTML = element.alt;
          });
        });

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close--Img")[0];

        // When the user clicks on <span> (x), close the modal
        span.onclick = function () {
          modal.style.display = "none";
        };
</script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
            crossorigin="anonymous">
    </script> 
   

</html>
