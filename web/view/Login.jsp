<%-- 
    Document   : Login
    Created on : Feb 7, 2022, 10:43:59 PM
    Author     : Admin
--%>

<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        
        <!-- Specific background for this page -->
        <style>
            body{
                background-image: url('./assets/image/AccountFeature/backgroundAccountFeature.png');
            }
        </style>
    </head>
    <body>
        <%-- Include header of web site from general--%>
        <jsp:include page="./header.jsp"></jsp:include>
        
        <!-- Container -->
        <div class="container container-account">
            <div class="d-flex flex-wrap justify-content-center ">
                
                <!-- left field -->
                <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap flex-grow-0" style="background-color: #326D6B;">
                    <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                </div>
                
                <!-- right field -->
                <div class="d-flex bg-light flex-fill" style="--bs-bg-opacity:.9;">
                    
                    <!-- Choose role part -->
                    <div class="d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="chooseRole">
                        <h4 class="text-center text-dark py-1 my-1">Login As</h4>
                        <button class="btn btn-warning py-2 my-1 px-5" id="roleStudent">Student</button>
                        <button class="btn btn-warning py-2 my-1 px-5" id="roleTeacher">Teacher</button>
                        <p class="text-center text-dark py-1 my-1">New Member? <a href="<i:ReadUrlFromContext url="/SignUp"/>" class="text-success text-center">Create new account</a></p>
                    </div>
                    
                    <!-- input login form part -->
                    <div class="d-none d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="loginForm">
                        <button type="button" class="btn btn-outline-primary rounded-circle" id="backToChooseRole"><i class="fas fa-long-arrow-alt-left"></i></button>
                        <h3>Welcome <span id="role" class="text-success"></span>!!</h3>
                        <h4 class="text-center text-dark py-3">Login your account</h4>
                        <form id="login-form" action="Login" method="POST">
                            <div class="form__group field mb-3">
                                <input type="text" id="username" class="form__field" name="username" placeholder="Username" required />
                                <label for="username" class="form__label"> Username</label>
                            </div>
                            <div class="form__group field mb-3">
                                <input type="password" id="password_login" class="form__field" name="password" placeholder="Password" required/>
                                <label for="password_login" class="form__label">Password</label>
                            </div>
                            <div class="d-flex justify-content-between">
                                <!-- Checkbox -->
                                <div class="form-check mr-2 small" style="margin-right: 1rem;">
                                    <input class="form-check-input" type="checkbox" value="remember" id="rememberme" name="remember" style="margin-top: 0;"/>
                                    <label class="form-check-label" for="rememberme">
                                        Remember me
                                    </label>
                                </div>
                                <a href="<i:ReadUrlFromContext url="/ResetPassword"/>" class="small">Forgot password?</a>
                            </div>
                            <div class="text-danger" id="login-noti"></div>
                            <div class="d-flex justify-content-center">
                                <button class="btn btn-success btn-lg px-5 mt-2" type="submit" id="login-btn">Login</button>
                            </div>
                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0 text-muted">Or</p>
                            </div>
                            <input type="hidden" name="role" id="roleUser"/>
                            <div class="d-flex justify-content-center text-center mt-3 pt-1">
                                <a href="#!" class="text-dark"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-google fa-lg"></i></a>
                            </div>
                        </form>
                        <div class="mt-2">
                            <p class="mb-0">Don't have an account? <a href="<i:ReadUrlFromContext url="/SignUp"/>" class="text-dark-50 fw-bold">Sign Up</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
         <%
            /* check if exist message_forward in request attribute, if yes then run js script */
            HashMap<String, String> messageForward = (HashMap)request.getAttribute("message_forward");
            if(messageForward != null){
        %>
        <script>
            $('#chooseRole').addClass('d-none');
            $('#loginForm').removeClass('d-none');
            $('#login-noti').html("<%=messageForward.get("loginNoti")%>");
            $('#role').html("<%=messageForward.get("role")%>");
            $('#roleUser').val("<%=messageForward.get("role")%>");
            $('#username').val("<%=messageForward.get("username")%>");
            $('#password_login').val("<%=messageForward.get("password")%>");
        </script>
        <%}%>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidateInputForm.js"/>"></script>
        <script>
            $(document).ready(function () {
                $('#roleStudent').click(function () {
                    $('#chooseRole').toggleClass('d-none');
                    $('#role').html('Student');
                    $('#roleUser').val('Student');
                    $('#loginForm').removeClass('d-none');
                });
                $('#roleTeacher').click(function () {
                    $('#chooseRole').toggleClass('d-none');
                    $('#role').html('Teacher');
                    $('#roleUser').val('Teacher');
                    $('#loginForm').removeClass('d-none');
                });
                $('#backToChooseRole').click(function () {
                    $('#chooseRole').toggleClass('d-none');
                    $('#loginForm').toggleClass('d-none');
                });
              });
        </script>
    </body>
</html>
