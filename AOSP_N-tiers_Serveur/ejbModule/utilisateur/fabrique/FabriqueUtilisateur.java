package utilisateur.fabrique;

import java.util.Collection;


import utilisateur.clientServeur.TypeUtilisateur;
import utilisateur.entity.Administrateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.EtatCivil;
import utilisateur.entity.Jardinier;
import utilisateur.entity.Specialiste;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;

public class FabriqueUtilisateur {
	
	public static Utilisateur fabriqueUtilisateur(TypeUtilisateur typeUtilisateur, EtatCivil etatCivil, String mail, String motPasse,
			Collection<DroitUtilisateur> droits, String codePostal, Specialite specialite){
		Utilisateur utilisateur =null;
		
		switch(typeUtilisateur){
		case administrateur : utilisateur = new Administrateur(etatCivil, mail,motPasse, droits); break;
		case jardinier : utilisateur = new Jardinier(etatCivil, mail,motPasse, droits, codePostal); break;
		case specialiste : utilisateur= new Specialiste(etatCivil, mail, motPasse,
				droits, codePostal, specialite);
		}
		
		return utilisateur;
	}

}
