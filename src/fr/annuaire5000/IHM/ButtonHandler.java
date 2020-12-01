package fr.annuaire5000.IHM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orb.ParserDataFactory;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.EtudiantDAO;
import fr.annuaire5000.Model.NoeudDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


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

		String eventString = event.getSource().toString();
		if (eventString.contains("Ajouter")) {
			ajouter();
		}
		if (eventString.contains("Importer")) {
			importer();
		}
		if (eventString.contains("Rechercher")) {
			recherche();
		}

		if (eventString.contains("Help")) {
			help();
		}
		if (eventString.contains("Exporter")) {
			exporter();
			
		}
	}
	private void ajouter() {
		boolean tropLong=false;
		
		
		String[] textFields = new String[5];	
		textFields[0]=root.getLeftVBox().getTfNom().getText();
		textFields[1]=root.getLeftVBox().getTfPrenom().getText();
		textFields[2]=root.getLeftVBox().getTfDepartement().getText()	;	
		textFields[3]=root.getLeftVBox().getTfPromotion().getText();
		textFields[4]=root.getLeftVBox().getTfAnnee().getText();
		tropLong=verificationLongeur(textFields);
		if(tropLong) {
			return;
		}
		System.out.println(tropLong);
		root.getLeftVBox().getLblTailleMax0().setVisible(false);
		root.getLeftVBox().getLblTailleMax1().setVisible(false);
		root.getLeftVBox().getLblTailleMax2().setVisible(false);
		root.getLeftVBox().getLblTailleMax3().setVisible(false);
		root.getLeftVBox().getLblTailleMax4().setVisible(false);

		
		
		if( !textFields[0].isEmpty() && !textFields[1].isEmpty() && !textFields[2].isEmpty()&& !textFields[3].isEmpty()
				&& !textFields[4].isEmpty()) {
			root.getLeftVBox().getLblErreur().setVisible(false);
			Etudiant etudiant = new Etudiant(textFields[0], textFields[1], textFields[2], textFields[3], textFields[4]);
			root.getRightVBox().getObservableEtudiants().add(0, etudiant);//permet d'ajouter l'étudiant en haut du tableau

			NoeudDao.ajouterEtudiant(etudiant);	
			root.getLeftVBox().getTfNom().setText("");
			root.getLeftVBox().getTfPrenom().setText("");
			root.getLeftVBox().getTfDepartement().setText("");
			root.getLeftVBox().getTfPromotion().setText("");
			root.getLeftVBox().getTfAnnee().setText("");	
		}else {

			root.getLeftVBox().getLblErreur().setVisible(true);
		}
	}


	private void importer () {
		FileChooser fileChooser = new FileChooser();
		File initDir = new File("C:/Users/formation/desktop");
		fileChooser.setInitialDirectory(initDir);

		File f = fileChooser.showOpenDialog(null);
		if(f != null) {
			EtudiantDAO importation = new EtudiantDAO();
			List<Etudiant> etudiants = importation.importExtern(f);
			NoeudDao.ajouterListEtudiant(etudiants); 
			etudiants= new ArrayList<Etudiant>();
			etudiants = NoeudDao.getAllOrdre();

			for (Etudiant etudiant : etudiants) {
				root.getRightVBox().getObservableEtudiants().add(etudiant);
			}
		}
	} 

	private void recherche() {
		boolean tropLong = false;
		System.out.println("dans rechercher");
		String[] textFields = new String[5];	
		textFields[0]=root.getLeftVBox().getTfNom().getText();
		textFields[1]=root.getLeftVBox().getTfPrenom().getText();
		textFields[2]=root.getLeftVBox().getTfDepartement().getText()	;	
		textFields[3]=root.getLeftVBox().getTfPromotion().getText();
		textFields[4]=root.getLeftVBox().getTfAnnee().getText();
		tropLong=verificationLongeur(textFields);
		if(tropLong) {
			return;
		}
		System.out.println("apres le if");
		root.getLeftVBox().getLblTailleMax0().setVisible(false);
		root.getLeftVBox().getLblTailleMax1().setVisible(false);
		root.getLeftVBox().getLblTailleMax2().setVisible(false);
		root.getLeftVBox().getLblTailleMax3().setVisible(false);
		root.getLeftVBox().getLblTailleMax4().setVisible(false);
		
		//pour mettre à null les TF non recherchés
		for (int i = 0; i < textFields.length; i++) {
			textFields[i]= (textFields[i].length()<1)? null:textFields[i];
		}
		for (String string : textFields) {
			System.out.println(string);
		}
		List<Etudiant> resultats = new ArrayList<Etudiant>();		
		resultats=NoeudDao.recherche(textFields);
		System.out.println("retour dans rechercher");
		root.getRightVBox().getObservableRecherche().clear();
		for (Etudiant etudiant : resultats) {
			System.out.println(etudiant);
			root.getRightVBox().getObservableRecherche().add(etudiant);
		}
		

	}

	private boolean verificationLongeur(String [] tab) {
		boolean tropLong=false;
		
		if(tab[0].length()>NoeudDao.structure[0]) {
			root.getLeftVBox().getLblTailleMax0().setVisible(true);
			tropLong = true;
		}else root.getLeftVBox().getLblTailleMax0().setVisible(false);
		if(tab[1].length()>NoeudDao.structure[1]) {
			root.getLeftVBox().getLblTailleMax1().setVisible(true);
			tropLong = true;
		}else root.getLeftVBox().getLblTailleMax1().setVisible(false);
		if(tab[2].length()>NoeudDao.structure[2]) {
			root.getLeftVBox().getLblTailleMax2().setVisible(true);
			tropLong = true;
		}else root.getLeftVBox().getLblTailleMax2().setVisible(false);
		if(tab[3].length()>NoeudDao.structure[3]) {
			root.getLeftVBox().getLblTailleMax3().setVisible(true);
			tropLong = true;
		}else root.getLeftVBox().getLblTailleMax3().setVisible(false);
		if(tab[4].length()>NoeudDao.structure[4]) {
			root.getLeftVBox().getLblTailleMax4().setVisible(true);
			tropLong = true;
		}else root.getLeftVBox().getLblTailleMax4().setVisible(false);
		return tropLong;
	}

	private void exporter() {
		 
	}
	
	
	private void help() {

		Stage popupwindow=new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Votre guide");


		VBox layout= new VBox(10);
		
		ImageView img2 = new ImageView(getClass().getResource("/ressource/image/eqlimg.png").toString());	
		Label lbl=new Label();
		lbl.setAlignment(Pos.CENTER);
		lbl.setPrefSize(500, 100);
		lbl.setGraphic(img2);	
		lbl.setContentDisplay(ContentDisplay.TOP);
		layout.getChildren().add(lbl);
		
		Label lblmessage1 = new Label("Bienvenue dans notre liste des stagiaires chez EQL.");
		lblmessage1.setAlignment(Pos.CENTER);
		lblmessage1.setPrefSize(500, 100);
		Label lblmessage2 = new Label("En tant qu'utilisateur vous pouvez créer un annuaire à partir du fichier stagiaires.txt\r\n"
				+ "\r\n"
				+ "En tant qu'utilisateur vous pouvez visualiser la liste des stagiaires par ordre alphabétique\r\n"
				+ "\r\n"
				+ "En tant qu'utilisateur vous pouvez ajouter un stagiaire à l'annuaire\r\n"
				+ "\r\n"
				+ "En tant qu'utilisateur vous pouvez rechercher des stagiaires à partir d'un ou plusieurs critères\r\n"
				+ "\r\n"
				+ "En tant qu'utilisateur vous pouvez exporter l'annuaire, ou un extrait issu de ma recherche, au format pdf\r\n"
				+ "\r\n"
				+ "En tant qu'utilisateur vous pouvez accéder à une documentation utilisateur\r\n"
				+ "\r\n"
				+ "En tant qu'administrateur vous pouvez accéder à toutes les fonctionnalités de l'utilisateur\r\n"
				+ "\r\n"
				+ "En tant qu'administrateur vous pouvez mettre à jour un stagiaire enregistré dans l'annuaire\r\n"
				+ "\r\n"
				+ "En tant qu'administrateur vous pouvez supprimer un stagiaire enregistré dans l'annuaire ");

		layout.setPadding(new Insets (10));

		layout.getChildren().addAll(lblmessage1,lblmessage2);
		
		Scene scene1= new Scene(layout, 500, 500);

		popupwindow.setScene(scene1);

		popupwindow.showAndWait();

	}



}

