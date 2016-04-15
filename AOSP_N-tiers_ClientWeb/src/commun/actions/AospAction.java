package commun.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AospAction extends ActionSupport{
	
	protected String titre = "Aosp";

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


}
