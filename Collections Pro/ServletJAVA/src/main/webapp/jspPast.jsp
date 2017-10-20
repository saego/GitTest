<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Saego
  Date: 20.10.17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTTP headers request example</title>
</head>
<body>
    <h2>Header request Example</h2>
    <table width="100%" border="3" bgcolor="red" align="center">
        <tr bgcolor="aqua">
            <th>Header's names</th>
            <th>Header's vavues</th>
        </tr>
        <%
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                out.print("<tr><td>" + headerName + "</td>\n");
                out.println("<td>" + headerValue + "</td></tr>\n");
            }
        %>
    </table>
</body>
</html>
