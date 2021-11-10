 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
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
 }

index.init();