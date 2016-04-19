<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html">

<html lang="fr">
<head>

	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>	
	<sb:head/>
	<script type="text/javascript" src="<s:url namespace="/js" action="gestion_potager"/>" defer></script>
	<script type="text/javascript" src="<s:url namespace="/js" action="formAjax"/>" defer></script>
	
	<s:url namespace="/resources" action="css_potager_style"    var="css_style"/>
	<link rel="stylesheet" href='${css_style}'>
	
	
	<title>${titre}</title>
	
</head>


<body>
	
	<div id="context" style="display:none;"><%=request.getContextPath()%></div>
		
	<%@ include file="menu.jsp"%>
