import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {

	Plateau p ;
	Sac s ;
	ArrayList<Joueur> ListJoueur ;
	
	public Jeu(Plateau p , Sac s , ArrayList<Joueur> j) {
		this.p = p ;
		this.s = s ;
		this.ListJoueur = j ;
	}
	
	public static void partie() {
		Scanner scanner = new Scanner(System.in) ;
		
		ArrayList<Joueur> a = new ArrayList<Joueur>() ;
		
		// On demande le nombre de joueurs
		int nbJoueur = ScanNbJoueur() ;

		// Tant que le nombre de joueur est incorrect
		while(nbJoueur > 8 || nbJoueur < 2) {
			System.out.println("Le nombre de Joueur doit être inférieur ou égal à huit et supérieur ou égal à deux. Veuillez changez le nombre");
			nbJoueur = ScanNbJoueur() ;
		}

		// On ajoute tout les joueurs à la liste des joueurs 
		for(int i = 0 ; i < nbJoueur ;i++ ) {
			a.add(ScanNomJoueur(i+1)) ;
		}
	
		// On demande le nombre de de tuiles à utiliser 
		int nbSac = ScanNbTuile() ;
		// On cré ensuite le sac 
		Sac s = new Sac(nbSac) ;
		
		
		// Création du plateau de jeu 
		Plateau Plateaujeu = new Plateau() ;
		Plateaujeu.plateau.get(0).add(s.CreaTuile()) ;
		
		Jeu part = new Jeu(Plateaujeu , s ,a) ;
		
		while(FinJeu(a,s) == false) {
			for(int i = 0 ; i < a.size() ; i++) {
				System.out.println("Tour de " + a.get(i).nom);
				part.Tour(i);
			}
		}
	}
	
	public void Tour(int n) {
		
		if(this.ListJoueur.get(n).abandon != true) {
			this.ListJoueur.get(n).main = this.s.CreaTuile() ;
		}
	}
	
	public static int ScanNbTuile() {
		Scanner scanner = new Scanner(System.in) ;
		
		System.out.println("Entrez le nombre de Tuile que vous voulez dans le sac : ");
		
		int num = scanner.nextInt() ;
		return num ;  
	}
	
	
	public static int ScanNbJoueur() {
		Scanner scanner = new Scanner(System.in) ;
		
		System.out.println("Entrez le nombre de joueur :");
		
		int num = scanner.nextInt() ;
		return num ;  
	}
	
	public static Joueur ScanNomJoueur(int i) {
		Scanner scanner = new Scanner(System.in) ;
		
		System.out.println("Entrez le nom du Joueur " + i );
		
		String s = scanner.next() ;
		return (new Joueur(s)) ;
	}
	
	public static boolean FinJeu(ArrayList<Joueur> J , Sac s) {
		if(s.Restant <= 0) {
			return true ;
		}
		int abandon = 0 ; 
		for(int i = 0 ; i< J.size() ; i++ ) {
			if(J.get(i).abandon) {
				abandon ++ ;
			}
		}
		if(abandon >= J.size()-1 ) {
			return true ;
		}
		return false ;
	}
	
	public static void main(String[] args) {
		partie() ;
	}
	
}
