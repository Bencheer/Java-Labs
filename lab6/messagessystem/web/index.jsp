<%@ page import="checksession.CheckSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Вход</title>
      <link rel="stylesheet" type="text/css" href="style/style.css"/>
      <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  </head>
  <body style="background: #98D4BC;">
  <%if (CheckSession.isSetSesion(request.getCookies())) {%>
  <script>
      window.location = "user.jsp";
  </script>
  <%} else {%>
    <dic class="wrapper">
        <div class="authorise-form">
            <input type="text" class="login" id="login" placeholder="Логин"/>
            <input type="password" class="password" id="password" placeholder="Пароль"/>
            <div class="auth-user">Войти</div>
        </div>
    </dic>

    <script>
        function auth() {
            var login = $(document).find('#login').val();
            var password = $(document).find('#password').val();

            if (login != '' && password != '') {
                $.ajax({
                    type: "POST",
                    data: {login: login, password: password},
                    url: "/auth",
                    dataType: "json",
                    success: function (data) {
                        if (data.success == 1) {
                            window.location = "user.jsp";
                        } else {
                            alert("Неверный логин или пароль!");
                        }
                    }
                });
            } else {
                alert("Заполните поля логина и пароля!");
            }
        }

        $(document).on("click", ".auth-user", function() {
            auth();
        });
    </script>
  <%}%>
  </body>
</html>
