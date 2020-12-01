package fr.annuaire5000.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NoeudDao {

	public static File fileArbre = new File("./arbre.bin");



	//Tableau contenant les longeurs de chaque information d'un noeud
	//exprimées en octet. Ces valeurs sont arbitraires. chaque noeud fait 93 octets
	//Avec dans l'ordre : 0=le nom, 1=le prénom, 2=le département, 3=la promotion, 4=l'année,5=fils gauche, 
	//6=fils droit,7=taille d'un noeud sans enfant, 8=taille d'un noeud avec enfant
	public static int[] structure = {30,30,3,10,4,8,8,77,93};

	public File getFileArbre() {
		return fileArbre;
	}
	public void setFileArbre(File fileArbre) {
		NoeudDao.fileArbre = fileArbre;
	}


	public static void ajouterListEtudiant (List<Etudiant> etudiants) {

		boolean isArbre =fileArbre.exists();


		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");

			//permet d'initialiser mon fichier à null et évite erreur de lecture dans insererBin
			if (!isArbre) {

				for (int i = 0; i <structure[8]; i++) {
					raf.writeBytes("*");
				}
			}
			for (Etudiant etudiant : etudiants) {
				insererBin(etudiant, 0l, raf);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}






	}

	public static void ajouterEtudiant (Etudiant etudiant) {
		boolean isArbre =fileArbre.exists();


		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");

			//permet d'initialiser mon fichier à null et évite erreur de lecture dans insererBin
			if (!isArbre) {
				for (int i = 0; i <structure[8]; i++) {
					raf.writeBytes("*");
				}
			}
			insererBin(etudiant, 0l, raf);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private static Long insererBin(Etudiant etudiant, Long index, RandomAccessFile raf) throws IOException 
	{
		raf.seek(index);
		byte[] nom = new byte[30];
		raf.read(nom);

		String lenom= new String(nom, StandardCharsets.UTF_8);



		if (nom[0]==35||nom[0]==42) {
			raf.seek(raf.getFilePointer()-30);
			raf.writeBytes(etudiant.toLargeurFixe());
			raf.writeLong(Long.MAX_VALUE);
			raf.writeLong(Long.MAX_VALUE);


			return index;
		}

		if ((etudiant.getNom().compareTo(lenom)<0)) {
			raf.seek(raf.getFilePointer()+47);
			index=raf.readLong();
			raf.seek(raf.getFilePointer()-8);
			Long pointer = raf.getFilePointer();
			Long fin =raf.length();

			if (index>fin) {



				raf.seek(pointer);
				raf.writeLong((fin));
				index=fin;
				raf.seek(index);
				raf.writeBytes("******************************");

			}
			insererBin(etudiant, index, raf);
		} else if ((etudiant.getNom().compareTo(lenom)>0)) {
			raf.seek(raf.getFilePointer()+55);
			index=raf.readLong();
			raf.seek(raf.getFilePointer()-8);
			Long pointer = raf.getFilePointer();
			Long fin =raf.length();
			if (index>fin) {


				raf.seek(pointer);
				raf.writeLong((fin));
				index=fin;
				raf.seek(index);
				raf.writeBytes("##############################");

			}
			insererBin(etudiant, index, raf);

		}

		return index;
	}

	public static List<Etudiant> getAllOrdre(){
		List<Etudiant> etudiantsOrdre = new ArrayList<Etudiant>();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");


			etudiantsOrdre=getAllOrdreBin(0l, raf);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}





		return etudiantsOrdre;
	}
	private static List<Etudiant> getAllOrdreBin(Long noeud, RandomAccessFile raf) throws IOException {

		raf.seek(noeud);
		List<Etudiant> etudiantsOrdre = new ArrayList<Etudiant>();

		String[] etudiant =new String[5];
		for (int i = 0; i < etudiant.length; i++) {
			byte[] temp = new byte[structure[i]];
			raf.read(temp);
			etudiant[i]=new String (temp, StandardCharsets.UTF_8).trim();
		}
		Etudiant etudiantduNoeud = new Etudiant(etudiant[0], etudiant[1], etudiant[2], etudiant[3], etudiant[4]);	

		Long gauche = raf.readLong();
		Long droite = raf.readLong();




		if (gauche!=Long.MAX_VALUE) {
			etudiantsOrdre.addAll(getAllOrdreBin(gauche,raf));
		}

		etudiantsOrdre.add(etudiantduNoeud);

		if (droite!=Long.MAX_VALUE) {
			etudiantsOrdre.addAll(getAllOrdreBin(droite,raf));
		}

		return etudiantsOrdre;
	}

	private static Long dernierDescendantBin(Long noeud, RandomAccessFile raf) throws IOException 
	{
		System.out.println("dans dernier desandant");

		raf.seek(noeud+85);
		Long droite = raf.readLong();
		if (droite == Long.MAX_VALUE)
			return noeud;
		return dernierDescendantBin(droite,raf);
	}

	public static void supprimer (String nom) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");


			supprimerNomBin(nom, 0l, raf);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private static Long supprimerNomBin(String nom, Long noeud, RandomAccessFile raf) throws IOException
	{

		System.out.println("dans supprimer nom");
		if (noeud == Long.MAX_VALUE)
			return noeud;

		raf.seek(noeud);
		byte[] nomBin = new byte[30];
		raf.read(nomBin);
		raf.seek(noeud+77);
		Long gauche = raf.readLong();
		Long droite = raf.readLong();
		String nomNoeud= new String(nomBin, StandardCharsets.UTF_8);
		System.out.println(nom+" compate to "+nomNoeud.trim());

		if (nom.equals(nomNoeud.trim())) {
			System.out.println("si égal noeud = "+noeud);
			return supprimerRacineNomBin(noeud, raf);
		}
		if (nom.compareTo(nomNoeud.trim())<0) {
			gauche=supprimerNomBin(nom, gauche, raf);
			raf.seek(noeud+77);
			raf.writeLong(gauche);
			System.out.println("noeud = "+gauche+" gauche = "+gauche);

		}
		else {
			droite=supprimerNomBin(nom, droite, raf);
			raf.seek(noeud+85);
			raf.writeLong(droite);
			System.out.println("noeud = "+droite+" gauche = "+droite);

		}
		return noeud;
	}



	private static Long supprimerRacineNomBin( Long noeud, RandomAccessFile raf) throws IOException 
	{
		System.out.println("dans supprimer racine noeud = "+noeud);
		raf.seek(noeud);
		raf.seek(noeud+77);
		Long gauche = raf.readLong();
		Long droite = raf.readLong();


		if (gauche == Long.MAX_VALUE)
			return droite;
		if (droite == Long.MAX_VALUE)
			return gauche;
		Long f = dernierDescendantBin(gauche, raf);
		raf.seek(f);
		byte[] fnomBin = new byte[30];
		raf.read(fnomBin);
		raf.seek(noeud+77);
		String fnomNoeud= new String(fnomBin, StandardCharsets.UTF_8);
		raf.seek(noeud);
		raf.write(fnomBin);

		gauche=supprimerNomBin(fnomNoeud.trim(), gauche, raf);
		raf.seek(raf.getFilePointer()+47);
		raf.writeLong(gauche);
		System.out.println("changement descendant noeud = "+noeud+" gauche = "+gauche);
		return noeud; // attention a ce retour f ou null
	}

	public static List<Etudiant> recherche(String[] criteres){
		List<Etudiant> resultats = new ArrayList<Etudiant>();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileArbre, "rw");


			resultats=rechercheBin(criteres, raf);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return resultats;

	}
	private static List<Etudiant> rechercheBin (String[] criteres, RandomAccessFile raf) throws IOException{

		List<Etudiant> resultatsIntermediaires = new ArrayList<Etudiant>();
		List<Etudiant> resultatsFinaux = new ArrayList<Etudiant>();
		
		int i=0;

		while (criteres[i]==null) {
			i++;	
		}
		System.out.println("après le while i= "+i);
		resultatsIntermediaires = rechercheCol(criteres[i], i, raf);
		System.out.println("nb de resultat = "+resultatsIntermediaires.size());
		for (Etudiant etudiant : resultatsIntermediaires) {
			System.out.println(etudiant);
		}
		for (i=i+1 ; i < criteres.length; i++) {
			System.out.println("après le for i= "+i);
			if (criteres[i]!=null) {
				resultatsFinaux.clear();
				for (Etudiant etudiant : resultatsIntermediaires) {
					if (etudiant.getField(i).toLowerCase().contains(criteres[i])){
						resultatsFinaux.add(etudiant);
					}
				}
				resultatsIntermediaires.clear();
				resultatsIntermediaires.addAll(resultatsFinaux);
			}
		}

		System.out.println("nb de resultat = "+resultatsIntermediaires.size());
		for (Etudiant etudiant : resultatsIntermediaires) {
			System.out.println(etudiant);
		}

		return resultatsIntermediaires;

	}

	private static List<Etudiant> rechercheCol(String critere,int numCol, RandomAccessFile raf) throws IOException {

		List<Etudiant> resultats = new ArrayList<Etudiant>();
		byte[] colBin = new byte[structure[numCol]];
		raf.seek(0);

		while (raf.getFilePointer()<raf.length()) {
			//premier switch pour placer le pointeur sur la colonne choisie
			switch (numCol) {

			case 1:
				raf.seek(raf.getFilePointer()+structure[0]);
				break;
			case 2:
				raf.seek(raf.getFilePointer()+structure[0]+structure[1]);
				break;
			case 3:
				raf.seek(raf.getFilePointer()+structure[0]+structure[1]+structure[2]);
				break;
			case 4:
				raf.seek(raf.getFilePointer()+structure[0]+structure[1]+structure[2]+structure[3]);
				break;
			case 5:
				raf.seek(raf.getFilePointer()+structure[0]+structure[1]+structure[2]+structure[3]+structure[4]);
				break;
			default : 
				break;

			}
			raf.read(colBin);
			//deuxieme swicth pour replacer le pointeur en début de ligne
			switch (numCol) {

			case 0:
				raf.seek(raf.getFilePointer()-structure[0]);
				break;
			case 1:
				raf.seek(raf.getFilePointer()-(structure[0]+structure[1]));

				break;
			case 2:
				raf.seek(raf.getFilePointer()-(structure[0]+structure[1]+structure[2]));

				break;
			case 3:
				raf.seek(raf.getFilePointer()-(structure[0]+structure[1]+structure[2]+structure[3]));

				break;
			case 4:
				raf.seek(raf.getFilePointer()-(structure[0]+structure[1]+structure[2]+structure[3]+structure[4]));

				break;
			case 5:
				raf.seek(raf.getFilePointer()-structure[7]);

				break;
			default : 
				break;
			}
			String colonne = new String(colBin, StandardCharsets.UTF_8).trim().toLowerCase();

			if (colonne.contains(critere)) {
				
				String[] etudiant =new String[5];
				//switch permétant le retour en début de ligne en fonction de la collone dans laqullle on recherche

				for (int i = 0; i < etudiant.length; i++) {
					byte[] temp = new byte[structure[i]];
					raf.read(temp);
					etudiant[i]=new String (temp, StandardCharsets.UTF_8).trim();
					
				}//déplacement du poiteur en début de ligne 
				raf.seek(raf.getFilePointer()-structure[7]);
				Etudiant match = new Etudiant(etudiant[0], etudiant[1], etudiant[2], etudiant[3], etudiant[4]);
				resultats.add(match);


			}
			//pointeur à la ligne suivante
			raf.seek(raf.getFilePointer()+structure[8]);
		}

		return resultats;


	}



}


