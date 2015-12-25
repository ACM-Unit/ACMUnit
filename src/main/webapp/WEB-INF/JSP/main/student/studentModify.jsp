<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
    <li id='head'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
    </li>
    <li id='back'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/student/students.php">назад</a>
    </li>

</ul>
<form id="form" method="post" >
<div id="blockcreate">
    <a class='textStud'>Для модификации, введите новые значения и нажмите кнопку "применить"</a>
    <div  id="blockcreate1">
        <div>
            <ul class="textarea">
                <li id='textStud1'>Фамилия</li>
                <li><input maxlength="25" size="20" id="1" name="surname" value="${student.surname}" class='textSt'></li>
            </ul>
        </div>
        <div>
            <ul class="textarea">
                <li id='textStud2'>Имя</li>
                <li><input maxlength="25" size="20" id="2" name="name"  value="${student.name}" class='textSt'></li>
            </ul>
        </div>
        <div>
            <ul>
                <li  class="textarea">Группа</li>
                <li><input maxlength="25" size="20" id="3" name="group" value="${student.group}" class='textSt'></li>
            </ul>
        </div>
        <div>
            <ul>
                <li  class="textarea">Дата поступления</li>
                <li><input type="text" maxlength="25" size="20" id="datepicker" name="date" value="${student.dateString}" class='textSt'></li>
                <button id="studBut" class="btn btn-6 btn-6d textarea" name="id" value="${student.id}" onclick="chckspace('${CONTEXT}${CURRENT_MAPPING}/student/studentModify.php')"><div>Применить</div></button>
            </ul>
        </div>
    </div>
</div>
</form>