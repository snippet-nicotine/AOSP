package utilisateur.entity;



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

	
	public Administrateur(EtatCivil etatCivil, String mail, String motPasse){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
	}
	
	

}
