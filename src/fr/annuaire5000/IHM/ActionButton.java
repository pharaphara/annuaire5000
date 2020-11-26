package fr.annuaire5000.IHM;

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
			root.setPadding(new Insets(20));
			root.setHgap(25);
			root.setVgap(15);

			//Scene scene = new Scene(root,650,200);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//Label UserName
			Label userName = new Label("UserName: ");
			root.add(userName, 0,0);
			userName.getStyleClass().add("lb");


			//TextField UserName
			TextField userNametf = new TextField();
			root.add(userNametf, 1,0);
			userNametf.getStyleClass().add("tf");

			//Label Password
			Label password = new Label("Password: ");
			root.add(password, 0, 1);
			password.getStyleClass().add("lb");


			//Password Field
			PasswordField passwordField = new PasswordField();
			root.add(passwordField, 1, 1);
			passwordField.getStyleClass().add("tf");


			//TextField pour afficher le password
			TextField pass_text = new TextField();
			pass_text.setVisible(false);
			root.add(pass_text, 1, 1);
			pass_text.getStyleClass().add("tf");


			//CheckBox (Affichage de mot passe)
			CheckBox pass_Toggle = new CheckBox("Show Password");
			root.add(pass_Toggle, 2, 1);
			pass_Toggle.getStyleClass().add("lb");

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
			label.getStyleClass().add("lb");


			//Button Login
			Button  login = new Button ("Login");
			root.add(login, 1, 2);
			label.getStyleClass().add("lb");
			login.getStyleClass().add("btn");

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

			popupwindow.setScene(scene1);

			popupwindow.showAndWait();	

		}catch (Exception e) {
			e.printStackTrace();		
		}
	}
}

