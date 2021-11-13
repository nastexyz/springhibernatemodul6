<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%-- zadanie 1.2 - formularze --%>
<%--Dodaj widok formularza zawierający pola login oraz password, email--%>
<%-- zadanie 1.3 - formularze --%>
<%--Wykorzystaj w tym celu encję Person z poprzednich zajęć--%>

<form:form method="post" modelAttribute="person">

    Login: <form:input path="login"/> <br />
    Password: <form:password path="password"/> <br />
    Email: <form:input type="email" path="email"/> <br />

    <input type="submit" value="Wysyłam"> <br />

</form:form>

<%--zadanie 1.4 formularze--%>

<%--FORMULARZ DO OBSLUGI PRZEZ @RequestParam--%>

<%--
<form method="post">

    Login: <input type = "text" name="login"> <br />
    Password: <input type="password" name="password"> <br />
    Email: <input type="email" name="email"> <br />

    <input type="submit" value="Wysyłam"> <br />

</form>--%>