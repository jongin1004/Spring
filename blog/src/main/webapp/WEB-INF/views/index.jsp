<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout/header.jsp" %>

<div class="container">
<c:forEach var="board" items="${boards}">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">${board.title}</h5>
        <a href="#" class="btn btn-primary">자세히 보기</a>
      </div>
    </div>
</div>
</c:forEach>

<%@ include file="layout/footer.jsp" %>