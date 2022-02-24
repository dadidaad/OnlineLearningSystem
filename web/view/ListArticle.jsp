<%-- 
    Document   : ListArticle
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : Hoang ngoc Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article page</title>
        <!-- Link to bootstrap fontawesome and Boxicon -->
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    </head>
    <body>
        <%@include file="./header.jsp" %>
        <div class="main" style="  width: 100%; margin-left: 20px;">
            <!--Top newest article-->
            <h4 style="margin-left: 40px;">Top new article</h4>
            <div class="row mt-3 mb-3 ml-5">

                <c:forEach items="${listT}" var="o">
                    <div class="col-md-6 row" style=" margin-top: 10px; margin-left: 15px;">
                        <div class="col-md-4">
                            <img class="col-sm-12" src="${o.image}">
                        </div>
                        <div class="col-md-8">
                            <a href="detail?did=${o.id}">
                                <h9 class="title">${o.title}</h9>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!--end of Top newest article-->              
            <!--List all article-->
            <div class="title" style=" display: inline-block;margin-left: 30px; margin-top: 50px;">
                <h4 style="float:left;">All article</h4>   
                <form method="post" action="searcharticle" class="form-inline" onsubmit="return FormValidate();" >
                    <div class="form-group" style="float:right; margin-left: 800px;">

                        <input type="name"
                               class="form-control" id="name" name="name" value="${txtS}"
                               placeholder="Enter title">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
                <label for="name" style="margin-left: 900px;"><span style="color: red;" id="errorName"></span></label> 
            </div>
            <!--These link for all article use c:forEach of JSTL -->
            <c:forEach items="${listP}" var="o" >
                <div class="row" style=" margin-bottom:30px; margin-left: 18px;">
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
                       
                    </div>
                </div>
            </c:forEach>
            <h1 style="color:red; text-align: center">${message}</h1>

            <!--end of List all article
             <span class="text-muted">   <i class="fa fa-eye-slash"></i> Views: 50  <a href="#"></a></span>-->        
            <!--Paging article-->
            <ul class="pagination" style="margin-top: 50px; margin-left: 45px;">
                <c:if test="${tag>1}">
                    <li class="page-item"><a href="listarticle?index=${tag-1}" class="page-link">Previous</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${endP}" var="i">
                    <li class="page-item ${tag==i?"active":""}"><a href="listarticle?index=${i}" class="page-link">${i}</a></li>
                    </c:forEach>
                    <c:if test="${tag<endP}">
                    <li class="page-item"><a href="listarticle?index=${tag+1}" class="page-link">Next</a></li>
                    </c:if>
            </ul>

        </div>

        <!--end of Paging article-->

    </body>
    <%@include file="./footer.jsp" %>
    <!-- Java Script link-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script>
                    function FormValidate() {
                        var name = document.getElementById('name').value.trim();
                        var errorName = document.getElementById('errorName');
                        if (name == '' || name == null) {
                            errorName.innerHTML = "Please enter title";
                        }
                        else{
                        return name;
                    }
                    return false;
                    }

    </script>
</html>
<style>
    span{
        margin-left: 40px;    
    }
</style>