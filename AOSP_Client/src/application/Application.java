package application;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DaoPotagerAjoutException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public class Application {
	
	public static ServiceGestionPotager serviceGestionPotager;
	
	public static void main(String[] args) {
		
		InitialContext initialContext;


		try {
			initialContext = new InitialContext();
			serviceGestionPotager = (ServiceGestionPotager) initialContext.lookup( "ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager" );
			
			Jardinier proprio = new Jardinier();
			proprio.setNom("Proprio");
			
			Jardinier visiteur1 = new Jardinier();
			visiteur1.setNom("Visiteur 1");
			
			Jardinier visiteur2 = new Jardinier();
			visiteur2.setNom("Visiteur 2");
						
			Potager potager = new Potager();
			potager.setNom("Mon potager");
			potager.setLargeur(150);
			potager.setLongueur(150);
			potager.setCodePostal("13006");
			potager.setProprietaire(proprio);
				
			//potager.addVisiteur(visiteur1);
			
			serviceGestionPotager.ajouterPotager(potager);
			
			
		} catch (NamingException | NomPotagerException | CPPotagerException | ProprietairePotagerException | DimensionPotagerException | DaoPotagerAjoutException e) {
			e.printStackTrace();
		}
		
	}

}
