package fr.annuaire5000.IHM;

import javafx.scene.layout.BorderPane;

public class MainPanel extends BorderPane {
	
	private LeftGridPane leftGridPane = new LeftGridPane();
	private HBoxEnTete hboxEnTete = new HBoxEnTete();
	private RightVBox rightVBox = new RightVBox();
	
	public MainPanel() {
		super();

		setLeft(leftGridPane);
		setTop(hboxEnTete);
		setRight(rightVBox);
		
	}

	public MainPanel(LeftGridPane leftGridPane, HBoxEnTete hboxEnTete, RightVBox rightVBox) {
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

	public RightVBox getRightVBox() {
		return rightVBox;
	}

	public void setRightVBox(RightVBox rightVBox) {
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