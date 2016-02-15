<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/juke.php">ОБНОВЛЕННЫЙ NISSAN JUKE</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/jukeView.php">Обзор модели</a></li>
                <li><a href="${CONTEXT}/jukeSelectColor.php">Выбор цвета</a></li>
                <li><a href="#">360 градусов</a></li>
                <li><a href="#">Галерея</a></li>
                <li><a href="" download="pdf/Juke_MC.pdf">Скачать прайс</a></li>
                <li><a href="" download="pdf/Juke.pdf">Скачать брошюру</a></li>
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
                            <a href=""><img src="${CONTEXT}/index_files/j1.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j2.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j3.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j4.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j5.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j6.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j7.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j8.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j9.png" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/j10.png" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#0f0f10;"></a>
                    <a rel="2" href="#" style="background:#7f0f1a;"></a>
                    <a rel="3" href="#" style="background:#a10f0f;"></a>
                    <a rel="4" href="#" style="background:#dedede;"></a>
                    <a rel="5" href="#" style="background:#201f24;"></a>
                    <a rel="6" href="#" style="background:#424242;"></a>
                    <a rel="7" href="#" style="background:#898a8a;"></a>
                    <a rel="8" href="#" style="background:#c4c5bb;"></a>
                    <a rel="9" href="#" style="background:#355488;"></a>
                    <a rel="10" href="#" style="background:#c99331;"></a>
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