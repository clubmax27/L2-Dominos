import java.util.ArrayList;
public class Plateau {

	Tuile[][] plateau ;
	Sac s ;
	
	public Plateau(Sac s) {
		this.s = s ;
		Tuile z = s.CreaTuile() ;
		Tuile[] ae = {z}  ;
		Tuile[][] a = {ae} ;
		this.plateau = a ;
	}
	
	public void verifBordure() {
		for(int i = 0 ; i < this.plateau[0].length; i++ ) {
			if(this.plateau[0] != null) {
				this.plateau = RajouteHaut() ;
			}
		}
		for(int i = 0 ; i < this.plateau.length ; i++) {
			if(this.plateau[i][0] != null) {
				this.plateau = RajouteGauche() ;
			}
			if(this.plateau[i][this.plateau[i].length] != null) {
				this.plateau = RajouteDroite() ;
			}
		}
		for(int i = 0 ; i < this.plateau[0].length ; i++) {
			if(this.plateau[this.plateau.length][i] != null) {
				this.plateau = RajouteBas() ;
			}
		}
	}
	
	public Tuile[][] RajouteHaut() {
		Tuile[] haut = new Tuile[this.plateau[0].length] ;
		Tuile[][] plat = new Tuile[this.plateau.length+1][haut.length] ; 
		plat[0] = haut ;
		for(int i = 0 ; i < this.plateau.length ; i++) {
			plat[i+1] = (this.plateau[i]) ;
		}
		
		return plat ;
	}
	
	public Tuile[][] RajouteBas() {
		Tuile[] bas = new Tuile[this.plateau[0].length] ;
		Tuile[][] plat = new Tuile[this.plateau.length+1][bas.length] ;
		
		for(int i = 0 ; i < this.plateau.length ; i++) {
			plat[i] = plateau[i] ;
		}
		plat[plat.length-1] = bas ;
		return plat ;
	}
	
	public Tuile[][] RajouteDroite() {
		for(int i = 0 ; i < this.plateau.length ; i++) {
			Tuile[] a = new Tuile[plateau[i].length] ;
			for(int j = 0 ; j < this.plateau[i].length ; i++) {
				a[i] = plateau[i][j] ;
			}
			plateau[i] = a ;
		}
		return this.plateau ;
	}
	
