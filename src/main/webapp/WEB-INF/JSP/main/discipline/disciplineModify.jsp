<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
    <li id='head'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
    </li>
    <li id='back'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/discipline/disciplines.php">назад</a>
    </li>

</ul>
<form id="form" method="post" >
<div id="blockcreate">
    <a class='textStud'>Для того чтобы модифицировать дисциплину введите новое значение поля и нажмите кнопку "применить"</a>
    <div id="blockcreate1">
        <ul>
            <li class="textarea">Название</li>
            <li><input maxlength="25" size="20" name="name" value="${discs.name}" class='textSt'></li>
            <button id="studBut" name="id" value="${discs.id}" class="btn btn-6 btn-6d textarea"><div>Применить</div></button>
        </ul>
    </div>
</div>
</form>