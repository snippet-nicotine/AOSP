package utilisateur.webApp;

public class CRUDDroits extends MyActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	public String affiche(){		
		return SUCCESS;
	}
	
	public String creation(){
		System.out.println("creation droits");
		return SUCCESS;
	}
	public String modification(){	
		System.out.println("modification droits");

		return SUCCESS;
	}
	public String suppression(){
		System.out.println("suppression droits");

		return SUCCESS;
	}
	public String rechercherParId(){
		System.out.println("rechercherParId droits");

		return SUCCESS;
	}
	
	public String remplir(){
		System.out.println("remplir droits");

		return SUCCESS;
	}

}
