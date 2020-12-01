package fr.annuaire5000.IHM;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAppAnnuaire5000 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MainPanel root = new MainPanel();
		
		Scene scene = new Scene(root, 1400, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Annuaire5000");
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
		

	}

}
