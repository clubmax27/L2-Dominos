
public class Tuile {
	
	int[] haut ;
	int[] bas ; 
	int[] gauche ; 
	int[] droite ;
	
	
	Tuile VGauche ;
	Tuile VDroit ;
	Tuile VBas ; 
	Tuile VHaut ;
	
	public Tuile(int[]h , int []d , int[] b , int[] g) {
		this.haut = h ;
		this.bas = b ;
		this.droite = d ;
		this.gauche = g ; 
	}
	
	public void tournerGauche() {
		int[] mem = this.haut;
		this.haut = this.droite;
		this.droite = this.bas;
		this.bas = this.gauche;
		this.gauche = mem;
	}
	
	public void tournerDroite() {
		int[] mem = this.haut;
		this.haut = this.gauche;
		this.gauche = this.bas;
		this.bas = this.droite;
		this.droite = mem;
	}
	
	public void setVGauche(Tuile vGauche) {
		VGauche = vGauche;
	}

	public void setVDroit(Tuile vDroit) {
		VDroit = vDroit;
	}

	public void setVBas(Tuile vBas) {
		VBas = vBas;
	}

	public void setVHaut(Tuile vHaut) {
		VHaut = vHaut;
	}
	
	public String AfficheHaut() {
		return ("x" + haut[0] + haut[1] + haut[2] + "x");
		
	}
	
	public String AfficheLigne1() {
		return(gauche[0] + "xxx" + droite[0]);
	}
	
	public String AfficheLigne2 () {
		return(gauche[1] + "xxx" + droite[1]);
	}
	
	public String AfficheLigne3() {
		return(gauche[2] + "xxx" + droite[2]);
	}
	
	public String AfficheBas() {
		return ("x" + bas[0] + bas[1] + bas[2] + "x");
		
	}
	
}
