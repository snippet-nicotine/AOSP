package potager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utilisateur.entity.Jardinier;

@Entity
@Table(name="aosp_potager_jardinier")
public class PotagerJardinier implements Serializable{

	private static final long serialVersionUID = 1L;

	@Embeddable
	public static class Id implements Serializable{

		private static final long serialVersionUID = 1L;

		@Column(name="id_potager")
		private int idPotager;
		
		@Column(name="id_jardinier")
		private int idJardinier;
		
		

		public int getIdPotager() {
			return idPotager;
		}

		public Id() {
			super();
		}

		public void setIdPotager(int idPotager) {
			this.idPotager = idPotager;
		}

		public int getIdJardinier() {
			return idJardinier;
		}

		public void setIdJardinier(int idJardinier) {
			this.idJardinier = idJardinier;
		}

		@Override
		public String toString() {
			return "Id [idPotager=" + idPotager + ", idJardinier=" + idJardinier + "]";
		}
		
	}
	
	@EmbeddedId
	private Id id = new Id();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_potager", insertable=false, updatable=false)
	private Potager potager;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_jardinier", insertable=false, updatable=false)
	private Jardinier jardinier;

	public PotagerJardinier(){
		getId().setIdPotager(   potager.getIdPotager() );
		getId().setIdJardinier( jardinier.getIdJardinier() );
	
		setPotager(potager);
		setJardinier(jardinier);
		
		potager.getVisiteurs().add(this);
		jardinier.getPotagerPartages().add(this);

	}
	
	
	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}

	public Jardinier getJardinier() {
		return jardinier;
	}

	public void setJardinier(Jardinier jardinier) {
		this.jardinier = jardinier;
	}
	
	
}
