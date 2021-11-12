 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
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
            url:"/auth/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(res) {
            alert("회원가입 성공");
            location.href = "/";
        }).fail(function(error) {
            console.log(JSON.stringify(error));
        });
    },

    update: function() {
            let data = {
                id: $("#id").val(),
                email: $("#email").val(),
                password: $("#password").val()
            }

            $.ajax({
                type:"PUT",
                url:"/user",
                data:JSON.stringify(data),
                contentType:"application/json; charset=utf-8",
                dataType:"json"
            }).done(function(res) {
                alert("회원정보 수정완료.");
                location.href = "/";
            }).fail(function(error) {
                console.log(JSON.stringify(error));
            });
        }
 }

index.init();