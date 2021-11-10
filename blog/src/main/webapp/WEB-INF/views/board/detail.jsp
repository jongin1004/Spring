<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
  <button class="btn btn-secondary" onclick="history.back()">목록으로</button>
  <c:if test="${ board.user.id == principal.user.id}">
    <a href="/board/${board.id}/updateForm">수정</a>
    <button id="btn-delete" class="btn btn-danger">삭제</button>
  </c:if>
  <br /><br />
  <div>
    글번호 : <span id="id"><i>${board.id}</i> </span>
    작성자 : <span><i>${board.user.username} </i></span>
  </div>
  <br />
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