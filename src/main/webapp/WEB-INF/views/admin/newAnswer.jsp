<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h1>New question</h1>


<form:form method="post" modelAttribute="answer" >

    Question:<form:select path="question" items="${questions}" itemLabel="description" itemValue="id"></form:select>
    Description:<form:input path="description"></form:input>
    <br>Image:<form:input path="image"></form:input>
    <br>Correct: Yes <form:radiobutton path="correct" value="true"/>
    No <form:radiobutton path="correct" value="false"/>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
