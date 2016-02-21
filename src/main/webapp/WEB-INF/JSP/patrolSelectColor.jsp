<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/patrol.jsp">NISSAN MICRA</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/patrolView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/patrolSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Patrol.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/Patrol_ua.pdf" download>Скачать брошюру</a></li>
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
                            <a href=""><img src="${CONTEXT}/index_files/p1.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/p2.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/p3.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/p4.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/p5.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/p6.jpg" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#ffffff;"></a>
                    <a rel="2" href="#" style="background:#9f1c24;"></a>
                    <a rel="3" href="#" style="background:#413b47;"></a>
                    <a rel="4" href="#" style="background:#95a7ae;"></a>
                    <a rel="5" href="#" style="background:#9ec39b;"></a>
                    <a rel="6" href="#" style="background:#c9b9a9;"></a>
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
