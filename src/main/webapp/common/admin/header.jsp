<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/home">Admin Panel</a>
    <ul class="navbar-nav ms-auto">
      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a></li>
      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
  </div>
</nav>
