package utilisateur.service.lister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.dao.IFacadeDaoUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;


@Stateless
@LocalBean
public class ServiceListerUtilisateur {

	@EJB
	private IFacadeDaoUtilisateur daoLister;
	
	

	public List<Utilisateur> listerUtilisateurParId(){
		return daoLister.listerUtilisateurParId();
	}


	public List<Specialite> getListeSpecialite(){
		return daoLister.getListeSpecialite();
	}

	public List<DroitUtilisateur> getListeDroit(){
		return daoLister.getListeDroit();
	}

	public Collection<DroitUtilisateur> tabToListe(String[] tab){
		Collection<DroitUtilisateur> liste = new ArrayList<DroitUtilisateur> ();
		DroitUtilisateur droitUtilisateur = null;
		int intId;
		for(int i=0;i<tab.length;i++) {
			intId = Integer.parseInt(tab[i]);
			droitUtilisateur = daoLister.rechercherParIdDroit(intId);
			liste.add(droitUtilisateur);
		}
		return liste;
	}

}
