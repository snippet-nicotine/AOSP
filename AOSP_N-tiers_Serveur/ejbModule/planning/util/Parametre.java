package planning.util;
/***********************************************************************
 * Module:  Parametre.java
 * Author:  Moi
 * Purpose: Defines the Class Parametre
 * Cette classe contient les RG métier de l'application
 ***********************************************************************/


public class Parametre {
		
	public final static String NOM_TABLE_PLANNING = 			"planning";
	public final static String NOM_TABLE_FOLLOWER = 			"follower";
	public final static String NOM_TABLE_PLANNING_FOLLOWER = 	"planning_follower";
	public final static String NOM_TABLE_EVENEMENT = 			"evenement";
	public final static String NOM_TABLE_PLANTE = 				"plante";
	
	// nombre de mots cles maximum definissant un livre
	public final static int NBMOTCLEMAX = 5;
	// montant de la caution pour l'emprunt d'un CD
	public final static int MONTANTCAUTION = 30;
	// nb de relance max avant radiation
	public final static int NBRELANCEMAX = 3;
	// nombre de jours max definissant la durée d'un emprunt.
	// Après cette date, on envoie une relance
	public final static int DUREEPRET = 45;
	
	
//	public final static String strNomDriver = "oracle.jdbc.driver.OracleDriver";
//	public final static String dbURL ="jdbc:oracle:thin:stag13/stag13pw@junon:1521:AFPA";

}