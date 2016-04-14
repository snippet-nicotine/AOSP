<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="planning.entity.Evenement"%>
<%@page import="planning.entity.Planning"%>
<%@page import="planning.util.ConstanteString"%>
<%@page import="planning.util.Parametre"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link rel="stylesheet" href="<s:url namespace="/Planning" action="css" />" /> --%>
<%@ include file="/WEB-INF/vuesPartielles/globale_css.jsp"%>

<script	src="<%=request.getContextPath()%>/planification/script/tableau.js"></script>
<script	src="<%=request.getContextPath()%>/planification/script/gestionEvenement.js"></script>

<title>Gestion des évènements</title>
</head>
<body>
	<%@ include file="/WEB-INF/vuesPartielles/header.jsp"%>
	<div id="corps">
		<!-- Récupération du nom de l'utilisateur uniquement en version projet complet -->
		<h1 class="version_corps">	Gestion des plannings, planning actif :	</h1>
		<div id="explication">Pour lister les évènements d'un planning,
			Veuillez d'abord sélectionner un planning puis cliquer sur "Lister
			par planning"</div>
		<div id="divTableau">
			<!-- Construction du tableau de gauche des plannings -->
			<table id="monTableau" class="tablo">
				<caption>Les plannings</caption>
				<thead>
					<tr>
						<!-- première ligne -->
						<th>Id</th>
						<th>Date création</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="plannings" >
					<tr>
            			<td><s:property value="idPlanning"/><br /></td>
						<td><s:property value="dateCreation"/><br /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div id="divTableauPotager">
			<!-- Construction du tableau de droite des évènements -->
			<table id="monTableauPotager" class="tablo2">
				<caption>Tableau des évènements</caption>
				<thead>
					<!-- en-tête -->
					<tr>
						<!-- première ligne -->
						<th>Id</th>
						<th>Plng</th>
						<th>Action</th>
						<th>Plante</th>
						<th>n</th>
						<th>p</th>
						<th>k</th>
						<th>Date</th>
						<th>Com auto</th>
						<th>Com libre</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="evenements" >
						<tr>
            				<td><s:property value="idEvenement"/><br /></td>
							<td><s:property value="idPlanning"/><br /></td>
							<td><s:property value="idAction"/><br /></td>
							<td><s:property value="idPlante"/><br /></td>
							<td><s:property value="nutrition.n"/><br /></td>
							<td><s:property value="nutrition.p"/><br /></td>
							<td><s:property value="nutrition.k"/><br /></td>
							<td><s:property value="dateEvenement"/><br /></td>
							<td><s:property value="commentaireAuto"/><br /></td>
							<td><s:property value="commentaire"/><br /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div id="explication">Pour modifier un évènement, Veuillez
			d'abord sélectionner l'évènement ci-dessus</div>
		<div id="saisie">
			<section>
				<h3>Saisie / modification d'un évènement :</h3>
	<%-- 			<div id="explication2"><%=monMessageErreur%></div> --%>
				<form id="gestion" method="post" action="#">
					<fieldset>
						<legend>Informations de l'évènement :</legend>
						<ol>
							<li><label for="idEvenement">Id évènement:</label> <input
								id="idEvenement" name="idEvenement" type="text"
								onblur="verifEntierPositifNonNul(this)"></li>
							<!-- -->
							<li><label for="idPlanning">id Planning:</label> <input
								id="idPlanning" name="idPlanning" type="text"
								onblur="verifEntierPositifNonNul(this)"></li>
							<li><label for="idAction">id Action:</label> <input
								id="idAction" name="idAction" type="text"
								onblur="verifEntierPositifNonNul(this)"></li>
							<li><label for="idPlante">id Plante :</label> <input
								id="idPlante" name="idPlante" type="text"
								onblur="verifEntierPositifNonNul(this)"></li>
							<li><label for="idNutrition">id Nutrition:</label> <input
								id="idNutrition" name="idNutrition" type="text"
								onblur="verifEntierPositifNonNul(this)"></li>
							<li><label for="dateEvenement">Dt création:</label> <input
								id="dateEvenement" name="dateEvenement" type="date"
								onblur="isDate(this)"></li>
							<fieldset class="commentaire">
								<legend class="legende-">Comm auto:</legend>
								<textarea id="comAuto" rows="4" cols="80" name="comAuto"
									title="Commentaire auto"></textarea>
							</fieldset>
							<fieldset class="commentaire">
								<legend class="legende-">Comm:</legend>
								<textarea id="com" rows="4" cols="80" name="com"
									title="Votre commentaire sur le carré potager"></textarea>
							</fieldset>
							<div id="bouton">
								<fieldset>
									<legend>Action</legend>
									<ol>
										<li><button id="btnCreer">Ajouter</button>
										<li>
										<li><button id="btnModif">Modifier</button>
										<li>
										<li><button id="btnEffacer"
												onclick="clearChamps(); return false">Effacer</button>
										<li>
										<li><button id="btnSup">Supprimer</button>
										<li>
										<li><button id="btnQuit">Quitter</button>
										<li>
										<li><button id="btnList">Lister par planning</button>
										<li>
									</ol>
								</fieldset>
							</div>
						</ol>
					</fieldset>
				</form>
			</section>
		</div>
	</div>
</body>
</html>