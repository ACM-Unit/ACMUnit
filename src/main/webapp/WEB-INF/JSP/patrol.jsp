<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside>
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/patrol.jsp">NISSAN PATROL</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/patrolView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/patrolSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Patrol.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/Patrol_ua.pdf" download>Скачать брошюру</a></li>
            </ul>
        </li>
    </ul>
</aside>
<div class="model-content">
    <img src="${CONTEXT}/index_files/Patrol_cover_atl.jpg"  width="100%">
    <div class="text">
        <div class="btext">
            <div class="wtext">

                <div align="justify">Позвольте себе высшую роскошь — свободу. Исследуйте, отдыхайте, находите приключения вместе с Nissan PATROL — легендарным флагманом внедорожников Nissan.</div>
            </div>
        </div>
        <span class="price">от 2 249 180 грн.</span>
    </div>
</div>
