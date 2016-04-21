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

	/**
	 * Méthode permettant de remplir une collection de Droit utilisateur avec un tableau de String contenant les id (en String)
	 *  des droits
	 * @param tab tableau contenant les id (en String) des droits à créer
	 * @return la Collection de droits obtenue à partir du tableau tab
	 */
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
	
	/**
	 * Méthode permettant de remplir un tableau de String avec les id contenus dans une List de droits
	 * @param liste liste de droit utilisateur
	 * @return le tableau de String contenant les id de la liste de droits
	 */
	public String[] listeToTab(Collection<DroitUtilisateur> liste){
		String[] tab = null;
		int i=0;
		
		// on est obligé d'utiliser un compteur (i) puisqu'une Collection ne possede pas de méthode get(i)
		if(liste!=null){
			tab= new String[liste.size()];
			for(DroitUtilisateur droit : liste){
			// Méthode rapide pour transformer un int en String
			tab[i]=""+droit.getIdDroit();
			i++;
			}
			
					
		}
		return tab;
	}

}
