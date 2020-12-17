<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>New question</h1>


<form:form method="post" modelAttribute="question" >

    Description:<form:input path="description"></form:input>
    <br>Image:<form:input path="image"></form:input>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
