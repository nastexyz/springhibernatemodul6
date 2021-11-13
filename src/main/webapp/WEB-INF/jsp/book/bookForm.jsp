<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new book</h2>
<form:form modelAttribute="book">
    <form:hidden path="id"/>
    Title: <form:input path="title"/><br>
    <form:errors path="title"/> <br>

    Description: <form:textarea path="description" cols="50" rows="15"/><br>
    <form:errors path="description"/> <br>

    Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><br>
    <form:errors path="publisher"/> <br>

    Authors: <form:select multiple="true" path="authors" items="${authors}" itemValue="id" itemLabel="fullName"/>
    <form:errors path="authors"/> <br>

    Rating: <form:input path="rating" type="number"/> <br>
    <form:errors path="rating"/> <br>

    Pages: <form: input path="pages" type="number"/> <br>
    <form:errors path="pages"/> <br>

    <input type="submit" value="Zapisz">

</form:form>