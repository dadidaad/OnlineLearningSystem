<%-- 
    Document   : ListArticle
    Created on : Feb 10, 2022, 10:20:19 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="./header.jsp" %>
        <h4>Top new article</h4>
        <div class="row mt-3 mb-3">

            <c:forEach items="${listT}" var="o">
                <div class="col-md-6 row" style=" margin-top: 10px">
                    <div class="col-md-4">
                        <img class="col-sm-12" src="${o.image}">
                    </div>
                    <div class="col-md-8">
                        <a href="#">
                            <h9 class="title">${o.title}</h9>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <h4>All article</h4>            
        <c:forEach items="${listP}" var="o">
            <div class="row" style=" margin-top: 10px">
                <div class="col-sm-4">
                    <a href="#" class="">
                        <img class="col-sm-12" src="${o.image}">
                    </a>
                </div>
                <div class="col-sm-8">
                    <a href="detail?did=${o.id}">
                        <h3 class="title">${o.title}</h3>
                    </a>
                    <p>${o.description}</p>
                    <c:if test="${sessionScope.account != null}">
                        <a href="like?aid=${o.id}" style="text-decoration: none; margin-right: 10px">
                            <span style="font-size:30px">&#128077;</span>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.account == null}">
                        <a href="Login.jsp" style="text-decoration: none; margin-right: 10px">
                            <span style="font-size:30px">&#128077;</span>
                        </a>
                    </c:if>

                    </span>

                </div>
            </div>
        </c:forEach>
        <nav style="margin: 20px auto; width: 500px" aria-label="...">
            <ul class="pagination pagination-lg">
                <c:forEach begin="1" end="4" var="i">
                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                    </c:forEach>
            </ul>
        </nav>
 <style>
            .col-sm-8 p{
                overflow: hidden;
                display: -webkit-box;
                -webkit-line-clamp: 3;
                -webkit-box-orient: vertical;
            }
        </style>
         </body>
        <%@include file="./footer.jsp" %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
   
</html>
