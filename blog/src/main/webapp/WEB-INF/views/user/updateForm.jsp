<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
      <input type="hidden" id="id" value="${principal.user.id}">
      <div class="row mb-3">
        <label for="username" class="col-sm-2 col-form-label">UserName</label>
        <div class="col-sm-10">
          <input type="text" value="${principal.user.username}" class="form-control" id="username" readonly>
        </div>
      </div>
      <div class="row mb-3">
              <label for="email" class="col-sm-2 col-form-label">Email</label>
              <div class="col-sm-10">
                <input type="email" value="${principal.user.email}" class="form-control" id="email">
              </div>
            </div>
      <div class="row mb-3">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="password">
        </div>
      </div>
    </form>
    <button id="btn-update" class="btn btn-primary">회원수정</button>
</div>

<script src="/js/user.js" defer></script>
<%@ include file="../layout/footer.jsp" %>