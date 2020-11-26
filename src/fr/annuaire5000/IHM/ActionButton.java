package fr.annuaire5000.IHM;

import fr.annuaire5000.Model.Etudiant;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ActionButton {

	public static void modeAdmin()
	{
		Stage popupwindow=new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Window Admin");

		try {

			GridPane root = new GridPane();
			root.setStyle("-fx-background-color: CORNSILK");
			root.setPadding(new Insets(20));
			root.setHgap(25);
			root.setVgap(15);

			//Scene scene = new Scene(root,650,200);

			//Label UserName
			Label userName = new Label("UserName: ");
			root.add(userName, 0,0);
			//userName.getStyleClass().add("lb");
			userName.setStyle("-fx-text-fill:#32343f; -fx-font: bold 13pt \"Book Antiqua\"");

			//TextField UserName
			TextField userNametf = new TextField();
			root.add(userNametf, 1,0);
			//userNametf.getStyleClass().add("tf");
			userNametf.setStyle("-fx-text-fill: #ffaa19;\r\n"
					+ "	-fx-font: bold 13pt \"Avenir\";\r\n"
					+ "	-fx-background-color: #32343f;");
			//Label Password
			Label password = new Label("Password: ");
			root.add(password, 0, 1);
			//password.getStyleClass().add("lb");
			password.setStyle("-fx-text-fill:#32343f; -fx-font: bold 13pt \"Book Antiqua\"");


			//Password Field
			PasswordField passwordField = new PasswordField();
			root.add(passwordField, 1, 1);
			//passwordField.getStyleClass().add("tf");
			passwordField.setStyle("-fx-text-fill: #ffaa19; -fx-font: bold 13pt \"Avenir\"; -fx-background-color: #32343f");

			//TextField pour afficher le password
			TextField pass_text = new TextField();
			pass_text.setVisible(false);
			root.add(pass_text, 1, 1);
			//pass_text.getStyleClass().add("tf");
			pass_text.setStyle("-fx-text-fill: #ffaa19; -fx-font: bold 13pt \"Avenir\"; -fx-background-color: #32343f");

			//CheckBox (Affichage de mot passe)
			CheckBox pass_Toggle = new CheckBox("Show Password");
			root.add(pass_Toggle, 2, 1);
			//pass_Toggle.getStyleClass().add("lb");
			pass_Toggle.setStyle("-fx-text-fill:#32343f; -fx-font: bold 13pt \"Book Antiqua\"");

			//Evenement (je vais le sortir dans un classe tout seul juste pour un test)

			pass_Toggle.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_Val)->{

				if(pass_Toggle.isSelected()) {

					pass_text.setText(passwordField.getText());
					pass_text.setVisible(true);
					passwordField.setVisible(false);
					return;
				}
				passwordField.setText(pass_text.getText());
				passwordField.setVisible(true);
				pass_text.setVisible(false);

			});


			//Label pour afficher le message
			Label label = new Label("");
			root.add(label, 0, 3);
			GridPane.setColumnSpan(label,2);
			//label.getStyleClass().add("lb");
			label.setStyle("-fx-text-fill:#32343f; -fx-font: bold 13pt \"Book Antiqua\"");


			//Button Login
			Button  login = new Button ("Login");
			root.add(login, 1, 2);
			//label.getStyleClass().add("lb");
			label.setStyle("-fx-text-fill:#32343f; -fx-font: bold 13pt \"Book Antiqua\"");

			//login.getStyleClass().add("btn");
			login.setStyle("	-fx-text-fill: #32343f;\r\n"
					+ "	-fx-font: bold 15pt \"Book Antiqua\";\r\n"
					+ "	-fx-background-color: #ffaa19;");

			//show
			login.setOnAction(e->{
				if((userName.getText() !=null && !passwordField.getText().isEmpty() ))
				{
					if(!passwordField.getText().equals("@fromage")) 
					{

						label.setText("Oups désolé votre mot de passe est incorrect !!");

						label.setTextFill(Color.rgb(210, 39, 30));
					}else
					{
						label.setText("Parfait !!  merci pour votre connection");
						label.setTextFill(Color.rgb(21, 117, 84));
					}

				}else
				{
					label.setText("Veuillez entrer votre nom et password");
				}


			});
			//ajouter le gird pane
			Scene scene1= new Scene(root, 650, 450);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			popupwindow.setScene(scene1);
			popupwindow.showAndWait();	

		}catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	
	public static void Ajouter(LeftGridPane leftGridPane, RightVBoxTableViews rightVBox) {
		String nom = leftGridPane.getTfNom().getText();
		String prenom = leftGridPane.getTfPrenom().getText();
		String departement = leftGridPane.getTfDepartement().getText();
		String promotion = leftGridPane.getTfPromotion().getText();
		String annee = leftGridPane.getTfAnnee().getText();
		Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
		System.out.println(etudiant.toString());
		rightVBox.getObservableEtudiants().add(etudiant);
	
		
	}

}

