package test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import potager.clientServeur.ServiceGestionPotager;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;


public class TestServicePotager {

	private static ServiceGestionPotager service;
	
	@BeforeClass
	public static void init() throws NamingException {
		
		Context context = new InitialContext();
		service  = (ServiceGestionPotager) context.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager");
	
	}
	
	@Test
	public void testAjout_d_un_potager_standard() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException, DaoPotagerQueryException{
		
		fail("aie aie aie");
		
		/*
		Jardinier utilisateur = new Jardinier();
		utilisateur.setNom("utilisateur test)");
		
		//Nb de potagers avant l'ajout
		int nbPotagers = service.listerPotager().size();
		Potager potager = new Potager("Potager test 1", 100, 100, "13006", utilisateur);
		potager = service.ajouterPotager(potager);
				
		//assertTrue("Le potager doit avoir un Id",     potager.getIdPotager() > 0 );
		//assertTrue("Le nombre de carrés doit être 4", potager.getCarres().size() == 4 );
		*/
	}

}
