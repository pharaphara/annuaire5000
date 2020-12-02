package fr.annuaire5000.IHM;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LeftGridPane extends GridPane {

	private HBox btnBox;
	private Label lblNom;
	private TextField tfNom;
	private Label lblPrenom;
	private TextField tfPrenom;
	private Label lblDepartement;
	private TextField tfDepartement;
	private Label lblPromotion;
	private TextField tfPromotion;
	private Label lblAnnee;
	private TextField tfAnnee;
	private Label lblErreur;
	private Button btnAjouter;
	private Button btnRechercher;
	private Button btnModifier;
	private Button btnSupprimer;

	public LeftGridPane() {
		super();

		lblNom = new Label("Nom : ");
		tfNom = new TextField();
		addRow(0, lblNom, tfNom);


		lblPrenom = new Label("Prénom : ");
		tfPrenom = new TextField();
		addRow(1, lblPrenom, tfPrenom);


		lblDepartement = new Label("Département : ");
		tfDepartement = new TextField();
		addRow(2, lblDepartement, tfDepartement);


		lblPromotion = new Label("Numéro de promotion : ");
		tfPromotion = new TextField();
		addRow(3, lblPromotion, tfPromotion);


		lblAnnee = new Label("Année : ");
		tfAnnee = new TextField();
		addRow(4, lblAnnee, tfAnnee);

		lblErreur = new Label("Veuillez saisir les champs");
		lblErreur.setVisible(false);
		addRow(5, lblErreur);

		btnAjouter = new Button("Ajouter");
		btnAjouter.setPrefSize(100, 50);

		btnRechercher = new Button("Rechercher");
		btnRechercher.setPrefSize(100, 50);

		btnModifier = new Button("Modifier");
		btnModifier.setPrefSize(100, 50);


		btnSupprimer = new Button("Supprimer");
		btnSupprimer.setPrefSize(100, 50);



		btnBox = new HBox(20);
		btnBox.getChildren().addAll(btnAjouter, btnRechercher, btnModifier, btnSupprimer);
		btnBox.setAlignment(Pos.CENTER);

		addRow(6, btnBox);
		//add(btnBox, 0, 7, 2, 1);

		setPrefSize(600, 300);
		setVgap(50);
		setPadding(new Insets(80));

	}

	public LeftGridPane(Label lblNom, TextField tfNom, Label lblPrenom, TextField thPrenom, Label lblDepartement,
			TextField tfDepartement, Label lblPromotion, TextField tfPromotion, Label lblAnnee, TextField tfAnnee,
			Button btnAjouter, Button btnRechercher, Button btnModifier, Button btnSupprimer) {
		super();
		this.lblNom = lblNom;
		this.tfNom = tfNom;
		this.lblPrenom = lblPrenom;
		this.tfPrenom = thPrenom;
		this.lblDepartement = lblDepartement;
		this.tfDepartement = tfDepartement;
		this.lblPromotion = lblPromotion;
		this.tfPromotion = tfPromotion;
		this.lblAnnee = lblAnnee;
		this.tfAnnee = tfAnnee;
		
		this.btnAjouter = btnAjouter;
		this.btnRechercher = btnRechercher;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((btnAjouter == null) ? 0 : btnAjouter.hashCode());
		result = prime * result + ((btnModifier == null) ? 0 : btnModifier.hashCode());
		result = prime * result + ((btnRechercher == null) ? 0 : btnRechercher.hashCode());
		result = prime * result + ((btnSupprimer == null) ? 0 : btnSupprimer.hashCode());
		result = prime * result + ((lblAnnee == null) ? 0 : lblAnnee.hashCode());
		result = prime * result + ((lblDepartement == null) ? 0 : lblDepartement.hashCode());
		result = prime * result + ((lblNom == null) ? 0 : lblNom.hashCode());
		result = prime * result + ((lblPrenom == null) ? 0 : lblPrenom.hashCode());
		result = prime * result + ((lblPromotion == null) ? 0 : lblPromotion.hashCode());
		result = prime * result + ((tfAnnee == null) ? 0 : tfAnnee.hashCode());
		result = prime * result + ((tfDepartement == null) ? 0 : tfDepartement.hashCode());
		result = prime * result + ((tfNom == null) ? 0 : tfNom.hashCode());
		result = prime * result + ((tfPromotion == null) ? 0 : tfPromotion.hashCode());
		result = prime * result + ((tfPrenom == null) ? 0 : tfPrenom.hashCode());
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
		LeftGridPane other = (LeftGridPane) obj;
		if (btnAjouter == null) {
			if (other.btnAjouter != null)
				return false;
		} else if (!btnAjouter.equals(other.btnAjouter))
			return false;
		if (btnModifier == null) {
			if (other.btnModifier != null)
				return false;
		} else if (!btnModifier.equals(other.btnModifier))
			return false;
		if (btnRechercher == null) {
			if (other.btnRechercher != null)
				return false;
		} else if (!btnRechercher.equals(other.btnRechercher))
			return false;
		if (btnSupprimer == null) {
			if (other.btnSupprimer != null)
				return false;
		} else if (!btnSupprimer.equals(other.btnSupprimer))
			return false;
		if (lblAnnee == null) {
			if (other.lblAnnee != null)
				return false;
		} else if (!lblAnnee.equals(other.lblAnnee))
			return false;
		if (lblDepartement == null) {
			if (other.lblDepartement != null)
				return false;
		} else if (!lblDepartement.equals(other.lblDepartement))
			return false;
		if (lblNom == null) {
			if (other.lblNom != null)
				return false;
		} else if (!lblNom.equals(other.lblNom))
			return false;
		if (lblPrenom == null) {
			if (other.lblPrenom != null)
				return false;
		} else if (!lblPrenom.equals(other.lblPrenom))
			return false;
		if (lblPromotion == null) {
			if (other.lblPromotion != null)
				return false;
		} else if (!lblPromotion.equals(other.lblPromotion))
			return false;
		if (tfAnnee == null) {
			if (other.tfAnnee != null)
				return false;
		} else if (!tfAnnee.equals(other.tfAnnee))
			return false;
		if (tfDepartement == null) {
			if (other.tfDepartement != null)
				return false;
		} else if (!tfDepartement.equals(other.tfDepartement))
			return false;
		if (tfNom == null) {
			if (other.tfNom != null)
				return false;
		} else if (!tfNom.equals(other.tfNom))
			return false;
		if (tfPromotion == null) {
			if (other.tfPromotion != null)
				return false;
		} else if (!tfPromotion.equals(other.tfPromotion))
			return false;
		if (tfPrenom == null) {
			if (other.tfPrenom != null)
				return false;
		} else if (!tfPrenom.equals(other.tfPrenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LeftGridPane [lblNom=" + lblNom + ", tfNom=" + tfNom + ", lblPrenom=" + lblPrenom + ", thPrenom="
				+ tfPrenom + ", lblDepartement=" + lblDepartement + ", tfDepartement=" + tfDepartement
				+ ", lblPromotion=" + lblPromotion + ", tfPromotion=" + tfPromotion + ", lblAnnee=" + lblAnnee
				+ ", tfAnnee=" + tfAnnee + ", btnAjouter=" + btnAjouter + ", btnRechercher=" + btnRechercher
				+ ", btnModifier=" + btnModifier + ", btnSupprimer=" + btnSupprimer + "]";
	}

	public HBox getBtnBox() {
		return btnBox;
	}

	public void setBtnBox(HBox btnBox) {
		this.btnBox = btnBox;
	}

	public Label getLblErreur() {
		return lblErreur;
	}

	public void setLblErreur(Label lblErreur) {
		this.lblErreur = lblErreur;
	}
}
