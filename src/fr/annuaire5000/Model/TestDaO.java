package fr.annuaire5000.Model;

import java.io.File;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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
		//ab.affichageOrdre(ab.root);

		Noeud racine = new Noeud(new Etudiant("/racine"), null, null);

		for (Etudiant etudiant : etudiants) {
			racine.inserer(etudiant, racine);

		}
		//racine.affichageOrdre(racine);
		Etudiant Test = new Etudiant("Test");
		racine.inserer(Test, racine);

		Etudiant abcd= new Etudiant ("abcd");
		//racine.affichageOrdre(racine);

		String nom = "abcd";
		racine.inserer(abcd, racine);

		//racine.supprimer(Test, racine);
		
		racine.supprimerNom("abcd", racine);
		racine.affichageOrdre(racine);


	}
}




