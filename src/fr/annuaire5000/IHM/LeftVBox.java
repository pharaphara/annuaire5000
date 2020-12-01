package fr.annuaire5000.IHM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftVBox extends VBox {
	
	private HBox btnBox = new HBox(20);
	private HBox hbNom= new HBox(20);
	private HBox hbPrenom= new HBox(20);
	private HBox hbDep= new HBox(20);
	private HBox hbPromo= new HBox(20);
	private HBox hbAnnee= new HBox(20);
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
	private Label lblTailleMax0 = new Label("Maximum 30 caractères");
	private Label lblTailleMax1 = new Label("Maximum 30 caractères");
	private Label lblTailleMax2 = new Label("Maximum  3 caractères");
	private Label lblTailleMax3 = new Label("Maximum 10 caractères");
	private Label lblTailleMax4 = new Label("Maximum  4 caractères");
	

	public LeftVBox() {
		
		hbNom.getChildren().addAll(lblNom,tfNom, lblTailleMax0);
		tfNom.setPrefSize(300, 15);
		lblNom.setPrefSize(200, 15);
		lblNom.setStyle("-fx-font-size:15");
		lblTailleMax0.setStyle("-fx-font-size:15");
		lblTailleMax0.setVisible(false);
		
		hbPrenom.getChildren().addAll(lblPrenom,tfPrenom, lblTailleMax1);
		tfPrenom.setPrefSize(300, 15);
		lblPrenom.setPrefSize(200, 15);
		lblPrenom.setStyle("-fx-font-size:15");
		lblTailleMax1.setStyle("-fx-font-size:15");
		lblTailleMax1.setVisible(false);
		
		hbDep.getChildren().addAll(lblDepartement,tfDepartement, lblTailleMax2);
		tfDepartement.setPrefSize(300, 15);
		lblDepartement.setPrefSize(200, 15);
		lblDepartement.setStyle("-fx-font-size:15");
		lblTailleMax2.setStyle("-fx-font-size:15");
		lblTailleMax2.setVisible(false);
		
		hbPromo.getChildren().addAll(lblPromotion, tfPromotion, lblTailleMax3);
		tfPromotion.setPrefSize(300, 15);
		lblPromotion.setPrefSize(200, 15);
		lblPromotion.setStyle("-fx-font-size:15");
		lblTailleMax3.setStyle("-fx-font-size:15");
		lblTailleMax3.setVisible(false);
		
		hbAnnee.getChildren().addAll(lblAnnee, tfAnnee, lblTailleMax4);
		tfAnnee.setPrefSize(300, 15);
		lblAnnee.setPrefSize(200, 15);
		lblAnnee.setStyle("-fx-font-size:15");
		lblTailleMax4.setStyle("-fx-font-size:15");
		lblTailleMax4.setVisible(false);

		
		btnBox.getChildren().addAll(btnAjouter,btnRechercher,btnModifier,btnSupprimer);
		
		btnBox.setAlignment(Pos.CENTER);
		btnAjouter.setStyle("-fx-font-size:15");
		btnRechercher.setStyle("-fx-font-size:15");
		btnModifier.setStyle("-fx-font-size:15");
		btnSupprimer.setStyle("-fx-font-size:15");
		btnSupprimer.setDisable(true);
		btnModifier.setDisable(true);
		
		lblErreur.setStyle("-fx-font-size:15");
		lblErreur.setVisible(false);
		
		getChildren().addAll(hbNom,hbPrenom,hbDep,hbPromo,hbAnnee,lblErreur,btnBox);

		setAlignment(Pos.CENTER);
		setPrefSize(800, 800);
		setSpacing(20);
		setPadding(new Insets(20));
		

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

	public Label getLblTailleMax0() {
		return lblTailleMax0;
	}

	public void setLblTailleMax0(Label lblTailleMax0) {
		this.lblTailleMax0 = lblTailleMax0;
	}

	public Label getLblTailleMax1() {
		return lblTailleMax1;
	}
	
	public void setLblTailleMax1(Label lblTailleMax1) {
		this.lblTailleMax1 = lblTailleMax1;
	}

	public Label getLblTailleMax2() {
		return lblTailleMax2;
	}

	public void setLblTailleMax2(Label lblTailleMax2) {
		this.lblTailleMax2 = lblTailleMax2;
	}

	public Label getLblTailleMax3() {
		return lblTailleMax3;
	}

	public void setLblTailleMax3(Label lblTailleMax3) {
		this.lblTailleMax3 = lblTailleMax3;
	}

	public Label getLblTailleMax4() {
		return lblTailleMax4;
	}

	public void setLblTailleMax4(Label lblTailleMax4) {
		this.lblTailleMax4 = lblTailleMax4;
	}

}
