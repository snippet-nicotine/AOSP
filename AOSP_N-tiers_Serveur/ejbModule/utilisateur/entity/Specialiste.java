package utilisateur.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aosp_specialiste")
public class Specialiste extends AbstractJardinier{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Specialite getSpecialite() {
		return specialite;
	}


	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}


	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpecialite", nullable = true)
	private Specialite specialite;
	
	

}
