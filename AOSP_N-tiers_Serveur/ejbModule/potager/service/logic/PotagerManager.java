package potager.service.logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import potager.config.Parametres;
import potager.entity.Carre;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;

@Stateless
@LocalBean
public class PotagerManager {
	
	public Potager getPotager(){
		return new Potager();
	}
		
	public Potager getPotager(String nom, int longueur, int largeur, String codePostal, Jardinier proprietaire){
		
		Potager potager = new Potager();
		potager.setNom(nom);
		potager.setCodePostal(codePostal);
		potager.setProprietaire(proprietaire);
		this.setDimension(potager, largeur, longueur);

		return potager;
				
	}
	
	public void buildPotager(Potager potager){		
		setDimension(potager);		
	}
	
	private void setDimension(Potager potager){
		setDimension(potager, potager.getLargeur(), potager.getLongueur() );
	}

	private void setDimension(Potager potager, int largeur, int longueur) {
		
		int nbCarresX = longueur/Parametres.TAILLE_CARRE;
		int nbCarresY = largeur/Parametres.TAILLE_CARRE;
		
		System.out.println("nbCarresX: " + nbCarresX);
		System.out.println("nbCarresY: " + nbCarresY);
		
		for(int x=0; x<nbCarresX; x++){
			
			for(int y=0 ; y<nbCarresY; y++){
				
				Carre carre = new Carre(potager, x, y);
				potager.getCarres().add(carre);
				
			}
			
		}		
		
	}

}
