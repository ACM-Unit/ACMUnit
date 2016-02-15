<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${CURRENT_SESSION_ACCOUNT ne null }">
	<a id='logout' href="${CONTEXT }/logout.php">Logout</a>
</c:if>
