package fr.annuaire5000.IHM;



import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class MainPanel extends BorderPane {

	private LeftGridPane leftGridPane = new LeftGridPane();
	private HBoxEnTete hboxEnTete = new HBoxEnTete();
	private RightVBoxTableViews rightVBox = new RightVBoxTableViews();

	public MainPanel() {
		super();

		setLeft(leftGridPane);
		setTop(hboxEnTete);
		setRight(rightVBox);

<<<<<<< HEAD
=======
		Label lblerreur = new Label ();
		
		leftGridPane.add(lblerreur, 0, 5);
>>>>>>> cf2fc2498e191b2bed045f877ed710e46c36de6d
		hboxEnTete.getBtn3().setOnAction(e->ActionButtonConnecter.modeAdmin(leftGridPane));
		leftGridPane.getBtnRechercher().setOnAction(e-> ActionButtonRechercher.Rechercher(leftGridPane, rightVBox));		
	
	}

	public MainPanel(LeftGridPane leftGridPane, HBoxEnTete hboxEnTete, RightVBoxTableViews rightVBox) {
		super();
		this.leftGridPane = leftGridPane;
		this.hboxEnTete = hboxEnTete;
		this.rightVBox = rightVBox;
	}

	public LeftGridPane getLeftGridPane() {
		return leftGridPane;
	}

	public void setLeftGridPane(LeftGridPane leftGridPane) {
		this.leftGridPane = leftGridPane;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hboxEnTete == null) ? 0 : hboxEnTete.hashCode());
		result = prime * result + ((leftGridPane == null) ? 0 : leftGridPane.hashCode());
		result = prime * result + ((rightVBox == null) ? 0 : rightVBox.hashCode());
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
		MainPanel other = (MainPanel) obj;
		if (hboxEnTete == null) {
			if (other.hboxEnTete != null)
				return false;
		} else if (!hboxEnTete.equals(other.hboxEnTete))
			return false;
		if (leftGridPane == null) {
			if (other.leftGridPane != null)
				return false;
		} else if (!leftGridPane.equals(other.leftGridPane))
			return false;
		if (rightVBox == null) {
			if (other.rightVBox != null)
				return false;
		} else if (!rightVBox.equals(other.rightVBox))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MainPanel [leftGridPane=" + leftGridPane + ", hboxEnTete=" + hboxEnTete + ", rightVBox=" + rightVBox
				+ "]";
	}


}
