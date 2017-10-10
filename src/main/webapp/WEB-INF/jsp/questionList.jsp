<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Questions</title>
    <body>
        <form:form modelAttribute="answerDTO" method="post" action="questioning">
            <c:forEach var="answer" items="${answerDTO.answers}" varStatus="i">
                <p>${answer.question.text}</p>
                <input type="hidden" name="answers[${i.index}].question" value="${answer.question.id}:${answer.question.text}">
                &alpha; <input name="answers[${i.index}].interval.alpha"
                       value="${answer.interval.alpha}"/><br>
                &beta; <input name="answers[${i.index}].interval.beta"
                value="${answer.interval.beta}"/><br>
                m <input name="answers[${i.index}].interval.MLow"
                         value="${answer.interval.MLow}"/><br>
                M <input name="answers[${i.index}].interval.MHigh"
                         value="${answer.interval.MHigh}"/><br>
                h <input name="answers[${i.index}].interval.h"
                         value="${answer.interval.h}"/><br>
            </c:forEach>
            <br><br><input type="submit" value="Відправити відповідь">
        </form:form>
    </body>
</html>