<%-- 
    Document   : ForgotPassword
    Created on : Feb 10, 2022, 9:27:54 PM
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
                    <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap flex-grow-0" style="background-color: #326D6B;">
                        <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                </div>
                <div class="d-flex bg-light flex-fill" style="--bs-bg-opacity:.9;">
                    <div class=" d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="forgotPassword">
                        <h4 class="text-dark">Forgot password</h4>
                        <<!-- multistep form -->
                       
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/checkValidatorInput.js"/>"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
