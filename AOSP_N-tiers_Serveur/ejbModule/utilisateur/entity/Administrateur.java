package utilisateur.entity;



import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aosp_administrateur")
public class Administrateur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();		
	}

	
	public Administrateur(EtatCivil etatCivil, String mail, String motPasse, Collection<DroitUtilisateur> droits){
		super(etatCivil, mail, motPasse, droits);
		
	}


	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
