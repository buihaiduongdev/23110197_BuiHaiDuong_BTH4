<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<body>
<h2>Danh sách Category</h2>
<a href="category-form.jsp">Thêm mới</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Icon</th><th>Action</th></tr>
<c:forEach var="c" items="${list}">
<tr>
    <td>${c.cateid}</td>
    <td>${c.catename}</td>
    <td>${c.icon}</td>
    <td>
        <a href="category/edit?id=${c.cateid}">Edit</a> |
        <a href="category/delete?id=${c.cateid}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>
</body>
</html>