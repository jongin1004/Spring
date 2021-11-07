 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },

    save: function() {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        $.ajax({
            type:"POST",
            url:"/blog/api/user",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(res) {
            console.log(res);
            location.href = "/blog";
        }).fail(function(error) {
            console.log(JSON.stringify(error));
        });
    }
 }

index.init();