<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>

<h1>Spring Boot file upload example ccc</h1>

<form method="POST" th:action="@{/uploadFile}" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <br>Pic <input type="radio" name="dir" value="/home/john/Pictures"/>
    <br>Video <input type="radio" name="dir" value="/home/john/Videos"/></br>
    <button type="submit">Submit</button>
</form>
</body>
</html>