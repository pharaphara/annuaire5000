package fr.annuaire5000.IHM;

import java.io.File;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;


public class ActionButtonAjouter {

	public static void Ajouter(LeftGridPane leftGridPane, RightVBoxTableViews rightVBox) {

		File file = new File("./arbreTest.bin");
		String nom = leftGridPane.getTfNom().getText();
		String prenom = leftGridPane.getTfPrenom().getText();
		String departement = leftGridPane.getTfDepartement().getText();
		String promotion = leftGridPane.getTfPromotion().getText();
		String annee = leftGridPane.getTfAnnee().getText();
		
		Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
		
			if( !nom.isEmpty() && !prenom.isEmpty() && !departement.isEmpty()&& !promotion.isEmpty()
					&& !annee.isEmpty()) {
				leftGridPane.getLblErreur().setVisible(false);
				rightVBox.getObservableEtudiants().add(etudiant);
			
		NoeudDao.inserer(etudiant, file);	
		leftGridPane.getTfNom().setText("");
		leftGridPane.getTfPrenom().setText("");
		leftGridPane.getTfDepartement().setText("");
		leftGridPane.getTfPromotion().setText("");
		leftGridPane.getTfAnnee().setText("");	
			}else {
				
				leftGridPane.getLblErreur().setVisible(true);
			}
		
	}

	
}

