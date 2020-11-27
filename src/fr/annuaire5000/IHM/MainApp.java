package fr.annuaire5000.IHM;



import com.sun.javafx.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//com.sun.javafx.util.Logging.getCSSLogger().setLevel(sun.util.logging.PlatformLogger.Level.OFF);
		
		MainPanel root = new MainPanel();
		
		Scene scene = new Scene(root, 1200, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Annuaire5000");
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
		

	}

}
