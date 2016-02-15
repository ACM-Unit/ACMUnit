<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="/qashqai.php">NISSAN QASHQAI</a>
            <ul class="dropdown-inside">
                <li><a href="/qashqaiView.php">Обзор модели</a></li>
                <li><a href="/qashqaiSelectColor.php">Выбор цвета</a></li>
                <li><a href="#">360 градусов</a></li>
                <li><a href="#">Галерея</a></li>
                <li><a href="pdf/Qashqai.pdf" download>Скачать прайс</a></li>
                <li><a href="pdf/QQ_New.pdf" download>Скачать брошюру</a></li>
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
                            <a href=""><img src="${CONTEXT}/index_files/q1.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q2.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q3.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q4.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q5.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q6.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q7.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/q8.jpg" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#c0bdb8;"></a>
                    <a rel="2" href="#" style="background:#e5e9ec;"></a>
                    <a rel="3" href="#" style="background:#ffffff;"></a>
                    <a rel="4" href="#" style="background:#1e1e1e;"></a>
                    <a rel="5" href="#" style="background:#593e35;"></a>
                    <a rel="6" href="#" style="background:#314690;"></a>
                    <a rel="7" href="#" style="background:#403136;"></a>
                    <a rel="8" href="#" style="background:#712727;"></a>
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
