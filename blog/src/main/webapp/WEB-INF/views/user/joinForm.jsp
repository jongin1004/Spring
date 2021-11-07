<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
      <div class="row mb-3">
        <label for="username" class="col-sm-2 col-form-label">UserName</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="username">
        </div>
      </div>
      <div class="row mb-3">
              <label for="email" class="col-sm-2 col-form-label">Email</label>
              <div class="col-sm-10">
                <input type="email" class="form-control" id="email">
              </div>
            </div>
      <div class="row mb-3">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="password">
        </div>
      </div>
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입</button>
</div>

<script src="/blog/js/user.js" defer></script>
<%@ include file="../layout/footer.jsp" %>