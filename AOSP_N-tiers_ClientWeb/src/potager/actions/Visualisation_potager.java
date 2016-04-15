package potager.actions;

import commun.actions.AospAction;
import potager.clientServeur.ServiceGestionPotager;
import potager.entity.Potager;

public class Visualisation_potager extends PotagerAction{

	private static final long serialVersionUID = 1L;

	private int idPotager;
	private Potager potager;
	private ServiceGestionPotager serviceGestionpotager;
	
	@Override
	public String execute(){
		
		String result = ERROR;
		
		if( init() ){
			potager = serviceGestionPotager.getPotager();
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
