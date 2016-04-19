package utilisateur.entity;



import java.util.Collection;


public class Administrateur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
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
