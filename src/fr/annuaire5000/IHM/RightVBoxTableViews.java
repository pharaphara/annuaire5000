package fr.annuaire5000.IHM;

import java.util.ArrayList;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.EtudiantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RightVBoxTableViews extends VBox {
	
	private Label lbl1;
	private EtudiantDAO dao = new EtudiantDAO();
	private ObservableList<Etudiant> observableEtudiants ;
	private TableView<Etudiant> tableEtudiants;
	private Label lbl2;
	private ObservableList<Etudiant> observableRecherche;
	private TableView<Etudiant> tableRecherche;
	private Button btnExporterListe;
	private Button btnExporterRecherche;
	private HBox hBoxLblStagiaireEtExport;
	private HBox hBoxLblRechercheEtExport;

	
	@SuppressWarnings("unchecked")
	public RightVBoxTableViews() {
		super();

		lbl1 = new Label("Liste de stagiaire :");
		lbl1.setStyle("-fx-font-size:15");

		
		btnExporterListe = new Button("Exporter Liste");

		
		hBoxLblStagiaireEtExport = new HBox(30);
		hBoxLblStagiaireEtExport.getChildren().addAll(btnExporterListe, lbl1);
		hBoxLblStagiaireEtExport.setAlignment(Pos.CENTER);

		
		observableEtudiants=FXCollections.observableArrayList(new ArrayList<Etudiant>());
		tableEtudiants = new TableView<>(observableEtudiants);
		
		TableColumn<Etudiant, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<Etudiant, String> colPrenom = new TableColumn<>("Prénom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		
		TableColumn<Etudiant, String> colDepartement = new TableColumn<>("Département");
		colDepartement.setCellValueFactory(new PropertyValueFactory<>("departement"));
		
		TableColumn<Etudiant, String> colPromotion = new TableColumn<>("Promotion");
		colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Etudiant, String> colAnnee = new TableColumn<>("Année");
		colAnnee.setCellValueFactory(new PropertyValueFactory<>("annee"));
		
		tableEtudiants.getColumns().addAll(colNom, colPrenom, colDepartement, colPromotion, colAnnee);
		tableEtudiants.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		
		
		lbl2 = new Label("Résultat :");
		lbl2.setStyle("-fx-font-size:15");

		btnExporterRecherche = new Button("Exporter Recherche");

	
		hBoxLblRechercheEtExport = new HBox(30);
		hBoxLblRechercheEtExport.getChildren().addAll(btnExporterRecherche, lbl2);
		hBoxLblRechercheEtExport.setAlignment(Pos.CENTER);

	
		observableRecherche = FXCollections.observableArrayList();
		
		tableRecherche = new TableView<>(observableRecherche);
		
		TableColumn<Etudiant, String> colNomR = new TableColumn<>("Nom");
		colNomR.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<Etudiant, String> colPrenomR = new TableColumn<>("Prénom");
		colPrenomR.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		
		TableColumn<Etudiant, String> colDepartementR = new TableColumn<>("Département");
		colDepartementR.setCellValueFactory(new PropertyValueFactory<>("departement"));
		
		TableColumn<Etudiant, String> colPromotionR = new TableColumn<>("Promotion");
		colPromotionR.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Etudiant, String> colAnneeR = new TableColumn<>("Année");
		colAnneeR.setCellValueFactory(new PropertyValueFactory<>("annee"));
		
		tableRecherche.getColumns().addAll(colNomR, colPrenomR, colDepartementR, colPromotionR, colAnneeR);
		tableRecherche.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		setPadding(new Insets(20));
		getChildren().addAll(hBoxLblStagiaireEtExport, tableEtudiants, hBoxLblRechercheEtExport, tableRecherche);
		setAlignment(Pos.TOP_CENTER);
		setSpacing(20);
		setPrefSize(600, 800);
	
		
	}


	public RightVBoxTableViews(Label lbl1, EtudiantDAO dao, ObservableList<Etudiant> observableEtudiants,
			TableView<Etudiant> tableEtudiants, Label lbl2, ObservableList<Etudiant> observableRecherche,
			TableView<Etudiant> tableRecherche) {
		super();
		this.lbl1 = lbl1;
		this.dao = dao;
		this.observableEtudiants = observableEtudiants;
		this.tableEtudiants = tableEtudiants;
		this.lbl2 = lbl2;
		this.observableRecherche = observableRecherche;
		this.tableRecherche = tableRecherche;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dao == null) ? 0 : dao.hashCode());
		result = prime * result + ((lbl1 == null) ? 0 : lbl1.hashCode());
		result = prime * result + ((lbl2 == null) ? 0 : lbl2.hashCode());
		result = prime * result + ((observableEtudiants == null) ? 0 : observableEtudiants.hashCode());
		result = prime * result + ((observableRecherche == null) ? 0 : observableRecherche.hashCode());
		result = prime * result + ((tableEtudiants == null) ? 0 : tableEtudiants.hashCode());
		result = prime * result + ((tableRecherche == null) ? 0 : tableRecherche.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RightVBoxTableViews other = (RightVBoxTableViews) obj;
		if (dao == null) {
			if (other.dao != null)
				return false;
		} else if (!dao.equals(other.dao))
			return false;
		if (lbl1 == null) {
			if (other.lbl1 != null)
				return false;
		} else if (!lbl1.equals(other.lbl1))
			return false;
		if (lbl2 == null) {
			if (other.lbl2 != null)
				return false;
		} else if (!lbl2.equals(other.lbl2))
			return false;
		if (observableEtudiants == null) {
			if (other.observableEtudiants != null)
				return false;
		} else if (!observableEtudiants.equals(other.observableEtudiants))
			return false;
		if (observableRecherche == null) {
			if (other.observableRecherche != null)
				return false;
		} else if (!observableRecherche.equals(other.observableRecherche))
			return false;
		if (tableEtudiants == null) {
			if (other.tableEtudiants != null)
				return false;
		} else if (!tableEtudiants.equals(other.tableEtudiants))
			return false;
		if (tableRecherche == null) {
			if (other.tableRecherche != null)
				return false;
		} else if (!tableRecherche.equals(other.tableRecherche))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RightVBoxTableViews [lbl1=" + lbl1 + ", dao=" + dao + ", observableEtudiants=" + observableEtudiants
				+ ", tableEtudiants=" + tableEtudiants + ", lbl2=" + lbl2 + ", observableRecherche="
				+ observableRecherche + ", tableRecherche=" + tableRecherche + "]";
	}


	public Label getLbl1() {
		return lbl1;
	}


	public void setLbl1(Label lbl1) {
		this.lbl1 = lbl1;
	}


	public EtudiantDAO getDao() {
		return dao;
	}


	public void setDao(EtudiantDAO dao) {
		this.dao = dao;
	}


	public ObservableList<Etudiant> getObservableEtudiants() {
		return observableEtudiants;
	}


	public void setObservableEtudiants(ObservableList<Etudiant> observableEtudiants) {
		this.observableEtudiants = observableEtudiants;
	}


	public TableView<Etudiant> getTableEtudiants() {
		return tableEtudiants;
	}


	public void setTableEtudiants(TableView<Etudiant> tableEtudiants) {
		this.tableEtudiants = tableEtudiants;
	}


	public Label getLbl2() {
		return lbl2;
	}


	public void setLbl2(Label lbl2) {
		this.lbl2 = lbl2;
	}


	public ObservableList<Etudiant> getObservableRecherche() {
		return observableRecherche;
	}


	public void setObservableRecherche(ObservableList<Etudiant> observableRecherche) {
		this.observableRecherche = observableRecherche;
	}


	public TableView<Etudiant> getTableRecherche() {
		return tableRecherche;
	}


	public void setTableRecherche(TableView<Etudiant> tableRecherche) {
		this.tableRecherche = tableRecherche;
	}


	public Button getBtnExporterListe() {
		return btnExporterListe;
	}


	public void setBtnExporterListe(Button btnExporterListe) {
		this.btnExporterListe = btnExporterListe;
	}


	public Button getBtnExporterRecherche() {
		return btnExporterRecherche;
	}


	public void setBtnExporterRecherche(Button btnExporterRecherche) {
		this.btnExporterRecherche = btnExporterRecherche;
	}
	
	
	

}
