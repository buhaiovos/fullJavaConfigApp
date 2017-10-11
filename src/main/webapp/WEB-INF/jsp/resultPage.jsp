<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Result</title>
<body>
    <h1>Result</h1>
    <table>
        <tr>
            <th>№ Эксперта</th>
            <th>Коэффициент компетентности</th>
        </tr>
        <c:forEach var="result" items="${results}">
            <tr>
                <td>${result.expertId}</td>
                <td>${result.calculatedCompetency}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>