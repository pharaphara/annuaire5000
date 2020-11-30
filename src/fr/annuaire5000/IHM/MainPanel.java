package fr.annuaire5000.IHM;



import java.util.ArrayList;
import java.util.List;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
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
		
		}
		
		hboxEnTete.getBtn3().setOnAction(e->ActionButtonConnecter.modeAdmin(this));
		//leftGridPane.getBtnRechercher().setOnAction(e-> ActionButtonRechercher.Rechercher(leftGridPane, rightVBox));
		ButtonHandler handler = new ButtonHandler(this);
		leftVBox.getBtnAjouter().setOnAction(handler);
		hboxEnTete.getBtn1().setOnAction(handler);
		
		hboxEnTete.getBtn4().setOnAction(handler);
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
