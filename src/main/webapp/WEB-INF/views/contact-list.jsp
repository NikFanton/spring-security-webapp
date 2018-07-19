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
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <h2>Contact list | <a style="cursor: pointer;" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <hr>
        <h3>Create new one</h3>
        <div id="save-contact">
            <form name="saveContact" action="" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <tаble>
                    <tr>
                        <td>First name:</td>
                        <td><input type="text" name="first_name"/></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input type="text" name="last_name"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input name="submit" type="submit" value="Save">
                        </td>
                    </tr>
                </tаble>
            </form>
        </div>
        <hr>
    </sec:authorize>

    <c:if test="${not empty contacts}">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <th></th>
                    </sec:authorize>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td>${contact.id}</td>
                        <td>${contact.firstName}</td>
                        <td>${contact.lastName}</td>
                        <td><a href="${pageContext.request.contextPath}contacts/${contact.id}">profile</a></td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="${pageContext.request.contextPath}contacts/${contact.id}/delete">-</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
