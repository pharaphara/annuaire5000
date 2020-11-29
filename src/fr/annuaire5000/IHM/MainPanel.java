package fr.annuaire5000.IHM;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class MainPanel extends BorderPane {

	
	private HBoxEnTete hboxEnTete = new HBoxEnTete();
	private RightVBoxTableViews rightVBox = new RightVBoxTableViews();
	private LeftVBox leftVBox = new LeftVBox();
	private int numBtn=0;

	public MainPanel() {
		super();

		setLeft(leftVBox);
		setTop(hboxEnTete);
		setRight(rightVBox);

		
		
		//hboxEnTete.getBtn3().setOnAction(e->ActionButtonConnecter.modeAdmin(leftGridPane));
		//leftGridPane.getBtnRechercher().setOnAction(e-> ActionButtonRechercher.Rechercher(leftGridPane, rightVBox));
		ButtonHandler handler = new ButtonHandler(this);
		leftVBox.getBtnAjouter().setOnAction(handler);
		
	
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
