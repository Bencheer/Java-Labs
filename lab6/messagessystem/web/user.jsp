<%@ page import="checksession.CheckSession" %>
<%@ page import="jdbc.Jdbc" %>
<%@ page import="getdata.GetUsersInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/style.css"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <title>Пользователь </title>
</head>
<body>
    <%ArrayList<String> a = GetUsersInfo.getInfo(request.getCookies());%>
    <%if (CheckSession.isSetSesion(request.getCookies())) {%>
    <div class="wrapper">
        <div class="system-info">
            <div class="user">
                <ul>
                    <li>
                        Мой профиль
                    </li>
                    <li>
                        <table>
                            <tr>
                                <td>ID:</td>
                                <td>
                                    <%=GetUsersInfo.getId()%>
                                </td>
                            </tr>
                        </table>
                    </li>
                    <li>
                        <table>
                            <tr>
                                <td>Логин:</td>
                                <td>
                                    <%=GetUsersInfo.getLogin()%>
                                </td>
                            </tr>
                        </table>
                    </li>
                    <li>
                        <table>
                            <tr>
                                <td>Фамилия:</td>
                                <td>
                                    <%=GetUsersInfo.getFam()%>
                                </td>
                            </tr>
                        </table>
                    </li>
                    <li>
                        <table>
                            <tr>
                                <td>Имя:</td>
                                <td>
                                    <%=GetUsersInfo.getName()%>
                                </td>
                            </tr>
                        </table>
                    </li>
                    <hr/>
                    <%--<li>--%>
                        <%--<table>--%>
                            <%--<tr>--%>
                                <%--<td>Всего пользователей:</td>--%>
                                <%--<td>--%>

                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</table>--%>
                    <%--</li>--%>
                    <hr/>
                    <li class="exit">Выход</li>
                </ul>
            </div> 
        </div>

        <div class="conteiner">
            <nav>
                <ul>
                    <li class="show-users" id="show-users">Пользователи</li>
                    <li class="show-messages" id="show-messages">Сообщения</li>
                    <li class="show-first-top-ten" id="show-first-top-ten">Топ 10 сверху</li>
                    <li class="show-last-top-ten" id="show-last-top-ten">Топ 10 снизу</li>
                </ul>
            </nav>
            <div class="content">
                <div id="cont-messages" class="cont-messages">
                    Сообщения пользователей
                </div>
                <div id="cont-users" class="cont-users">
                    Список пользователей
                </div>
                <div id="cont-top-ten-up" class="cont-top-ten-up">
                    <table>

                    </table>
                </div>
                <div id="cont-top-ten-down" class="cont-top-ten-down">
                    Топ 10 последних пользователей
                </div>
            </div>
        </div>

    </div>

    <script>
        var lastId = '';
        $(document).find("nav ul li").on("click", function() {
            $(document).find("nav ul li").removeClass("selected");
            $(this).addClass("selected");
            var nowId = $(this).attr('id');
            if (lastId !== '') {
                $('#' + lastId).toggle();
            }
            switch (nowId) {
                case 'show-users':
                    lastId = 'cont-messages';
                    $('#' + lastId).toggle(100);
                    break;

                case 'show-messages':
                    lastId = 'cont-users';
                    $('#' + lastId).toggle(100);
                    break;

                case 'show-first-top-ten':
                    lastId = 'cont-top-ten-up';
                    $.ajax({
                        type: "POST",
                        url: "/topten",
                        dataType: "json",
                        success: function(data) {
                            if (data[0].success == 1) {
                                var allData = [];
                                var lineData = [];
                                for (var j = 0; j < 10; j++) {
                                    if (typeof data[1][j] !== "undefined") {
                                        lineData.push(data[1][j]);
                                        lineData.push(data[2][j]);
                                        lineData.push(data[3][j]);
                                        lineData.push(data[4][j]);

                                        allData.push(lineData);
                                        lineData = [];
                                    } else {
                                        break;
                                    }
                                }
                                var tr = "<tr><td>Фамилия</td><td>Имя</td><td>Логин</td><td>Время последнего входа</td></tr>";
                                $(document).find('#cont-top-ten-up table').append(tr);
                                for (var i = 0; i < allData.length; i++) {
                                    tr = "<tr><td>" + allData[i][0] + "</td><td>" + allData[i][1] + "</td><td>" + allData[i][2] + "</td><td>" + allData[i][3] + "</td></tr>";
                                    $(document).find('#cont-top-ten-up table').append(tr);
                                }
                            } else {
                                alert(0);
                            }
                        }
                    });
                    $('#' + lastId).toggle(100);
                    break;

                case 'show-last-top-ten':
                    lastId = 'cont-top-ten-down';
                    $('#' + lastId).toggle(100);
                    break;
            }
        });

        $(document).on("click", ".exit", function() {
            $.ajax({
                type: "POST",
                url: "/exit",
                dataType: "json",
                success: function(data) {
                    if (data.success == 1) {
                        window.location = "index.jsp";
                    } else {
                        alert("Нет подключения к БД!");
                    }
                }
            });
        });
    </script>
<%} else {%>
    <script>
        window.location = "index.jsp";
    </script>
<%}%>
</body>
</html>
