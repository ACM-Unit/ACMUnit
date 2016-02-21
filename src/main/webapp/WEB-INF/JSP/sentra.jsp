<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside>
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/sentra.jsp">NISSAN SENTRA</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/sentraView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/sentraSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Sentra.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/Sentra_ua.pdf" download>Скачать брошюру</a></li>
            </ul>
        </li>
    </ul>
</aside>
        <div class="model-content">
            <img src="${CONTEXT}/index_files/sentra-big.jpg" width="100%">
            <div class="text">
                <div class="btext">
                    <div class="wtext">

                        <p class="title1" data-anchor-id="СКОРОВУКРАИНЕspan"><font color="#FFFFFF"><b>СКОРО В УКРАИНЕ</b><span itemprop="description"></span></font></p>
                        <font color="#FFFFFF"> </font>
                        <p class="title1" data-anchor-id="СКОРОВУКРАИНЕspan"><span itemprop="description"><font color="#FFFFFF">Солидный, надежный и технологичный. Новый Nissan SENTRA – однажды оказавшись внутри, Вы не захотите ничего другого. </font> </span></p>
                    </div>
                </div>
                <span class="price">от ${sentra} грн.</span>
            </div>
        </div>
