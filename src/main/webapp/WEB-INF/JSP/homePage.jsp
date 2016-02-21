<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-picture">
    <div class="slider">
        <ul class="slides">
            <li class="slide"><div class="box"><a href="http://www.nissan.ua/UA/ru/services-fleet/vehicles/offer/combat.html" style="height: auto;"><img src="${CONTEXT}/index_files/tactics_jan_push_2_980x435_ru.jpg" style="width: 100%;"></a></div></li>
            <li class="slide"><div class="box"><a href="http://ukr.nissan.ua/UA/uk/services-fleet/vehicles/offer/you_nissan.html" style="height: auto;"><img src="${CONTEXT}/index_files/indexNissanYou.jpg" style="width: 100%;"></a></div></li>
            <li class="slide"><div class="box"><a href="http://www.nissan.ua/UA/ru/services-fleet/vehicles/offer/accessories.html" style="height: auto;"><img src="${CONTEXT}/index_files/accessories_480x435_push_ru.jpg" style="width: 100%;"></a></div></li>
            <li class="slide"><div class="box"><a href="${CONTEXT}/juke.jsp" style="height: auto;"><img src="${CONTEXT}/index_files/juke_mc_980x435_ru.jpg" style="width: 100%;"></a></div></li>
        </ul>
    </div>

    <script type="text/javascript">
        var glide = $('.slider').glide().data('api_glide');

        $(window).on('keyup', function (key) {
            if (key.keyCode === 13) {
                glide.jump(3, console.log('Wooo!'));
            };
        });

        $('.slider-arrow').on('click', function() {
            console.log(glide.current());
        });
    </script>

</div>
<ul class="promo">
    <li>
        <a target="_top" href="/tools/banner/click.php?id=401"><img src="/uploads/banner_banner/image/0004/01.jpg" alt="YOU + Nissan  Акция" height="110" border="0" width="264"><span>YOU + Nissan  Акция</span></a>
    </li>
    <li>
        <a target="_top" href="/tools/banner/click.php?id=397"><img src="/uploads/banner_banner/image/0003/97.jpg" alt="Эксклюзивное предложение" height="110" border="0" width="264"><span>Эксклюзивное предложение</span></a>
    </li>
    <li>
        <a target="_top" href="/tools/banner/click.php?id=378"><img src="/uploads/banner_banner/image/0003/78.jpg" alt="Выгодное предложение" height="117" border="0" width="264"><span>Выгодное предложение</span></a>
    </li>
</ul>

</div>
<article>
    <div class="cars-select2">
        <div class="cars_index">
            <div class="carBlock">
                <span>Легковые автомобили</span>
                <a href="${CONTEXT}/micra.jsp" style=" bottom: 0px; margin-left:-0px; z-index:2; position:relative;">
                    <img src="${CONTEXT}/index_files/a41e1903dcddfe9620d1311365c0ec55.png" alt="" title="" border="0">
                </a>
                <a href="${CONTEXT}/sentra.jsp" style=" bottom: 0px; margin-left:-15px; z-index:1; position:relative;">
                    <img src="${CONTEXT}/index_files/sentra-spisok-mini.jpg" alt="" title="" border="0">
                </a>


            </div>
            <div class="carBlock">
                <span>Кроссоверы</span>
                <a href="${CONTEXT}/juke.jsp" style=" bottom: 0px; margin-left:-0px; z-index:4; position:relative;">
                    <img src="${CONTEXT}/index_files/new-juke-small2.png" alt="" title="" border="0">
                </a>
                <a href="${CONTEXT}/qashqai.jsp" style=" bottom: 0px; margin-left:-15px; z-index:2; position:relative;">
                    <img src="${CONTEXT}/index_files/e2c6de24bc47eb12f0ffd477e92fcde2.png" alt="" title="" border="0">
                </a>
                <a href="${CONTEXT}/murano.jsp" style=" bottom: 0px; margin-left:-15px; z-index:1; position:relative;">
                    <img src="${CONTEXT}/index_files/eb5a8590cca42ada8045f960239554d8.png" alt="" title="" border="0">
                </a>


            </div>
            <div class="carBlock">
                <span>Внедорожники</span>
                <a href="${CONTEXT}/patrol.php" style=" bottom: 0px; margin-left:-15px; z-index:3; position:relative;">
                    <img src="${CONTEXT}/index_files/patrol_small.png" alt="" title="" border="0">
                </a>
                <a href="${CONTEXT}/xTrail.php" style=" bottom: 0px; margin-left:-15px; z-index:1; position:relative;">
                    <img src="${CONTEXT}/index_files/index.png" alt="" title="" border="0">
                </a>

            </div>
            <div style="clear:both"></div>
        </div>
    </div>
    <div class="about-block">
        <h4><a href="" class="show-about">О компании</a></h4>
        <div class="about-text" style="padding: 0 20px 0 20px;">

            <p align="justify"><b>Авто плюс</b> - официальный дилер <b>Nissan</b> <b>(Ниссан)</b> в Сумах! Став нашим клиентом, мы создадим для Вас наиболее выгодные условия покупки и сервисного обслуживания автомобилей Nissan. Все автомобили, представленные в автосалоне, сертифицированы и адаптированы для эксплуатации в Украине. Всегда есть возможность провести для Вас тест-драйв без предварительной записи. К Вашим услугам специальная программа кредитования Nissan Finance.</p>

        </div>
    </div>
</article>