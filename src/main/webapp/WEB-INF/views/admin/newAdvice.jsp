<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>New advice</h1>

<form:form method="post" modelAttribute="advice" >

    Title:<form:input path="title"></form:input>
    <br> Description:<form:input path="description"></form:input>
    Question:<form:select path="question" items="${questions}" itemLabel="description" itemValue="id" multiple="yes"></form:select>
    <br>Image:<form:input path="video"></form:input>
<br>img<form:input type="file"  action="@{/uploadFile}"  path="uploadDir" enctype="multipart/form-data"></form:input>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
