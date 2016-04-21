package utilisateur.entity;

import java.util.Collection;
import java.util.List;
import potager.entity.Potager;


public class Jardinier extends AbstractJardinier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List<Potager> potagers;


	private List<Potager> potagerPartages;




	public Jardinier() {
		super();
	}


	public Jardinier(EtatCivil etatCivil, String mail, String motPasse,
			Collection<DroitUtilisateur> listeDroits, String codePostal){
		setEtatCivil(etatCivil);
		setMail(mail);
		setMotPasse(motPasse);
		setListeDroits(listeDroits);
		setCodePostal(codePostal);
	}


	public String getNom(){
		return "test";
	}

	public void setNom(){

	}

	public List<Potager> getPotagers() {
		return potagers;
	}

	public void setPotagers(List<Potager> potagers) {
		this.potagers = potagers;
	}

	public List<Potager> getPotagerPartages() {
		return potagerPartages;
	}

	public void setPotagerPartages(List<Potager> potagerPartages) {
		this.potagerPartages = potagerPartages;
	}

	public void clean() {
		// TODO Auto-generated method stub		
	}

	@Override
	public String toString() {
		return super.toString()+" Jardinier [potagers=" + potagers + ", potagerPartages=" + potagerPartages + "]";
	}

}