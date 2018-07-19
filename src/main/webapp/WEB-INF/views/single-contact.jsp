<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Contact</title>
</head>
<body>
    <table>
        <tr>
            <td style="text-align: right;"><b>Id:</b></td>
            <td>${contact.id}</td>
        </tr>
        <tr>
            <td style="text-align: right;"><b>First name:</b></td>
            <td>${contact.firstName}</td>
        </tr>
        <tr>
            <td style="text-align: right;"><b>Last name:</b></td>
            <td>${contact.lastName}</td>
        </tr>
    </table>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <hr>
        <h3>Change data</h3>
        <div id="save-contact">
            <form name="updateContact" action="/contacts/${contact.id}/update" method="post">
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
</body>
</html>