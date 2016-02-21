<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside style="position: static; width: 200px;">
    <ul class="dropdown">
        <li  class="dropdown-top">
            <a class="dropdown-top" width="200px" href="${CONTEXT}/xTrail.jsp">NISSAN X-TRAIL</a>
            <ul class="dropdown-inside">
                <li><a href="${CONTEXT}/xTrailView">Обзор модели</a></li>
                <li><a href="${CONTEXT}/xTrailSelectColor">Выбор цвета</a></li>
                <li><a href="${CONTEXT}/pdf/Xtrail_New.pdf" download>Скачать прайс</a></li>
                <li><a href="${CONTEXT}/pdf/X-Trail-New_ua.pdf" download>Скачать брошюру</a></li>
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
                            <a href=""><img src="${CONTEXT}/index_files/x1.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x2.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x3.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x4.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x5.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x6.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x7.jpg" ></a>
                        </div>
                        <div class="content">
                            <a href=""><img src="${CONTEXT}/index_files/x8.jpg" ></a>
                        </div>
                    </div>
                </div>
                <!-- Навигация  -->
                <div class="contentnav">
                    <a rel="1" href="#" style="background:#000001;"></a>
                    <a rel="2" href="#" style="background:#142329;"></a>
                    <a rel="3" href="#" style="background:#413c34;"></a>
                    <a rel="4" href="#" style="background:#23241c;"></a>
                    <a rel="5" href="#" style="background:#3f1b1c;"></a>
                    <a rel="6" href="#" style="background:#8e929b;"></a>
                    <a rel="7" href="#" style="background:#9b978a;"></a>
                    <a rel="8" href="#" style="background:#cfcfd1;"></a>
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
