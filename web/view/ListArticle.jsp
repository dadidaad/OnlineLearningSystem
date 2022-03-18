<%-- 
    Document   : ListArticle
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : Hoang ngoc Long
--%>

<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    </head>

    <body>

        <jsp:include page="./header.jsp"></jsp:include>
            <div class="main" style="  width: 100%; margin-left: 20px;">
                <!--Top newest article-->
                <div class="group" style="display:inline-block;">
                    <h4 style="margin-left: 40px;float: left; margin-top: 40px; font-size: 30px;">Top new article</h4> 
                               
            </div>
            <c:if test="${sessionScope.account != null}">
                 <a  href="favorarticle"
                     class="btn btn-danger" role="button" style="float: right;margin-top: 40px; margin-right: 10%;">Favor Aritcle</a></td>  
                     </c:if>
            <div class="row mt-3 mb-3 ml-5">

                <c:forEach items="${listT}" var="o" >
                    <div class="col-md-5 row" style="margin-top:10px; margin-left: 90px;">
                        <div class="col-md-4">
                            <img class="col-sm-10" src="${o.image}">
                        </div>
                        <div class="col-md-8">
                            <a href="detailarticle?did=${o.id}">
                                <h9 class="title">${o.title}</h9>
                                <br>

                            </a>
                            <p style="width: 60%; margin-top: 10px;">${o.description}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!--end of Top newest article-->              
            <!--List all article-->
            <div class="title" style=" display: inline-block;margin-left: 40px; margin-top: 30px; margin-bottom: 20px;">
                <h4 style="float:left; font-size: 30px;">All article</h4>   
                <form method="post" action="searcharticle" class="form-inline" onsubmit="return FormValidate();" style="display: inline-block; float: right; margin-right: 140px;" >

                    <div class="form-group" style="float:left; display: inline-block;">

                        <input type="name"
                               class="form-control" id="name" name="name" value="${txtS}"
                               placeholder="Enter title">

                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
                <label for="name" style="margin-left: 900px;"><span style="color: red;" id="errorName"></span></label> 
            </div>
            <!--These link for all article use c:forEach of JSTL -->

            <c:forEach items="${listP}" var="o" >
                <div class="row" style=" margin-bottom:40px; margin-left: 23px;">
                    <div class="col-sm-4" >
                        <a href="#" class="">
                            <img class="col-sm-12" src="${o.image}" >
                        </a>
                    </div>
                    <div class="col-sm-8" >
                        <a href="detailarticle?did=${o.id}">
                            <h3 class="title" style="font-size: 30px; margin-bottom: 30px;">${o.title}</h3>
                        </a>
                        <p style="width: 90%; font-size: 18px; margin-bottom: 20px;">${o.description}</p>

                        <c:if test="${sessionScope.account != null}">
                            <a href="likearticle?aid=${o.id}" style="text-decoration: none; margin-right:10px; font-size: 20px; ">
                                <i class="fas fa-thumbs-up"></i> Like
                            </a>
                            </a>
                        </c:if>
                        <c:if test="${sessionScope.account == null}">
                            <a href="Login"  style="text-decoration: none; margin-right: 10px; margin-top: 40px; font-size: 20px;">
                                <i class="fas fa-thumbs-up"></i> Like
                            </a>
                        </c:if>

                        <span class="text-muted" >Author: ${o.createName}<a href="#"></a></span>
                         <span class="text-muted" >View: ${o.view}<a href="#"></a></span>
                    </div>
                </div>
            </c:forEach>
            <h1 style="color:red; text-align: center">${message}</h1>

            <!--end of List all article
             <span class="text-muted">   <i class="fa fa-eye-slash"></i> Views: 50  <a href="#"></a></span>-->        
            <!--Paging article-->
            <ul class="pagination" style="margin-top: 30px; margin-bottom: 30px; margin-left: 4px;">
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
    <script>
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
</html>
<style>
    span{
        margin-left: 40px;   
        margin-top: 30px;
    }
</style>