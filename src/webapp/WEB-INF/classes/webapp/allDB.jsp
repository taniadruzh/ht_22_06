<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
</head>
<body>
<table border="2">
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>gender</th>
        <th>phone</th>
    </tr>
    <c:forEach var="student" items="${allstudents}">
        <tr>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.gender}</td>
            <td>${student.phone}</td>
        </tr>
    </c:forEach>
</table>
</br>
</body>
</html>