<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>

<h1>Spring Boot file upload example ccc</h1>

<form method="POST" th:action="@{/uploadFile}" enctype="multipart/form-data">
    <input type="file" name="file"/> <br/><br/>
    <button type="submit">Submit</button>
    <input type="hidden" name="dir" value="/home/john/Pictures"/>
</form>

</body>
</html>