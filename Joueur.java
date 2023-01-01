public class Joueur {
	
	Tuile main;
	String nom;
	Boolean abandon = false;
	int score;
	
	public Joueur(String n) {
		this.nom = n;

		this.score = 0;
	}
	
	public void abandonner() { //Si le joueur abandonne cela à supprimer le joueur de l'ordre des joueurs possibles;
		this.abandon = true;
	}
	
	public String afficherScore() {
		return this.nom + " : " + this.score + " points";
	}
	
	public void pointGagnerDroite(Tuile tDroit) {
		
		this.score += tDroit.droite[0] + tDroit.droite[1] + tDroit.droite[2];
		
	}
	
	public void pointGagnerGauche(Tuile tGauche) {
		
		this.score += tGauche.gauche[0] + tGauche.gauche[1] + tGauche.gauche[2];
		
	}

	public void pointGagnerHaut(Tuile tHaut) {
	
		this.score += tHaut.haut[0] + tHaut.haut[1] + tHaut.haut[2];
	
	}

	public void pointGagnerBas(Tuile tBas) {
	
		this.score += tBas.bas[0] + tBas.bas[1] + tBas.bas[2];
	
	}

}