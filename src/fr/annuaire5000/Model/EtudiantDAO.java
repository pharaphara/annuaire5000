package fr.annuaire5000.Model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class EtudiantDAO {


	public List<Etudiant> importExtern (File file){


		List<Etudiant> etudiants = new ArrayList<Etudiant>();

		RandomAccessFile raf = null;

		List<String> liststringEtudiants = new ArrayList<>();
		String lecture="";
		try {
			raf = new RandomAccessFile(file, "r");
			while(raf.getFilePointer()<file.length()) {

				for (int i = 0; i < 5; i++) {//5= nombre de ligne avec des information dans le fichier d'import
					lecture = lecture+raf.readLine()+";";
				}
				raf.readLine();//pour sauter la ligne de l'étoile
				String strIso = new String(lecture.getBytes("ISO-8859-1"), "UTF-8");
				liststringEtudiants.add(strIso);
				lecture="";
			}

			for (String string : liststringEtudiants) {
				String[] info= string.split(";");
				Etudiant etudiant = new Etudiant(info[0].trim(),info[1].trim(),info[2].trim(),info[3].trim(),info[4].trim());
				etudiants.add(etudiant);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return etudiants;
	}


	

	
}

