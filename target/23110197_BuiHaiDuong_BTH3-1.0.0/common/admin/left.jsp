<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 220px; height: 100vh;">
    <a href="${pageContext.request.contextPath}/admin/home" 
       class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <span class="fs-5 fw-bold">Admin Menu</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/home" class="nav-link active">
                <i class="bi bi-speedometer2"></i> Dashboard
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/users" class="nav-link text-dark">
                <i class="bi bi-people"></i> Quản lý Users
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/categories" class="nav-link text-dark">
                <i class="bi bi-list-task"></i> Quản lý Categories
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/reports" class="nav-link text-dark">
                <i class="bi bi-bar-chart"></i> Báo cáo
            </a>
        </li>
    </ul>
    <hr>
    <div>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger w-100">
            <i class="bi bi-box-arrow-right"></i> Logout
        </a>
    </div>
</div>
