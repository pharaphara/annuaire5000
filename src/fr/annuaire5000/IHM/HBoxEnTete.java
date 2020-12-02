package fr.annuaire5000.IHM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HBoxEnTete extends HBox {
	private Label lbl0;
	private Button btn1;
	private Button btn4;
	private ImageView img2;

	private Button btn3 = new Button("Connecter");

	public HBoxEnTete() {
		super();

		btn1 = new Button("Importer");
		btn1.setStyle("-fx-font-size:15");
		btn3.setStyle("-fx-font-size:15");
		btn4 = new Button("Help");
		btn4.setStyle("-fx-font-size:15");
		setSpacing(100);
		setAlignment(Pos.CENTER);
		setPrefSize(1200, 50);
		setPadding(new Insets (15));

		VBox imgplacer = new VBox();
		imgplacer.setPrefSize(10, 10);
		img2 = new ImageView(getClass().getResource("/ressource/image/eqlimg.png").toString());	
		lbl0=new Label();
		lbl0.setGraphic(img2);	
		lbl0.setContentDisplay(ContentDisplay.TOP);
		lbl0.setStyle("-fx-background-radius: 15");
		imgplacer.getChildren().add(lbl0);
		getChildren().addAll(imgplacer,btn1, btn3, btn4);
	}


	public HBoxEnTete(Label lbl0, Button btn1, Button btn4, ImageView img2, Button btn3) {
		super();
		this.lbl0 = lbl0;
		this.btn1 = btn1;
		this.btn4 = btn4;
		
		this.img2 = img2;
		this.btn3 = btn3;
	}
	

	public Button getBtn1() {
		return btn1;
	}


	public void setBtn1(Button btn1) {
		this.btn1 = btn1;
	}


	public Button getBtn3() {
		return btn3;
	}


	public void setBtn3(Button btn3) {
		this.btn3 = btn3;
	}


	public Button getBtn4() {
		return btn4;
	}


	public void setBtn4(Button btn4) {
		this.btn4 = btn4;
	}


	public ImageView getImg2() {
		return img2;
	}


	public void setImg2(ImageView img2) {
		this.img2 = img2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((btn1 == null) ? 0 : btn1.hashCode());
		result = prime * result + ((btn3 == null) ? 0 : btn3.hashCode());
		result = prime * result + ((btn4 == null) ? 0 : btn4.hashCode());
		result = prime * result + ((img2 == null) ? 0 : img2.hashCode());
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
		HBoxEnTete other = (HBoxEnTete) obj;
		if (btn1 == null) {
			if (other.btn1 != null)
				return false;
		} else if (!btn1.equals(other.btn1))
			return false;
		if (btn3 == null) {
			if (other.btn3 != null)
				return false;
		} else if (!btn3.equals(other.btn3))
			return false;
		if (btn4 == null) {
			if (other.btn4 != null)
				return false;
		} else if (!btn4.equals(other.btn4))
			return false;
		if (img2 == null) {
			if (other.img2 != null)
				return false;
		} else if (!img2.equals(other.img2))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "HBoxEnTete [btn1=" + btn1 + ", btn3=" + btn3 + ", btn4=" + btn4 + ", img2=" + img2 + "]";
	}


	/**
	 * @return the lbl0
	 */
	public Label getLbl0() {
		return lbl0;
	}


	/**
	 * @param lbl0 the lbl0 to set
	 */
	public void setLbl0(Label lbl0) {
		this.lbl0 = lbl0;
	}
}
