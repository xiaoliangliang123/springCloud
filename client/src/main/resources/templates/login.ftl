<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
    <script src="/static/common/jquery-3.4.1.min.js"></script>
    <script src="/static/common/request.js"></script>

    <script>
        function login() {

            var username = $("#username").val();
            var password = $("#password").val();

            var user = new Object();
            user.username = username ;
            user.password = password;

            postRequest(user,function (data) {
                alert(data);
            })
        }
    </script>
</head>
<body>
<div>
    <div>
        <input type="text" name="username" id="username">
        <input type="text" name="password" id="password">
        <input type="submit" value="登陆" onclick="login()">
    </div>
</div>
</body>
</html>