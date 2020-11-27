package fr.annuaire5000.IHM;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HboxVboxPanel extends Application{


	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		
		//Partie HBOX (manque qlq rectifcation pour faire jolie les bouttons)
		
		HBox hbox1 = new HBox();
		Button btn1 = new Button("Importer");
		btn1.setStyle("-fx-border-color: black");
		Button btn2 = new Button("Exporter");
		btn2.setStyle("-fx-border-color: black");

		Button btn3 = new Button("Connecter");
		btn3.setStyle("-fx-border-color: black");

		Button btn4 = new Button("Help");
		btn4.setStyle("-fx-border-color: black");

		hbox1.setSpacing(10);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setStyle("-fx-background-color: teal"); 
		
		Pane pane = new HBox(15);
		Image img = new Image("EQL.png");
		//pane.getChildren().add(new ImageView(img));
		pane.setPrefSize(50, 50);
		ImageView img2 = new ImageView(img);
		img2.setFitHeight(50);
		img2.setFitWidth(50);
		pane.getChildren().add(img2);
		hbox1.getChildren().addAll(pane);	
		hbox1.getChildren().addAll(btn1, btn2, btn3, btn4);

		root.setTop(hbox1);
        //Partie VBox (liste stagiaire + resultat de recherche)

		VBox box = new VBox();
		box.setPadding(new Insets(80));
		Label lbl1 = new Label("Liste de stagiaire : ");
		TextField text = new TextField();
		text.setPrefSize(150, 350);
		
		Label lbl2 = new Label("Resultat:");
		TextField text1 = new TextField();
		text1.setPrefSize(150, 350);
		box.getChildren().addAll(lbl1,text,lbl2,text1);
		lbl1.setPadding(new Insets(0,70,0,0));
		box.setAlignment(Pos.TOP_CENTER);
		box.setPrefWidth(600);
		box.setStyle("-fx-background-color: cyan");

		root.setRight(box);

		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Projet 1 ");
		primaryStage.show();

	}



	public static void main(String[] args)  {

		launch(args);

	}



}
