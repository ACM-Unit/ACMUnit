<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<table id='panel' class="maxw" align="center">
		<tr background-color= "#f0f0f0">
			<td align="left" background-color= "#f0f0f0"><a
				href="${CONTEXT}${CURRENT_MAPPING}/student/students.php">Студенты</a></td>
			<td align="center" background-color= "#f0f0f0"><a
				href="${CONTEXT }${CURRENT_MAPPING}/discipline/disciplines.php">Дисциплины</a></td>
			<c:if test="${CURRENT_ROLE eq 1}">
				<td align="center" background-color= "#f0f0f0"><a href="${CONTEXT }${CURRENT_MAPPING}/mark/mark.php">Внести
						оценки</a></td>
			</c:if>

			<td align="right" background-color= "#f0f0f0"><a href="${CONTEXT}${CURRENT_MAPPING}/term/terms.php?sel=1">Семестры</a></td>

		</tr>
	</table>
<div id="owl-demo" class="owl-carousel owl-theme">

	<div class="item"><h1>1</h1></div>
	<div class="item"><h1>2</h1></div>
	<div class="item"><h1>3</h1></div>
	<div class="item"><h1>4</h1></div>
	<div class="item"><h1>5</h1></div>
	<div class="item"><h1>6</h1></div>
	<div class="item"><h1>7</h1></div>
	<div class="item"><h1>8</h1></div>
	<div class="item"><h1>9</h1></div>
	<div class="item"><h1>10</h1></div>
	<div class="item"><h1>11</h1></div>
	<div class="item"><h1>12</h1></div>

</div>
<script>
	$(document).ready(function() {

		$("#owl-demo").owlCarousel({
			navigation : true
		});

	});
</script>


