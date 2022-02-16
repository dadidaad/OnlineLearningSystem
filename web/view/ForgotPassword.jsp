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
        <jsp:include page="./header.jsp"></jsp:include>
            <div class="container container-account">
                <div class="d-flex justify-content-center flex-fill">
                    <div class="d-flex flex-fill flex-column align-items-center  py-1 left flex-wrap flex-grow-0" style="background-color: #326D6B;">
                        <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/educationImage.png"/>" alt="education" class="md-8 py-2">
                    </div>
                    <div class="d-flex bg-light flex-fill flex-grow-0" style="--bs-bg-opacity:.9;">
                        <div class=" d-flex flex-fill flex-column flex-wrap align-items-center" id="forgotPassword">
                            <h4 class="text-dark mt-3">Forgot password</h4>
                            <div class="bs-stepper" id="stepper">
                                <div class="bs-stepper-header" role="tablist">
                                  <!-- your steps here -->
                                    <div class="step" data-target="#mail-part">
                                        <button type="button" class="step-trigger" role="tab" aria-controls="mail-part" id="mail-part-trigger">
                                            <span class="bs-stepper-circle">1</span>
                                            <span class="bs-stepper-label">Verify Email</span>
                                        </button>
                                    </div>
                                    <div class="line"></div>
                                    <div class="step" data-target="#captcha-part">
                                        <button type="button" class="step-trigger" role="tab" aria-controls="captcha-part" id="captcha-part-trigger">
                                            <span class="bs-stepper-circle">2</span>
                                            <span class="bs-stepper-label">Check Token</span>
                                        </button>
                                    </div>
                                    <div class="line"></div>
                                    <div class="step" data-target="#password-part">
                                        <button type="button" class="step-trigger" role="tab" aria-controls="password-part" id="password-part-trigger">
                                            <span class="bs-stepper-circle">3</span>
                                            <span class="bs-stepper-label">New Password</span>
                                        </button>
                                    </div>
                                    <div class="line"></div>
                                    <div class="step" data-target="#finish-part">
                                        <button type="button" class="step-trigger" role="tab" aria-controls="finish-part" id="finish-part-trigger">
                                            <span class="bs-stepper-circle">4</span>
                                            <span class="bs-stepper-label">Finish</span>
                                        </button>
                                    </div>
                                </div>
                                <div class="bs-stepper-content mt-3">
                                    <!-- your steps content here -->
                                    <div id="mail-part" class="content" role="tabpanel" aria-labelledby="mail-part-trigger">
                                        <div class="d-flex justify-content-center align-items-center flex-column flex-fill">
                                            <form action="ResetPassword" method="post" id="submitmail-form">
                                                <div class="form__group mb-3">
                                                    <input type="email" id="email" class="form__field" name="email" placeholder="Email" required />
                                                    <label for="email" class="form__label">Email</label>
                                                    <input type="hidden" name="step" value="mailverify"/>
                                                    <div id="notiExistMail" class="text-danger small"></div>
                                                </div>
                                                <button class="btn btn-primary px-3 py-1" id="verifymail-btn" type="submit">Next</button>
                                            </form>
                                            <p class="text-dark">Input your email you signed up to our service.</p>
                                        </div>
                                    </div>
                                    <div id="captcha-part" class="content" role="tabpanel" aria-labelledby="captcha-part-trigger"> 
                                        <div class="d-flex justify-content-center align-items-center flex-column flex-fill">
                                            <form action="ResetPassword" method="post" id="verifytoken-form">
                                                <div class="form__group mb-3">
                                                    <input type="text" id="captcha" class="form__field" name="captcha" placeholder="Captcha" />
                                                    <label for="captcha" class="form__label">Captcha</label>
                                                    <button type="button" class="btn btn-primary" id="resend-btn">Resend captcha</button>
                                                    <input type="hidden" name="step" value="captchaverify"/>
                                                    <div id="notiCaptcha" class="small text-danger"></div>
                                                </div>
                                                <div class="d-flex">
                                                    <button onclick="previous()" class="btn btn-outline-primary px-3 py-1 mx-3">Back</button>
                                                    <button type="submit" class="btn btn-primary px-3 py-1">Check captcha</button>
                                                </div>
                                            </form>
                                            <p class="text-dark">Input captcha we send to your mail</p>
                                        </div>
                                    </div>
                                    <div id="password-part" class="content" role="tabpanel" aria-labelledby="password-part-trigger"> 
                                        <div class="d-flex justify-content-center align-items-center flex-column flex-fill">
                                            <form id="forgotPassword-form" action="ResetPassword" method="POST">
                                                <div class="form__group has-feedback mb-3">
                                                    <input type="password" name="password" id="password_reset" class="form__field" placeholder="Password" />
                                                    <label  class="form__label" for="password">Password</label>
                                                </div>
                                                <div class="form__group has-feedback mb-3">
                                                    <input type="password" name="confirmPassword" id="confirmPassword" class="form__field" placeholder="Confirm Password"/>
                                                    <label class="form__label" for="confirmPassword">Confirm Password</label>
                                                </div>
                                                <div class="d-flex">
                                                    <button type="button" onclick="previous()" class="btn btn-outline-primary px-3 py-1 mx-3">Back</button>
                                                    <button type="submit" class="btn btn-primary px-3 py-1" id="changePass-btn">Confirm</button>
                                                </div>
                                                <input type="hidden" name="step" value="resetpassword">
                                                <div class="text-danger small" id="resetPw-noti"></div>
                                            </form>
                                            <p class="text-dark">Input new password for your account</p>
                                        </div>
                                    </div>
                                    <div id="finish-part" class="content" role="tabpanel" aria-labelledby="finish-part-trigger">
                                        <div class="d-flex justify-content-center flex-column align-items-center">
                                            <img src="<i:ReadUrlFromContext url="/assets/image/AccountFeature/success-icon.png"/>" alt="success" style="width:50px; height:50px;">
                                            <p class="text-dark"><span class="text-success" id="reset-noti">Reset password successfully</span> Please return to the login page to use our service.</p>
                                            <a href="<i:ReadUrlFromContext url="/Login"/>" class="btn btn-primary btn-lg">Return login screen</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bs-stepper/dist/js/bs-stepper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CallAjaxForResetPassword.js"/>"></script>
        <script src="<i:ReadUrlFromContext url="/assets/js/CheckValidateInputForm.js"/>"></script>
    </body>
</html>
