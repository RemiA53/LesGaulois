package personnages;

public class Gaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	private String nom;
//	private int force;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + "envoie un grand coup dans la machoire de" + romain.getNom());	
//		romain.recevoirCoup(force/3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
		romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
		}
		return;
		}

	
	@Override
	public String toString() {
		return nom;
	}
	
}

public class Romain {
	private String nom;
	private int force;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public 	void recevoirCoup(forceCoup) {
//		this.force = force - forceCoup
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
		case 0:
		 parler("Aïe");
		 break;
		 
		default:
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 break;
		}
		return equipementEjecte;
		}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de
		" + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		 texte += "\nMais heureusement, grace à mon équipement sa force est
		diminué de ";
		 for (int i = 0; i < nbEquipement;) {
		  if ((equipements[i] != null &&
		  equipements[i].equals(Equipement.BOUCLIER)) == true) {
		   resistanceEquipement += 8;
		  } else {
		   System.out.println("Equipement casque");
		   resistanceEquipement += 5;
		  }
		  i++;
		 }
		 texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous
		la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		 if (equipements[i] == null) {
		  continue;
		 } else {
		  equipementEjecte[nbEquipementEjecte] = equipements[i];
		  nbEquipementEjecte++;
		  equipements[i] = null;
		 }
		}
		return equipementEjecte;
		}


}