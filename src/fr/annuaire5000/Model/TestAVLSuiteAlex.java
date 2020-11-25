package fr.annuaire5000.Model;


public class TestAVLSuiteAlex {
	
	Noeud root = null;
	
	public void add(Etudiant etudiant) {
	root = ajoutR(root, etudiant);
    }

    private Noeud ajoutR(Noeud current, Etudiant etudiant) {

        if (current == null) {
            
        return  new Noeud(etudiant) ;
        }

        if ((etudiant.compareTo(current.getEtudiant()))>0) {
            current.droite = ajoutR(current.droite, etudiant);
        } else if ((etudiant.compareTo(current.getEtudiant()))<0) {
            current.gauche = ajoutR(current.gauche, etudiant);
        }

        //kHALED
        
        
       current.height = Math.max(height(current.gauche), height(current.droite)) + 1;
        
       int bf = bf(current);

		// LL Case
		if (bf > 1 &&  (etudiant.compareTo(current.getEtudiant())) < (etudiant.compareTo(current.gauche.getEtudiant()))) {
			return rightRotate(current);
		}
       
      
		// RR Case
		if (bf < -1 && (etudiant.compareTo(current.getEtudiant())) > (etudiant.compareTo(current.droite.getEtudiant()))) {
			return leftRotate(current);
		}
		// LR Case
		if (bf >1  && (etudiant.compareTo(current.getEtudiant())) > (etudiant.compareTo(current.gauche.getEtudiant()))) {
			current.gauche = rightRotate(current.gauche);
			return rightRotate(current);
		}
		// RL Case
		if (bf < -1 && (etudiant.compareTo(current.getEtudiant())) < (etudiant.compareTo(current.droite.getEtudiant()))) {
			current.droite = rightRotate(current.droite);
			return leftRotate(current);
		}
        return current;
    }
    

	private int height(Noeud current) {
		if (current == null) {
			return 0;
		}

		return current.height;
	}

	private int bf(Noeud current) {
		if (current == null) {
			return 0;
		}

		return height(current.gauche) - height(current.droite);
	}
	
	private Noeud leftRotate(Noeud c) {

		Noeud b = c.droite;
		Noeud T2 = b.gauche;

		// rotate
		b.gauche = c;
		c.droite = T2;

		// ht update
		c.height = Math.max(height(c.gauche), height(c.droite)) + 1;
		b.height = Math.max(height(b.gauche), height(b.droite)) + 1;

		return b;
	}
	private Noeud rightRotate(Noeud c) {

		Noeud b = c.gauche;
		Noeud T3 = b.droite;

		// rotate
		b.gauche = c;
		c.droite = T3;

		// ht update
		c.height = Math.max(height(c.gauche), height(c.droite)) + 1;
		b.height = Math.max(height(b.gauche), height(b.droite)) + 1;

		return b;
	}

	
	
	public TestAVLSuiteAlex(Noeud root) {
		super();
		this.root = root;
	}
	

	public TestAVLSuiteAlex() {
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
        System.out.println(" " + noeud.getEtudiant().getNom());
        affichageOrdre(noeud.gauche);
        affichageOrdre(noeud.droite);
    }

//}
//	public void afficher() {
//		afficher(this.root);
//	}
//
//	
//	private void afficher(Noeud noeud) {
//
//		if (noeud == null) {
//			return;
//		}
//
//		// self work
//		String str = "";
//
//		if (noeud.gauche == null) {
//			str += ".";
//		} else {
//			str += noeud.gauche.getEtudiant().getNom();
//		}
//
//		str += " => " + noeud.getEtudiant().getNom() + " <= ";
//
//		if (noeud.droite.getEtudiant().getNom() == null) {
//			str += ".";
//		} else {
//			str += noeud.droite.getEtudiant().getNom();
//	}
//
//	System.out.println(str);
//
//	afficher(noeud.gauche);
//	afficher(noeud.droite);

	}
	

}
