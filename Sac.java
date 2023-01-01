
public class Sac {
	
	public int Restant ;

	public Sac(int n) {
		this.Restant = n ;
	}
	
	
	public Tuile CreaTuile() {
		int []a = new int[3] ;
		for(int i = 0 ; i < a.length ;  i++) {
			a[i] = (int)(Math.random() * 10 ) ;
		}
		int []b = new int[3] ;
		for(int i = 0 ; i < b.length ;  i++) {
			b[i] = (int)(Math.random() * 10 ) ;
		}
		int []c = new int[3] ;
		for(int i = 0 ; i < c.length ;  i++) {
			c[i] = (int)(Math.random() * 10 ) ;
		}
		int []d = new int[3] ;
		for(int i = 0 ; i < d.length ;  i++) {
			d[i] = (int)(Math.random() * 10 ) ;
		}
		Tuile x = new Tuile(a,b,c,d); // abcd soit respectivement les valeurs Haut Droite Bas Gauche de la tuile
		
		this.Restant = this.Restant -1 ;
		return x; 
	}

}