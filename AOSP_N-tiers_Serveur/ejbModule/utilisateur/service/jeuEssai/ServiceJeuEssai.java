package utilisateur.service.jeuEssai;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.dao.IFacadeDaoUtilisateur;

@Stateless
@LocalBean
public class ServiceJeuEssai {
	
	@EJB
	IFacadeDaoUtilisateur daoJeuEssai;
	
	
	public void creerJeuEssai(){
		daoJeuEssai.creerJeuEssai();
	}

}
