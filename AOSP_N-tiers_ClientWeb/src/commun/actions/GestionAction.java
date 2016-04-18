package commun.actions;

import com.opensymphony.xwork2.ActionSupport;

public abstract class GestionAction extends ActionSupport{
	
	protected final String TITRE   = "Aosp";
	public final String VISUALISER = "visualiser";
	
	/*
	 * Initialise l'action
	 * @return false en cas d'erreur
	 */
	protected abstract boolean init();
	

	public String getTitre() {
		return TITRE;
	}


}
