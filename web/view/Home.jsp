<%-- 
    Document   : Home
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<i:ImportUrl url="/assets/css/style.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div  class="container">
            <jsp:include page="./general/header.jsp"></jsp:include>
        </div>
        <div class="container">
            <jsp:include page="./general/footer.jsp"></jsp:include>
        </div>
    </body>
</html>
