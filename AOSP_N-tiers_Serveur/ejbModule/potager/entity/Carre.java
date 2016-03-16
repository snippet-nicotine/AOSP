package potager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aosp_carre")
public class Carre implements Serializable{

	private static final long serialVersionUID = 8695011214229733217L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCarre;
	private int x;
	private int y;
	
	@ManyToOne
	private Potager potager;
	
	public Carre(){
		
	}
	
	public Carre(Potager potager, int x, int y){
		this.x = x;
		this.y = y;
		this.potager = potager;
	}

	public int getIdCarre() {
		return idCarre;
	}

	public void setIdCarre(int idCarre) {
		this.idCarre = idCarre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
