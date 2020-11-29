package fr.annuaire5000.Model;

public class Etudiant implements Comparable<Etudiant>{

	private String nom;
	private String prenom;
	private String departement;
	private String promotion;
	private String annee;

	public Etudiant() {
		super();
	}

	public Etudiant(String nom, String prenom, String departement, String promotion, String annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.promotion = promotion;
		this.annee = annee;
	}
	public Etudiant(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((departement == null) ? 0 : departement.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", promotion="
				+ promotion + ", annee=" + annee + "]";
	}

	@Override
	public int compareTo(Etudiant o) {

		return this.getNom().compareToIgnoreCase(o.getNom());
	}

	public String toLargeurFixe() {

		String esp1="";
		String esp2="";
		String esp3="";
		String esp4="";
		String esp5="";

		for (int i = 0; i < 30 -nom.length(); i++) {

			esp1 = esp1+" ";
		}

		for (int i = 0; i < 30 -prenom.length(); i++) {

			esp2 = esp2+" ";
		}
		for (int i = 0; i < 3 -departement.length(); i++) {

			esp3 = esp3+" ";
		}
		for (int i = 0; i < 10 -promotion.length(); i++) {

			esp4 = esp4+" ";
		}
		for (int i = 0; i < 4 -annee.length(); i++) {

			esp5 = esp5+" ";
		}
		return  nom + esp1 + prenom +esp2 + departement+esp3 + promotion +esp4 + annee + esp5;
	}

	public String getField(int i) {
		switch (i) {
		case 0:
			return nom;
		case 1:
			return prenom;
		case 2:
			return departement;
		case 3:
			return promotion;
		case 4:
			return annee;

		default:
			break;
		}
		return null;
	}


}
