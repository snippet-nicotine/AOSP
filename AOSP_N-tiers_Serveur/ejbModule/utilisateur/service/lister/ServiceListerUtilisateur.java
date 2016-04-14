package utilisateur.service.lister;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.dao.IFacadeDaoUtilisateur;
import utilisateur.entity.Utilisateur;


@Stateless
@LocalBean
public class ServiceListerUtilisateur {
	
	@EJB
	private IFacadeDaoUtilisateur daoLister;
	
	
	public List<Utilisateur> listerUtilisateurParId(){
		return daoLister.listerUtilisateurParId();
	}

}
