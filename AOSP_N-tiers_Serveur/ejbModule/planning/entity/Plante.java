package planning.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import commun.config.Parametres;
import planning.util.Parametre;

@Entity
@Table(name = Parametres.bddPrefix + Parametres.bddSeparator + Parametre.NOM_TABLE_PLANTE + Parametres.bddSuffix)
public class Plante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idPlante", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "planteSequence")
	@SequenceGenerator(name = "planteSequence", sequenceName = "plante_sequence",
	initialValue = 1, allocationSize = 30)
	private int idPlante;
	
	@Transient
	List<Evenement> evenements = new ArrayList<Evenement>();

}
