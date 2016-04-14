<?php

	$mysqli = new mysqli("mysql.hostinger.fr","u708024600_cdi","cdiafpa","u708024600_cdi");
	
	/* Création une requête préparée */
	if ($stmt = $mysqli->prepare("SELECT nom, numCompte, solde FROM 14033935_client")) {

		/* Lecture des paramètres de marques 
		$stmt->bind_param( "i", $id);

		/* Exécution de la requète */
		$stmt->execute();

		/* Lecture des variables résultantes */
		$stmt->bind_result($nom, $numCompte, $solde);

		$clients = array();
		/* Récupération des valeurs */
		while($stmt->fetch())
		{
			$client = array();
			$client['nom'] = $nom;
			$client['numCompte'] = $numCompte;
			$client['solde'] = $solde;
			
			array_push($clients, $client);
		}

		echo json_encode($clients);

		/* Fermeture du traitement */
		$stmt->close();
	}


	$mysqli->close();
?>