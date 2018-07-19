<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mykyta_Huchenko
  Date: 7/9/2018
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <div id="menu">
        <sec:authorize access="isAnonymous()">
            <div id="login">
                <form name="loginForm" action="${loginUrl}" method="post">
                    <tаble>
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="j_username"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="j_password"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input name="submit"
                                                                  type="submit"
                                                                  value="Login">
                            </td>
                        </tr>
                    </tаble>
                </form>
            </div>
        </sec:authorize>
    </div>
    <c:if test="${not empty contacts}">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td>${contact.id}</td>
                        <td>${contact.firstName}</td>
                        <td>${contact.lastName}</td>
                        <td>${contact.birthDate.toLocalDate()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
