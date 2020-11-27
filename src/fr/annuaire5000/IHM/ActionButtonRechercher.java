package fr.annuaire5000.IHM;

import fr.annuaire5000.Model.Etudiant;

public class ActionButtonRechercher {
	
	public static void Rechercher(LeftGridPane leftGridPane, RightVBoxTableViews rightVBox) {
		String nom = leftGridPane.getTfNom().getText();
		String prenom = leftGridPane.getTfPrenom().getText();
		String departement = leftGridPane.getTfDepartement().getText();
		String promotion = leftGridPane.getTfPromotion().getText();
		String annee = leftGridPane.getTfAnnee().getText();
		Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
		System.out.println("Rechercher fonctionne");
		
	}

}
