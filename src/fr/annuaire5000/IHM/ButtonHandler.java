package fr.annuaire5000.IHM;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdfjet.Letter;
import com.pdfjet.PDF;
import com.pdfjet.Page;

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
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;



public class ButtonHandler implements EventHandler<ActionEvent>{

	private MainPanel root;
	String[] textFields = new String[5];
	

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
			exporterListe();

		}
		if (eventString.contains("ExporterResultat")) {
			exporterResultat();

		}
	}
	private void ajouter() {
		root.getLeftVBox().getLblErreur().setVisible(false);
		if (!lireTf())
			return;

		
		
		if( textFields[0]!=null && textFields[1]!=null && textFields[2]!=null&& textFields[3]!=null
				&& textFields[4]!=null) {
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
		
		if (!lireTf())
		return;
		
		List<Etudiant> resultats = new ArrayList<Etudiant>();		
		resultats=NoeudDao.recherche(textFields);
		System.out.println("retour dans rechercher");
		root.getRightVBox().getObservableRecherche().clear();
		for (Etudiant etudiant : resultats) {
			System.out.println(etudiant);
			root.getRightVBox().getObservableRecherche().add(etudiant);
		}
		

	}

	private boolean lireTf() {
		boolean tropLong=false;
		textFields[0]=root.getLeftVBox().getTfNom().getText().toLowerCase();
		textFields[1]=root.getLeftVBox().getTfPrenom().getText().toLowerCase();
		textFields[2]=root.getLeftVBox().getTfDepartement().getText().toLowerCase();	
		textFields[3]=root.getLeftVBox().getTfPromotion().getText().toLowerCase();
		textFields[4]=root.getLeftVBox().getTfAnnee().getText().toLowerCase();
		tropLong=verificationLongeur(textFields, tropLong);
		if(tropLong) {
			return false;
		}
		root.getLeftVBox().getLblTailleMax0().setVisible(false);
		root.getLeftVBox().getLblTailleMax1().setVisible(false);
		root.getLeftVBox().getLblTailleMax2().setVisible(false);
		root.getLeftVBox().getLblTailleMax3().setVisible(false);
		root.getLeftVBox().getLblTailleMax4().setVisible(false);
		
		//pour mettre à null les TF non recherchés
		for (int i = 0; i < textFields.length; i++) {
			textFields[i]= (textFields[i].length()<1)? null:textFields[i];
		}
		return true;
	}
	private boolean verificationLongeur(String [] tab, boolean tropLong) {
		
		
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

	private void exporterListe() {

		Document doc =new Document();
		try {

			PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\formation\\Desktop\\PDF\\Etudiant.pdf"));
			doc.open();
			Image img = Image.getInstance("C:\\Users\\formation\\Desktop\\PDF\\eqlimg.png");
			img.scaleAbsoluteWidth(120);
			img.scaleAbsoluteHeight(80);
			img.setAlignment(Image.ALIGN_CENTER);
			doc.add(img);
			doc.add(new Paragraph("     "));
			Paragraph P1=new Paragraph("Liste des Etudiants : ");
			P1.setAlignment(Element.ALIGN_CENTER);
			doc.add(P1);
			doc.add(new Paragraph("         "));
			doc.add(new Paragraph("         "));
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			PdfPCell cell;

			///////////
			cell = new PdfPCell(new Phrase("Nom",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Prenom",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Departement",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Promotion",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
		 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Année ",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			////////////////


			if(table!=null) {
				for (Etudiant etudiant : root.getRightVBox().getObservableEtudiants()) {
					
					cell = new PdfPCell (new Phrase(etudiant.getNom(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getPrenom(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					
					cell = new PdfPCell (new Phrase(etudiant.getDepartement(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getPromotion(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getAnnee(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
				}
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File("C:\\Users\\formation\\Desktop\\PDF\\Etudiant.pdf"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	
	

	private void exporterResultat() {

		Document doc =new Document();
		try {

			PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\formation\\Desktop\\PDF\\Etudiant.pdf"));
			doc.open();
			doc.add(new Paragraph("Liste Etudiant"));
			doc.add(new Paragraph("------------------"));

			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(200);
			PdfPCell cell;

			///////////
			cell = new PdfPCell(new Phrase("Nom",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Prenom",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("departement",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("promotion",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("annee ",FontFactory.getFont("Comic SansMs",12)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);           
			 cell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(cell);

			////////////////

			if(table!=null) {
				for (Etudiant etudiant : root.getRightVBox().getObservableRecherche()) {
					
					cell = new PdfPCell (new Phrase(etudiant.getNom(), FontFactory.getFont("Arial",11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getPrenom()));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					
					cell = new PdfPCell (new Phrase(etudiant.getDepartement()));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getPromotion()));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);

					cell = new PdfPCell (new Phrase(etudiant.getAnnee()));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
				}
			}

			doc.add(table);
			doc.close();

			Desktop.getDesktop().open(new File("C:\\Users\\formation\\Desktop\\PDF\\Etudiant.pdf"));
		} catch (Exception e) {

			e.printStackTrace();
		}
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

