<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Contact</title>
</head>
<body>
    ${contact.id}
    ${contact.firstName}
    ${contact.lastName}
    ${contact.birthDate.toLocalDate()}
</body>
</html>