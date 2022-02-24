<%-- 
    Document   : header
    Created on : Feb 7, 2022, 11:26:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page import="Bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <header class="d-flex flex-wrap align-items-center justify-content-between justify-content-md-between pt-1 mb-4 border-bottom bg-white px-3">
            <a href="<i:ReadUrlFromContext url="/Home"/>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="<i:ReadUrlFromContext url="/assets/image/logo.png"/>" alt="logo" >
            </a>

            <ul class="nav col-12 col-md-6 mb-2 justify-content-center mb-md-0">
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Home"/>" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Forum</a></li>
                <li class="nav-item"><a href="<i:ReadUrlFromContext url="/Subject"/>" class="nav-link">Learning</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Request</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            </ul>
            <c:set var="currentURI" value="${pageContext.request.requestURI}"></c:set>
            <c:if test = "${fn:containsIgnoreCase(currentURI, 'login') ne true 
                            or !fn:containsIgnoreCase(currentURI, 'signup') ne true 
                            or !fn:containsIgnoreCase(currentURI, 'resetpassword') ne true}">
                <c:if test="${sessionScope.user eq null}">
                    <a href="<i:ReadUrlFromContext url="/Login"/>" class="btn btn-outline-primary me-2">Login</a>
                    <a href="<i:ReadUrlFromContext url="/SignUp"/>" class="btn btn-primary">Sign-up</a>
                </c:if>
                <c:if test="${sessionScope.user ne null}">
                    <img class="small-avatar" alt="avatar" src="<i:ReadUrlFromContext url="${sessionScope.user.avatar}"/>"/>
                    <div class="dropdown">
                        <button class="btn btn-outline-light btnclick">
                            <p class="text-dark">
                                ${sessionScope.user.displayName}
                            <i class="fas fa-caret-down"></i>
                            </p>
                        </button>
                        <div class="dropdown-content" id="myDropdown">
                            <a href="<i:ReadUrlFromContext url="/SettingAccount"/>">Your profile</a>
                            <div class="divider"></div>
                            <a href="<i:ReadUrlFromContext url="/LogOut"/>">Log Out</a>
                        </div>
                    </div> 
                </c:if>
            </c:if>
        </header>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
    </body>
</html>
