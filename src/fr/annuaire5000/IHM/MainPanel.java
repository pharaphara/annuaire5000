package fr.annuaire5000.IHM;

import java.util.ArrayList;
import java.util.List;
import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;


public class MainPanel extends BorderPane {


	private HBoxEnTete hboxEnTete = new HBoxEnTete();
	private RightVBoxTableViews rightVBox = new RightVBoxTableViews();
	private LeftVBox leftVBox = new LeftVBox();


	public MainPanel() {
		super();

		setLeft(leftVBox);
		setTop(hboxEnTete);
		setRight(rightVBox);

		if (NoeudDao.fileArbre.exists()) {

			List<Etudiant>	etudiants= new ArrayList<Etudiant>();
			etudiants = NoeudDao.getAllOrdre();

			for (Etudiant etudiant : etudiants) {
				rightVBox.getObservableEtudiants().add(etudiant);
			}
			getRightVBox().getObservableEtudiants().remove(new Etudiant("~/~Racine", "de l'arbre", "ZZZ", "XXXX", "9999"));

		}


		hboxEnTete.getBtn3().setOnAction(e->ActionButtonConnecter.modeAdmin(this));


		ButtonHandler handler = new ButtonHandler(this);
		leftVBox.getBtnAjouter().setOnAction(handler);
		leftVBox.getBtnRechercher().setOnAction(handler);
		hboxEnTete.getBtn1().setOnAction(handler);

		hboxEnTete.getBtn3().setOnAction(e->ActionButtonConnecter.modeAdmin(this));
		
		rightVBox.getBtnExporterListe().setOnAction(handler);
		rightVBox.getBtnExporterRecherche().setOnAction(handler);
		
		hboxEnTete.getBtn4().setOnAction(handler);
		rightVBox.getTableEtudiants().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Etudiant>() {

			@Override
			public void changed(ObservableValue<? extends Etudiant> observable, Etudiant oldValue, Etudiant newValue) {
				leftVBox.getTfNom().setText(newValue.getNom());
				leftVBox.getTfPrenom().setText(newValue.getPrenom());
				leftVBox.getTfDepartement().setText(newValue.getDepartement());
				leftVBox.getTfPromotion().setText(newValue.getPromotion());
				leftVBox.getTfAnnee().setText(newValue.getAnnee());

			}
		});

	}

	public HBoxEnTete getHboxEnTete() {
		return hboxEnTete;
	}

	public void setHboxEnTete(HBoxEnTete hboxEnTete) {
		this.hboxEnTete = hboxEnTete;
	}

	public RightVBoxTableViews getRightVBox() {
		return rightVBox;
	}

	public void setRightVBox(RightVBoxTableViews rightVBox) {
		this.rightVBox = rightVBox;
	}

	public LeftVBox getLeftVBox() {
		return leftVBox;
	}

	public void setLeftVBox(LeftVBox leftVBox) {
		this.leftVBox = leftVBox;
	}


}
