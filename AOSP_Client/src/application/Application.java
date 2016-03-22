package application;

import javax.naming.InitialContext;

import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
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
			Potager potager = new Potager();
			potager.setNom("Mon potager");
			potager.setLargeur(150);
			potager.setLongueur(150);
			potager.setCodePostal("13006");
			potager.setProprietaire(proprio);				
		
			Jardinier visiteur1 = new Jardinier();
			visiteur1.setNom("Visiteur 1");
			
			Jardinier visiteur2 = new Jardinier();
			visiteur2.setNom("Visiteur 2");
			
			potager.addVisiteur(visiteur1);
			potager.addVisiteur(visiteur2);
			
			Potager newPotager = serviceGestionPotager.ajouterPotager(potager);
			
			for(Jardinier visiteur : newPotager.getVisiteurs() ){
				System.out.println(visiteur.getIdJardinier());
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
