<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
    <c:choose>
         <c:when test = "${empty sessionScope.principal}">
            <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/loginForm">로그인</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/joinForm">회원가입</a>
                </li>
            </ul>
         </c:when>

         <c:otherwise>
            <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/board/form">글쓰기</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/user/form">회원정보</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/logout">로그아웃</a>
                </li>
            </ul>
         </c:otherwise>
    </c:choose>
    </div>
  </div>
</nav>