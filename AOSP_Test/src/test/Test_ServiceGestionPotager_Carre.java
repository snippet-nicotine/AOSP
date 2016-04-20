package test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import potager.clientServeur.ServiceGestionPotager;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.entity.Carre;
import utilisateur.entity.Jardinier;

public class Test_ServiceGestionPotager_Carre {

	private static ServiceGestionPotager service;

	@BeforeClass
	public static void setUpBeforeClass() throws NamingException {
		
		Context context = new InitialContext();
		service  = (ServiceGestionPotager) context.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager");
		
	}
	
	@Test
	public void creer_carre_nominal() throws DaoPotagerAjoutException {
		Carre carre = new Carre();
		carre.setX(1);
		carre.setY(1);
		service.creerCarre(carre);
	}

}
