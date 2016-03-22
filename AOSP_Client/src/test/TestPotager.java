package test;

import static org.junit.Assert.assertThat;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.hamcrest.core.IsNot;

import org.junit.BeforeClass;
import org.junit.Test;

import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DaoPotagerAjoutException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import utilisateur.entity.Jardinier;

public class TestPotager {
	
	private static ServiceGestionPotager serviceGestionPotager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Context context        = new InitialContext();
		serviceGestionPotager  = (ServiceGestionPotager) context.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager");
	}
	

	@Test
	public void testAjouterPotager() throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException {
		
		Potager potager = new Potager("Potager test", 150, 150, "13006", new Jardinier("Jardinier test") );		
		potager = serviceGestionPotager.ajouterPotager(potager);
		System.out.println(potager.getIdPotager());
		assertThat(potager.getIdPotager() , IsNot.not(0) );
		
	}
		

}
