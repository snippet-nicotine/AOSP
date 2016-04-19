<%@page import="commun.config.Parametres"%>
<%@page import="potager.entity.Potager"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>

	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
		
	<s:form>
		<s:textfield name="potager.nom" />
	</s:form>
	
	<div id="contenu" class="container-fluid">	
			
			<section id="titre" class="page-header">
			  <h1>Administration des potagers</h1>
			</section>			
            		
			<section id="actions">
			
				<div class="panel panel-default">
				
				  <div class="panel-heading">
				  
				  		<span>Créer un nouveau potager</span>
				  		
<!-- 				  		Barre annulation et messages -->
					  	<s:url namespace="/actions" action="/annuler_potager" var="annuler"/>
						<s:a href="%{annuler}" class="btn btn-danger btn-xs pull-right">
						 		<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
						 		Annuler (<s:property value="nombreAnnulations" />)
						</s:a>			 	
						<a href="<%= request.getContextPath() %>/aosp/message" class="btn btn-default btn-xs pull-right">Demande d'arrosage</a>
				  </div>
				  
				  <div class="panel-body">
					 	<section id="ajouter">
	
						<%@ include file="vuesPartielles/form-ajouter.jsp" %>		
				
					</section>
				  </div>
				</div>
			 	
			 	<div class="row pull-right">
			 	</div>
			 	
			</section>
		
			<!-- Ajouter un potager -->
						
			
			
			<section id="lister">
			
				<table class="table table-hover table-striped table-bordered">
				
					<thead>
						<tr>
							<th>Nom</th>
							<th>Dimension</th>
							<th>Code Postal</th>
							<th>Propriétaire</th>
							<th>Date de création</th>
							<th>Visiteurs</th>
							<th>Actions</th>
						</tr>
						
					</thead>
						
					<tbody>
					
						<s:iterator value="potagers">
														
							<%@ include file="vuesPartielles/tableau-potager/potager-item.jsp"%>
													
						</s:iterator>
															
					</tbody>
							
				</table>
			
			</section>
		</div>

<!-- 	<section id="modifier"> -->
<%-- 		<%@ include file="vuesPartielles/form-modifier-modal.jsp"%>	 --%>
<!-- 	</section> -->
	
	<section id="infos">
		<s:actionerror   theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
    </section>
	

</body>
	

</html>