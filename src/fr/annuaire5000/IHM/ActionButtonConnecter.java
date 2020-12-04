package fr.annuaire5000.IHM;

import fr.annuaire5000.Model.Etudiant;
import fr.annuaire5000.Model.NoeudDao;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

			Label password = new Label("Password: ");
			gridpane.add(password, 0, 1);

			PasswordField passwordField = new PasswordField();
			gridpane.add(passwordField, 1, 1);

			TextField pass_text = new TextField();
			pass_text.setVisible(false);
			gridpane.add(pass_text, 1, 1);
			pass_text.setText(passwordField.getText());
			pass_text.setVisible(true);
			passwordField.setVisible(false);
			passwordField.setText(pass_text.getText());
			passwordField.setVisible(true);
			pass_text.setVisible(false);


			Label label = new Label("");
			gridpane.add(label, 0, 3);
			GridPane.setColumnSpan(label,2);

			Button  login = new Button ("Login");
			gridpane.add(login, 1, 2);

			Button  btnQuitter = new Button ("Exit");
			gridpane.add(btnQuitter, 2, 2);

			login.setOnAction(e->{
				if((passwordField.getText()!=null ))
				{
					if(passwordField.getText().equals("@fromage")) 
					{

						label.setText("Parfait !!  merci pour votre connection");
						root.getLeftVBox().getBtnModifier().setDisable(false);
						root.getLeftVBox().getBtnSupprimer().setDisable(false);

						//modifier mode admin
						root.getLeftVBox().getBtnModifier().setOnAction(d->{

							String nomSupr=root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedItem().getNom();
							NoeudDao.supprimer(nomSupr);

							
							String nom = root.getLeftVBox().getTfNom().getText();
							String prenom = root.getLeftVBox().getTfPrenom().getText();
							String departement = root.getLeftVBox().getTfDepartement().getText();
							String promotion = root.getLeftVBox().getTfPromotion().getText();
							String annee = root.getLeftVBox().getTfAnnee().getText();
							root.getRightVBox().getObservableEtudiants().remove(root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedItem());

							Etudiant etudiant = new Etudiant(nom, prenom, departement, promotion, annee);
							NoeudDao.ajouterEtudiant(etudiant);
							root.getRightVBox().getObservableEtudiants().add(0, etudiant);

						} );

						//Supprimer mode admin
						root.getLeftVBox().getBtnSupprimer().setOnAction(d-> {

							String nom=root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedItem().toLargeurFixe().trim();

							NoeudDao.supprimer(nom);
							root.getRightVBox().getObservableEtudiants().remove(root.getRightVBox().getTableEtudiants().getSelectionModel().getSelectedIndex());

						});

						popupwindow.close();

					}else
					{
						label.setText("Oups désolé votre mot de passe est incorrect !!");
					}

				}else
				{
					label.setText("Veuillez entrer votre password");
				}
			});
			btnQuitter.setOnAction(e->popupwindow.close());
			Scene scene1= new Scene(gridpane, 400, 150);


			popupwindow.setScene(scene1);
			popupwindow.showAndWait();	

		}catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
