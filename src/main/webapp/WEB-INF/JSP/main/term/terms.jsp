<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="select" value="${sel}"/>
<p id='head'>
    <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
</p>
<form id="form1" name="terms" method="get">
<div id="tableStud">
    <ul>
        <li id='textTermsStud' border="1" >
            <a class="text">Выбрать семестр</a>
        </li>
        <li>
            <select required id='comboStud' name="sel">
                <c:forEach items="${term}" var="term">
                    <c:if test="${select == term.id}">
                       <option selected value=${term.id}>Семестр${term.id}</option>
                    </c:if>
                    <c:if test="${select != term.id}">
                        <option value=${term.id}>Семестр${term.id}</option>
                    </c:if>
                </c:forEach>
            </select>
        </li>
        <li>
            <button type="submit" id="TermsStudBut" class="btn btn-6 btn-6d" onclick="selected()">выбрать</button>
        </li>
    </ul>
    <div id='averageMark'>
        <a>Длительность  семестра: 24 недели</a>
    </div>
    <p>
        <a id="textTerm" class='textStud'>Список дисциплин</a>
    </p>

    <ul>
        <li id="termSelect" >
            <c:if test="${CURRENT_ROLE eq 1}">
            <button type="submit" class="btn btn-6 btn-6d but1" onclick="send1()">Создать семестр</button>
            <button type="submit" class="btn btn-6 btn-6d but1" onclick="send()">Модифицировать текущий семестр </button>
            <button type="submit" class="btn btn-6 btn-6d but1" onclick="send2()">Удалить текущий семестр</button>
            </c:if>
        </li>
        <li id="tableDisc1">
            <table border="1">
                <tr>
                    <td height="100px" class="columStud">Наименование дисциплины</td>
                </tr>
                <c:forEach items="${disc}" var="disc">
                    <c:if test="${disc.key==select}">
                        <c:forEach items="${disc.value}" var="discTerm">
                            <tr>
                                <td height="100px">${discTerm.name}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </table>
        </li>
    </ul>
</div>
</form>