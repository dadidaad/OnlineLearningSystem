<%-- 
    Document   : Login
    Created on : Feb 7, 2022, 10:43:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <style>
            body{
                background-image: url('../assets/image/AccountFeature/backgroundAccountFeature.png');
            }
        </style>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <div class="container container-account">
            <div class="d-flex flex-wrap justify-content-center ">
                <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap" style="background-color: #326D6B;">
                    <h3 class="text-center text-white md-10">Tutorduo</h3>
                    <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                </div>
                <div class="d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center bg-light" style="--bs-bg-opacity:.9;">
                    <h4 class="text-center text-dark py-1 my-1">Login As</h4>
                    <button class="btn btn-warning py-2 my-1 px-5">Student</button>
                    <button class="btn btn-warning py-2 my-1 px-5">Teacher</button>
                    <p class="text-center text-dark py-1 my-1">New Member? <a href="#" class="text-success text-center">Create new account</a></p>
                </div>
            </div>
        </div>
    </body>
</html>
