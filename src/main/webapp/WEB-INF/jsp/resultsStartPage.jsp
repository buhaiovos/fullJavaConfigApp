<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Получить результат</title>
<body>
    Експерты: ${expertsNum}<br>
    Вопросов: ${questionsNum}

    <form method="post" action="finish">
        <input type="submit" value="Получить результат">
    </form>
</body>
</html>