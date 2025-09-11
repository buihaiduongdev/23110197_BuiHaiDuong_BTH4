<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">

		<!-- Tiêu đề tùy theo role -->
		<c:choose>
			<c:when test="${sessionScope.user.roleid == 1}">
				<h3 class="mb-4 text-primary">User Home - Danh sách Category</h3>
			</c:when>
			<c:when test="${sessionScope.user.roleid == 2}">
				<h3 class="mb-4 text-success">Manager Home - Category của bạn</h3>
			</c:when>
			<c:when test="${sessionScope.user.roleid == 3}">
				<h3 class="mb-4 text-danger">Admin Home - Quản lý tất cả
					Category</h3>
			</c:when>
		</c:choose>

		<!-- Nút thêm category -->
		<a href="${pageContext.request.contextPath}/category/add"
			class="btn btn-success mb-3">Thêm Category</a>

		<!-- Bảng danh sách category -->
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Ảnh mô tả</th>
					<th>Người tạo</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cate" items="${categories}">
					<tr>
						<td>${cate.cateid}</td>
						<td>${cate.catename}</td>
						<td><c:if test="${cate.icon != null}">
								<img
									src="${pageContext.request.contextPath}/uploads/${cate.icon}"
									alt="Category Icon" class="img-thumbnail"
									style="max-width: 100px; max-height: 80px;">
							</c:if></td>
						<td>${cate.user.username}</td>
						<td>
							<!-- Admin: sửa/xóa tất cả --> <c:if
								test="${sessionScope.user.roleid == 3}">
								<a
									href="${pageContext.request.contextPath}/category/edit?id=${cate.cateid}"
									class="btn btn-warning btn-sm">Sửa</a>
								<a
									href="${pageContext.request.contextPath}/category/delete?id=${cate.cateid}"
									class="btn btn-danger btn-sm">Xóa</a>
							</c:if> <!-- User/Manager: chỉ sửa/xóa category của chính mình --> <c:if
								test="${sessionScope.user.roleid != 3 && sessionScope.user.userid == cate.user.userid}">
								<a
									href="${pageContext.request.contextPath}/category/edit?id=${cate.cateid}"
									class="btn btn-warning btn-sm">Sửa</a>
								<a
									href="${pageContext.request.contextPath}/category/delete?id=${cate.cateid}"
									class="btn btn-danger btn-sm">Xóa</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/logout"
			class="btn btn-outline-danger">Đăng xuất</a>

	</div>

</body>
</html>
