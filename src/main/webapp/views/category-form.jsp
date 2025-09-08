<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg rounded-3">
        <div class="card-header text-center bg-primary text-white">
            <h3 class="mb-0">
                <c:choose>
                    <c:when test="${category != null}">Sửa Category</c:when>
                    <c:otherwise>Thêm Category</c:otherwise>
                </c:choose>
            </h3>
        </div>
        <div class="card-body">
            <form method="post" action="${pageContext.request.contextPath}/category/${category != null ? 'edit' : 'add'}">
                <c:if test="${category != null}">
                    <input type="hidden" name="id" value="${category.cateid}"/>
                </c:if>

                <div class="mb-3">
                    <label for="catename" class="form-label">Tên Category</label>
                    <input type="text" class="form-control" id="catename" name="catename"
                           value="${category != null ? category.catename : ''}" required/>
                </div>

                <div class="mb-3">
                    <label for="icon" class="form-label">Icon</label>
                    <input type="text" class="form-control" id="icon" name="icon"
                           value="${category != null ? category.icon : ''}" required/>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success px-4">Lưu</button>
                    <a href="${pageContext.request.contextPath}/${sessionScope.user.roleid == 1 ? 'user' : sessionScope.user.roleid == 2 ? 'manager' : 'admin'}/home"
                       class="btn btn-secondary px-4 ms-2">Hủy</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
