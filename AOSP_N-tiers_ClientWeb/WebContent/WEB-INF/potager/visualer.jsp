<%@page import="java.util.ArrayList"%>
<%@page import="commun.config.Parametres"%>
<%@page import="potager.entity.Potager"%>
<%@page import="potager.entity.Carre"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">

<% Potager potager = (Potager) request.getAttribute("potager"); %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/potager/css/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/potager/css/style.css">
	
	
<title>Administration des potagers</title>
</head>
<body>
	
	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
	
	<div id="contenu" class="container-fluid">	
	
		<div class="row">
		
			<section id="titre" class="page-header">
			  <h1>${potager.nom}</h1>
			</section>					
					
			<section id="carres">
							
				<% for(int y=0; y < potager.getNbCarresY(); y++) { %>
					
					<div class="ligne">				
									
						<%	for(int x=0; x < potager.getNbCarresX(); x++){ 
								
								int index = ( y*potager.getNbCarresX() ) + x ;
								Carre carre = potager.getCarres().get(index);
								request.setAttribute("carre", carre);
						%>								
								<jsp:include page="vuesPartielles/carre.jsp"></jsp:include>
						<% } %>
					
					</div>
									
				<% } %>		

			</section>
			
			
		</div>
	</div>

</body>

	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/potager/css/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/potager/js/gestionPotager.js"></script>

</html>