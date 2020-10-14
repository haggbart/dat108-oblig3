<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/fontawesome.all.js"></script>
    <title>Login</title>
</head>
<body>

<div class="container card shadow-lg mx-auto mt-5">
    <div class="card-body">
        <h4 class="card-title text-center mb-4 mt-1">Handleliste</h4>

        <c:if test="${sessionScope.message != null}">
        <hr>
        <p class="text-danger text-center">${sessionScope.message}</p>
            <c:remove var="message" scope="session"/>
        </c:if>
        <form method="post" action="login" autofocus>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fas fa-user-lock"></i> </span>
                    </div>

                    <input class="form-control" type="password" name="password" placeholder="Passord" autofocus required>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Logg inn</button>
            </div>
        </form>
    </div>
</div>



</body>
</html>
