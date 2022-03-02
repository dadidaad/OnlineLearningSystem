<%-- 
    Document   : AccepArticle
    Created on : Feb 8, 2022, 5:07:15 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Manager article</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div class="container">
            <h2>Manager article</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Image</th>
                        <th>Author</th>
                        <th>CreateDay</th>
                        <th>Accept</th>
                        <th>Decline</th>
                        <th>Show detail</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach items="${listP}" var="o">
                        <tr>
                            <td>${o.id}</td>    
                            <td>
                                <img src="${o.image}">
                                <style>
                                    .table-striped img{
                                        width: 100px;
                                        height: 100px;
                                    }
                                </style>
                            </td>
                            <th>${o.createName}</th>
                            <td>${o.pulished}</td>  
                            <td><a href="accept?pid=${o.id}"
                                   class="btn btn-info" role="button">Accept</a></td>
                            <td><a  class="btn btn-info" role="button"  onclick="showMessage(${o.id})">Decline</a></td>    
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
                                    Show details
                                </button>
                                <!-- Modal -->
                                 <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">${o.title}</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>Description: </label>
                                                    ${o.description}
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                           
                        </tr>
                    </c:forEach>

                </tbody>

            </table> 
        </div>
        <script>
            function showMessage(id) {
                var result = confirm("Want to decline?");
                if (result === true) {
                    window.location.href = 'deleteprepare?pid=' + id;
                }
            }
        </script>                                                 

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>

