<%-- 
    Document   : ArticleDetail
    Created on : Feb 13, 2022, 2:45:32 PM
    Author     : hoang
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
        <%@include file="./header.jsp" %>
        <!--section detail article-->
        <div class="container">
            <div class="row mt-3">
                <div class="col-md-12">

                    <h2 style="font-size: 40px; color: red;">${article.title}</h2>

                    <hr />
                    <input type="hidden" name="idarticle" value="${article.id}" hidden/>
                    <div class="text-center py-3">
                        <p> ${ article.pulished }</p>
                        <figure class="figure">
                            <img src="${article.image}" class="figure-img img-fluid my-2" alt="...">
                            <figcaption class="figure-caption" style="font-size: 25px;">Author: ${article.createName}</figcaption>
                        </figure>
                    </div>

                    <p style="margin-bottom: 30px;"> ${ article.description }</p>

                    <!--section end of detail article-->

                    <!--section comment article-->	
                    <div class="row mt-3">

                        <div class="comment-wrapper">
                            <div class="card">
                                <div class="card-body">
                                    <form action="createcommentarticle" method="post" name="myForm">
                                        <input type="hidden" name="articleId" value="${article.id}"/>
                                        <textarea name="title" class="form-control"  oninput="checkMess()" class="form-control"  placeholder="Write a comment...."></textarea>               

                                        <button  onClick="return FormValidate();" type="submit" class="btn btn-primary" >Post</button>
                                    </form>
                                    <label for="image"><span style="color: red;" id="errorTitle" style="margin-top: 50px; float: right;"></span></label> 
                                    <h3 style="color: red">${message}</h3>
                                    <div class="clearfix"></div>
                                    <hr>
                                    <ul class="media-list">
                                        <c:forEach items="${comments}" var="comment">
                                            <li class="media" style="margin-top: 20px;">
                                                <img src="<i:ReadUrlFromContext url="${comment.image}" />" style="width: 50px; height: 50px;" class="rounded-circle">
                                                <div class="media-body">
                                                    <strong class="text-success">${comment.name }</strong>
                                                    <p>
                                                        ${ comment.content }
                                                    </p>
                                                    <span class="text-muted pull-right">
                                                        <small class="text-muted">${comment.pulished}</small>
                                                    </span>
                                                    <c:if test="${comment.username == sessionScope.account.username}">

                                                        <a class="btn btn-info" role="button"  onclick="showMessage(${comment.commentid})" style="float: right;">Delete</a>
                                                    </c:if>

                                                </div>

                                                <br>
                                                <br>

                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function FormValidate() {
                    var image = document.myForm.title.value.trim();
                    var dodai = image.length;
                    var errorImage = document.getElementById('errorTitle');
                    if (image == "" || image == null) {
                        errorImage.innerHTML = "Please enter comment";
                        return false;
                    }
                    if (dodai > 300) {
                        errorImage.innerHTML = "Please enter not over 300 characters";
                        return false;
                    }

                }
                function showMessage(id) {
                    var result = confirm("Want to delete your comment?");
                    if (result === true) {
                        window.location.href = 'deletecomment?pid=' + id;
                    }
                }

            </script>

            <!-- end of section comment article-->	
            <%@include file="./footer.jsp" %>

    </body>
</html>

