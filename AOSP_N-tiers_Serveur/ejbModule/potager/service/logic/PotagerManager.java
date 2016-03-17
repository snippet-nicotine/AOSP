package potager.service.logic;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import potager.config.Parametres;
import potager.entity.Carre;
import potager.entity.Potager;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import potager.util.Validateur;
import utilisateur.entity.Jardinier;

@Stateless
@LocalBean
public class PotagerManager {
	
	public Potager getPotager(){
		return new Potager();
	}
		
	public Potager getPotager(String nom, int longueur, int largeur, String codePostal, Jardinier proprietaire) throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException{
		
		Potager potager = new Potager();
		potager.setNom(nom);
		potager.setCodePostal(codePostal);
		potager.setProprietaire(proprietaire);
		
		buildPotager(potager);
		
		return potager;
		
	}
	
	public void validerPotager(Potager potager) throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException{
		
		// Control de la validité de données
		// RG 19.1 Nom, codePostal et le jardinier sont obligatoire
		
		if( potager.getNom().isEmpty() )                              throw new NomPotagerException("Le nom du potager doit être renseigné.");
		if( ! Validateur.checkCodePostal(potager.getCodePostal() ) )  throw new CPPotagerException("Le code postal n'est pas valide. (ex: 13100, 65200, 13000, ...)");
		if( potager.getProprietaire() == null )                       throw new ProprietairePotagerException("Le potager a obligatoirement un propriétaire.");
		
		// RG 19.3 La largeur et la longueur du potager >= 50cm
		if( potager.getLongueur() < Parametres.TAILLE_CARRE ) throw new DimensionPotagerException("La longueur doit être supérieur à " + Parametres.TAILLE_CARRE + "cm");
		if( potager.getLargeur()  < Parametres.TAILLE_CARRE ) throw new DimensionPotagerException("La largeur doit être supérieur à " + Parametres.TAILLE_CARRE + "cm");
					
	}
	
	public void buildPotager(Potager potager) throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException{	
		
		setDimension(potager);
		validerPotager(potager);

	}
	
	private void setDimension(Potager potager){
		setDimension(potager, potager.getLargeur(), potager.getLongueur() );
	}

	private void setDimension(Potager potager, int largeur, int longueur) {
		
		int nbCarresX = longueur/Parametres.TAILLE_CARRE;
		int nbCarresY = largeur/Parametres.TAILLE_CARRE;
		
		potager.setNbCarresX(nbCarresX);
		potager.setNbCarresY(nbCarresY);
		
		potager.setCarres( new ArrayList<Carre>() );
		
		for(int y=0; y<nbCarresY; y++){
			
			for(int x=0 ; x<nbCarresX; x++){
				
				Carre carre = new Carre(potager, x, y);
				potager.getCarres().add(carre);
				
			}
			
		}		
		
	}

}
