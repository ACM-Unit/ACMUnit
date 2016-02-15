$(function() {

	if ($('#tabs').length) {
		$('#tabs').tabs();
	}

	if ($('#accordion').length) {
		$('#accordion').accordion({
			heightStyle : "content"
		});
	}

	if ($('.vacancy-title').length) {
		$('.vacancy-title').on('click', function(e) {
			e.preventDefault();
			$(this).parent().next('.vacancy-text').slideToggle();
		});
	}

	if ($('.show-about').length) {
		$('.show-about').on('click', function(e) {
			e.preventDefault();
			$(this).toggleClass('close');
			$(this).parent().next('.about-text').slideToggle();
		});
	}

	if ($('.colors-slider').length) {
		$('.colors-slider').bxSlider({
			minSlides : 6,
			maxSlides : 6,
			slideWidth : 75,
			slideMargin : 18,
			moveSlides : 1,
			infiniteLoop : false,
			hideControlOnEnd : true,
			pager : false
		});
	}

	if ($('.color').length) {
		$('.color').on('click', function(e) {
			e.preventDefault();
			$('.color').removeClass('selected');
			$(this).addClass('selected');
			var path = $(this).attr('href');
			$('#preview-color').attr('src', path);
		});
	}

	var tblwidth = $('#table-t1').width();
	if (tblwidth > 758) {
		//alert(tblwidth);
		$('#tabs').css('overflow-x', 'scroll');
	}
	//$('.chitem').on('click', function() {
	//	$("#construct").submit();
	//});

	$('.bxslider').bxSlider({
		pagerCustom : '#bx-pager'
	});
}); 