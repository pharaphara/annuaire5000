package fr.annuaire5000.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestDaO {

	public static void main(String[] args) {
		
			File file = new File("./stagiaires.txt");
		
			EtudiantDAO dao = new EtudiantDAO();
			List<Etudiant> etudiants = dao.importExtern(file);
			
			System.out.println(etudiants);
			
			
			

		}

	}


