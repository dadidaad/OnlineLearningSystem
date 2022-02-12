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
        <div class="main" style="  width: 100%; margin-left: 20px;">
            <!--Top newest article-->
            <h4 style="margin-left: 30px;">Top new article</h4>
            <div class="row mt-3 mb-3">

                <c:forEach items="${listT}" var="o">
                    <div class="col-md-6 row" style=" margin-top: 10px; margin-left: 10px;">
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
         <!--end of Top newest article-->    
            
            <!--List all article-->
            <h4 style="margin-left: 30px;">All article</h4>   
             <!--These link for all article use c:forEach of JSTL -->
            <c:forEach items="${listP}" var="o" >
                <div class="row" style=" margin-top: 10px">
                    <div class="col-sm-4" >
                        <a href="#" class="">
                            <img class="col-sm-12" src="${o.image}" >
                        </a>
                    </div>
                    <div class="col-sm-8" >
                        <a href="detail?did=${o.id}">
                            <h3 class="title">${o.title}</h3>
                        </a>
                        <p style="width: 90%">${o.description}</p>
                        <a href="like?aid=${o.id}" style="text-decoration: none; margin-right: 10px">
                            <i class="fas fa-thumbs-up"></i> Like
                        </a>
                        <span class="text-muted">Author: <a href="#"></a></span>
                        <span class="text-muted">Category: <a href="#"></a></span>
                        <span class="text-muted">   <i class="fa fa-eye-slash"></i> Views: 50  <a href="#"></a></span>
                    </div>
                </div>
            </c:forEach>
              
            <!--end of List all article-->
            
            
            <!--Paging article-->
            <div class="end" style=" margin-top: 50px; margin-left: 500px;margin-bottom: 50px;">
                <c:forEach begin="1" end="${endP}" var="i">
                    <td><a href="listarticle?index=${i}"
                           class="btn btn-info">${i}</a></td>

                </c:forEach>       
            </div>

        </div>
          
            <!--end of Paging article-->
        <style>
            span{
                margin-left: 40px;    
            }
        </style>
    </body>
    <%@include file="./footer.jsp" %>
     <!-- Java Script link-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</html>
