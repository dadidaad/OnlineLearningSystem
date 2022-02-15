<%-- 
    Document   : header
    Created on : Feb 7, 2022, 11:26:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page import="Bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between pt-1 pb-2 mb-4 border-bottom bg-white px-3">
            <a href="<i:ReadUrlFromContext url="/view/Home.jsp"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="<i:ReadUrlFromContext url="/assets/image/logo.png"/>" alt="logo" >
            </a>

            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/view/Home.jsp"/>" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Forum</a></li>
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Subject"/>" class="nav-link">Learning</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Request</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            </ul>
            <c:set var="currentURI" value="${pageContext.request.requestURI}"></c:set>
            <c:if test = "${fn:containsIgnoreCase(currentURI, 'login') ne true or !fn:containsIgnoreCase(currentURI, 'signup') ne true or !fn:containsIgnoreCase(currentURI, 'resetpassword') ne true}">
                <div class="col-md-3 text-end">
                    <c:if test="${sessionScope.user eq null}">
                        <a href="<i:ReadUrlFromContext url="/Login"/>" class="btn btn-outline-primary me-2">Login</a>
                        <a href="<i:ReadUrlFromContext url="/SignUp"/>" class="btn btn-primary">Sign-up</a>
                    </c:if>
                </div>
                <c:if test="${sessionScope.user ne null}">
                    <p class="text-success" style="font-size: 20px;font-weight: 500; padding-top: 15px; padding-right: 10px;"> Hello
                        ${sessionScope.user.displayName}
                    </p>
                </c:if>
            </c:if>
        </div>
    </header>
</body>
</html>
