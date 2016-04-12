package utilisateur.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import potager.entity.Potager;

@Entity
@Table(name="aosp_jardinier")
public class Jardinier extends AbstractJardinier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManyToMany(mappedBy="visiteurs", 	fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;	
	
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	


}