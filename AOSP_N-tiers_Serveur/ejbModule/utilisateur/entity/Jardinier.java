package utilisateur.entity;

import java.util.ArrayList;
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

	// Ajouté par nicolas
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.EAGER)
	private List<Potager> potagers;
	
	// Ajouté par nicolas.
	@ManyToMany(mappedBy="visiteurs", fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;

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

		super.clean();
		
		if(potagers != null){
			setPotagers( new ArrayList<Potager>(potagers) );			
		}
		else{
			setPotagers( new ArrayList<Potager>() );
		}
		
		if(potagerPartages != null){
			setPotagerPartages( new ArrayList<Potager>(potagerPartages) );			
		} 
		else {
			setPotagerPartages( new ArrayList<Potager>() );
		}
				
	}
	


}