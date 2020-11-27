package fr.annuaire5000.IHM;

import fr.annuaire5000.Model.Etudiant;
import javafx.scene.control.Label;


public class ActionButtonAjouter {

	public static void Ajouter(LeftGridPane leftGridPane, RightVBoxTableViews rightVBox) {

		Label lblerreur = new Label("");
		//leftGridPane.getBtnBox().add;
		
		leftGridPane.getBtnAjouter().setOnAction(q ->
		{ 

			if( !leftGridPane.getTfNom().getText().isEmpty()&&!leftGridPane.getTfPrenom().getText().isEmpty()
					&&!leftGridPane.getTfAnnee().getText().isEmpty()&&!leftGridPane.getTfPromotion().getText().isEmpty()
					&&!leftGridPane.getTfAnnee().getText().isEmpty()) {
				ActionButtonAjouter.Ajouter(leftGridPane, rightVBox);
				lblerreur.setText("");
			
			}else {
				lblerreur.setText("Veuillez remplir tout les champs SVP");
				
			}
		});

		String nom = leftGridPane.getTfNom().getText();
		String prenom = leftGridPane.getTfPrenom().getText();
		String departement = leftGridPane.getTfDepartement().getText();
		String promotion = leftGridPane.getTfPromotion().getText();
		String annee = leftGridPane.getTfAnnee().getText();
		Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);

			rightVBox.getObservableEtudiants().add(etudiant);
	}

	
}

