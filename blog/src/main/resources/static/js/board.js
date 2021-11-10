 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
        });

        $("#btn-delete").on("click", ()=>{
            this.deleteById();
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
 }

index.init();