<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Category</title>
</head>
<body>
<h2>${category != null ? "Sửa Category" : "Thêm Category"}</h2>
<form method="post" action="${pageContext.request.contextPath}/category/${category != null ? 'edit' : 'add'}">
    <c:if test="${category != null}">
        <input type="hidden" name="id" value="${category.cateid}"/>
    </c:if>
    Tên: <input type="text" name="catename" value="${category != null ? category.catename : ''}"/><br/>
    Icon: <input type="text" name="icon" value="${category != null ? category.icon : ''}"/><br/>
    <input type="submit" value="Lưu"/>
</form>
</body>
</html>
