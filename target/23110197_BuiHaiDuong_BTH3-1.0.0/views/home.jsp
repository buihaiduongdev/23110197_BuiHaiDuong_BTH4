<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Danh sách Category</h2>
<a href="${pageContext.request.contextPath}/category/add">Thêm Category</a>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Icon</th>
        <th>UserID</th>
        <th>Action</th>
    </tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.cateid}</td>
            <td>${c.catename}</td>
            <td>${c.icon}</td>
            <td>${c.user.userid}</td>
            <td>
                <a href="${pageContext.request.contextPath}/category/edit?id=${c.cateid}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/category/delete?id=${c.cateid}" 
                   onclick="return confirm('Xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
