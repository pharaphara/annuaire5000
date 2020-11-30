package fr.annuaire5000.IHM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftVBox extends VBox {
	
	private HBox btnBox = new HBox();
	private HBox hbNom= new HBox();
	private HBox hbPrenom= new HBox();
	private HBox hbDep= new HBox();
	private HBox hbPromo= new HBox();
	private HBox hbAnnee= new HBox();
	private Label lblNom = new Label("Nom : ");
	private TextField tfNom = new TextField();
	private Label lblPrenom = new Label("Prénom : ");
	private TextField tfPrenom= new TextField();
	private Label lblDepartement= new Label("Département : ");
	private TextField tfDepartement= new TextField();
	private Label lblPromotion = new Label("Numéro de promotion : ");
	private TextField tfPromotion = new TextField();
	private Label lblAnnee =new Label("Année : ");
	private TextField tfAnnee= new TextField();
	private Label lblErreur = new Label("Veuillez saisir les champs");
	private Button btnAjouter= new Button("Ajouter");
	private Button btnRechercher= new Button("Rechercher");
	private Button btnModifier = new Button("Modifier");
	private Button btnSupprimer= new Button("Supprimer");

	public LeftVBox() {
		
		hbNom.getChildren().addAll(lblNom,tfNom);
		hbPrenom.getChildren().addAll(lblPrenom,tfPrenom);
		hbDep.getChildren().addAll(lblDepartement,tfDepartement);
		hbPromo.getChildren().addAll(lblPromotion,tfPromotion);
		hbAnnee.getChildren().addAll(lblAnnee,tfAnnee);
		btnBox.getChildren().addAll(btnAjouter,btnRechercher,btnModifier,btnSupprimer);
		getChildren().addAll(hbNom,hbPrenom,hbDep,hbPromo,hbAnnee,lblErreur,btnBox);
		
		tfNom.getLength();
	}

	public HBox getBtnBox() {
		return btnBox;
	}

	public void setBtnBox(HBox btnBox) {
		this.btnBox = btnBox;
	}

	public HBox getHbNom() {
		return hbNom;
	}

	public void setHbNom(HBox hbNom) {
		this.hbNom = hbNom;
	}

	public HBox getHbPrenom() {
		return hbPrenom;
	}

	public void setHbPrenom(HBox hbPrenom) {
		this.hbPrenom = hbPrenom;
	}

	public HBox getHbDep() {
		return hbDep;
	}

	public void setHbDep(HBox hbDep) {
		this.hbDep = hbDep;
	}

	public HBox getHbPromo() {
		return hbPromo;
	}

	public void setHbPromo(HBox hbPromo) {
		this.hbPromo = hbPromo;
	}

	public HBox getHbAnnee() {
		return hbAnnee;
	}

	public void setHbAnnee(HBox hbAnnee) {
		this.hbAnnee = hbAnnee;
	}

	public Label getLblNom() {
		return lblNom;
	}

	public void setLblNom(Label lblNom) {
		this.lblNom = lblNom;
	}

	public TextField getTfNom() {
		return tfNom;
	}

	public void setTfNom(TextField tfNom) {
		this.tfNom = tfNom;
	}

	public Label getLblPrenom() {
		return lblPrenom;
	}

	public void setLblPrenom(Label lblPrenom) {
		this.lblPrenom = lblPrenom;
	}

	public TextField getTfPrenom() {
		return tfPrenom;
	}

	public void setTfPrenom(TextField tfPrenom) {
		this.tfPrenom = tfPrenom;
	}

	public Label getLblDepartement() {
		return lblDepartement;
	}

	public void setLblDepartement(Label lblDepartement) {
		this.lblDepartement = lblDepartement;
	}

	public TextField getTfDepartement() {
		return tfDepartement;
	}

	public void setTfDepartement(TextField tfDepartement) {
		this.tfDepartement = tfDepartement;
	}

	public Label getLblPromotion() {
		return lblPromotion;
	}

	public void setLblPromotion(Label lblPromotion) {
		this.lblPromotion = lblPromotion;
	}

	public TextField getTfPromotion() {
		return tfPromotion;
	}

	public void setTfPromotion(TextField tfPromotion) {
		this.tfPromotion = tfPromotion;
	}

	public Label getLblAnnee() {
		return lblAnnee;
	}

	public void setLblAnnee(Label lblAnnee) {
		this.lblAnnee = lblAnnee;
	}

	public TextField getTfAnnee() {
		return tfAnnee;
	}

	public void setTfAnnee(TextField tfAnnee) {
		this.tfAnnee = tfAnnee;
	}

	public Label getLblErreur() {
		return lblErreur;
	}

	public void setLblErreur(Label lblErreur) {
		this.lblErreur = lblErreur;
	}

	public Button getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(Button btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public Button getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(Button btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public Button getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(Button btnModifier) {
		this.btnModifier = btnModifier;
	}

	public Button getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(Button btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

}
