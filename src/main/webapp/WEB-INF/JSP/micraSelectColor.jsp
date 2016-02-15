<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="/micra.php">NISSAN MICRA</a>
            <ul class="dropdown-inside">
                <li><a href="/micraView.php">Обзор модели</a></li>
                <li><a href="/micraSelectColor.php">Выбор цвета</a></li>
                <li><a href="#">360 градусов</a></li>
                <li><a href="#">Галерея</a></li>
                <li><a href="/pdf/Micra.pdf" download>Скачать прайс</a></li>
                <li><a href="/pdf/Micra_ua.pdf" download>Скачать брошюру</a></li>
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
                            <a href=""><img src="${CONTEXT}/index_files/1.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/2.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/3.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/4.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/5.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/6.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/7.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/8.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/10.jpg" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#dd852b;"></a>
                    <a rel="2" href="#" style="background:#9f1c24;"></a>
                    <a rel="3" href="#" style="background:#413b47;"></a>
                    <a rel="4" href="#" style="background:#76858c;"></a>
                    <a rel="5" href="#" style="background:#00376f;"></a>
                    <a rel="6" href="#" style="background:#8ba52a;"></a>
                    <a rel="7" href="#" style="background:#394344;"></a>
                    <a rel="8" href="#" style="background:#4d3744;"></a>
                    <a rel="9" href="#" style="background:#e9e7db;"></a>
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