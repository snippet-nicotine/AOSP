package utilisateur.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import potager.entity.Potager;

@Entity
@Table(name="aosp_jardinier")
public class Jardinier extends AbstractJardinier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="proprietaire", cascade = {CascadeType.ALL} )
	private List<Potager> potagers;
	
	// Ajouté par nicolas.
	@ManyToMany(mappedBy="visiteurs", fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;
	
	
	public String getNom(){
		return super.getEtatCivil().getNom();
	}
	
	public void setNom(String nom){
		EtatCivil etatCivil = new EtatCivil();
		etatCivil.setNom(nom);
		super.setEtatCivil(etatCivil);
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
	


}