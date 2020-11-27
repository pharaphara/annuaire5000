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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ActionButtonConnecter {

	public static void modeAdmin(LeftGridPane leftGridPane)
	{
		Stage popupwindow=new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Window Admin");

		try {

			GridPane root = new GridPane();

			root.setPadding(new Insets(20));
			root.setHgap(25);
			root.setVgap(15);

			Label userName = new Label("UserName: ");
			root.add(userName, 0,0);

			TextField userNametf = new TextField();
			root.add(userNametf, 1,0);

			Label password = new Label("Password: ");
			root.add(password, 0, 1);

			PasswordField passwordField = new PasswordField();
			root.add(passwordField, 1, 1);

			TextField pass_text = new TextField();
			pass_text.setVisible(false);
			root.add(pass_text, 1, 1);

			CheckBox pass_Toggle = new CheckBox("Show Password");
			root.add(pass_Toggle, 2, 1);

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

			Label label = new Label("");
			root.add(label, 0, 3);
			GridPane.setColumnSpan(label,2);

			Button  login = new Button ("Login");
			root.add(login, 1, 2);

			Button  btnQuitter = new Button ("Exit");
			root.add(btnQuitter, 2, 2);

			login.setOnAction(e->{
				if((userName.getText() !=null && !passwordField.getText().isEmpty() ))
				{
					if(!passwordField.getText().equals("@fromage")) 
					{

						label.setText("Oups désolé votre mot de passe est incorrect !!");


					}else
					{
						label.setText("Parfait !!  merci pour votre connection");

						leftGridPane.getBtnModifier().setOnAction(m-> System.out.println("là tu peux modifier oui"));
						leftGridPane.getBtnSupprimer().setOnAction(s-> System.out.println("là tu peux supprimer oui"));

						popupwindow.close();

					}

				}else
				{
					label.setText("Veuillez entrer votre nom et password");
				}
			});
			btnQuitter.setOnAction(e->popupwindow.close());
			Scene scene1= new Scene(root, 650, 450);
			popupwindow.setScene(scene1);
			popupwindow.showAndWait();	

		}catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
