package utilisateur.entity;

import java.util.Collection;

public class Specialiste extends AbstractJardinier{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private Specialite specialite;

	public Specialiste(EtatCivil etatCivil, String mail, String motPasse, 
			Collection<DroitUtilisateur> listeDroits, String codePostal, Specialite specialite){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setListeDroits(listeDroits);
		setCodePostal(codePostal);
		setSpecialite(specialite);
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return super.toString()+" Specialiste [specialite=" + specialite + "]";
	}

}
