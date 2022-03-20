<%-- 
    Document   : FavorArticle
    Created on : Mar 12, 2022, 10:41:40 AM
    Author     : hoang
--%>

<%@taglib uri="/WEB-INF/tlds/customTag" prefix="i" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />
                <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>"/>
    </head>
    <body>
            <!--begin of menu-->
            <!--end of menu-->
            <!--begin of list article-->
              <div  class="container">
            <jsp:include page="./header.jsp"></jsp:include>
            </div>
             <h2 style="margin-left: 40px; margin-top: 60px; font-size: 30px;">My favorite article</h2>
              <c:forEach items="${listF}" var="o" >
                <div class="row" style=" margin-bottom:30px; margin-left: 3%;">
                    <div class="col-sm-4" >
                        <a href="#" class="">
                            <img class="col-sm-12" src="${o.image}" >
                        </a>
                    </div>
                    <div class="col-sm-8" >
                        <a href="detailarticle?did=${o.id}">
                            <h3 class="title" style="font-size: 30px; margin-bottom: 30px;">${o.title}</h3>
                        </a>
                        <p style="width: 90%; font-size: 18px; margin-bottom: 20px;">${o.description}</p>
                                    
                        <span class="text-muted">Author: ${o.createName}<a href="#"></a></span>
                       <td><a   onclick="showMessage(${o.id})"
                              class="btn btn-info" role="button" style="float: right; margin-right: 15%;">Delete</a></td>
                    </div>                        
                </div>
                             
            </c:forEach>
              <h2 style="text-align: center; color: blue;">${message}</h2>
            <!--end of list article-->
    </body>
    
        <%@include file="./footer.jsp" %>
        <!-- Java Script link-->
        <script>
            
            function showMessage(id) {
                var result = confirm("Want to delete your favor?");
                if (result === true) {
                    window.location.href = 'deletefavorarticle?pid=' + id;
                }
            }
              function FormValidate() {
                        var name = document.getElementById('name').value.trim();
                        var errorName = document.getElementById('errorName');
                        if (name == '' || name == null) {
                            errorName.innerHTML = "Please enter title";
                        }
                        else{
                        return name;
                    }
                    return false;
                    }
        </script>                  
    <!-- Java Script link-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</html>
