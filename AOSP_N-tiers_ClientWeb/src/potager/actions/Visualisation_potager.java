package potager.actions;

import commun.actions.GestionAction;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;
import potager.service.exception.DaoPotagerGetException;

public class Visualisation_potager extends InitPotagerAction{

	private static final long serialVersionUID = 1L;

	private int idPotager;
	private final String TITRE = "Visualisation d'un potager";
	
	private Potager potager;
	private ServiceGestionPotager serviceGestionpotager;
	
	@Override
	protected boolean init() {
		
		boolean isValid = super.init();
		
		if( isValid ){
			
			try {
				
				potager = serviceGestionPotager.getPotager(idPotager);
				
			} catch (DaoPotagerGetException e) {
				
				addActionError( e.getMessage() );
				isValid = false;
				
			}
			
		}
		
		return isValid;
	}
	
	@Override
	public String execute(){
		
		String result = ERROR;
		
		if( init() ){
			result = SUCCESS;
		}
			
		return result;
	}
	
	public int getIdPotager() {
		return idPotager;
	}

	public void setIdPotager(int idPotager) {
		this.idPotager = idPotager;
	}

	public Potager getPotager() {
		return potager;
	}

	public void setPotager(Potager potager) {
		this.potager = potager;
	}

	public ServiceGestionPotager getServiceGestionpotager() {
		return serviceGestionpotager;
	}

	public void setServiceGestionpotager(ServiceGestionPotager serviceGestionpotager) {
		this.serviceGestionpotager = serviceGestionpotager;
	}
	
}
