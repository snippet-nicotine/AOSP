<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
  <head>
  	<s:url namespace="/resources" action="css_materialize" var="materializeCss"/>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  
  </head>

  <body>
  
  <header>
	  <%@include file="vuesPartielles/top-bar.jsp"%>
	  <%@include file="vuesPartielles/side-bar.jsp"%>
  </header>
  
  <main>
	  <div class="container">
	  	<div class="row">
	  		<div class="col s12 ">
	  			<h2 class="center-align flow-text">Bienvenue dans votre espace Nicolas</h2>
	  		</div>
	  		
	  		
	  <div class="row">
        <div class="col s12 m4">
          
              <h3>Mes potagers</h3>
              <ul class="collection">
              	<li class="collection-item">Mon potager</li>
              	<li class="collection-item">Un autre</li>
              	<li class="collection-item">Le 3eme</li>
              </ul>
            </div>
        
        <div class="col s12 m4">
          <div class="card">
            <div class="card-content">
              <span class="card-title">Ajouter un potager</span>
              <form action="">
              	<div class="row">
	              	<div class="input-field col s12">
          				<label for="nom">Nom</label>
	              		<input id="nom" name="nom" type="text" class="validate"/>
	              	</div>
              	</div>
	              	<div class="row">
		              	<div class="input-field col s6">
	          				<label for="longueur">Longueur</label>
		              		<input id="longueur" name="longueur" type="text" class="validate"/>
		              	</div>
		              	<div class="input-field col s6">
	          				<label for="largeur">Largeur</label>
		              		<input id="largeur" name="largeur" type="text" class="validate"/>
		              	</div>	              	
	              	</div>
              	<div class="row">
              		<div class="input-field col s12">
	          				<label for="codePostal">Code Postal</label>
		              		<input id="codePostal" name="codePostal" type="text" class="validate"/>
		             </div>	
              	</div>
              </form>
              
            </div>
            <div class="card-action">
	  				<a class="waves-effect waves-light btn-flat">Annuler</a>
	  				<a class="waves-effect waves-light btn">Ajouter</a>
          	</div>
        </div>
        </div>
        
        <div class="col s12 m4">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Card Title</span>
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a href="#">This is a link</a>
              <a href="#">This is a link</a>
            </div>
          </div>
        </div>
        
      </div>
      
      		<div class="col s6">This div is 6-columns wide</div>
	  	</div>
	  </div>
  </main>
  
  <footer></footer>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
  	<script type="text/javascript" src="<s:url namespace="/js" action="gestion_potager"/>"></script>
  </body>
</html>