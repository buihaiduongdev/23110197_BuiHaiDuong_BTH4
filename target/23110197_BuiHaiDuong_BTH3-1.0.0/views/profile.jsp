<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<div class="card p-4">
    <h3>Cập nhật thông tin cá nhân</h3>
    <form method="post" action="${pageContext.request.contextPath}/profile/update" enctype="multipart/form-data">
       <div class="mb-3">
            <label>Ảnh đại diện</label><br/>
            <c:if test="${not empty user.avatar}">
                <img src="${pageContext.request.contextPath}/uploads/${user.avatar}" alt="Avatar" width="120" class="mb-2"/>
            </c:if>
            <input type="file" class="form-control" name="image"/>
        </div>
        <div class="mb-3">
            <label>Fullname</label>
            <input type="text" class="form-control" name="fullname" value="${user.fullName}"/>
        </div>
        <div class="mb-3">
            <label>Phone</label>
            <input type="text" class="form-control" name="phone" value="${user.phone}"/>
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" class="form-control" name="email" value="${user.email}"/>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
</div>
</body>
</html>
