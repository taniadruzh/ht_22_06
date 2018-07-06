<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<form action="EditStudentServlet" method="get">
    <h2>ADD FIELD:</h2>
    Name: <input type=text name="name"/>
    </br>

    <input type="submit" value="add" name="buttonEditOFStudent"/>
</form>
</br>
<%--<form action="EditStudentServlet" method="get">--%>
    <%--<h2>DELETE STUDENT:</h2>--%>
    <%--Name: <input type=text name="name"/>--%>
    <%--</br>--%>
    <%--Surname: <input type=text name="surname" />--%>
    <%--</br>--%>
    <%--Gender: male <input type="radio" name="gender" value="male">--%>
    <%--female <input type="radio" name="gender" value="female">--%>
    <%--</br>--%>
    <%--Phone: <input type=text name="phone">--%>
    <%--</br>--%>
    <%--<input type="submit" value="delete" name="buttonEditOFStudent"/>--%>
<%--</form>--%>

<%--</br>--%>
<%--<a href="/allDB">All students</a>--%>

</body>
</html>
