<%@page import="commun.config.Parametres"%>
<%@page import="potager.entity.Potager"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<s:url namespace="/resources" action="css_potager_style"    var="css_style"/>
	
	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
		
	
	
	<div id="contenu" class="container-fluid">	
			
			<section id="titre" class="page-header">
			  <h1>Administration des potagers</h1>
			</section>			
            		
			<section id="actions">
			
				<div class="panel panel-default">
				
				  <div class="panel-heading">
				  
				  		<span>Créer un nouveau potager</span>
				  		
					  	<s:url namespace="/actions" action="/annuler_potager" var="annuler"/>
						 <s:a href="%{annuler}" class="btn btn-danger btn-xs pull-right">
						 		<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
						 		Annuler (<s:property value="nombreAnnulations" />)
						 </s:a>			 	
						 <a href="<%= request.getContextPath() %>/aosp/message" class="btn btn-default btn-xs pull-right">Demande d'arrosage</a>
				  </div>
				  
				  <div class="panel-body">
					 	<section id="ajouter">
	
						<s:form namespace="/actions" id="formulaire-ajouter" action="ajouter_potager" theme="bootstrap" cssClass="form-inline" >
								
								<s:textfield
										label="Nom"
										name="potager.nom"
										tooltip="Nom du potager"
								/>
							
							<div class="form-group">
								<s:textfield
										label="Longueur"
										name="potager.longueur"
										tooltip="Longueur du potager"
								/>
								<b>X</b>
								<s:textfield
										label="Largeur"
										name="potager.largeur"
										tooltip="Largeur du potager"
								/>					
							</div>
							
							<s:textfield
									label="Code Postal"
									name="potager.codePostal"
									tooltip="Code postal (format: 13000, 65000,...)"
							/>
																	
							<s:submit cssClass="btn btn-success" value="+ Ajouter"/>
							
						</s:form>			
				
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
							<th>Nombre de carrés</th>
							<th>Code Postal</th>
							<th>Propriétaire</th>
							<th>Date de création</th>
							<th>Visiteurs</th>
							<th>Actions</th>
						</tr>
						
					</thead>
						
					<tbody>
										
						<c:forEach items="${potagers}" var="potager">
							<tr 
								data-potager-id="${potager.idPotager}"
								data-potager-nom="${potager.nom}"
								data-potager-longueur="${potager.longueur}"
								data-potager-largeur="${potager.largeur}"
								data-potager-codePostal="${potager.codePostal}"
							>				
								
								<td> 
									<s:url namespace="/actions" action="/voir_potager" var="voirPotager"/>
									<s:a href="%{voirPotager}">${potager.nom}</s:a>								
								</td>
								
								<td>${potager.largeur} x ${potager.longueur}</td>
								
								<td>${fn:length(potager.carres)}</td>
								
								<td>${potager.codePostal}</td>
								
								<td> <a href="#" > ${potager.proprietaire.nom} </a> </td>
								
								<td> 																
									<tags:localDate  pattern="dd/MM/yyyy" date="${potager.dateCreation}"/>														
																						
								</td>
							
								<td> 
									<c:forEach items="${potager.visiteurs}" var="visiteur">
										${visiteur.nom},
									</c:forEach>
								 </td>
								
								<td>
																	
									<s:a class="bouton-afficher-modifier" href="#">
										<i class="glyphicon glyphicon-pencil"></i>									
									</s:a>
							
									<s:url namespace="/actions" action="/supprimer_potager" var="supprimerPotager">
										<s:param name="id">${potager.idPotager}</s:param>
									</s:url>
									
									<s:a href="%{supprimerPotager}" class="">
										<i  class="glyphicon glyphicon-remove"></i>										
									</s:a>
									
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
							
				</table>
			
			</section>
		</div>

	<section id="modifier">
		<%@ include file="vuesPartielles/modal-modifier.jsp"%>	
	</section>
	
	<section id="infos">
		<s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
    </section>
	

</body>
	
	<script type="text/javascript" src="<s:url namespace="/js" action="gestion_potager"/>"></script>

</html>