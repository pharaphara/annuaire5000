package fr.annuaire5000.Model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NoeudDao {

	public File fileArbre = new File("./arbreTest.bin");



	static void inserer(Etudiant etudiant, File file) 
	{

		RandomAccessFile raf = null;
		String lenom = null;
		Long gauche = null;
		Long droite = null;



		try {
			raf = new RandomAccessFile(file, "rw");
			byte[] nom = new byte[30];
			raf.seek(0);
			raf.read(nom);
			lenom=nom.toString();

			if(lenom.compareToIgnoreCase(etudiant.getNom())>0) {
				raf.seek(raf.getFilePointer()+47);
				gauche=raf.readLong();
			}



			raf.seek(77);


			raf.writeBytes(etudiant.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	static void initialisation (RandomAccessFile raf) throws IOException {

		raf.writeBytes(new Etudiant("/racine", "1", "2", "3", "4").toLargeurFixe());
		raf.writeLong(Long.MAX_VALUE);
		raf.writeLong(Long.MAX_VALUE);
		raf.seek(0);
		byte[] init = new byte[93];
		raf.readFully(init);




	}


	static Long insererBin(Etudiant etudiant, Long index, RandomAccessFile raf) throws IOException 
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

	static void affichageOrdreBin(Long noeud, RandomAccessFile raf) throws IOException {

		raf.seek(noeud);

		byte[] nom = new byte[30];
		raf.read(nom);
		raf.seek(raf.getFilePointer()+47);
		Long gauche = raf.readLong();
		Long droite = raf.readLong();


		String lenom= new String(nom, StandardCharsets.UTF_8);

		if (gauche!=Long.MAX_VALUE) {
			affichageOrdreBin(gauche,raf);
		}

		System.out.print(lenom.trim()+" - ");

		if (droite!=Long.MAX_VALUE) {
			affichageOrdreBin(droite,raf);
		}
	}

	static Long dernierDescendantBin(Long noeud, RandomAccessFile raf) throws IOException 
	{
		System.out.println("dans dernier desandant");

		raf.seek(noeud+85);
		Long droite = raf.readLong();
		if (droite == Long.MAX_VALUE)
			return noeud;
		return dernierDescendantBin(droite,raf);
	}


	static Long supprimerNomBin(String nom, Long noeud, RandomAccessFile raf) throws IOException
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



	static Long supprimerRacineNomBin( Long noeud, RandomAccessFile raf) throws IOException 
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

	static List<Etudiant> recherche (String[] criteres, RandomAccessFile raf) throws IOException{

		List<Etudiant> resultats = new ArrayList<Etudiant>();
		List<Integer> indexMatch = new ArrayList<Integer>();

		for (String str : criteres) {
			System.out.println(str);
		}

		if (criteres[0]!=null) {

			System.out.println("dans 0");
			long taillefichier = raf.length();
			byte[] nomBin = new byte[30];//la colonne nom fait 30 octets de large
			int pointeur = 0;
			
			while (raf.getFilePointer()<taillefichier) {
				raf.seek(93*pointeur);//chaque etudiant fait 92 octets
				raf.read(nomBin);
				String nom= new String(nomBin, StandardCharsets.UTF_8).trim();
				//System.out.println("lenom = "+nom);
				if (nom.contains(criteres[0])) {
					System.out.println(" nom = "+nom);
					System.out.println("quand pointeur = "+pointeur);
					indexMatch.add(pointeur);

				}
				pointeur++;//chaque etudiant fait 92 octet
			}

		}
		System.out.println("sortie de 0");
		if (criteres[1]!=null) {

			long taillefichier = raf.length();
			byte[] prenomBin = new byte[30];//la colonne nom fait 30 octets de large
			int pointeur = 0;
			String resultat = "";


			if (!indexMatch.isEmpty()) {
				for (Integer integer : indexMatch) {
					raf.seek(92*integer+30);//chaque etudiant fait 92 octets et le prénom se trouve à +30 octet
					raf.read(prenomBin);
					String prenom= new String(prenomBin, StandardCharsets.UTF_8).trim();
					if (!prenom.contains(criteres[1])) {
						indexMatch.remove(prenom);
					}
				}
			}else {
				raf.seek(0);
				while (raf.getFilePointer()<taillefichier) {
					raf.seek(92*pointeur+30);//chaque etudiant fait 92 octets
					raf.read(prenomBin);
					String prenom = new String(prenomBin, StandardCharsets.UTF_8).trim();
					if (prenom.contains(criteres[1])) {
						indexMatch.add(pointeur);
					}
					pointeur++;//chaque etudiant fait 92 octet
				}
			}


		}
		;
		if (criteres[2]!=null) {

			long taillefichier = raf.length();
			byte[] depBin = new byte[3];//la colonne dep fait 3 octets de large
			int pointeur = 0;
			String resultat = "";


			if (!indexMatch.isEmpty()) {

				for (Integer integer : indexMatch) {
					raf.seek(92*integer+60);//chaque etudiant fait 92 octets et le prénom se trouve à +60 octet
					raf.read(depBin);
					String dep= new String(depBin, StandardCharsets.UTF_8).trim();
					if (!dep.contains(criteres[2])) {
						indexMatch.remove(dep);
					}
				}
			}else {
				raf.seek(0);
				while (raf.getFilePointer()<taillefichier) {
					raf.seek(92*pointeur+30);//chaque etudiant fait 92 octets
					raf.read(depBin);
					String prenom = new String(depBin, StandardCharsets.UTF_8).trim();
					if (prenom.contains(criteres[2])) {
						indexMatch.add(pointeur);
					}
					pointeur++;//chaque etudiant fait 92 octet
				}
			}


		}
		if (criteres[3]!=null) {

			long taillefichier = raf.length();
			byte[] promoBin = new byte[10];//la colonne promo fait 10 octets de large
			int pointeur = 0;



			if (!indexMatch.isEmpty()) {

				for (Integer integer : indexMatch) {
					raf.seek(92*integer+63);//chaque etudiant fait 92 octets et le prénom se trouve à +60 octet
					raf.read(promoBin);
					String promo= new String(promoBin, StandardCharsets.UTF_8).trim();
					if (!promo.contains(criteres[3])) {
						indexMatch.remove(promo);
					}
				}
			}else {
				raf.seek(0);
				while (raf.getFilePointer()<taillefichier) {
					raf.seek(92*pointeur+30);//chaque etudiant fait 92 octets
					raf.read(promoBin);
					String promo = new String(promoBin, StandardCharsets.UTF_8).trim();
					if (promo.contains(criteres[3])) {
						indexMatch.add(pointeur);
					}
					pointeur++;//chaque etudiant fait 92 octet
				}
			}


		}
		if (criteres[4]!=null) {

			long taillefichier = raf.length();
			byte[] depBin = new byte[4];//la col année  fait 4 octets de large
			int pointeur = 0;



			if (!indexMatch.isEmpty()) {

				for (Integer integer : indexMatch) {
					raf.seek(92*integer+73);//chaque etudiant fait 92 octets et le prénom se trouve à +60 octet
					raf.read(depBin);
					String dep= new String(depBin, StandardCharsets.UTF_8).trim();
					if (!dep.contains(criteres[4])) {
						indexMatch.remove(dep);
					}
				}
			}else {
				raf.seek(0);
				while (raf.getFilePointer()<taillefichier) {
					raf.seek(92*pointeur+73);//chaque etudiant fait 92 octets
					raf.read(depBin);
					String prenom = new String(depBin, StandardCharsets.UTF_8).trim();
					if (prenom.contains(criteres[4])) {
						indexMatch.add(pointeur);
					}
					pointeur++;//chaque etudiant fait 92 octet
				}
			}


		}





		
		for (Integer integer : indexMatch) {

			System.out.println("resultat à la position = "+(Integer.toHexString(integer*93)));
		}
		return null;

	}



}


