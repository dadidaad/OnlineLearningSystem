<%-- 
    Document   : UserWall
    Created on : Feb 26, 2022, 7:20:09 PM
    Author     : DajtVox
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <title>Your profile</title>
        <style>
            body{
                background-color: #E9E9E9;
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container-fluid my-3">
                <div class="row">
                    <div class="col-md-3 card bg-white mx-5 p-0" style="height: 80vh;">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <h4 class="text-dark fw-bold container mt-5 mb-3 fs-3">Account Settings</h4>
                            <button class="nav-link active py-3" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="true">
                                <div class="d-flex align-items-center container text-dark fw-light"><i class="far fa-user mx-1"></i><p>Profile</p></div>
                            </button>
                            <button class="nav-link py-3" id="v-pills-password-tab" data-bs-toggle="pill" data-bs-target="#v-pills-password" type="button" role="tab" aria-controls="v-pills-password" aria-selected="false">
                                <div class="d-flex align-items-center container text-dark fw-light"><i class="fas fa-lock mx-1"></i><p>Change Password</p></div>
                            </button>
                            <h4 class="text-dark fw-bold container mt-5 mb-3 fs-3">Service</h4>
                            <button class="nav-link py-3" id="v-pills-wallet-tab" data-bs-toggle="pill" data-bs-target="#v-pills-wallet" type="button" role="tab" aria-controls="v-pills-wallet" aria-selected="false">
                                <div class="d-flex align-items-center container text-dark fw-light"><i class="fas fa-wallet"></i><p>Wallet</p></div>
                            </button>
                            <button class="nav-link py-3" id="v-pills-history-tab" data-bs-toggle="pill" data-bs-target="#v-pills-history" type="button" role="tab" aria-controls="v-pills-history" aria-selected="false">
                                <div class="d-flex align-items-center container text-dark fw-light"><i class="fas fa-history"></i><p>History</p></div>
                            </button>
                            <button class="nav-link py-3" id="v-pills-notification-tab" data-bs-toggle="pill" data-bs-target="#v-pills-notification" type="button" role="tab" aria-controls="v-pills-notification" aria-selected="false">
                                <div class="d-flex align-items-center container text-dark fw-light"><i class="fas fa-bell"></i><p>Notifications</p></div>
                            </button>
                        </div>
                    </div>
                    <div class="col-md-8 card bg-white">
                    <c:set var="userProfile" value="${requestScope.userProfile}"></c:set>
                        <div class="tab-content" id="v-pills-tabContent">
                            <div class="tab-pane fade show active" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                                <div class="container mt-3">
                                    <form action="EditProfile" id="editProfile-form" enctype="multipart/form-data" method="post">
                                        <div class="row">
                                            <div class="col-3 d-flex flex-column">
                                                <div class="top-left-content">
                                                    <input type="file" accept="image/*" id="avaUpload" name="avatar" style="display:none;" disabled/>
                                                    <label for="avaUpload" class="uploadImg_label">
                                                        <i class="fas fa-upload"></i>
                                                    </label>
                                                    <img src="<i:ReadUrlFromContext url="${userProfile.avatar}"/>" alt="avatar" class="bigAvatar">
                                                <button type="button" class="edit-icon" id="editProfile"><i class="fas fa-edit"></i></button>
                                            </div>
                                            <div class="bot-left-content mt-4">
                                                <label class="text-line my-2" for="bio-text">Bio</label>
                                                <textarea id="bio-text" maxLength="200" rows="10" cols="20" wrap="hard" name="description" disabled placeholder="Tell something about your, max 200 characters">${userProfile.description}</textarea>
                                                <div class="text-danger" id="alertBio"></div>
                                            </div>
                                            <div class="btn-edit mt-3">
                                                <button type="button" class="btn btn-outline-danger" id="cancel">Cancel</button>
                                                <input type="submit" class="btn btn-outline-primary" id="saveChanges" value="Save">
                                            </div>
                                        </div>
                                        <div class="col-8 d-flex flex-column mx-3">
                                            <div class="top-right-content d-flex flex-column">
                                                <div class="d-flex justify-content-between my-1">
                                                    <div>
                                                        <input type="text" value="${userProfile.displayName}" class="fw-bold text-dark fs-4" id="displayName" name="displayName" disabled>
                                                    </div>
                                                    <c:if test = "${userProfile.role == 'Student'}">
                                                        <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#becomeTutorModal">Become a tutor</button>
                                                    </c:if>
                                                </div>
                                                <p class="fw-light fs-6 my-1 text-dark">
                                                    <c:choose>
                                                        <c:when test="${userProfile.sex == false}">
                                                            <i class="fas fa-mars"></i>  Male
                                                        </c:when>
                                                        <c:otherwise>
                                                            <i class="fas fa-venus"></i>  Female
                                                        </c:otherwise>  
                                                    </c:choose>
                                                </p>
                                                <div class="my-1">
                                                    <label for="dob"><i class="fas fa-birthday-cake"></i></label>
                                                    <input type="date" id="dob" name="dob" placeholder="dd/mm/yyyy" class="fw-light text-dark fs-6" value="<fmt:formatDate pattern = "yyyy-MM-dd" 
                                                                    value = "${userProfile.dateOfBirth}" />" disabled /> 
                                                </div>
                                                <p class="fw-light fs-6 text-dark my-1"><i class="fas fa-envelope"></i>  ${userProfile.mail}</p>
                                                <p class="fw-light fs-6 text-dark my-1"><i class="fas fa-calendar-alt"></i>  Created at <fmt:formatDate pattern = "dd-MM-yyyy" 
                                                                value = "${userProfile.createDate}"/></p>
                                                <p class="fw-bold fs-5 text-dark my-1">${userProfile.role}</p>
                                                <p class="fw-lighter fs-6 text-dark mt-2">Rating</p>
                                                <p class="fw-light fs-6 text-dark mt-1">9.0 <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i> of 13 reviewers</p>
                                            </div>
                                            <div class="bot-right-content mt-5 d-flex flex-column">
                                                <p class="text-bold fs-3 text-dark text-line">Comment</p>
                                                <div class="feedback mt-1">
                                                    <p class="text-primary text-bold fs-5">Doan Anh Tu</p>
                                                    <p class="text-dark fs-6 mt-1">Nice work, good job!!</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="v-pills-password" role="tabpanel" aria-labelledby="v-pills-password-tab">
                            <div class="d-flex flex-column align-items-center justify-content-center my-5">
                                <h3 class="fw-bolder fs-3 text-dark my-3">Change Password</h3>
                                <form id="changepw-form" action="ChangePassword" method="post">
                                    <div class="form__group has-feedback mb-3">
                                        <input type="password" name="oldPassword" id="password_old" class="form__field" placeholder="Old Password"  required />
                                        <label  class="form__label" for="password_reg">Old Password</label>
                                    </div>
                                    <div class="form__group has-feedback mb-3">
                                        <input type="password" name="newPassword" id="password_new" class="form__field" placeholder="New Password"  required />
                                        <label  class="form__label" for="password_reg">New Password</label>
                                    </div>
                                    <div class="form__group has-feedback mb-3">
                                        <input type="password" name="confirmPassword" id="confirmPassword" class="form__field" placeholder="Confirm New Password"  required />
                                        <label class="form__label" for="confirmPassword">Confirm New Password</label>
                                    </div>
                                    <div id="changepw-noti"></div>
                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-outline-dark px-3 mt-2" id="changePw-btn">Change password</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="v-pills-wallet" role="tabpanel" aria-labelledby="v-pills-wallet-tab"></div>
                        <div class="tab-pane fade" id="v-pills-history" role="tabpanel" aria-labelledby="v-pills-history-tab"></div>
                        <div class="tab-pane fade" id="v-pills-notification" role="tabpanel" aria-labelledby="v-pills-notification-tab"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="becomeTutorModal" tabindex="-1" aria-labelledby="becomeTutorModal" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Become a tutor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <c:choose>
                            <c:when test = "${requestScope.teacherStatus}">
                                <p class="fs-5 text-dark">Your CV has been submitted, waiting for admin response</p>
                            </c:when>
                            <c:otherwise>
                                <p class="text-dark fs-4">Send your CV and choose subject</p>
                                <form action="BecomeTutor" method="post" id="becometutor-form" enctype="multipart/form-data">
                                    <div class="form__group mb-3" x-data="{ fileName: '' }">
                                        <div class="input-group shadow">
                                            <span class="input-group-text px-3 text-muted"><i class="fas fa-image fa-lg"></i></span>
                                            <input type="file" accept="image/*" x-ref="file" @change="fileName = $refs.file.files[0].name" name="teacherCV" class="d-none" required>
                                            <input type="text" class="form-control form-control-lg" placeholder="Upload your CV" x-model="fileName" disabled required>
                                            <button class="browse btn btn-dark px-2" type="button" x-on:click.prevent="$refs.file.click()"><i class="fas fa-image"></i> Browse</button>
                                        </div>
                                    </div>
                                    <div class="form__group mb-3">
                                        <select id="subject" name="subject" class="form__field" required>
                                            <option value="" disabled selected>Choose subject</option>
                                            <c:forEach items="${requestScope.listSubject}" var="subject">
                                                <option value="${subject.subjectID}">${subject.subjectName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-dark">Submit your CV</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.8.0/dist/alpine.min.js"/>
        <script>
            var triggerTabList = [].slice.call(document.querySelectorAll('#myTab a'));
            triggerTabList.forEach(function (triggerEl) {
                var tabTrigger = new bootstrap.Tab(triggerEl);
                triggerEl.addEventListener('click', function (event) {
                    event.preventDefault();
                    tabTrigger.show();
                });
            });
        </script>
        <script src ="<i:ReadUrlFromContext url="/assets/js/UserSettingsJs.js"/>"></script>
        <script src ="<i:ReadUrlFromContext url="/assets/js/CheckValidateInputForm.js"/>"></script>
    </body>
</html>
