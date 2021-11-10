<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
      <div class="row mb-3">
        <label for="title" class="col-sm-2 col-form-label">title</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="title" name="title">
        </div>
      </div>

      <div class="row mb-3">
        <label for="content" class="col-sm-2 col-form-label">Content</label>
        <div class="col-sm-10">
          <textarea rows="3" cols="" class="form-control summernote" id="content" name="content"></textarea>
        </div>
      </div>
    </form>
    <button id="btn-save" type="submit" class="btn btn-primary">글작성</button>
</div>
<script>
  $('.summernote').summernote({
    placeholder: '',
    tabsize: 2,
    height: 300
  });
</script>

<script src="/js/board.js" defer></script>
<%@ include file="../layout/footer.jsp" %>