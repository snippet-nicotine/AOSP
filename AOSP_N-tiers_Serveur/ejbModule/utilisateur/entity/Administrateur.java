package utilisateur.entity;




import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;

import utilisateur.util.Param;

/**
 * Entit� qui impl�ment les administrateurs
 * @author Guillaume
 *
 */
@Entity
@Table(name = Param.TABLE_AOSP_ADMINISTRATEUR)
public class Administrateur extends Utilisateur {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par d�faut
	 */
	public Administrateur() {
		super();		
	}

	/**
	 * Constructeur qui initialise toutes les propri�ts de l'administrateur sauf l'id qui sera g�n�r�e automatiquemnt
	 * @param etatCivil �tat civil de l'administrateur
	 * @param mail mail de l'administrateur
	 * @param motPasse mot de passe de l'administrateur
	 * @param listeDroits liste des droits de l'administrateur
	 */
	public Administrateur(EtatCivil etatCivil, String mail, String motPasse, Collection<DroitUtilisateur> droits){
		super(etatCivil, mail, motPasse, droits);
		
	}

	// toString
	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
