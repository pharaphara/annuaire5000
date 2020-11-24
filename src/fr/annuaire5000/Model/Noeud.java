package fr.annuaire5000.Model;

public class Noeud implements Comparable<Noeud>{
	
	Etudiant etudiant;
    Noeud gauche;
    Noeud droite;

    Noeud(Etudiant value) {
        this.etudiant = value;
        gauche = null;
        droite = null;
    }

	public Noeud() {
		super();
	}
	

	

	public Noeud(Etudiant etudiant, Noeud gauche, Noeud droite) {
		super();
		this.etudiant = etudiant;
		this.gauche = gauche;
		this.droite = droite;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Noeud getGauche() {
		return gauche;
	}

	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}

	public Noeud getDroite() {
		return droite;
	}

	public void setDroite(Noeud droite) {
		this.droite = droite;
	}

	
	

	@Override
	public String toString() {
		return "Noeud [etudiant=" + etudiant + ", gauche=" + gauche + ", droite=" + droite + "]";
	}

	@Override
	public int compareTo(Noeud o) {
		// TODO Auto-generated method stub
		return this.getEtudiant().getNom().compareTo(o.getEtudiant().getNom());
	}
	

    
    

}
