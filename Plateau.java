import java.util.ArrayList;
public class Plateau {

	ArrayList<ArrayList<Tuile>> plateau ;
	
	public Plateau() {
		ArrayList<ArrayList<Tuile>> a = new ArrayList<ArrayList<Tuile>>() ;
		this.plateau = a ;
	}
	
	public void verifBordure() {
		for(int i = 0 ; i < this.plateau.get(0).size(); i++ ) {
			if(this.plateau.get(0).get(i) != null) {
				this.plateau = RajouteHaut() ;
			}
		}
		for(int i = 0 ; i < this.plateau.size() ; i++) {
			if(this.plateau.get(i).get(0) != null) {
				this.plateau = RajouteGauche() ;
			}
			if(this.plateau.get(i).get(this.plateau.get(i).size()) != null) {
				this.plateau = RajouteDroite() ;
			}
		}
		for(int i = 0 ; i < this.plateau.get(0).size() ; i++) {
			if(this.plateau.get(this.plateau.size()).get(i) != null) {
				this.plateau = RajouteBas() ;
			}
		}
	}
	
	public ArrayList<ArrayList<Tuile>> RajouteHaut() {
		ArrayList<Tuile> haut = new ArrayList<Tuile>() ; 
		while(haut.size() < this.plateau.get(0).size()) {
			haut.add(null) ;
		}
		ArrayList<ArrayList<Tuile>> plat =new ArrayList<ArrayList<Tuile>>() ; 
		plat.add(haut) ;
		for(int i = 0 ; i < this.plateau.size() ; i++) {
			plat.add(this.plateau.get(i)) ;
		}
		
		return plat ;
	}
	
	public ArrayList<ArrayList<Tuile>> RajouteBas() {
		ArrayList<Tuile> bas = new ArrayList<Tuile>() ; 
		this.plateau.add(bas) ;
		return this.plateau ;
	}
	
	public ArrayList<ArrayList<Tuile>> RajouteDroite() {
		for(int i = 0 ; i < this.plateau.size() ; i++) {
			this.plateau.get(i).add(null) ;
		}
		return this.plateau ;
	}
	
