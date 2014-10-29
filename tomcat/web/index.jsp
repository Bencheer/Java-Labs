<%@ page import="sample.Time" %>
<%--
  Created by IntelliJ IDEA.
  User: CM
  Date: 29.10.2014
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <div class="message">
        <h1>
            Время на сервере:
        </h1>

        <%=Time.getTime()%>
    </div>
  </body>
</html>
