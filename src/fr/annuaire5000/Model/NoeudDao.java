package fr.annuaire5000.Model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

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

		System.out.println(init.toString());


	}


	static Long insererBin(Etudiant etudiant, Long index, RandomAccessFile raf) throws IOException 
	{
		System.out.println("début index = "+index);
		raf.seek(index);
		byte[] nom = new byte[30];
		raf.read(nom);

		String lenom= new String(nom, StandardCharsets.UTF_8);
		System.out.println("le nom pointeur = "+raf.getFilePointer());
		System.out.println("lenom = "+lenom);



		if (nom[0]==35||nom[0]==42) {
			System.out.println("pointeur = "+raf.getFilePointer());
			raf.seek(raf.getFilePointer()-30);
			System.out.println("pointeur = "+raf.getFilePointer());
			raf.writeBytes(etudiant.toLargeurFixe());
			raf.writeLong(Long.MAX_VALUE);
			raf.writeLong(Long.MAX_VALUE);
			System.out.println("nouveau noeud index = "+index);

			return index;
		}
		System.out.println("2eme partie");
		if ((etudiant.getNom().compareTo(lenom)<0)) {
			raf.seek(raf.getFilePointer()+47);
			index=raf.readLong();
			raf.seek(raf.getFilePointer()-8);
			Long pointer = raf.getFilePointer();
			Long fin =raf.length();

			if (index>fin) {


				System.out.println("fin = "+fin);
				raf.seek(pointer);
				raf.writeLong((fin));
				index=fin;
				raf.seek(index);
				raf.writeBytes("******************************");
				System.out.println("val index gauche = "+index);
			}
			insererBin(etudiant, index, raf);
		} else if ((etudiant.getNom().compareTo(lenom)>0)) {
			raf.seek(raf.getFilePointer()+55);
			index=raf.readLong();
			raf.seek(raf.getFilePointer()-8);
			Long pointer = raf.getFilePointer();
			Long fin =raf.length();
			if (index>fin) {

				System.out.println("fin = "+fin);
				raf.seek(pointer);
				raf.writeLong((fin));
				index=fin;
				raf.seek(index);
				raf.writeBytes("##############################");
				System.out.println("val index droite = "+index);
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

		System.out.print(lenom.trim());

		if (droite!=Long.MAX_VALUE) {
			affichageOrdreBin(droite,raf);
		}
	}

	static Long dernierDescendantBin(Long noeud, RandomAccessFile raf) throws IOException 
	{
		System.out.println("dans dernier desandant");
		raf.seek(noeud);
		byte[] nomBin = new byte[30];
		raf.read(nomBin);
		raf.seek(raf.getFilePointer()+47);
		Long gauche = raf.readLong();
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
		raf.seek(raf.getFilePointer()+47);
		Long gauche = raf.readLong();
		Long droite = raf.readLong();
		String nomNoeud= new String(nomBin, StandardCharsets.UTF_8);
		System.out.println(nom+" = "+nomNoeud.trim());
		System.out.println(nom.equals(nomNoeud.trim()));
		System.out.println(nom.compareTo(nomNoeud.trim())<0);
		System.out.println(nom.compareTo(nomNoeud.trim())>0);
		System.out.println();
		if (nom.equals(nomNoeud.trim())) {
			System.out.println("si égal noeud = "+noeud);
		return supprimerRacineNomBin(noeud, raf);
		}
		if (nom.compareTo(nomNoeud.trim())<0)
			supprimerNomBin(nom, gauche, raf);
		else 
			supprimerNomBin(nom, droite, raf);
		return noeud;
	}



	static Long supprimerRacineNomBin( Long noeud, RandomAccessFile raf) throws IOException 
	{
		System.out.println("dans supprimer racine noeud = "+noeud);
		raf.seek(noeud);
		byte[] nomBin = new byte[30];
		raf.read(nomBin);
		raf.seek(raf.getFilePointer()+47);
		Long gauche = raf.readLong();
		Long droite = raf.readLong();
		String nomNoeud= new String(nomBin, StandardCharsets.UTF_8);
System.out.println("gauche = "+gauche);
System.out.println("droite = "+droite);
		if (gauche == Long.MAX_VALUE) {
			System.out.println("retour droite");
			return droite;
		}
		if (droite == Long.MAX_VALUE) {
			System.out.println("retour gauche");
			
			return gauche;
		}
		System.out.println("apres le if");
		
		Long f = dernierDescendantBin(gauche, raf);
		raf.seek(f);
		byte[] fnomBin = new byte[30];
		raf.read(nomBin);
		raf.seek(raf.getFilePointer()+47);
		Long fgauche = raf.readLong();
		Long fdroite = raf.readLong();
		String fnomNoeud= new String(fnomBin, StandardCharsets.UTF_8);

		raf.seek(noeud);
		raf.write(fnomBin);

		gauche=supprimerNomBin(fnomNoeud.trim(), gauche, raf);
		return null; // attention a ce retour f ou null
	}

}


