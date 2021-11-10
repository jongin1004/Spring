<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <button class="btn btn-secondary" onclick="history.back()">목록으로</button>
  <button id="btn-update" class="btn btn-warning">수정</button>
  <button id="btn-delete" class="btn btn-danger">삭제</button>
  <br /><br />
  <div class="row mb-3">
    <label for="title" class="col-sm-2 col-form-label">title</label>
    <div class="col-sm-10">
      <h3>${board.title}</h3>
    </div>
  </div>
  <hr />
  <div class="row mb-3">
    <label for="content" class="col-sm-2 col-form-label">Content</label>
    <div class="col-sm-10">
      <div>${board.content}</div>
    </div>
  </div>
</div>

<script src="/js/board.js" defer></script>
<%@ include file="../layout/footer.jsp" %>