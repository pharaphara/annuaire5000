package fr.annuaire5000.IHM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
//Class du panneau droit en attendant les tableaux, remplacés par les tf1 et tf2
public class RightVBox extends VBox {
	
	private Label lbl1;
	private TextField tf1;
	private Label lbl2;
	private TextField tf2;
	
	public RightVBox() {
		super();
		
		lbl1 = new Label("Liste de stagiaire :");
		lbl1.setStyle("-fx-font-size: 16 ; -fx-font-weight: bold");
		tf1 = new TextField();
		tf1.setAlignment(Pos.CENTER);
		tf1.setPrefSize(150, 400);
		lbl2 = new Label("Résultat :");
		lbl2.setStyle("-fx-font-size: 16 ; -fx-font-weight: bold");
		tf2 = new TextField();
		tf2.setAlignment(Pos.CENTER);
		tf2.setPrefSize(150, 400);
		
		setPadding(new Insets(20));
		getChildren().addAll(lbl1, tf1, lbl2, tf2);
		setAlignment(Pos.TOP_CENTER);
		setPrefSize(600, 300);
		setStyle("-fx-background-color: teal");
		
	}

	public RightVBox(Label lbl1, TextField tf1, Label lbl2, TextField tf2) {
		super();
		this.lbl1 = lbl1;
		this.tf1 = tf1;
		this.lbl2 = lbl2;
		this.tf2 = tf2;
	}

	public Label getLbl1() {
		return lbl1;
	}

	public void setLbl1(Label lbl1) {
		this.lbl1 = lbl1;
	}

	public TextField getTf1() {
		return tf1;
	}

	public void setTf1(TextField tf1) {
		this.tf1 = tf1;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lbl1 == null) ? 0 : lbl1.hashCode());
		result = prime * result + ((lbl2 == null) ? 0 : lbl2.hashCode());
		result = prime * result + ((tf1 == null) ? 0 : tf1.hashCode());
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
		RightVBox other = (RightVBox) obj;
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
		if (tf1 == null) {
			if (other.tf1 != null)
				return false;
		} else if (!tf1.equals(other.tf1))
			return false;
		if (tf2 == null) {
			if (other.tf2 != null)
				return false;
		} else if (!tf2.equals(other.tf2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RightVBox [lbl1=" + lbl1 + ", tf1=" + tf1 + ", lbl2=" + lbl2 + ", tf2=" + tf2 + "]";
	}
	
	

}
