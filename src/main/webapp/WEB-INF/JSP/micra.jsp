<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <aside>
        <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/micra.jsp">NISSAN MICRA</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/micraView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/micraSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Micra.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/Micra_ua.pdf" download>Скачать брошюру</a></li>
            </ul>
            </li>
            </ul>
    </aside>
<div class="model-content">
            <img src="${CONTEXT}/index_files/micra_big.jpg" width="100%">
            <div class="text">
                <div class="btext">
                    <div class="wtext">
                        <div align="justify"><strong>Новая Micra</strong>, которая объединяет в себе модный стиль, компактный дизайн и удивительно просторный салон довезет Вас куда угодно, более того быстро и с комфортом.</div>
                    </div>
                </div>
                <span class="price">от ${micra} грн.</span>
            </div>
</div>
