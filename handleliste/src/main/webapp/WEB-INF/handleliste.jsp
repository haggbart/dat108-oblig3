<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Handleliste</title>
</head>
<body>

<div class="container">
    <h1>Min handleliste</h1>

    <div>
        <form action="handleliste" method="post">
            <button type="submit">Legg til</button>
            <label><input type="text" name="beskrivelse"></label>
        </form>
    </div>
    <div>
        <form action="handleliste" method="post">
        <jsp:useBean id="handleliste" scope="request" type="java.util.List<model.Item>"/>
        <c:forEach items="${handleliste}" var="item">
            <div>
                <label><button type="submit" name="item" value="${item.id}">Slett</button>${item}</label>
            </div>
        </c:forEach>
        </form>
    </div>

</div>

</body>
</html>
