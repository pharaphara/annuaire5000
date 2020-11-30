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


		

		
			
			
			NoeudDao.ajouterListEtudiant(etudiants);
			
		
			
//			String[] criteres = new String[] {null,null,"75",null,null};
//			System.out.println();
//			
//			NoeudDao.recherche(criteres);
			
			
			



}
}




