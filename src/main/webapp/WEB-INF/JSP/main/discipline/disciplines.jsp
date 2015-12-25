<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p id='head'>
    <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
</p>
<div id="tableStud">
<p>
    <a class='textStud'>Список дисциплин</a>
</p>

<ul>
<li id="termSelect" >
    <c:if test="${CURRENT_ROLE eq 1}">
    <form id="form1" method="get" action="${CONTEXT}${CURRENT_MAPPING}/discipline/disciplineCreating.php"><button type="submit" class="btn btn-6 btn-6d but1" >Создать дисциплину</button></form>
    <form id="form2" method="get" ><button id="but3" type="submit"  name="butMark"  class="btn btn-6 btn-6d but1" onClick="chck1('${CONTEXT}${CURRENT_MAPPING}/discipline/disciplineModify.php')">Модифицировать выбранную дисциплину </button></form>
    <button type="submit" class="btn btn-6 btn-6d but1" onClick="deleteDisc()">Удалить выбранные дисциплины</button>
    </c:if>
</li>
<li id="tableDisc1">
    <table border="1">
        <tr>
            <td height="100px" class="columStud1"></td>
            <td height="100px" class="columStud1">Наименование дисциплины</td>
    </tr>
<c:forEach items="${disc}" var="disc">
    <tr>
        <th height="100px" id="discRow2"><input type="checkbox" name="id" value="${disc.id}"></th>
        <td height="100px">${disc.name}</td>
    </tr>
</c:forEach>
        </table>
</li>
</ul>
    </div>