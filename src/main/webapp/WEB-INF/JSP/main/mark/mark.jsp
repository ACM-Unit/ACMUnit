<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p id='head'>
    <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
</p>
<div id="tableStud">

    <ul>
        <li>
            <form id="form" method="get">

                <input type="hidden" name="sel" value="1" />
                <button id="but1" type="submit" name="butMark" class="btn btn-6 btn-6d" value="2" onClick="chck('${CONTEXT}${CURRENT_MAPPING}/mark/markModify.php')">Изменить оценки у выбраного студента</button></form></li>

    <a  class='textStud'>  Список студентов</a>
    <a  class='textStud'> </a>
    <table border="1" bordercolor="#666">
        <tr>
            <th id="row1" height="100px"> </th>
            <td height="100px" class="columStud"><div class="text">Фамилия</div></td>
            <td height="100px" class="columStud"><div class="text">Имя</div></td>
            <td height="100px" class="columStud"><div class="text">Дата поступления</div></td>
            <td height="100px" class="columStud"><div class="text">Группа</div></td>
        </tr>
        <c:forEach items="${students}" var="students">
            <tr>
                <th id="row2" height="100px"><input type="checkbox" name="id" value="${students.id}"></th>
                <td id="name${students.id}" height="100px" >${students.name}</td>
                <td id="surname${students.id}" height="100px" >${students.surname}</td>
                <td id="date${students.id}" height="100px" >${students.date}</td>
                <td id="group${students.id}" height="100px" >${students.group}</td>
            </tr>
        </c:forEach>
    </table>
</div>
