package fr.esgi.jeu;

public class Launcher {
	
	private static final int TOTAL_SQUARES = 20;
	private static final int ID_GAME = 10023;

	public static void main(String args[]) {
		System.out.println("Welcome to the game!");
		Player p1 = new Player("Ivan");
		Player p2 = new Player("Ludovic");
		Player p3 = new Player("Bernanrd");

		Player[] players = new Player[] {p1,p2,p3};
		//int[] caise = new int[] { 1, 2, 3 };
		
		Board board = new Board("Jungle",TOTAL_SQUARES);
		board.generateSquares();
		
		Game jeu1 = new Game(ID_GAME, board, players);
		//jeu1.getAllPlayers();
		//jeu1.getPlateau();
		jeu1.setPlayersInBeginning();
		System.out.println(jeu1.toString());
	}
}