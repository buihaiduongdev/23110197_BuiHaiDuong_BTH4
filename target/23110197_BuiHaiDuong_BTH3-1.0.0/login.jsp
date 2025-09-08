<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg rounded-4">
                <div class="card-header text-center bg-primary text-white">
                    <h4>Đăng nhập</h4>
                </div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">Tên đăng nhập</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Mật khẩu</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
                    </form>
                </div>
            </div>

            <div class="mt-4">
                <div class="alert alert-info">
                    <h6>Tài khoản mẫu (Tự tạo bằng <code>InitDB</code>):</h6>
                    <p>Tạo database có tên 'BTH03' các tables và records sẽ được tự động tạo</p>
                    <ul>
                        <li><strong>user1</strong> / 123 (Role: User)</li>
                        <li><strong>manager1</strong> / 123 (Role: Manager)</li>
                        <li><strong>admin1</strong> / 123 (Role: Admin)</li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
