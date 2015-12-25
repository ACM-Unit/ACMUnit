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
<form id="form" method="post">
<div id="blockcreate">
    <a class='textStud'>Для того что б создать новую дисциплину заполните все поля и нажмите кнопку "создать"</a>
        <div id="blockcreate1">
            <ul>
                <li  class="textarea">Название</li>
                <li><input  id="1" name="name" maxlength="25" size="20" value="" class='textSt'></li>
                <button id="studBut" class="btn btn-6 btn-6d textarea"  onclick="chckspace1('${CONTEXT}${CURRENT_MAPPING}/discipline/disciplineCreating.php')"><div>Создать</div></button>
            </ul>
    </div>
</div>
    </form>
