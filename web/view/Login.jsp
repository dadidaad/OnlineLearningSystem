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
                <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap flex-grow-0" style="background-color: #326D6B;">
                    <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                </div>
                <div class="d-flex bg-light flex-fill" style="--bs-bg-opacity:.9;">
                    <div class="d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center left-field" id="chooseRole">
                        <h4 class="text-center text-dark py-1 my-1">Login As</h4>
                        <button class="btn btn-warning py-2 my-1 px-5" id="roleStudent">Student</button>
                        <button class="btn btn-warning py-2 my-1 px-5" id="roleTeacher">Teacher</button>
                        <p class="text-center text-dark py-1 my-1">New Member? <a href="#" class="text-success text-center">Create new account</a></p>
                    </div>
                    <div class="d-none d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="loginForm">
                        <button type="button" class="btn btn-outline-primary rounded-circle" id="backToChooseRole"><i class="fas fa-long-arrow-alt-left"></i></button>
                        <h3>Welcome <span id="role" class="text-success"></span>!!</h3>
                        <h4 class="text-center text-dark py-3">Login your account</h4>
                        <form>
                            <div class="form__group field mb-4">
                                <input type="text" id="username" class="form__field" name="username" placeholder="Email or Username" required />
                                <label for="username" class="form__label">Email or Username</label>
                            </div>
                            <div class="form__group field mb-4">
                                <input type="password" id="password" class="form__field" name="password" placeholder="Pasword" required/>
                                <label for="password" class="form__label">Password</label>
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                <!-- Checkbox -->
                                <div class="form-check mb-0">
                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                    <label class="form-check-label small" for="form2Example3">Remember me
                                    </label>
                                </div>
                                <a href="#!" class="small">Forgot password?</a>
                            </div>
                            <div class="d-flex justify-content-center">
                                <button class="btn btn-success btn-lg px-5 mt-2" type="submit">Login</button>
                            </div>
                            <div class="divider d-flex align-items-center my-4">
                                <p class="text-center fw-bold mx-3 mb-0 text-muted">Or</p>
                            </div>
                            <div class="d-flex justify-content-center text-center mt-3 pt-1">
                                <a href="#!" class="text-dark"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-google fa-lg"></i></a>
                            </div>
                        </form>
                        <div class="mt-2">
                            <p class="mb-0">Don't have an account? <a href="#!" class="text-dark-50 fw-bold">Sign Up</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                $('#roleStudent').click(function () {
                    $('#chooseRole').toggleClass('d-none');
                    $('#role').html('Student');
                    $('#loginForm').removeClass('d-none');
                });
                $('#roleTeacher').click(function () {
                    $('#chooseRole').toggleClass('d-none');
                    $('#role').html('Teacher');
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
