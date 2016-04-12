<%@page import="commun.config.Parametres"%>
<%@page import="potager.entity.Potager"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<s:url namespace="/resources" action="css_potager_style" var="css_style"/>

<!DOCTYPE html">

<html lang="fr">
<head>

	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<sb:head/>
	<link rel="stylesheet" href='${css_style}'>
	
	
<title>Administration des potagers</title>
</head>
<body>
	
	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
		
	<div id="contenu" class="container-fluid">	
			
			<section id="titre" class="page-header">
			  <h1>Administration des potagers</h1>
			</section>			
            		
			<section class="well">
				
				<a href="<%= request.getContextPath() %>/aosp/potager/annuler" class="btn btn-danger">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
					Annuler (${nbAnnulations})
			 	</a>
			 	<a href="<%= request.getContextPath() %>/aosp/message" class="btn btn-default">Demande d'arrosage</a> ( sur tout les potagers listés (Message) )		
			</section>
		
			<!-- Ajouter un potager -->
						
			<section id="ajouter">
	
				<s:form namespace="/potager" id="formulaire-ajouter" action="ajouterBeanPotager" theme="bootstrap" cssClass="well form-inline" >
						
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
						X
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
					
					<s:select
                        tooltip="Visiteurs"
                        label="Visiteurs"
                        list="{'Red', 'Blue', 'Green'}"
                        name="favouriteColor"
                        emptyOption="true"
                        headerKey="None"
                        headerValue="None"/>
					
					<s:submit cssClass="btn btn-default" value="+ Ajouter"/>
					
				</s:form>			
				
			</section>
			
			<section id="lister">
			
				<table class="table table-hover table-striped table-bordered">
				
					<thead>
						<tr>
							<th>Nom</th>
							<th>Dimension</th>
							<th>Nombre de carrés</th>
							<th>Code Postal</th>
							<th>Propriétaire</th>
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
								
								<td><a href="<c:url value="/aosp/potager/${potager.idPotager}"/>"> 
									${potager.nom} </a>
								</td>
								
								<td>${potager.largeur} x ${potager.longueur}</td>
								
								<td>${fn:length(potager.carres)}</td>
								
								<td>${potager.codePostal}</td>
								
								<td> <a href="#" > ${potager.proprietaire.nom} </a> </td>
								
								<td> 
									<c:forEach items="${potager.visiteurs}" var="visiteur">
										${visiteur.nom},
									</c:forEach>
								 </td>
								
								<td>
									<a class="bouton-afficher-modifier"  href="#">
										<i class="glyphicon glyphicon-pencil"></i>
									</a>
									
									<a data-button-id="${potager.idPotager}" class="bouton-supprimer" href="#">
										<i  class="glyphicon glyphicon-remove"></i>
									</a>
									
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
							
				</table>
			
			</section>
		</div>

	<!-- Modifier le potager -->
	<div class="modal fade ${ isModifier ? 'visible' : '' }" id="modal-modifier" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modifier le potager</h4>
				</div>
				<div class="modal-body">
				
				<form class="form well" id="formulaire-modifier" method="POST" action="<%= request.getContextPath() %>/aosp/<%=Parametres.CONTROLLEUR_GESTION_POTAGER%>">
		  
				  <div class="form-group ${ erreurNom != null ? 'has-error' : '' }">
				    <label for="nom">Nom</label>
				    <input type="text" class="form-control" id="modifier-nom" name="modifier-nom" placeholder="Nom"
				    		data-toggle="tooltip" 
				    		title="${ erreurNom != null ? erreurNom : 'Entrez le nom du potager' }">
				  </div>
				  
				  <div class="form-group ${ erreurDimension != null ? 'has-error' : '' }">
				  
				    <label for="longueur">Dimension</label>
				    <input type="number" class="form-control" id="modifier-longueur" name="modifier-longueur" placeholder="Longueur"
				    		data-toggle="tooltip" 
				    		title="${ erreurDimension != null ? erreurDimension : 'Entrez la largeur du potager' }">				    
				    <input type="number" class="form-control" id="modifier-largeur"  name="modifier-largeur"  placeholder="Largeur"
				    		data-toggle="tooltip" 
			    			title="${ erreurDimension != null ? erreurDimension : 'Entrez la longueur du potager' }">
				    
				  </div>
				  
				  <div class="form-group ${ erreurCodepostal != null ? 'has-error' : '' }">
				    <label for="codePostal">Code Postal</label>
				    <input type="text" class="form-control" id="modifier-codePostal" name="modifier-codePostal" placeholder="Code Postal"
				    		data-toggle="tooltip" 
			    			title="${ erreurCodepostal != null ? erreurCodepostal : 'Entrez le code postal du potager (5 chiffres)' }">
				  </div>				  		  				  
				</form>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
					<button data-button-id="" name="modifier" type="button" class="bouton-modifier btn btn-primary">Mettre à jour</button>
				</div>
			</div>
		</div>
	</div>
	
	<section id="infos">
		<s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
    </section>
	

</body>

	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/potager/css/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/potager/js/gestionPotager.js"></script>

</html>