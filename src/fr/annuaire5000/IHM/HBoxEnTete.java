package fr.annuaire5000.IHM;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxEnTete extends HBox {

	private Button btn1;
	private Button btn2;

	private Button btn4;
	private Image img;
	private ImageView img2;

	private Button btn3 = new Button("Connecter");

	public HBoxEnTete() {
		super();

		btn1 = new Button("Importer");
		btn1.setStyle("-fx-background-radius: 5");
		btn2 = new Button("Exporter");
		btn2.setStyle("-fx-background-radius: 5");
		
		//btn3.setStyle("-fx-background-radius: 5");
		//btn3.setStyle("-fx-background-color: gold");
		btn4 = new Button("Help");
		btn4.setStyle("-fx-background-radius: 5");


		setSpacing(50);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: teal");
		setPrefSize(1200, 100);
		getChildren().addAll(btn1, btn2, btn3, btn4);





	}


	public HBoxEnTete(Button btn1, Button btn2, Button btn3, Button btn4, Image img, ImageView img2) {
		super();
		this.btn1 = btn1;
		this.btn2 = btn2;
		this.btn3 = btn3;
		this.btn4 = btn4;
		this.img = img;
		this.img2 = img2;
	}


	public Button getBtn1() {
		return btn1;
	}


	public void setBtn1(Button btn1) {
		this.btn1 = btn1;
	}


	public Button getBtn2() {
		return btn2;
	}


	public void setBtn2(Button btn2) {
		this.btn2 = btn2;
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


	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
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
		result = prime * result + ((btn2 == null) ? 0 : btn2.hashCode());
		result = prime * result + ((btn3 == null) ? 0 : btn3.hashCode());
		result = prime * result + ((btn4 == null) ? 0 : btn4.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
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
		if (btn2 == null) {
			if (other.btn2 != null)
				return false;
		} else if (!btn2.equals(other.btn2))
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
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
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
		return "HBoxEnTete [btn1=" + btn1 + ", btn2=" + btn2 + ", btn3=" + btn3 + ", btn4=" + btn4 + ", img=" + img
				+ ", img2=" + img2 + "]";
	}


	//Creation une classe interne Button handler pour connecter
	//on peut le sortir aprés comme classe externe

	private class ButtonHandler1 implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			//On instancie notre mot de passe pane
			MotPassePanel root = new MotPassePanel();

			//On instancie une nouvelle scene
			Scene scene = new Scene(root);
			//Récupérer le stage en cours pour lui transmettre la nouvelle scene
			Stage stage = (Stage) getScene().getWindow();
			stage.setScene(scene);
		}

	}
	//	
	//	


}
