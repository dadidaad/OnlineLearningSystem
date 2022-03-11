<%-- 
    Document   : ReportDetail
    Created on : Mar 11, 2022, 3:19:02 PM
    Author     : tinht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.3.4/dist/flowbite.min.css" />
        <title>Report Detail</title>
    </head>
    <body>
        <jsp:include page="./header.jsp"></jsp:include>
<!--        <form action="ReportList" method="post">
            <h2 class="text-hightlight1 mb-32px">1. Infomation</h2>
            <div class="mb-1">
                <label class="block text-sm font-medium text-gray-500">Request Title</label>
                <input type="text" readonly="" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
            </div>
            <div class="flex">
                <div class="mb-1 flex-1">
                    <label class="block text-sm font-medium text-gray-500">Subject</label>
                    <input type="text" readonly="" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-80 p-2.5">
                </div>
                <div class="mb-1 ">
                    <label class="block text-sm font-medium text-gray-500">Class</label>
                    <input type="text" readonly="" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-64 p-2.5">
                </div>
            </div>
                <div class="mb-4 ">
                    <label class="block text-sm font-medium text-gray-500">Price</label>
                    <input type="text" readonly="" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-80 p-2.5">
                </div>
                <div>
                    <h2 class="text-hightlight1 mb-32px">2. Content</h2>
                    <textarea class="AnswerTextarea" id="AnswerTextarea" rows="5" style="width: 100%" readonly >
                    </textarea>
                    <h2 class="text-hightlight1 mb-32px">3. Answer</h2>
                    <textarea class="AnswerTextarea" id="AnswerTextarea" rows="5" style="width: 100%" readonly >
                    </textarea>
                </div>
                <button type="submit" class="text-white bg-gradient-to-br from-green-400 to-blue-600 focus:ring-4 focus:ring-green-200 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">Accept</button>
                <button type="submit" class="relative inline-flex items-center justify-center p-0.5 mb-2 mr-2 overflow-hidden text-sm font-medium text-gray-900 rounded-lg group bg-gradient-to-br from-green-400 to-blue-600 group-hover:from-green-400 group-hover:to-blue-600 focus:ring-4 focus:ring-green-200">
                    <span class="relative px-5 py-2.5 transition-all ease-in duration-75 bg-white rounded-md group-hover:bg-opacity-0">
                        Decline
                    </span>
                </button>
        </form>-->
        
        <script src="https://unpkg.com/flowbite@1.3.4/dist/flowbite.js"></script>
    </body>
</html>
