<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.http.HttpStatus"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="o" tagdir="/WEB-INF/tags"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%> --%>
<%@page import="org.springframework.security.oauth2.common.exceptions.OAuth2Exception"%>

<%
/* 	if(request.getAttribute("error") != null && request.getAttribute("error" instanceof OAuth2Exception)) {
		request.setAttribute("errorCode", ((OAuth2Exception)request.getAttribute("error")).getOAuth2ErrorCode());
		request.setAttribute("message", ((OAuth2Exception)request.getAttribute("error")).getMessage());
	}  */

	if( request.getAttribute("java.servlet.error.exception") !=null ){
		Throwable t = (Throwable)request.getAttribute("javax.servlet.error.exception");
		request.setAttribute("errorCode",  t.getClass().getSimpleName() + " (" + request.getAttribute("javax.servlet.error.status_code") + ")");
		request.setAttribute("message", t.getMessage());
	}else if (request.getAttribute("javax.servlet.error.status_code") != null) {
		Integer code = (Integer)request.getAttribute("javax.servlet.error.status_code");
		HttpStatus status = HttpStatus.valueOf(code);
		request.setAttribute("errorCode", status.toString() + " " + status.getReasonPhrase());
		request.setAttribute("message", request.getAttribute("javax.servlet.error.message"));
	} else {
		request.setAttribute("errorCode", "Server error");
		request.setAttribute("message", "See the logs for details");
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 에러 페이지 입니다. </title>
</head>
<body>
	작업 처리도중 예외가 발생했습니다. 
</body>
</html>