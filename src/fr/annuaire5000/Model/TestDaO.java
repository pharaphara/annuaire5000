package fr.annuaire5000.Model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

//		racine.supprimerNom("abcd", racine);
//		racine.affichageOrdre(racine);

		NoeudDao daoN = new NoeudDao();


		File fileArbre = new File("./arbreTest.bin");
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");

			daoN.initialisation(raf);

			Etudiant Etudiant1 = new Etudiant("Etudiant1", "1", "2", "3", "4");
			Etudiant Etudiant2 = new Etudiant("Etudiant2", "1", "2", "3", "4");
			NoeudDao.insererBin(Etudiant1, 0l, raf);
			NoeudDao.insererBin(Etudiant2, 0l, raf);
			for (Etudiant etudiant : etudiants) {
				NoeudDao.insererBin(etudiant, 0l, raf);
			}
			NoeudDao.supprimerNomBin("ZARA", 0l, raf);
			
			NoeudDao.affichageOrdreBin(0l, raf);
			
			
			



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}




