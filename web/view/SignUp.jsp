<%-- 
    Document   : SignUp
    Created on : Feb 9, 2022, 2:43:19 PM
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
                    <div class=" d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="signUpForm">
                        <h4 class="text-center text-dark">Sign Up</h4>
                        <form class="" id="signup-form">
                            <div class="form__group mb-3">
                                <input type="text" id="username" class="form__field" name="username" placeholder="Username" required />
                                <label for="username" class="form__label">Username</label>
                            </div>
                            <div class="form__group mb-3">
                                <input type="email" id="email" class="form__field" name="email" placeholder="Email" required />
                                <label for="email" class="form__label">Email</label>
                            </div>
                            <div class="form__group mb-3">
                                <select id="sex" name="sex" class="form__field" place required>
                                    <option value="" disabled selected>Choose sex</option>
                                    <option value="0">Male</option>
                                    <option value="1">Female</option>
                                </select>
                            </div>
                            <div class="form__group has-feedback mb-3">
                                <input type="password" name="password" id="password_reg" class="form__field" placeholder="Password"required />
                                <label  class="form__label" for="password">Password</label>
                            </div>
                            <div class="form__group has-feedback mb-3">
                                <input type="password" name="confirmPassword" id="confirmPassword" class="form__field" placeholder="Confirm Password" required />
                                <label class="form__label" for="confirmPassword">Confirm Password</label>
                            </div>
                            <div class="d-flex justify-content-center">
                                <button class="btn btn-success btn-lg px-5 mt-2" type="submit">Sign Up</button>
                            </div>
                            <input type="hidden" name="role"/>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/checkValidatorInput.js"/>"></script>
    </body>
</html>
