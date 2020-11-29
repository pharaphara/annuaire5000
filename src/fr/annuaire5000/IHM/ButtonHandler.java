package fr.annuaire5000.IHM;

import java.io.File;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonHandler implements EventHandler<ActionEvent>{
	
	private MainPanel root;
	
	public ButtonHandler() {
		super();
	}
	public ButtonHandler(MainPanel root) {
		super();
		this.root = root;
	} 
	 

	

	@Override
	public void handle(ActionEvent event) {
		
		System.out.println(event.getSource());
		String eventString = event.getSource().toString();
		System.out.println(eventString);
		
		if (eventString.contains("Ajouter")) {
			ajouter();
		}
		
		
		
	}
	private void ajouter() {
		System.out.println("dans la méthode ajouter");
		File file = new File("./arbreTest.bin");
		String nom = root.getLeftVBox().getTfNom().getText();
		String prenom = root.getLeftVBox().getTfPrenom().getText();
		String departement = root.getLeftVBox().getTfDepartement().getText();
		String promotion = root.getLeftVBox().getTfPromotion().getText();
		String annee = root.getLeftVBox().getTfAnnee().getText();
		
		Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
		
			if( !nom.isEmpty() && !prenom.isEmpty() && !departement.isEmpty()&& !promotion.isEmpty()
					&& !annee.isEmpty()) {
				root.getLeftVBox().getLblErreur().setVisible(false);
				root.getRightVBox().getObservableEtudiants().add(0, etudiant);//permet d'ajouter l'étudiant en haut du tableau
			
		NoeudDao.inserer(etudiant);	
		root.getLeftVBox().getTfNom().setText("");
		root.getLeftVBox().getTfPrenom().setText("");
		root.getLeftVBox().getTfDepartement().setText("");
		root.getLeftVBox().getTfPromotion().setText("");
		root.getLeftVBox().getTfAnnee().setText("");	
			}else {
				
				root.getLeftVBox().getLblErreur().setVisible(true);
			}
	}
	
		
	}


