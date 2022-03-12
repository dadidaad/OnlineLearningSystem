<%-- 
    Document   : header
    Created on : Feb 7, 2022, 11:26:31 AM
    Author     : Admin
--%>

<%@page import="utils.AppUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page import="bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<header class="d-flex flex-wrap align-items-center justify-content-around justify-content-md-around pt-1 mb-4 border-bottom bg-white px-3">
    <a href="<i:ReadUrlFromContext url="/Home"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <img src="<i:ReadUrlFromContext url="/assets/image/logo.png"/>" alt="logo" >
    </a>

    <ul class="nav col-12 col-md-6 mb-2 justify-content-center mb-md-0">
        <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Home"/>" class="nav-link active" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="<i:ReadUrlFromContext url="/listarticle"/>" class="nav-link">Forum</a></li>
        <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Subject"/>" class="nav-link">Learning</a></li>
        <li class="nav-item"><a href="<i:ReadUrlFromContext url="/ListAllTeacher"/>" class="nav-link">Request</a></li>
            <c:if test="${sessionScope.user ne null}">
                <c:if test = "${sessionScope.user.role eq 'Admin'}">
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/ReportList"/>" class="nav-link">Report</a></li>
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Dashboard"/>" class="nav-link">Dashboard</a></li>
                </c:if>
            </c:if>
    </ul>
    <c:if test="${sessionScope.user ne null}"> 
        <div class="notifications">
            <div class="icon_wrap"><i class="far fa-bell"></i></div>
            <span class="badge badge-danger badge-counter notiUnread">${notiUnread}</span>
            <div class="notification_dd">
                <ul class="notification_ul">
                    <c:if test="${requestScope.notificationList.size() == 0}">
                        <h3 style="text-align: center;margin: 32px auto;">Notifications empty</h3>
                    </c:if>
                    <c:forEach items="${requestScope.notificationList}" var ="n" varStatus="loop">
                        <li class="starbucks success">
                            <div class="notify_icon" style="margin-left: 16px">
                                <c:set var="notiTitle" value="${n.getTitle()}"></c:set>
                                <c:if test="${fn:toLowerCase(notiTitle) == 'request'}">
                                    <span class="icon"><i class="fas fa-file-import"></i></span>
                                    </c:if>
                                    <c:if test="${fn:toLowerCase(notiTitle) == 'subject'}">
                                    <span class="icon"><i class="fab fa-leanpub"></i></span>
                                    </c:if>
                                    <c:if test="${fn:toLowerCase(notiTitle) == 'forum'}">
                                    <span class="icon"><i class="fab fa-forumbee"></i></span>
                                    </c:if>
                                    <c:if test="${fn:toLowerCase(notiTitle) == 'admin'}">
                                    <span class="icon"><i class="fas fa-user"></i></span>
                                    </c:if>
                            </div>
                            <div class="notify_data">
                                <div class="title">${n.getTitle()}</div>
                                <div class="sub_title">${n.getContent()}</div>
                            </div>
                            <c:if test="${!n.isRead()}">
                                <i style="color: blue;font-size: 10px;" class="fas fa-circle"></i>
                            </c:if>
                        </li>
                    </c:forEach>
                    <c:if test="${requestScope.notificationList.size() != 0}">    
                    <li class="show_all">
                        <a class="link" href="ViewProfile?optionNav=4">Show All</a>
                    </li>
                    </c:if>
                </ul>
            </div>
        </div>   
    </c:if>             
    <c:set var="currentURI" value="${pageContext.request.requestURI}"></c:set>
    <c:if test = "${fn:containsIgnoreCase(currentURI, 'login') ne true 
                    or !fn:containsIgnoreCase(currentURI, 'signup') ne true 
                    or !fn:containsIgnoreCase(currentURI, 'resetpassword') ne true}">
        <c:if test="${sessionScope.user eq null}">
            <a href="<i:ReadUrlFromContext url="/Login"/>" class="btn btn-outline-primary me-2">Login</a>
            <a href="<i:ReadUrlFromContext url="/SignUp"/>" class="btn btn-primary">Sign-up</a>
        </c:if>
        <c:if test="${sessionScope.user ne null}">
            <img style="width: 50px; height: 50px;" class="small-avatar" alt="avatar" src="<i:ReadUrlFromContext url="${sessionScope.user.avatar}"/>"/>
            <div class="dropdown" style="margin-right: 1.5em;">
                <button class="btn btn-outline-light btnclick">
                    <p class="text-dark">
                        ${sessionScope.user.displayName}
                        <i class="fas fa-caret-down"></i>
                    </p>
                </button>
                <div class="dropdown-content" id="myDropdown">
                    <a href="<i:ReadUrlFromContext url="/ViewProfile"/>">Your profile</a>
                    <div class="divider"></div>
                    <a href="<i:ReadUrlFromContext url="/Wallet"/>">Wallet</a></li>
                    <div class="divider"></div>
                    <a href="<i:ReadUrlFromContext url="/LogOut"/>">Log Out</a>
                </div>
            </div> 
        </c:if>
    </c:if>
</header>
<link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/Notification.css"/>"/>    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src ="<i:ReadUrlFromContext url="/assets/js/Notification.js"/>"></script>
<script>
    jQuery.fn.extend({
        setMenu: function () {
            return this.each(function () {
                var containermenu = $(this);
                var itemmenu = containermenu.find('.btnclick');
                itemmenu.click(function () {
                    var submenuitem = containermenu.find('.dropdown-content');
                    submenuitem.slideToggle(300);
                });
                $(document).click(function (e) {
                    if (!containermenu.is(e.target) &&
                            containermenu.has(e.target).length === 0) {
                        var isopened =
                                containermenu.find('.dropdown-content').css("display");
                        if (isopened == 'block') {
                            containermenu.find('.dropdown-content').slideToggle(300);
                        }
                    }
                });
            });
        },
    });
    $('.dropdown').setMenu();
</script>
