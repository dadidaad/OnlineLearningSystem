<%-- 
    Document   : header
    Created on : Feb 7, 2022, 11:26:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="<i:ImportUrl url="/view/Home.jsp"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <img src="<i:ImportUrl url="/assets/image/logo.png"/>" alt="logo" >
                </a>
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="<i:ImportUrl url="/view/Home.jsp"/>" class="nav-link active" aria-current="page">Home</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Forum</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Learning</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">Request</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">About</a></li>
                </ul>
            </header>

    </body>
</html>
