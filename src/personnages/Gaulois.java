package personnages;
import objet.Equipement;

public class Gaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
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
	private Equipement[]equipements = new Equipement[2];
	private int nbEquipement=0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat" + nom + "est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0]==equipement || equipements[1]==equipement) {
				System.out.println("Le soldat" + nom + "possède déjà" + equipement);
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				System.out.println("Le soldat" + nom + "s'équipe avec un" + equipement);
			}
		    break;
		case 0:
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat" + nom + "s'équipe avec un" + equipement);
			break;
		default:
			break;
		}
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
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
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
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
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
public class Main {
	public static void main(String[] args) {
	Equipement casque = new Equipement("casque");
	Equipement bouclier = new Equipement("bouclier");
	Romain minus = new  Romain("Minus", 10);
	
	minus.sEquiper(casque);        // Le soldat Minus s'équipe avec un casque.
    minus.sEquiper(casque);        // Le soldat Minus possède déjà un casque.
    minus.sEquiper(bouclier);      // Le soldat Minus s'équipe avec un bouclier.
    minus.sEquiper(casque); 
	}
}