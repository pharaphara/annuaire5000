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

			String[] criteres = new String[5];
			criteres[0] = leftGridPane.getTfNom().getText();
			criteres[1] = leftGridPane.getTfPrenom().getText();
			criteres[2] = leftGridPane.getTfDepartement().getText();
			criteres[3] = leftGridPane.getTfPromotion().getText();
			criteres[4] = leftGridPane.getTfAnnee().getText();
			
			for (String string : criteres) {
				System.out.println(string);
			}
			
				if( criteres[0].isEmpty() && criteres[1].isEmpty() && criteres[2].isEmpty()&& criteres[3].isEmpty()
						&& criteres[4].isEmpty()) {
					leftGridPane.getLblErreur().setVisible(false);
					rightVBox.getObservableEtudiants().add(criteres);
				
				}else {
					
					leftGridPane.getLblErreur().setVisible(true);
				}
			
		}
	}




