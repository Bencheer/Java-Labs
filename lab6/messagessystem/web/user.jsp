<%@ page import="checksession.CheckSession" %>
<%@ page import="jdbc.Jdbc" %>
<%@ page import="getdata.GetUsersInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="getdata.CountUsers" %>
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
                    <li>
                        <table>
                            <tr>
                                <td>Всего пользователей:</td>
                                <td>
                                    <%=CountUsers.getCountUsers(request.getCookies())%>
                                </td>
                            </tr>
                        </table>
                    </li>
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
                    <div class="write-message">
                        <textarea name="" id="" placeholder="Введите ваше сообщение"></textarea>
                        <div class="send">Отправить</div>
                    </div>
                    <div class="all-messages">
                        <div class="message" id="-1">
                            <div class="author" id="">test</div>
                            <div class="text">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus architecto aspernatur consequuntur debitis eveniet minima nulla reprehenderit voluptatum. Autem debitis dicta excepturi expedita harum illum quibusdam sequi sit velit vitae?
                            </div>
                            <div class="time">2014-11-03 18:41:52.0</div>
                        </div>
                    </div>
                </div>
                <div id="cont-users" class="cont-users">
                    <table>

                    </table>
                </div>
                <div id="cont-top-ten-up" class="cont-top-ten-up">
                    <table>

                    </table>
                </div>
                <div id="cont-top-ten-down" class="cont-top-ten-down">
                    <table>

                    </table>
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
                case 'show-messages':
                    lastId = 'cont-messages';
                    updateMess();
                    $('#' + lastId).toggle(100);
                    break;

                case 'show-users':
                    lastId = 'cont-users';
                    $(document).find('#cont-users table').html('');
                    $.ajax({
                        type: "POST",
                        url: "/getusers",
                        dataType: "json",
                        success: function(data) {
                            if (data[0].success == 1) {
                                var allData = [];
                                var lineData = [];
                                for (var j = 0; j < <%=CountUsers.getCountUsers(request.getCookies())%>; j++) {
                                        lineData.push(data[1][j]);
                                        lineData.push(data[2][j]);
                                        lineData.push(data[3][j]);
                                        lineData.push(data[4][j]);

                                        allData.push(lineData);
                                        lineData = [];
                                }
                                var tr = "<tr><td>№</td><td>Фамилия</td><td>Имя</td><td>Логин</td><td>Время последнего входа</td></tr>";
                                $(document).find('#cont-users table').append(tr);
                                for (var i = 0; i < allData.length; i++) {
                                    tr = "<tr><td>" + (i+1) + "</td><td>" + allData[i][0] + "</td><td>" + allData[i][1] + "</td><td>" + allData[i][2] + "</td><td>" + allData[i][3] + "</td></tr>";
                                    $(document).find('#cont-users table').append(tr);
                                }
                            } else {
                                alert(0);
                            }
                        }
                    });
                    $('#' + lastId).toggle(100);
                    break;

                case 'show-first-top-ten':
                    lastId = 'cont-top-ten-up';
                    $(document).find('#cont-top-ten-up table').html('');
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
                                var tr = "<tr><td>№</td><td>Фамилия</td><td>Имя</td><td>Логин</td><td>Время последнего входа</td></tr>";
                                $(document).find('#cont-top-ten-up table').append(tr);
                                for (var i = 0; i < allData.length; i++) {
                                    tr = "<tr><td>" + (i+1) + "</td><td>" + allData[i][0] + "</td><td>" + allData[i][1] + "</td><td>" + allData[i][2] + "</td><td>" + allData[i][3] + "</td></tr>";
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
                    $(document).find('#cont-top-ten-down table').html('');
                    $.ajax({
                        type: "POST",
                        url: "/toptendown",
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
                                var tr = "<tr><td>№</td><td>Фамилия</td><td>Имя</td><td>Логин</td><td>Время последнего входа</td></tr>";
                                $(document).find('#cont-top-ten-down table').append(tr);
                                for (var i = 0; i < allData.length; i++) {
                                    tr = "<tr><td>" + (i+1) + "</td><td>" + allData[i][0] + "</td><td>" + allData[i][1] + "</td><td>" + allData[i][2] + "</td><td>" + allData[i][3] + "</td></tr>";
                                    $(document).find('#cont-top-ten-down table').append(tr);
                                }
                            } else {
                                $(document).find('#cont-top-ten-down').html('Топ последних 10 пользователей пуст!');
                            }
                        }
                    });
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

        $('textarea').keyup(function(){
            $(this).height(16);
            $(this).height(this.scrollHeight).fadeIn(400);
        });

        $('textarea').on('focus', function() {
            $('.send').show();
        });


        $('.send').on('click', function(event) {
            var textVal = $('textarea').val();
            if (textVal != '') {
                $.ajax({
                    type: "POST",
                    data: {text: textVal},
                    url: "/sendmessage",
                    dataType: "json",
                    success: function (data) {
                        $('textarea').val('');
                        updateMess();
                    }
                });
            } else {
                alert('Вы не ввели сообщение!');
            }
        });

        function updateMess() {
            var lastId = -1;
//            if ($(document).find('.message') != undefined) {
//                var max = +$(document).find('.message').eq(0).attr('id');
//                for (var i = 0; i < $(document).find('.message').length; i++) {
//                    if (+$(document).find('.message').eq(i).attr('id') > max) {
//                        max = +$(document).find('.message').eq(i).attr('id');
//                    }
//                }
//                lastId = max;
//            }
            $.ajax({
                type: "POST",
                data: {lastId: lastId},
                url: "/getmessages",
                dataType: "json",
                success: function (data) {
                    if (data[data.length - 1].success === 1) {
                        $(document).find('.all-messages').html('');
                        for (var i = 0; i < data.length - 2; i++) {
                            $(document).find('.all-messages').append('<div class="message" id="' + data[i].mid +'"> \
                                                                        <div class="author" id="' + data[i].iduser +'">' + data[i].name + " " + data[i].fam +'</div> \
                                                                        <div class="text"> \
                                                                             ' + data[i].text +'    \
                                                                        </div> \
                                                                        <div class="time">' + data[i].time +'</div> \
                                                                    </div>');
                        }
                    }
                }
            });
        }

        $(document).click(function(e){
            if ($(e.target).parents().filter('.write-message').length != 1) {
                $('.send').hide();
                $('textarea').height(16);
            }
        });
    </script>
<%} else {%>
    <script>
        window.location = "index.jsp";
    </script>
<%}%>
</body>
</html>