	public Tuile[][] RajouteGauche() {
		for(int i = 0 ; i < this.plateau.length ; i++) {
			Tuile[] a = new Tuile[this.plateau[i].length+1] ; 
			for(int j = 0 ; j < this.plateau[i].length ; j++) {
				a[j+1] = plateau[i][j] ;
 			}
			plateau[i] = a ;
		}
		return this.plateau ;
	}
	
	
	public void poseHaut(int x , int y, Tuile t) { 
		if(this.plateau[x-1][y] != null) {
			System.out.println("Position déja occupé , veuillez replacez votre domino"); 
		}else if(x > 0 && x < this.plateau.length && y >= 0 && y < this.plateau[0].length){
			this.plateau[x-1][y] = t;
			System.out.println("Domino placé correctement");
			
			this.plateau[x][y].setVHaut(t);
			t.setVBas(this.plateau[x][y]);
			if(this.plateau[x-1][y-1] != null) {
				t.setVGauche(this.plateau[x+1][y-1]);
				this.plateau[x-1][y-1].setVDroit(t);
			}
			if(this.plateau[x-1][y+1] != null) {
				t.setVDroit(this.plateau[x+1][y+1]);
				this.plateau[x-1][y+1].setVGauche(t);
			}
			if(x-2 >= 0 && this.plateau[x-2][y] != null) {
				t.setVHaut(this.plateau[x-2][y]);
				this.plateau[x-2][y].setVBas(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void poseBas(int x , int y, Tuile t) { 
		if(this.plateau[x+1][y] != null) {
			System.out.println("Position d�j� occup� , veuillez replacez votre domino"); 
		}else if(x >= 0 && x+1 < this.plateau.length && y >= 0 && y < this.plateau[0].length){
			
			this.plateau[x+1][y] =  t;
			System.out.println("Domino plac� correctement");
			
			
			this.plateau[x][y].setVBas(t);
			t.setVHaut(this.plateau[x][y]);
			if(this.plateau[x+1][y-1] != null) {
				t.setVGauche(this.plateau[x+1][y-1]);
				this.plateau[x+1][y-1].setVDroit(t);
			}
			if(this.plateau[x+1][y+1] != null) {
				t.setVDroit(this.plateau[x+1][y+1]);
				this.plateau[x+1][y+1].setVGauche(t);
			}
			if(x+2 < this.plateau.length && this.plateau[x+2][y] != null) {
				t.setVBas(this.plateau[x+2][y]);
				this.plateau[x+2][y].setVHaut(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
		
		
	}
	
	public void poseDroit(int x , int y, Tuile t) { 
		if(this.plateau[x][y+1] != null) {
			System.out.println("Position d�j� occup� , veuillez replacez votre domino"); 
		}else if(x >= 0 && x < this.plateau.length && y >= 0 && y+1 < this.plateau[0].length){
			this.plateau[x][y+1] = t ;
			System.out.println("Domino plac� correctement");
			
			this.plateau[x][y].setVDroit(t);
			t.setVGauche(this.plateau[x][y]);
			if(this.plateau[x+1][y+1] != null) {
				t.setVBas(this.plateau[x+1][y+1]);
				this.plateau[x+1][y+1].setVHaut(t);
			}
			if(this.plateau[x-1][y+1] != null) {
				t.setVHaut(this.plateau[x-1][y+1]);
				this.plateau[x-1][y+1].setVBas(t);
			}
			if(y+2 < this.plateau[x].length && this.plateau[x][y+2] != null) {
				t.setVDroit(this.plateau[x][y+2]);
				this.plateau[x][y+2].setVGauche(t);
			}

			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void poseGauche(int x , int y, Tuile t) { 
		if(this.plateau[x][y-1] != null) {
			System.out.println("Position d�j� occup� , veuillez replacez votre domino"); 
		}else if(x >= 0 && x < this.plateau.length && y > 0 && y < this.plateau[0].length){
			this.plateau[x][y-1] = t;
			System.out.println("Domino plac� correctement");
			
			this.plateau[x][y].setVGauche(t);
			t.setVDroit(this.plateau[x][y]);
			if(this.plateau[x+1][y-1] != null) {
				t.setVBas(this.plateau[x+1][y-1]);
				this.plateau[x+1][y-1].setVHaut(t);
			}
			if(this.plateau[x-1][y-1] != null) {
				t.setVHaut(this.plateau[x-1][y-1]);
				this.plateau[x-1][y-1].setVBas(t);
			}
			if(y-2 >= 0 && this.plateau[x][y-2] != null) {
				t.setVGauche(this.plateau[x][y-2]);
				this.plateau[x][y-2].setVDroit(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void afficher() {
		
		
		this.verifBordure();
		
		System.out.println("");
		System.out.print("-----");
		for(int i = 1 ; i < plateau[0].length-1 ; i++) {
			System.out.print("--" + (char)(64+i) + "--");
		}
		for(int i = 0 ; i < plateau.length ; i++) {
			for(int j = 0 ; j < plateau[i].length ; j++ ) {
				String h = "" ;
				String l1 = "" ;
				String l2 = "" ;
				String l3 = "" ;
				String b = "" ;
				if(this.plateau[i][j] != null) {
					h = h + this.plateau[i][j].AfficheHaut() ;
					l1 = l1 + this.plateau[i][j].AfficheLigne1();
					l2 = l2 + this.plateau[i][j].AfficheLigne2();
					l3 = l3 + this.plateau[i][j].AfficheLigne3();
					b = b + this.plateau[i][j].AfficheBas() ;
				}else {
					h = h  + "xxxxx" ;
					l1 = l1 + "xxxxx" ; 
					l2 = l2 + "xxxxx" ; 
					l3 = l3 + "xxxxx" ;
					b = b + "xxxxx" ;
 				}
				
				System.out.println(" " +h);
				System.out.println(" " +l1) ;
				System.out.println("(char)(97+i) " + l2);
				System.out.println(" " +l3);
				System.out.println(" " +b);
				
			}
		}
	}
}
