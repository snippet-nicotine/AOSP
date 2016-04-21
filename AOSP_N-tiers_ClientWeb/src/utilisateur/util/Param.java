package utilisateur.util;

/**
 * Classe fournissant des constantes String Static
 * @author Guillaume
 *
 */
public class Param {

	// Le chemin d'acc�s aux EJB sur le serveur
	public static final String EJB_SERVICE_UTILISATEUR = 
			"ejb:/AOSP_N-tiers_Serveur/ServiceUtilisateur!utilisateur.clientServeur.IServiceUtilisateur";

	//*********** constantes String nommant les diff�rents types d'utilisateurs
	public static final String STR_ADMINISTRATEUR 	= "Administrateur";
	public static final String STR_JARDINIER 		= "Jardinier";
	public static final String STR_SPECIALISTE 		= "Sp�cialiste";
	//***********



}
