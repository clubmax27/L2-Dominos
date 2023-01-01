import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {

	public void partie() {
		Scanner scanner = new Scanner(System.in) ;
		
		ArrayList<Joueur> a = new ArrayList<Joueur>() ;
		
		// On demande le nombre de joueurs
		int nbJoueur = ScanNbJoueur() ;

		// Tant que le nombre de joueur est incorrect
		while(nbJoueur > 8 && nbJoueur < 2) {
			System.out.println("Le nombre de Joueur doit être inférieur ou égal à huit. Veuillez changez le nombre");
			nbJoueur = ScanNbJoueur() ;
		}

		// On ajoute tout les joueurs à la liste des joueurs 
		for(int i = 0 ; i <= nbJoueur ;i++ ) {
			a.add(ScanNomJoueur(i)) ;
		}
	}
	
	public int ScanNbJoueur() {
		Scanner scanner = new Scanner(System.in) ;
		
		System.out.println("Entrez le nombre de joueur :");
		
		int num = scanner.nextInt() ;
		return num ;  
	}
	
	public Joueur ScanNomJoueur(int i) {
		Scanner scanner = new Scanner(System.in) ;
		
		System.out.println("Entrez le nom du Joueur " + i );
		
		String s = scanner.next() ;
		return (new Joueur(s)) ;
	}
}