<%-- 
    Document   : ReportList
    Created on : Mar 10, 2022, 7:16:54 AM
    Author     : tinht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/ViewReport.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.3.4/dist/flowbite.min.css" />
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
        <div class="container">
            <div class="modal-bg">
                <div class="modal_content drop-shadow-lg">
                    <div class="close">+
                    </div>
                    
                </div>
            </div>
            <div>
                <button type="button" name="status" class="text-white bg-gray-800 hover:bg-gray-900 focus:ring-4 focus:ring-gray-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">Report</button>
                <button type="button" name="status" class="text-gray-900 hover:text-white border border-gray-800 hover:bg-gray-900 focus:ring-4 focus:ring-gray-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">Feedback</button>
            </div>
            <div class="flex flex-col">
                <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div class="inline-block py-2 min-w-full sm:px-6 lg:px-8">
                        <div class="overflow-hidden shadow-md sm:rounded-lg">
                            <table class="min-w-full">
                                <thead class="bg-gray-50 dark:bg-gray-700">
                                    <tr>
                                        <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase">
                                            User Sent
                                        </th>
                                        <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase">
                                            Reported
                                        </th>
                                        <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase">
                                            Title
                                        </th>
                                        <th scope="col" class="relative py-3 px-6">
                                            <span class="sr-only">Watch</span>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="bg-white border-b">
                                        <c:forEach items="${reportList}" var="x">
                                            <td class="py-4 px-6 text-sm font-medium text-gray-900 whitespace-nowrap">
                                                ${x.userSent}
                                            </td>
                                            <td class="py-4 px-6 text-sm font-medium text-gray-700 whitespace-nowrap">
                                                ${x.userReported}
                                            </td>
                                            <td class="py-4 px-6 text-sm text-gray-500 whitespace-nowrap">
                                                ${x.message}
                                            </td>
                                            <td class="py-4 px-6 text-sm font-medium text-right whitespace-nowrap">
                                                <a href="<i:ReadUrlFromContext url="/ReportList?status=detail-${x.id}"/>" class="text-blue-600 hover:underline cursor-pointer">Watch</a>
                                            </td>        
                                        </c:forEach>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
        <script src="<i:ReadUrlFromContext url="/assets/js/PopupCard.js"/>"></script> 
    </body>
</html>
