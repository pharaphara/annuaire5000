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

	public String toLargeurFixe() {


		return "Noeud [etudiant=" + etudiant + ", gauche=" + gauche + ", droite=" + droite + "]";
	}

	static Noeud composer(Etudiant etudiant,Noeud g,Noeud d)
	{
		return new Noeud(etudiant,g,d);
	}
	static Etudiant cle(Noeud a)
	{
		return a.getEtudiant();
	}
	static Noeud filsGauche(Noeud a)
	{
		return a.getGauche();
	}
	static Noeud filsDroit(Noeud a)
	{
		return a.getDroite();
	}
	//Version destructive 
	static Noeud inserer(Etudiant etudiant, Noeud noeud) 
	{
		if (noeud == null) {
			return new Noeud(etudiant,null,null);
		}

		if ((etudiant.compareTo(noeud.getEtudiant()))<0) {
			noeud.setGauche( inserer(etudiant, noeud.getGauche()));
		} else if ((etudiant.compareTo(noeud.getEtudiant()))>0) {
			noeud.setDroite(inserer(etudiant, noeud.getDroite()));
		}return noeud;
	}

	//Methode supprimer 
	static Noeud supprimer(Etudiant etudiant, Noeud noeud)
	{
		if (noeud == null)
			return noeud;
		if (etudiant.equals(noeud.getEtudiant()))
			return supprimerRacine(noeud);
		if (etudiant.compareTo(noeud.getEtudiant())<0)
			noeud.setGauche(supprimer(etudiant, noeud.getGauche()))  ;
		else 
			noeud.setDroite( supprimer(etudiant, noeud.getDroite()));
		return noeud;
	}
	//La méthode suivante supprime la clé de la racine de l’arbre.

	static Noeud supprimerRacine(Noeud noeud) 
	{
		if (noeud.getGauche() == null)
			return noeud.getDroite();
		if (noeud.getDroite() == null)
			return noeud.getGauche();
		Noeud f = dernierDescendant(noeud.getGauche());

		noeud.setEtudiant( f.getEtudiant()) ;
		noeud.setGauche(supprimer(f.getEtudiant(),noeud.getGauche())) ;
		return null; // attention a ce retour f ou null
	}

	static Noeud dernierDescendant(Noeud noeud) 
	{
		if (noeud.getDroite() == null)
			return noeud;
		return dernierDescendant(noeud.getDroite());
	}

	////////////////////////////////////////////////////

	
	static Noeud supprimerNom(String nom, Noeud noeud)
	{
		if (noeud == null)
			return noeud;
		if (nom.equals(noeud.getEtudiant().getNom()))
			return supprimerRacineNom(noeud);
		if (nom.compareTo(noeud.getEtudiant().getNom())<0)
			noeud.setGauche(supprimerNom(nom, noeud.getGauche()))  ;
		else 
			noeud.setDroite( supprimerNom(nom, noeud.getDroite()));
		return noeud;
	}
	//La méthode suivante supprime la clé de la racine de l’arbre.

	static Noeud supprimerRacineNom( Noeud noeud) 
	{
		if (noeud.getGauche() == null)
			return noeud.getDroite();
		if (noeud.getDroite() == null)
			return noeud.getGauche();
		Noeud f = dernierDescendant(noeud.getGauche());

		noeud.setEtudiant( f.getEtudiant()) ;
		noeud.setGauche(supprimer(f.getEtudiant(),noeud.getGauche())) ;
		return null; // attention a ce retour f ou null
	}

	//////////////////////////
	public void affichageOrdre(Noeud noeud) {
		if (noeud != null) {
			affichageOrdre(noeud.gauche);
			System.out.println(" " + noeud.getEtudiant().getNom());
			affichageOrdre(noeud.droite);
		}
	}
	static Noeud chercher(Etudiant etudiant, Noeud noeud) 
	{
	  if (noeud == null || etudiant.equals(noeud.getEtudiant()) )
	    return noeud;
	  if (etudiant.compareTo(noeud.getGauche().getEtudiant())<0)
	    return chercher(etudiant, noeud.getGauche());
	  return chercher(etudiant, noeud.getDroite());
	}
	
	
}