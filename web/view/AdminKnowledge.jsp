<%-- 
    Document   : AdminKnowledge
    Created on : Feb 25, 2022, 3:55:51 PM
    Author     : Phong Vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
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

        <!--Side Bar-->
        <nav class="sidebar close">
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
            <!--Main Side Bar-->
            <div class="menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="<i:ReadUrlFromContext url="/ConstantTableController" />">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Learning Manage</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Account manager</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-calendar-check icon'></i>
                                <span class="text nav-text">Teacher Apply</span>
                            </a>
                        </li>
                    </ul>
                </div>

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
         
        <!--Overview-->
        <main>
            <h2 class="dash-title">Overview</h2>
            <div class="dash-card">
                <div class="card-single">
                    <div class="card-body">
                        <span class="ti-briefcase"><i class='bx bx-book-bookmark icon' ></i></span>
                        <div>
                            <h5>Total of Subject</h5>
                            <h4>${requestScope.numbers[0]}</h4>
                        </div>
                    </div>
                    <div class="card-footer">
                        <a href="#">Available</a>
                    </div>
                </div>

                <div class="card-single">
                    <div class="card-body">
                        <span class="ti-reload"><i class='bx bx-notepad icon' ></i></span>
                        <div>
                            <h5>Total of Chapter</h5>
                            <h4>${requestScope.numbers[1]}</h4>
                        </div>
                    </div>
                    <div class="card-footer">
                        <a href="#">Available</a>
                    </div>
                </div>

                <div class="card-single">
                    <div class="card-body">
                        <span class="ti-check-box"><i class='bx bx-bookmark icon' ></i></span>
                        <div>
                            <h5>Total of Knowledge</h5>
                            <h4>${requestScope.numbers[2]}</h4>
                        </div>
                    </div>
                    <div class="card-footer">
                        <a href="#">Available</a>
                    </div>
                </div>
            </div>
            
            <!--Main Management-->
            <section class="recent">
                <div class="activity-grid">

                    <div class="activity-card">
                        <h3 class="">All Knowledge for ${requestScope.chapter.getChapterName()}</h3> <span class="new-subject"><a href="CreateKnowledgeController?chapId=${requestScope.chapter.getChapterID()}">Add New Knowledge</a></span>
                        <table borders="2">
                            <thead>
                                <tr>
                                    <th>KnowledgeID</th>
                                    <th>KnowledgeName</th>
                                    <th>KnowledgeContent</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.knowledges}" var="k" varStatus="loop">
                                    <tr>
                                        <td class="id-name">${k.getKnowledgeID()}</td>
                                        <td class="id-name"><a href="" style="color: black; font-weight: 600;"> ${k.getKnowledgeName()}</a></td>
                                        <td class="knowledgeContent">
                                            <img src="./${k.getKnowledgeContent()}" alt="" class="img">
                                        </td>
                                        <td><a href="KnowledgeUpdateController?knowledgeId=${k.getKnowledgeID()}" class="action" style="color: black;"><i class='bx bx-edit-alt icon' ></i></a></td>
                                        <td><span onclick="Confirm(${k.getKnowledgeID()}, ${k.getChapterID()})" class="action" style="color: black; " id="delete" ><i class='bx bx-trash icon' ></i></span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="summary">
                        <div class="summary-card">
                            <div class="summary-single">
                                <span><i class='bx bx-bookmark icon' ></i></span>
                                <div>
                                    <h5>${requestScope.knowledges.size()}</h5>
                                    <small>Knowledge for Chapter</small>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </section>
        </main>

        <!-- Include footer of web site from general -->
        <%@include file="./footer.jsp" %>

        <!-- link to java script file -->
        <script src="<i:ReadUrlFromContext url="/assets/js/ListSubjectScript.js"/>"></script>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
    crossorigin="anonymous"></script>
    <script>
       function Confirm(x,y){
            let choice = confirm("Do you want to delete this Knowledge?");
            if(choice){
                window.location.href= 'KnowledgeDeleteController?knowledgeId='+x+'&chapId='+y;
            }
       }
    </script>
</html>
