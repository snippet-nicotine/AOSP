package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import potager.clientServeur.ServiceGestionPotager;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public class Test_ServiceGestionPotager_Potager {

	private static ServiceGestionPotager service;
	private static Jardinier proprietaire;
	private static Potager potager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws NamingException {
		
		Context context = new InitialContext();
		service  = (ServiceGestionPotager) context.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager");
		
		proprietaire = new Jardinier();
		proprietaire.setNom("Utilisateur test)");
		
	}
		
	@After
	public void supprimePotager() throws DaoPotagerSuppressionException, DaoPotagerGetException{
		
		if(potager != null && potager.getIdPotager() > 0){
			System.out.println(potager.getIdPotager());
			service.supprimerPotager( potager.getIdPotager() );
		}
		
	}
	
	// --------------
	// AJOUTER
	// -------------
	
	@Test
	public void ajout_d_un_potager_standard() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerQueryException{
	
		// Nb de potagers avant l'ajout
		int nbPotagers = service.listerPotager().size();
		
		potager = new Potager("Potager test 1", 100, 100, "13006", proprietaire);
		potager = service.ajouterPotager(potager);
				
		assertTrue("Le potager doit avoir un Id",     potager.getIdPotager() > 0 );
		assertTrue("Le nombre de carrés doit être 4", potager.getCarres().size() == 4 );
		assertTrue("Il doit y avoir N + 1 potagers",  service.listerPotager().size() == nbPotagers + 1 );
		assertTrue("Le nom du potager doit être: Potager test 1",  potager.getNom().equals("Potager test 1") );
		
	}
	
	@Test(expected = NomPotagerException.class)	
	public void ajout_d_un_potager_avec_un_nom_invalide() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager(null, 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
				
	}
	
	@Test(expected = NomPotagerException.class)	
	public void ajout_d_un_potager_avec_un_nom_vide() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
				
	}
	
	@Test(expected = DimensionPotagerException.class)
	public void ajout_d_un_potager_avec_une_longueur_trop_petite() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("Longueur trop petite", 49, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = DimensionPotagerException.class)
	public void ajout_d_un_potager_avec_une_largeur_trop_petite() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("Largeur trop petite", 100, 49, "13006", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = CPPotagerException.class)
	public void ajout_d_un_potager_avec_un_codePostal_vide() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("CP invalide", 100, 100, "", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = CPPotagerException.class)
	public void ajout_d_un_potager_avec_un_codePostal_trop_petit() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("CP trop petit", 100, 100, "1300", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = CPPotagerException.class)
	public void ajout_d_un_potager_avec_un_codePostal_trop_grand() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("CP trop grand", 100, 100, "130068", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = CPPotagerException.class)
	public void ajout_d_un_potager_avec_un_codePostal_avec_des_lettres() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("CP trop grand", 100, 100, "13BH68", proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = CPPotagerException.class)
	public void ajout_d_un_potager_avec_un_codePostal_null() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("CP null", 100, 100, null, proprietaire);
		service.ajouterPotager(potager);
			
	}
	
	@Test(expected = ProprietairePotagerException.class)
	public void ajout_d_un_potager_avec_un_proprietaire_null() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
		
		potager = new Potager("Proprietaire null", 100, 100, "13006", null);
		service.ajouterPotager(potager);
			
	}
	
	// ---------------
	// MODIFIER
	// ---------------
	@Test
	public void modifier_un_potager_cas_nominal() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		Jardinier proprio = new Jardinier();
		proprio.setNom("Proprio");
		
		potager.setNom("Potager modifié");
		potager.setLargeur(150);
		potager.setLongueur(150);
		potager.setCodePostal("65000");
		potager.setProprietaire(proprio);
		
		potager = service.modifierPotager(potager);
		
		assertTrue("Le potager doit avoir pour nom: Potager modifié", potager.getNom().equals("Potager modifié") );
		assertTrue("Le potager doit avoir une largeur de 150", potager.getLargeur()   == 150 );
		assertTrue("Le potager doit avoir une longueur de 150", potager.getLongueur() == 150 );
		assertTrue("Le potager doit avoir un codePostal: 65000", potager.getCodePostal().equals("65000") );
		assertTrue("Le proprietaire du potager doit avoir pour nom: Proprio", potager.getProprietaire().getNom().equals("Proprio") );
				
	}
	
	@Test(expected = NomPotagerException.class)
	public void modifier_un_potager_sans_nom() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		potager.setNom("");
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = NomPotagerException.class)
	public void modifier_un_potager_avec_un_nom_null() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		potager.setNom(null);		
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = DimensionPotagerException.class)
	public void modifier_un_potager_avec_une_largeur_trop_petite() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);

		potager.setLargeur(49);
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = DimensionPotagerException.class)
	public void modifier_un_potager_avec_une_longueur_trop_petite() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);

		potager.setLongueur(49);
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = CPPotagerException.class)
	public void modifier_un_potager_avec_un_codePostal_vide() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		potager.setCodePostal("");
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = CPPotagerException.class)
	public void modifier_un_potager_avec_un_codePostal_null() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);

		potager.setCodePostal(null);
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = CPPotagerException.class)
	public void modifier_un_potager_avec_un_codePostal_avec_des_lettres() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		potager.setCodePostal("azfg58");
		
		potager = service.modifierPotager(potager);
		
	}
	
	@Test(expected = ProprietairePotagerException.class)
	public void modifier_un_potager_avec_un_proprietaire_null() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerModificationException{
		
		potager = new Potager("Potager a modifier - cas nominal -", 100, 100, "13006", proprietaire);
		service.ajouterPotager(potager);
		
		potager.setProprietaire(null);
		
		potager = service.modifierPotager(potager);
		
	}
	
	// ---------------
	// SUPPRIMER
	// ---------------
	
	@Test(expected = DaoPotagerGetException.class)
	public void supprimer_un_potager() throws DaoPotagerSuppressionException, DaoPotagerGetException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException {
		
		potager = new Potager("Potager a supprimer", 100, 100, "13006", proprietaire);
		Potager resultPotager = service.ajouterPotager(potager);
		
		int idPotager = resultPotager.getIdPotager();
		service.supprimerPotager( idPotager );
		
		//pour la methode After
		potager = null;
		service.getPotager( idPotager);	
	}
	
	@Test(expected = DaoPotagerSuppressionException.class)
	public void supprimer_un_potager_qui_n_existe_pas() throws DaoPotagerSuppressionException, DaoPotagerGetException {
		
		//pour la methode After
		potager=null;
		service.supprimerPotager( 0 );
		
	}
	
	// ---------------
	// GET
	// ---------------
	
	@Test
	public void recuperer_un_potager_par_son_id() throws DaoPotagerSuppressionException, DaoPotagerGetException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException {
		
		potager = new Potager("Potager a recupérer", 100, 100, "13006", proprietaire);
		potager = service.ajouterPotager(potager);
		
		Potager resultPotager = service.getPotager( potager.getIdPotager() );
		
		assertTrue("Le potager doit avoir le même id", resultPotager.getIdPotager() == potager.getIdPotager() );
		assertTrue("Le potager doit avoir le nom: Potager a recupérer", resultPotager.getNom().equals("Potager a recupérer") );
				
	}
	
	@Test(expected = DaoPotagerGetException.class)
	public void recuperer_un_potager_qui_n_existe_pas() throws DaoPotagerSuppressionException, DaoPotagerGetException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException {
		
		potager = new Potager("Potager a recupérer", 100, 100, "13006", proprietaire);
		potager = service.ajouterPotager(potager);
		
		Potager resultPotager = service.getPotager( -1 );
		
	}
	
	// ---------------
	// LISTER
	// ---------------
	
	@Test
	public void lister_tout_les_potagers() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerQueryException {
		
		potager = service.ajouterPotager(new Potager("Potager a lister 1", 100, 100, "13006", proprietaire) );
		potager = service.ajouterPotager(new Potager("Potager a lister 2", 100, 100, "13006", proprietaire) );
		
		ArrayList<Potager> potagers = (ArrayList<Potager>) service.listerPotager();
		assertTrue("La liste de potagers doit avoir au moins 2 potagers", potagers.size() >= 2);
	}
	
	@Test
	public void lister_tout_les_potagers_d_un_jardinier() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerQueryException {
		
		Jardinier autreJardinier = new Jardinier();
		autreJardinier.setNom("Autre jardinier");
		
		potager = service.ajouterPotager(new Potager("Potager a lister 1", 100, 100, "13006", proprietaire) );
		potager = service.ajouterPotager(new Potager("Potager a lister 2", 100, 100, "13006", autreJardinier) );
		
		ArrayList<Potager> potagers = (ArrayList<Potager>) service.listerPotager(potager.getProprietaire());
		System.out.println(potagers.size());
		assertTrue("L'autre jardinier n'a qu'un seul potager", potagers.size() == 1);
	}
	
	@Test
	public void lister_tout_les_potagers_par_codePostal() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerQueryException {
				
		potager = service.ajouterPotager(new Potager("Potager a lister 1", 100, 100, "12345", proprietaire) );
		potager = service.ajouterPotager(new Potager("Potager a lister 2", 100, 100, "12345", proprietaire) );
		
		ArrayList<Potager> potagers = (ArrayList<Potager>) service.listerPotager("12345");
		ArrayList<Potager> potagersVide = (ArrayList<Potager>) service.listerPotager("00000");
		
		assertTrue("Il y a 2 potagers avec le code postal 12345", potagers.size() == 2);
		assertTrue("Il n'y a aucun potager avec le code postal 00000", potagersVide.size() == 0);
	}
	
	

}
