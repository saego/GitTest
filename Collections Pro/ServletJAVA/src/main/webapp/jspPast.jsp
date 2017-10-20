
<%@taglib prefix=""  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Saego
  Date: 20.10.17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>HTTP headers request example</title>
</head>
<body>
    <h2>Header request Example</h2>
    <table width="100%" border="3" bgcolor="#006400" align="center">
        <tr bgcolor="green">
            <th>Header's names</th>
            <th>Header's vavues</th>
        </tr>

        <c:forEach items="${header.keySet()}" var="headerName">
            <tr>
                <td>
                    <c:out value="${headerName}">
                    </c:out>
                </td>
                <td>
                    <c:out value="${header.get(headerName)}">
                    </c:out>
                </td>
            </tr>
        </c:forEach>
        <%
    //it is just for older version!!
            /*        Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                out.print("<tr><td>" + headerName + "</td>\n");
                out.println("<td>" + headerValue + "</td></tr>\n");
            }
            */
        %>
    </table>
</body>
</html>
