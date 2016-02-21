<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
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
<article class="color">
    <div id="wrapper">
        <div id="slider">
            <div class="inslider">
                <!-- Контейнер контента  -->
                <div class="contentholder">
                    <div class="contentslider">

                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m1.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m2.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m3.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m4.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m5.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/m6.jpg" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#c9b9a9;"></a>
                    <a rel="2" href="#" style="background:#ffffff;"></a>
                    <a rel="3" href="#" style="background:#9f1c24;"></a>
                    <a rel="4" href="#" style="background:#c4c5bb;"></a>
                    <a rel="5" href="#" style="background:#898a8a;"></a>
                    <a rel="6" href="#" style="background:#314690;"></a>
                </div>
            </div>
        </div>
    </div>

</article>
<div class="colors-map">
    M — Металлик<br>
    s — Неметаллик<br>
    p — Перламутр
</div>
