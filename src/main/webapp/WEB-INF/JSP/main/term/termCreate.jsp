<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
    <li id='head'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
    </li>
    <li id='back'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/term/terms.php?sel=1">назад</a>
    </li>

</ul>
<form method="post" action="${CONTEXT}${CURRENT_MAPPING}/term/termCreation.php">
<div id="blockcreate">
    <a class='textStud'>Для того чтобы создать новый семестр заполните все поля и нажмите кнопку "создать"</a>
    <div id="blockcreate1">
        <ul text-align="top">
            <li class="textarea">длительность семестра</li>
            <li><input maxlength="25" size="20" name="nameDisc" value="" class='textSt'></li>
            <li  class="textTerms" id='textStud4'>дисциплины в семестре</li>
            <li class="selectTerms"><select id="selectedT" size=5 class='textSt' multiple name="hero[]">
                <c:forEach items="${disc}" var="disc">
                <option value=${disc.id}>${disc.name}</option>
                </c:forEach>
            </select></li>
            <input type="hidden" id="mass" name="mass"/>
            <button type="submit" id="studBut" class="btn btn-6 btn-6d textarea" onclick="multi()">Создать</button>
        </ul>
    </div>
</div>
</form>