package planning.appli;

import java.util.List;

import javax.naming.InitialContext;

import commun.config.Parametres;
import planning.clientServeur.IService;
import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.ServiceException;

/**
 * Servlet pour le CU Afficher le catalogue
 *
 */
public class GestionPlanning {

	private IService 		service;


	public List<Planning> listePlanning(int idCarre) {
		init();
		List<Planning> liste = null;
		try {
			System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			liste = service.rechercherAllPlanning(idCarre);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	
	public List<Evenement> listeEvenement(int idPlanning) {
		init();
		List<Evenement> liste = null;
		try {
			liste = service.rechercherAllEvenement(idPlanning);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	public List<Follower> listFollower() {
		init();
		List<Follower> liste = null;
		return liste;
	}
	

	
	public void init() {
		// initialisation de l'acces au service EJB
		InitialContext initialContext;
		try {
			initialContext 		= new InitialContext();
			service = (IService) initialContext.lookup(Parametres.EJB_SERVICE_GESTION_PLANNING);																   
		}
		catch (Exception e) {
			System.out.println("***DM GestionPlanning-init :  erreur link EJB");
			System.out.println(e);
		}
    }
}
