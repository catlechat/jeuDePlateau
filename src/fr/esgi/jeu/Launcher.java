package fr.esgi.jeu;

public class Launcher {
	public static void main(String args[]) {
		System.out.println("Welcome to the game!");
		Player p1 = new Player("Ivan");
		Player p2 = new Player("Ludovic");
		Player p3 = new Player("Bernanrd");

		Player[] players = new Player[] {p1,p2,p3};
		int[] caise = new int[] { 1, 2, 3 };
		
		Plateau plateau = new Plateau("Jungle",20,caise);
		
		Game jeu1 = new Game(10023, plateau, players);
		
		jeu1.getAllPlayers();
		jeu1.getPlateau();
		
	}
}
