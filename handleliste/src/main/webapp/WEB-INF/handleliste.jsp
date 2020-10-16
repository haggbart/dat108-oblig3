<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/fontawesome.all.js"></script>
    <title>Handleliste</title>
</head>
<body>


<div class="container card shadow-lg mx-auto mt-5">
    <div class="card-body">
        <h4 class="card-title text-center mb-4 mt-1">Handleliste</h4>

        <form action="handleliste" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-pen"></i></span>
                </div>
                <input class="form-control" type="text" name="beskrivelse"  placeholder="Legg til" autocomplete="off" required>
            </div>
        </form>

        <form action="handleliste" method="post">
            <ul class="list-group mx-auto">
                <c:forEach items="${requestScope.handleliste}" var="item">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <span>${item}</span>
                        <button type="submit" name="item" value="${item.id}" class="btn">
                            <i class="fas fa-trash-alt text-muted"></i></button>
                    </li>
                </c:forEach>
            </ul>
        </form>
    </div>
</div>

</body>
</html>
