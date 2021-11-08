<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/auth/loginProc" method="post">
      <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">UserName</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="username" name="username">
        </div>
      </div>

      <div class="row mb-3">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="password" name="password">
        </div>
      </div>

      <div class="row mb-3">
        <div class="col-sm-10 offset-sm-2">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck1" name="remember">
            <label class="form-check-label" for="gridCheck1">
              Remember user
            </label>
          </div>
        </div>
      </div>
      <button id="btn-login" type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>