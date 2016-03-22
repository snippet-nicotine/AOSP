package planning.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Version;

/**
 * A titre d'essai...
 * @author Didier
 *
 */
@Embeddable
public class Nutrition implements Serializable {

	@Version
	private static final long serialVersionUID = 1L;
	
	
	private int n;
	private int p;
	private int k;
	
	public Nutrition() {
		super();
	}

	public Nutrition(int n, int p, int k) {
		super();
		this.n = n;
		this.p = p;
		this.k = k;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	@Override
	public String toString() {
		return "Nutrition [n=" + n + ", p=" + p + ", k=" + k + "]";
	}
	
	
}
