package fr.esgi.jeu;

import java.util.Random;

public class Launcher {
	
	public static void main(String args[]) {
		System.out.println("Welcome to the game!");
		Player p1 = new Player("Ivan");
		Player p2 = new Player("Ludovic");
		Player p3 = new Player("Bernanrd");

		Player[] players = new Player[] {p1,p2,p3};
		//int[] caise = new int[] { 1, 2, 3 };
		
		Board board = new Board("Jungle",20);
		board.generateSquares();
		
		Game jeu1 = new Game(10023, board, players);
		jeu1.getAllPlayers();
		jeu1.getPlateau();
		jeu1.setPlayersInBeginning();
		jeu1.printGame();
		
	}
}
