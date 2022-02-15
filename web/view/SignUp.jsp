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
        <title>Sign Up</title>
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bs-stepper/dist/css/bs-stepper.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <style>
            body{
                background-image: url('./assets/image/AccountFeature/backgroundAccountFeature.png');
            }
        </style>
    </head>
    <body>
        <jsp:include page="../view/header.jsp"></jsp:include>
        <div class="container container-account">
            <div class="d-flex flex-wrap justify-content-center ">
                <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap flex-grow-0" style="background-color: #326D6B;">
                    <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                </div>
                <div class="d-flex bg-light flex-fill justify-content-center" style="--bs-bg-opacity:.9;">
                    <div class="bs-stepper" id="stepper">
                        <div class="bs-stepper-header" role="tablist">
                            <!-- your steps here -->
                            <div class="step" data-target="#signup-part">
                                <button type="button" class="step-trigger" role="tab" aria-controls="signup-part" id="signup-part-trigger">
                                    <span class="bs-stepper-circle">1</span>
                                    <span class="bs-stepper-label">Information</span>
                                </button>
                            </div>
                            <div class="line"></div>
                            <div class="step" data-target="#captcha-part">
                                <button type="button" class="step-trigger" role="tab" aria-controls="captcha-part" id="captcha-part-trigger">
                                    <span class="bs-stepper-circle">2</span>
                                    <span class="bs-stepper-label">Check Captcha</span>
                                </button>
                            </div>
                            <div class="line"></div>
                            <div class="step" data-target="#finish-part">
                                <button type="button" class="step-trigger" role="tab" aria-controls="finish-part" id="finish-part-trigger">
                                    <span class="bs-stepper-circle">3</span>
                                    <span class="bs-stepper-label">Finish</span>
                                </button>
                            </div>
                        </div>
                        <div class="bs-stepper-content mt-3">
                            <!-- your steps content here -->
                            <div id="signup-part" class="content" role="tabpanel" aria-labelledby="signup-part-trigger">
                                <div class=" d-flex flex-fill flex-column justify-content-center flex-wrap align-items-center" id="signUpForm">
                                    <h4 class="text-center text-dark">Sign Up</h4>
                                    <form id="signup-form" action="SignUp" method="post">
                                        <div class="form__group mb-3">
                                            <input type="text" id="username" class="form__field" name="username" placeholder="Username"  required />
                                            <label for="username" class="form__label">Username</label>
                                            <div id="notiExistUser" class="small text-danger"></div>
                                        </div>
                                        <div class="form__group mb-3">
                                            <input type="email" id="email" class="form__field" name="email" placeholder="Email" required />
                                            <label for="email" class="form__label">Email</label>
                                            <div id="notiExistMail" class="small text-danger"></div>
                                        </div>
                                        <div class="form__group mb-3">
                                            <select id="sex" name="sex" class="form__field" required>
                                                <option value="" disabled selected>Choose sex</option>
                                                <option value="male">Male</option>
                                                <option value="female">Female</option>
                                            </select>
                                        </div>
                                        <div class="form__group has-feedback mb-3">
                                            <input type="password" name="password" id="password_reg" class="form__field" placeholder="Password"  required />
                                            <label  class="form__label" for="password_reg">Password</label>
                                        </div>
                                        <div class="form__group has-feedback mb-3">
                                            <input type="password" name="confirmPassword" id="confirmPassword" class="form__field" placeholder="Confirm Password"  required />
                                            <label class="form__label" for="confirmPassword">Confirm Password</label>
                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success btn-lg px-5 mt-2 btn-next" id="signup-btn">Sign Up</button>
                                        </div>
                                    </form>
                                    <div id="notiRes" class="text-danger small"></div>
                                    <p class="text-dark">Already have an account?<a href="<i:ReadUrlFromContext url="/Login"/>" class="text-primary">Return login screen</a></p>
                                </div>
                            </div>
                            <div id="captcha-part" class="content" role="tabpanel" aria-labelledby="captcha-part-trigger"> 
                                <div class="d-flex justify-content-center align-items-center flex-column flex-fill">
                                    <form action="VerifyCaptcha" method="post" id="verifytoken-form">
                                        <div class="form__group mb-3">
                                            <input type="text" id="captcha" class="form__field" name="captcha" placeholder="Captcha" required/>
                                            <label for="captcha" class="form__label" name="captcha" id="captcha">Captcha</label>
                                            <button type="button" class="btn btn-primary" id="resend-btn">Resend captcha</button>
                                        </div>
                                        <div id="notiCaptcha" class="small text-danger"></div>
                                        <div class="d-flex">
                                            <button onclick="previous()" class="btn btn-outline-primary px-3 py-1 mx-3">Back</button>
                                            <button class="btn btn-primary px-3 py-1 btn-next" id="inputCaptcha-btn" type="submit">Verify</button>
                                        </div>
                                    </form>
                                    <p class="text-dark">Input captcha we send to your mail</p>
                                </div>
                            </div>
                            <div id="finish-part" class="content" role="tabpanel" aria-labelledby="finish-part-trigger">
                                <div class="d-flex justify-content-center flex-column align-items-center">
                                    <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/success-icon.png"/>" alt="success" style="width:50px; height:50px;">
                                    <p class="text-dark"><span id="notiRegister" class="text-success"></span> Please return to the login page to use our service.</p>
                                    <a href="<i:ReadUrlFromContext url="/Login"/>" class="btn btn-primary btn-lg">Return login screen</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bs-stepper/dist/js/bs-stepper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CallAjaxForRegister.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidatorInput.js"/>"></script>
    </body>
</html>
