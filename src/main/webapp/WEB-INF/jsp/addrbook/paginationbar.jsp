<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head lang="en">
<link rel="stylesheet" href="/css/pagination.css" type="text/css" media="screen" />

</head>
<body>

<!-- Pagination Bar -->
<div id="paginationbar">
    <div align="center">
        <ul class="pagination">
            <li>
            <c:if test="${page.firstPage}"><a href="#">First</a></c:if>		
			<c:if test="${!page.firstPage}">
            	<a href="${page.url}/?page.page=1&page.size=${page.size}">First</a>			
			</c:if>
            </li>
            
            <li>
            <c:if test="${!page.hasPreviousPage}"><a href="#">«</a></c:if>
			<c:if test="${page.hasPreviousPage}">
			    <a href="${page.url}/?page.page=${page.number-1}&page.size=${page.size}" title="Go to previous page">«</a>
			</c:if>
            </li>
            
            <c:forEach items="${page.items}" var="item">
            	<li>            
					<c:if test="${item.current}"><a class="active" href="#">${item.number}</a></c:if>
					<c:if test="${!item.current}">
	            	<a href="${page.url}/?page.page=${item.number}&page.size=${page.size}">${item.number}</a>
					</c:if>
            	</li>
            </c:forEach>
            
            <li>
            <c:if test="${!page.hasNextPage}"><a href="#">»</a></c:if>
			<c:if test="${page.hasNextPage}">
				<a href="${page.url}/?page.page=${page.number+1}&page.size=${page.size}" title="Go to next page">»</a>
			</c:if>
            </li>
            
            <li>
            <c:if test="${page.lastPage}"><a href="#">Last</a></c:if>
			<c:if test="${!page.lastPage}">
            	<a href="${page.url}/?page.page=${page.totalPages}&page.size=${page.size}">Last</a>			
			</c:if>
            </li>
        </ul>
    </div>
</div>

</body>
</html>