<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - <sitemesh:write property="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <jsp:include page="/common/admin/header.jsp"/>
    <div class="container-fluid mt-3">
        <div class="row">
            <div class="col-2">
                <jsp:include page="/common/admin/left.jsp"/>
            </div>
            <div class="col-10">
                <sitemesh:write property="body"/>
            </div>
        </div>
    </div>
    <jsp:include page="/common/admin/footer.jsp"/>
</body>
</html>
