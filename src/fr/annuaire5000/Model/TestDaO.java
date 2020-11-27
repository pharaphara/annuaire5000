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

		
		
		

		NoeudDao daoN = new NoeudDao();


		File fileArbre = new File("./arbreTest.bin");
		if (fileArbre.exists()) {
			fileArbre.delete();
		}
		RandomAccessFile raf;
		try {
			
			raf = new RandomAccessFile(fileArbre, "rw");

			NoeudDao.initialisation(raf);

			Etudiant Etudiant1 = new Etudiant("Etudiant1", "1", "2", "3", "4");
			Etudiant Etudiant2 = new Etudiant("Etudiant2", "1", "2", "3", "4");
			NoeudDao.insererBin(Etudiant1, 0l, raf);
			NoeudDao.insererBin(Etudiant2, 0l, raf);
			for (Etudiant etudiant : etudiants) {
				NoeudDao.insererBin(etudiant, 0l, raf);
			}
			NoeudDao.affichageOrdreBin(0l, raf);
			System.out.println();
			NoeudDao.supprimerNomBin("ABDENNEBI", 0l, raf);
			
			NoeudDao.affichageOrdreBin(0l, raf);
			
			String[] criteres = new String[] {"NGUY",null,null,null,null};
			System.out.println();
			
			NoeudDao.recherche(criteres, raf);
			
			
			



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}




