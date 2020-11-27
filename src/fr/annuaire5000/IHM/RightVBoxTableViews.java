package fr.annuaire5000.IHM;

import java.io.File;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.EtudiantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class RightVBoxTableViews extends VBox {
	
	private Label lbl1;
	private EtudiantDAO dao = new EtudiantDAO();
	private ObservableList<Etudiant> observableEtudiants;
	private TableView<Etudiant> tableEtudiants;
	private Label lbl2;
	private TextField tf2;
	
	public RightVBoxTableViews() {
		super();
		
		observableEtudiants = FXCollections.observableArrayList(dao.importExtern(new File("./stagiaires.txt")));
		
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
		
		
		lbl1 = new Label("Liste de stagiaire :");
		lbl1.setStyle("-fx-font-size: 16 ; -fx-font-weight: bold");
		
		lbl2 = new Label("RÃ©sultat :");
		lbl2.setStyle("-fx-font-size: 16 ; -fx-font-weight: bold");
		tf2 = new TextField();
		tf2.setAlignment(Pos.CENTER);
		tf2.setPrefSize(150, 400);
		
		setPadding(new Insets(20));
		getChildren().addAll(lbl1, tableEtudiants, lbl2, tf2);
		setAlignment(Pos.TOP_CENTER);
		setPrefSize(600, 300);
		setStyle("-fx-background-color: teal");
		
	}

	public RightVBoxTableViews(Label lbl1, EtudiantDAO dao, ObservableList<Etudiant> observableEtudiants,
			TableView<Etudiant> tableEtudiants, Label lbl2, TextField tf2) {
		super();
		this.lbl1 = lbl1;
		this.dao = dao;
		this.observableEtudiants = observableEtudiants;
		this.tableEtudiants = tableEtudiants;
		this.lbl2 = lbl2;
		this.tf2 = tf2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dao == null) ? 0 : dao.hashCode());
		result = prime * result + ((lbl1 == null) ? 0 : lbl1.hashCode());
		result = prime * result + ((lbl2 == null) ? 0 : lbl2.hashCode());
		result = prime * result + ((observableEtudiants == null) ? 0 : observableEtudiants.hashCode());
		result = prime * result + ((tableEtudiants == null) ? 0 : tableEtudiants.hashCode());
		result = prime * result + ((tf2 == null) ? 0 : tf2.hashCode());
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
		if (tableEtudiants == null) {
			if (other.tableEtudiants != null)
				return false;
		} else if (!tableEtudiants.equals(other.tableEtudiants))
			return false;
		if (tf2 == null) {
			if (other.tf2 != null)
				return false;
		} else if (!tf2.equals(other.tf2))
			return false;
		return true;
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

	public TextField getTf2() {
		return tf2;
	}

	public void setTf2(TextField tf2) {
		this.tf2 = tf2;
	}

	@Override
	public String toString() {
		return "RightVBoxTableViews [lbl1=" + lbl1 + ", dao=" + dao + ", observableEtudiants=" + observableEtudiants
				+ ", tableEtudiants=" + tableEtudiants + ", lbl2=" + lbl2 + ", tf2=" + tf2 + "]";
	}
	
	
	

}
