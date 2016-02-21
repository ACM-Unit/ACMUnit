<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside>
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/murano.jsp">NISSAN MURANO</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/muranoView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/muranoSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Murano.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/Murano_ua.pdf" download>Скачать брошюру</a></li>
            </ul>
        </li>
    </ul>
</aside>
<div class="model-content">
    <img src="${CONTEXT}/index_files/murano.jpg" width="100%">
    <div class="text">
        <div class="btext">
            <div class="wtext">

                <p class="title1" data-anchor-id="СКОРОВУКРАИНЕspan"><font color="#FFFFFF"><b>Nissan Murano</b><span itemprop="description"></span></font></p>
                <font color="#FFFFFF"> </font>
                <p class="title1" data-anchor-id="СКОРОВУКРАИНЕspan"><span itemprop="description"><font color="#FFFFFF">Вдохновляя город элегантностью. </font> </span></p>
            </div>
        </div>
        <span class="price">от 995 420 грн.</span>
    </div>
</div>