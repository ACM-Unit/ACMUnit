<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="select" value="${sel}"/>
<ul>
    <li id='head'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/home.php">на главную</a>
    </li>
    <li id='back'>
        <a href="${CONTEXT}${CURRENT_MAPPING}/student/students.php">назад</a>
    </li>
</ul>
<div id="tableStud">
    <a border="1" class='textStud'>Отображена успеваемость для следующего студента</a>
    <table border="1">
        <tr>
            <td height="30px" class="columStud"><div class="text">Фамилия</div></td>
            <td height="30px" class="columStud"><div class="text">Имя</div></td>
            <td height="30px" class="columStud"><div class="text">Группа</div></td>
            <td height="30px" class="columStud"><div class="text">Дата поступления</div></td>
        </tr>
        <tr>
            <td height="30px">${student.name}</td>
            <td height="30px">${student.surname}</td>
            <td height="30px">${student.date}</td>
            <td height="30px">${student.group}</td>
        </tr>
    </table>
    <form id="form" name="term" method="get">
    <ul>
        <li id="termSelect">

            <ul>
                <li id='textTermsStud' border="1">
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
                    <input  type="hidden" name="butMark" value=${butMark}> </input>
                    <button id="TermsStudBut" class="btn btn-6 btn-6d"><div>выбрать</div>
                    </button>
                </li>
            </ul>

            <div id='averageMark'>
                <a>Средняя оценка за семестр:
                                <c:forEach items="${averageMark}" var="averageMark">
                                    <c:if test="${averageMark.key==select}">
                                         ${averageMark.value}
                                    </c:if>
                                </c:forEach>
                     балла</a>
            </div>

        </li>
        <li id="tableDisc1">
            <table border="1" id="tb1">
                <tr>
                    <td  height="100px"class="columStud">Дисциплина</td>
                    <td  height="100px"class="columStud">Оценка</td>
                </tr>
                <c:forEach items="${mark}" var="mark">
                    <c:if test="${mark.key==select}">
                        <c:forEach items="${mark.value}" var="markTerm">
                            <tr>
                                <td height="100px">${markTerm.key.name}</td>
                                <c:if test="${markTerm.value.mark == 0}">
                                    <td height="100px">нет</td>
                                </c:if>
                                <c:if test="${markTerm.value.mark != 0}">
                                    <td height="100px">${markTerm.value.mark}</td>
                                </c:if>

                            </tr>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </table>
        </li>
    </ul>
    </form>
</div>
