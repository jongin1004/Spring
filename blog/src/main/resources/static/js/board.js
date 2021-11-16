 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
        });

        $("#btn-delete").on("click", ()=>{
            this.deleteById();
        });

        $("#btn-update").on("click", ()=>{
            this.update();
        });

        $("#btn-reply-save").on("click", ()=>{
            this.replySave();
        });
    },

    save: function() {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(res) {
            alert("글작성 성공");
            location.href = "/";
        }).fail(function(error) {
            console.log(JSON.stringify(error));
        });
    },

    deleteById: function() {
        let id = $("#id").text();

        $.ajax({
            type:"DELETE",
            url:"/api/board/"+id,
            dataType:"json"
        }).done(function(res) {
            alert("글삭제 성공");
            location.href = "/";
        }).fail(function(error) {
            console.log(JSON.stringify(error));
        });
    },

    update: function() {
        let id = $("#id").val();

        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        $.ajax({
            type:"PUT",
            url:"/api/board/"+id,
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(res) {
            alert("글수정 성공");
            location.href = "/board/"+id;
        }).fail(function(error) {
            console.log(JSON.stringify(error));
        });
    },

    save: function() {
        let userId = $("#userId").val();
        let boardId = $("#boardId").val();

        let data = {
            content: $("#reply-content").val()
        }

        console.log(userId);
        console.log(boardId);
        console.log(data);

//        $.ajax({
//            type:"POST",
//            url:"/api/reply",
//            data:JSON.stringify(data),
//            contentType:"application/json; charset=utf-8",
//            dataType:"json"
//        }).done(function(res) {
//            alert("댓글작성 성공");
//            location.href = "/";
//        }).fail(function(error) {
//            console.log(JSON.stringify(error));
//        });
    },
 }

index.init();