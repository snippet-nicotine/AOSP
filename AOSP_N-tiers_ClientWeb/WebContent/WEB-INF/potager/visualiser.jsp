	<%@ page import="com.opensymphony.xwork2.ActionContext" %>
	<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
	<%@page import="potager.entity.Carre"%>
	<%@page import="potager.entity.Potager"%>
	
	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
	
	<div id="contenu" class="container-fluid">	
	
		<div class="row">
		
			<section id="titre" class="page-header">
			  <h1>${potager.nom}</h1>
			</section>					
					
			<section id="carres">
						
				<s:iterator var="y" begin="0" end="potager.nbCarresX-1">
				
					<div class="ligne">
						<s:iterator var="x" begin="0" end="potager.nbCarresY-1">
						<c:set var="x" value="${x }"/>
						<c:set var="y" value="${y }"/>	
											
						<% 
							int x = (int) request.getAttribute("x");
							int y = (int) request.getAttribute("y");
							int nbX = (int) request.getAttribute("potager.nbCarresX");
							Potager potager = (Potager) request.getAttribute("potager"); 
							int index = ( y*nbX ) + x;
							int test = potager.getCarres().size();
							Carre carre = potager.getCarres().get(index);
							request.setAttribute("carre", carre);
						%>
						<jsp:include page="vuesPartielles/carre.jsp"></jsp:include>
						
						</s:iterator>
					</div>
				
				</s:iterator>	
<%-- 				<% for(int y=0; y < potager.getNbCarresY(); y++) { %> --%>
					
<!-- 					<div class="ligne">		 -->
<%-- 						<%	for(int x=0; x < potager.getNbCarresX(); x++){  --%>
								
<!--  								int index = ( y*potager.getNbCarresX() ) + x ; -->
<!--  								Carre carre = potager.getCarres().get(index); -->
<!--  								request.setAttribute("carre", carre); -->
<%-- 						%>								 --%>
<%-- 								<jsp:include page="vuesPartielles/carre.jsp"></jsp:include> --%>
<%-- 						<% } %> --%>
					
<!-- 					</div> -->
									
<%-- 				<% } %>		 --%>

			</section>
			
			
		</div>
	</div>

</body>

</html>