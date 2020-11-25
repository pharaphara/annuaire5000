package fr.annuaire5000.Model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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
		
		raf.writeBytes(new Etudiant("/racine", "", "", "", "").toLargeurFixe());
		raf.writeLong(Long.MIN_VALUE);
		raf.writeLong(Long.MIN_VALUE);
		raf.seek(0);
		byte[] init = new byte[93];
		raf.readFully(init);
		
		System.out.println(init.toString());
		
		
	}
	
	
	static Long inserer(Etudiant etudiant, Long index, RandomAccessFile raf) throws IOException 
	{
		raf.seek(index);
		byte[] nom = new byte[30];
		 raf.read(nom);
		String lenom = nom.toString();
		if (lenom == "000000000000000000000000000000") {
			
			raf.writeBytes(etudiant.toLargeurFixe());
			raf.writeLong(Long.MIN_VALUE);
			raf.writeLong(Long.MIN_VALUE);
			
			return index;
		}

		if ((etudiant.getNom().compareTo(lenom)<0)) {
			raf.seek(raf.getFilePointer()+47);
			index=raf.readLong();
			if (index==Long.MIN_VALUE) {
			Long fin =raf.length();
			raf.seek(raf.getFilePointer()-8);
			raf.writeLong((fin-1));
			index=fin-1;
			raf.writeBytes("000000000000000000000000000000");
			}
			inserer(etudiant, index, raf);
		} else if ((etudiant.getNom().compareTo(lenom)>0)) {
			raf.seek(raf.getFilePointer()+55);
			index=raf.readLong();
			if (index==Long.MIN_VALUE) {
				Long fin =raf.length();
				raf.seek(raf.getFilePointer()-8);
				raf.writeLong((fin-1));
				index=fin-1;
				raf.writeBytes("000000000000000000000000000000");
				}
			inserer(etudiant, index, raf);
		}return index;
	}


}
