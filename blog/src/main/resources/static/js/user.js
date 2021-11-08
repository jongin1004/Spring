 let index = {
    init: function() {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-login").on("click", ()=>{
            this.login();
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
            url:"/api/user",
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

    login: function() {
            let data = {
                username: $("#username").val(),
                password: $("#password").val(),
            }

            $.ajax({
                type:"POST",
                url:"/api/user/login",
                data:JSON.stringify(data),
                contentType:"application/json; charset=utf-8",
                dataType:"json"
            }).done(function(res) {
                alert("로그인이 완료되었습니다.");
                location.href = "/";
            }).fail(function(error) {
                console.log(JSON.stringify(error));
            });
        }
 }

index.init();