<%-- 
    Document   : Wallet
    Created on : Mar 7, 2022, 12:16:30 PM
    Author     : tinht
--%>

<%@page import="bean.PaginationBean"%>
<%@page import="bean.FinanceBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/Wallet.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.3.4/dist/flowbite.min.css" />
        <title>Wallet</title>
        
        <%
            List<FinanceBean> financeList = (List<FinanceBean>) request.getAttribute("listFinance");
            PaginationBean pagination = (PaginationBean) request.getAttribute("pagination");
        %>
    </head>
    <body>
        <div class="container">
            <jsp:include page="./header.jsp"></jsp:include>
            <div class="modal-bg">
                <div class="modal_content">
                    <div class="close">+</div>
                    <form action="Wallet" method="post">
                        <h4>Enter the amount you want here...</h4>
                        <input class="popup-btn" name="amount" type="number" value=${amount}><br>
                        <input class="popup-btn btn btn-primary" name="status" type="submit" value = "recharge"><br>
                        <input class="popup-btn btn btn-primary" name="status" type="submit" value = "withdrawal"><br>
                        ${warning}
                    </form>
                </div>
            </div> 
            
            <div class="row">
                <div class="col-md-3 mt-1">
                    <div class="card sidebar">
                        <div class="card-body">
                            <div class="mt-3 text-center">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9 mt-1">
                    <div class="card mb-3 content">
                        <div class="top">
                            <div class="money">
                                <h1>${sessionScope.user.cash.intValue()} VND</h1>
<!--                            <h1>${sessionScope.user.role}</h1>-->
                                <h2>Current wallet money</h2>
                            </div>
                            <div class="button">
                                <div id="button" for="click" class="text-center card-button">
                                    <h1>Update</h1>
                                </div>
                            </div>    
                        </div>
                        <div class="flex flex-col bot-table" >
                            <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
                                <div class="inline-block py-2 min-w-full sm:px-6 lg:px-8">
                                    <div class="overflow-hidden shadow-md sm:rounded-lg">
                                        <table class="min-w-full">
                                            <thead class="bg-gray-50">
                                                <tr>
                                                    <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase ">
                                                        User Get
                                                    </th>
                                                    <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase ">
                                                        Date
                                                    </th>
                                                    <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase ">
                                                        Money
                                                    </th>
                                                    <th scope="col" class="py-3 px-6 text-xs font-medium tracking-wider text-left text-gray-700 uppercase ">
                                                        Status
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody id="list">
                                                <c:forEach items="${listFinance}" var="x">
                                                    <!-- Product 1 -->
                                                    <tr class="bg-white border-b">
                                                        <td class="py-4 px-6 text-sm font-medium text-gray-900 whitespace-nowrap ">
                                                            ${x.userGet}
                                                        </td>
                                                        <td class="py-4 px-6 text-sm text-gray-500 whitespace-nowrap ">
                                                            ${x.time}
                                                        </td>
                                                        <td class="py-4 px-6 text-sm text-gray-500 whitespace-nowrap ">
                                                            ${x.money.intValue()} VND
                                                        </td>
                                                        <td class="py-4 px-6 text-sm text-gray-500 whitespace-nowrap ">
                                                            ${x.message}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <nav aria-label="Page navigation example" class="pagination-ex" id="pagination">
                            <ul class="inline-flex -space-x-px">     
                                <li>
                                    <a href="/Wallet?page=<%=pagination.getPrev()%>" data="<%=pagination.getPrev()%>" class="pagination-link py-2 px-3 ml-0 leading-tight text-gray-500 bg-white rounded-l-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">Previous</a>
                                </li>
                                </li>
                                <c:if test="${pagination.getPageIndex()>2}">
                                    <li>
                                        <a href="/Wallet?page=<%=pagination.getPageIndex() - 2%>" data="<%=pagination.getPageIndex() - 2%>" class="pagination-link py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"><%=pagination.getPageIndex() - 2%></a>
                                    </li>
                                </c:if>
                                <c:if test="${pagination.getPageIndex()>1}">
                                    <li>
                                        <a href="/Wallet?page=<%=pagination.getPageIndex() - 1%>" data="<%=pagination.getPageIndex() - 1%>" class="pagination-link py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"><%=pagination.getPageIndex() - 1%></a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="/Wallet?page=<%=pagination.getPageIndex()%>" data="<%=pagination.getPageIndex()%>" aria-current="page" class="pagination-link py-2 px-3 text-blue-600 bg-blue-50 border border-gray-300 hover:bg-blue-100 hover:text-blue-700 dark:border-gray-700 dark:bg-gray-700 dark:text-white"><%=pagination.getPageIndex()%></a>
                                </li>
                                <c:if test="${pagination.getPageIndex()<pagination.getCount()}">
                                    <li>
                                        <a href="/Wallet?page=<%=pagination.getPageIndex() + 1%>" data="<%=pagination.getPageIndex() + 1%>" class="pagination-link py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"><%=pagination.getPageIndex() + 1%></a>
                                    </li>
                                </c:if>
                                <c:if test="${pagination.getPageIndex()+1<pagination.getCount()}">
                                    <li>
                                        <a href="/Wallet?page=<%=pagination.getPageIndex() + 2%>" data="<%=pagination.getPageIndex() + 2%>" class="pagination-link py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white"><%=pagination.getPageIndex() + 2%></a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="/Wallet?page=<%=pagination.getNext()%>" data="<%=pagination.getNext()%>" class="pagination-link py-2 px-3 leading-tight text-gray-500 bg-white rounded-r-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">Next</a>
                                </li>
                            </ul>
                        </nav>        
                    </div>
                </div>
            </div>                
        </div>
                                
        <script src="<i:ReadUrlFromContext url="/assets/js/PopupCard.js"/>"></script>                        
        <script src="https://unpkg.com/flowbite@1.3.4/dist/flowbite.js"></script>
            <script>
                const url_string = window.location.href;
                const url = new URL(url_string);
                const search = url.searchParams.get("q");
                const paginationLinks = document.querySelectorAll(".pagination-link");
                if (paginationLinks) {
                    paginationLinks.forEach(item => {
                        var search = location.search.substring(1);
                        const params = search ? JSON.parse('{"' + decodeURI(search).replace(/"/g, '\\"')
                                .replace(/&/g, '","').replace(/=/g, '":"') + '"}') : {};
                        const page = item.getAttribute("data");
                        params.page = page;
                        const href = new URLSearchParams(params).toString();
                        item.setAttribute("href", "?" + href);
                    })
                }

        </script>                        
    </body>
</html>