	public ArrayList<ArrayList<Tuile>> RajouteGauche() {
		for(int i = 0 ; i < this.plateau.size() ; i++) {
			ArrayList<Tuile> a = new ArrayList<Tuile>() ; 
			a.add(null) ;
			for(int j = 0 ; j < this.plateau.get(i).size() ; j++) {
				a.add(this.plateau.get(i).get(j));
 			}
			this.plateau.set(i, a) ;
		}
		return this.plateau ;
	}
	
	
	public void poseHaut(int x , int y, Tuile t) { 
		if(this.plateau.get(x-1).get(y) != null) {
			System.out.println("Position déjà occupé , veuillez replacez votre domino"); 
		}else if(x > 0 && x < this.plateau.size() && y >= 0 && y < this.plateau.get(0).size()){
			this.plateau.get(x-1).set(y, t);
			System.out.println("Domino placé correctement");
			
			this.plateau.get(x).get(y).setVHaut(t);
			t.setVBas(this.plateau.get(x).get(y));
			if(this.plateau.get(x-1).get(y-1) != null) {
				t.setVGauche(this.plateau.get(x+1).get(y-1));
				this.plateau.get(x-1).get(y-1).setVDroit(t);
			}
			if(this.plateau.get(x-1).get(y+1) != null) {
				t.setVDroit(this.plateau.get(x+1).get(y+1));
				this.plateau.get(x-1).get(y+1).setVGauche(t);
			}
			if(x-2 >= 0 && this.plateau.get(x-2).get(y) != null) {
				t.setVHaut(this.plateau.get(x-2).get(y));
				this.plateau.get(x-2).get(y).setVBas(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void poseBas(int x , int y, Tuile t) { 
		if(this.plateau.get(x+1).get(y) != null) {
			System.out.println("Position déjà occupé , veuillez replacez votre domino"); 
		}else if(x >= 0 && x+1 < this.plateau.size() && y >= 0 && y < this.plateau.get(0).size()){
			
			this.plateau.get(x+1).set(y, t);
			System.out.println("Domino placé correctement");
			
			
			this.plateau.get(x).get(y).setVBas(t);
			t.setVHaut(this.plateau.get(x).get(y));
			if(this.plateau.get(x+1).get(y-1) != null) {
				t.setVGauche(this.plateau.get(x+1).get(y-1));
				this.plateau.get(x+1).get(y-1).setVDroit(t);
			}
			if(this.plateau.get(x+1).get(y+1) != null) {
				t.setVDroit(this.plateau.get(x+1).get(y+1));
				this.plateau.get(x+1).get(y+1).setVGauche(t);
			}
			if(x+2 < this.plateau.size() && this.plateau.get(x+2).get(y) != null) {
				t.setVBas(this.plateau.get(x+2).get(y));
				this.plateau.get(x+2).get(y).setVHaut(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
		
		
	}
	
	public void poseDroit(int x , int y, Tuile t) { 
		if(this.plateau.get(x).get(y+1) != null) {
			System.out.println("Position déjà occupé , veuillez replacez votre domino"); 
		}else if(x >= 0 && x < this.plateau.size() && y >= 0 && y+1 < this.plateau.get(0).size()){
			this.plateau.get(x).set(y+1, t);
			System.out.println("Domino placé correctement");
			
			this.plateau.get(x).get(y).setVDroit(t);
			t.setVGauche(this.plateau.get(x).get(y));
			if(this.plateau.get(x+1).get(y+1) != null) {
				t.setVBas(this.plateau.get(x+1).get(y+1));
				this.plateau.get(x+1).get(y+1).setVHaut(t);
			}
			if(this.plateau.get(x-1).get(y+1) != null) {
				t.setVHaut(this.plateau.get(x-1).get(y+1));
				this.plateau.get(x-1).get(y+1).setVBas(t);
			}
			if(y+2 < this.plateau.get(x).size() && this.plateau.get(x).get(y+2) != null) {
				t.setVDroit(this.plateau.get(x).get(y+2));
				this.plateau.get(x).get(y+2).setVGauche(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void poseGauche(int x , int y, Tuile t) { 
		if(this.plateau.get(x).get(y-1) != null) {
			System.out.println("Position déjà occupé , veuillez replacez votre domino"); 
		}else if(x >= 0 && x < this.plateau.size() && y > 0 && y < this.plateau.get(0).size()){
			this.plateau.get(x).set(y-1, t);
			System.out.println("Domino placé correctement");
			
			this.plateau.get(x).get(y).setVGauche(t);
			t.setVDroit(this.plateau.get(x).get(y));
			if(this.plateau.get(x+1).get(y-1) != null) {
				t.setVBas(this.plateau.get(x+1).get(y-1));
				this.plateau.get(x+1).get(y-1).setVHaut(t);
			}
			if(this.plateau.get(x-1).get(y-1) != null) {
				t.setVHaut(this.plateau.get(x-1).get(y-1));
				this.plateau.get(x-1).get(y-1).setVBas(t);
			}
			if(y-2 >= 0 && this.plateau.get(x).get(y-2) != null) {
				t.setVGauche(this.plateau.get(x).get(y-2));
				this.plateau.get(x).get(y-2).setVDroit(t);
			}
			
		}else {
			System.out.println("Position hors du tableau");
		}
	}
	
	public void afficher() {
		for(int i = 0 ; i < plateau.size() ; i++) {
			for(int j = 0 ; j < plateau.get(i).size() ; j++ ) {
				String h = "" ;
				String l1 = "" ;
				String l2 = "" ;
				String l3 = "" ;
				String b = "" ;
				if(this.plateau.get(i).get(i) != null) {
					h = h + this.plateau.get(i).get(i).AfficheHaut() ;
					l1 = l1 + this.plateau.get(i).get(i).AfficheLigne1();
					l2 = l2 + this.plateau.get(i).get(i).AfficheLigne2();
					l3 = l3 + this.plateau.get(i).get(i).AfficheLigne3();
					b = b + this.plateau.get(i).get(i).AfficheBas() ;
				}else {
					h = h  + "xxxxx" ;
					l1 = l1 + "xxxxx" ; 
					l2 = l2 + "xxxxx" ; 
					l3 = l3 + "xxxxx" ;
					b = b + "xxxxx" ;
 				}
				
				System.out.println(h);
				System.out.println(l1) ;
				System.out.println(l2);
				System.out.println(l3);
				System.out.println(b);
				
			}
		}
	}
}