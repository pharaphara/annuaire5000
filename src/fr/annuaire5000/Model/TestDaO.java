package fr.annuaire5000.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;




public class TestDaO {

	public static void main(String[] args) {
		
			File file = new File("./stagiaires.txt");
		
			EtudiantDAO dao = new EtudiantDAO();
			List<Etudiant> etudiants = dao.importExtern(file);
			
			for (Etudiant etudiant : etudiants) {
				System.out.println(etudiant);
			}
				
			
			System.out.println(etudiants.get(2).compareTo(etudiants.get(1)));
			
			ArbreBinaire ab = new ArbreBinaire();
			ab=dao.initialisationArbre(etudiants);
			
					
			ab.affichageOrdre(ab.root);
			
			
			dao.sauvegarderArbre(ab);
			
			
			
			

			
		}
}
	
	

