package utilisateur.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import utilisateur.exception.CodePostalNullException;

/**
 * Classe implémentant un service de vérification du code postal
 * @author Guillaume
 *
 */
@Stateless
@LocalBean
public class VerifCodePostal {

	/**
	 * Méthode qui vérifie la validité d'un code postal. Un code postal doit être composé de 5 chiffres
	 * @param code code postal à vérifier
	 * @return true si le code est valide, false sinon
	 * @throws CodePostalNullException 
	 */
	public static boolean verifCode(String code) throws CodePostalNullException{
		boolean retour=true;
		
		if (code==null) throw new CodePostalNullException("Code postal null !");
		else if(code.trim().length()!=5) retour=false;
		if(retour){
			// on essaye de parser en int le code. Permet de vérifier que le code est un nombre entier
			try{
				Integer.parseInt(code);			 
			}
			catch(NumberFormatException e){
				// si le parsing en int n'a pas fonctionné, retour = false. Autrement le code est bon
				retour = false; 
			}
		}

		return retour;
	}
}
