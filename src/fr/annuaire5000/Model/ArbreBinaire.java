package fr.annuaire5000.Model;

public class ArbreBinaire {
	
	Noeud root = null;
	
	public void add(Etudiant etudiant) {
        root = ajoutR(root, etudiant);
    }

    private Noeud ajoutR(Noeud current, Etudiant etudiant) {

        if (current == null) {
            return new Noeud(etudiant);
        }

        if ((etudiant.compareTo(current.getEtudiant()))>0) {
            current.droite = ajoutR(current.droite, etudiant);
        } else if ((etudiant.compareTo(current.getEtudiant()))<0) {
            current.gauche = ajoutR(current.gauche, etudiant);
        }

        return current;
    }


	public ArbreBinaire(Noeud root) {
		super();
		this.root = root;
	}
	

	public ArbreBinaire() {
		super();
	}

	public Noeud getRoot() {
		return root;
	}

	public void setRoot(Noeud root) {
		this.root = root;
	}

public void affichage(Noeud noeud) {
		
	    if (noeud != null) {
	 	    System.out.println(" " + noeud.getEtudiant().getNom());
	        affichage(noeud.gauche);
	        affichage(noeud.droite);
	    }
	}

public void affichageOrdre(Noeud noeud) {
    if (noeud != null) {
    	affichageOrdre(noeud.gauche);
        System.out.println(" " + noeud.getEtudiant().getNom());
        affichageOrdre(noeud.droite);
    }

}
	

}
