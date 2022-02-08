<%-- 
    Document   : header
    Created on : Feb 7, 2022, 11:26:31 AM
    Author     : Admin
--%>

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
                <li class="nav-item"><a href="#" class="nav-link">Learning</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Request</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            </ul>
            <div class="col-md-3 text-end">
                <button type="button" class="btn btn-outline-primary me-2">Login</button>
                <button type="button" class="btn btn-primary">Sign-up</button>
            </div>
        </header>
    </body>
</html>
