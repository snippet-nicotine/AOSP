package utilisateur.entity;

import java.util.List;

import potager.entity.Potager;

public class Jardinier extends AbstractJardinier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Ajouté par nicolas
	private List<Potager> potagers;
	
	// Ajouté par nicolas.
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

	}
	


}