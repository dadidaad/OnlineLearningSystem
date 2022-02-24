<%-- 
    Document   : ArticleDetail
    Created on : Feb 13, 2022, 2:45:32 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
          <%@include file="./header.jsp" %>
        <!--section detail article-->
     <div class="container">
	<div class="row mt-3">

		<div class="col-md-12">

			<h2>${article.title}</h2>
                        
			<hr />
					
			<div class="text-center py-3">
				<p> ${ article.pulished }</p>
				<figure class="figure">
                <img src="${article.image}" class="figure-img img-fluid my-2" alt="...">
  <figcaption class="figure-caption">Author: </figcaption>
</figure>
			</div>
				
			<p> ${ article.description }</p>
                   
        <!--section end of detail article-->
                        
	<!--section comment article-->		
	<h4>Comments:</h4>
		
        <div class="comment-wrapper">
            <div class="card">
                <div class="card-body">
                
                	<form action='<c:url value="/comments/do/add"/>' method="POST" >
                	<input type="hidden" name="articleId" value="${ article.id }"/>
                	<input class="form-control form-group" type="text" name="commentAuthor" placeholder="Name...">
                	<textarea name="commentContent" class="form-control" placeholder="Write a comment..." rows="3"></textarea>
                    <br>
                    <button name="addCommentSubmit" type="submit" class="btn btn-info pull-right">Post</button>
                    </form>
                    <div class="clearfix"></div>
                    <hr>
                    <ul class="media-list">
                        <c:forEach items="${ comments }" var="comment">
                        	<li class="media">
                            <a href="#" class="pull-left px-2">
                                <i class="fas fa-user-tie fa-3x"></i>
                            </a>
                            <div class="media-body">
                                <span class="text-muted pull-right">
                                    <small class="text-muted">${ comment.formattedDateTime }</small>
                                </span>
                                <strong class="text-success">@${ comment.author }</strong>
                                <p>
                                    ${ comment.content }
                                </p>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
	</div>
		</div>
	</div>
                        <!-- end of section comment article-->	
                            <%@include file="./footer.jsp" %>
    </body>
</html>

