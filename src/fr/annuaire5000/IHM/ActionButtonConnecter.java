package fr.annuaire5000.IHM;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	public static void modeAdmin(MainPanel root)
	{
		Stage popupwindow=new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Window Admin");

		try {

			GridPane gridpane = new GridPane();

			gridpane.setPadding(new Insets(20));
			gridpane.setHgap(25);
			gridpane.setVgap(15);

			Label userName = new Label("UserName: ");
			gridpane.add(userName, 0,0);

			TextField userNametf = new TextField();
			gridpane.add(userNametf, 1,0);

			Label password = new Label("Password: ");
			gridpane.add(password, 0, 1);

			PasswordField passwordField = new PasswordField();
			gridpane.add(passwordField, 1, 1);

			TextField pass_text = new TextField();
			pass_text.setVisible(false);
			gridpane.add(pass_text, 1, 1);

			CheckBox pass_Toggle = new CheckBox("Show Password");
			gridpane.add(pass_Toggle, 2, 1);

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
			gridpane.add(label, 0, 3);
			GridPane.setColumnSpan(label,2);

			Button  login = new Button ("Login");
			gridpane.add(login, 1, 2);

			Button  btnQuitter = new Button ("Exit");
			gridpane.add(btnQuitter, 2, 2);

			login.setOnAction(e->{
				if((userName.getText() !=null && !passwordField.getText().isEmpty() ))
				{
					if(!passwordField.getText().equals("@fromage")) 
					{

						label.setText("Oups désolé votre mot de passe est incorrect !!");


					}else
					{
						label.setText("Parfait !!  merci pour votre connection");

						//modifier mode admin
						root.getLeftVBox().getBtnModifier().setOnAction(d->{

							String nomSupr=root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedItem().getNom();
							NoeudDao.supprimer(nomSupr);

							root.getRightVBox().getObservableEtudiants().remove(root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedIndex());

							String nom = root.getLeftVBox().getTfNom().getText();
							String prenom = root.getLeftVBox().getTfPrenom().getText();
							String departement = root.getLeftVBox().getTfDepartement().getText();
							String promotion = root.getLeftVBox().getTfPromotion().getText();
							String annee = root.getLeftVBox().getTfAnnee().getText();

							Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
							NoeudDao.ajouterEtudiant(etudiant);
							root.getRightVBox().getObservableEtudiants().add(0, etudiant);

						} );

						//Supprimer mode admin
						root.getLeftVBox().getBtnSupprimer().setOnAction(d-> {

							String nom=root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedItem().getNom();

							NoeudDao.supprimer(nom);
							root.getRightVBox().getObservableEtudiants().remove(root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedIndex());

						});

						popupwindow.close();

					}

				}else
				{
					label.setText("Veuillez entrer votre nom et password");
				}
			});
			btnQuitter.setOnAction(e->popupwindow.close());
			Scene scene1= new Scene(gridpane, 650, 450);
			popupwindow.setScene(scene1);
			popupwindow.showAndWait();	

		}catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
