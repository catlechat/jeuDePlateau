package fr.esgi.jeu;

import java.util.Random;
import java.util.Scanner;

public class Launcher {

	private static final int MIN_MAP_SIZE = 20;
	private static final int MAX_MAP_SIZE = 60;

	private static final String[] BOARD_NAMES = {"Jungle","Temple"}; //les noms doivent etre sur 6 caises !

	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 8;

	public static void main(String[] args) {
		try ( Scanner scanner = new Scanner( System.in ) ) {
			while (true){
				System.out.println("_________Welcome to the game !_________");
				System.out.println("_________Main menu_____________________");
				System.out.println("_________1. New Game___________________");
				System.out.println("_________2. Continue___________________");
				System.out.println("_________3. Exit_______________________");
				switch (scanner.nextInt()) {
					case 1 -> {
						Random rand = new Random();
						System.out.println("Game is starting...");
						int playerCount;
						int boardName;
						int mapSize;
						do {
							System.out.println("Please enter the number of players:");
							playerCount = scanner.nextInt();
							if (playerCount > MAX_PLAYERS) {
								System.out.println("Too much players, maximum is " + MAX_PLAYERS);
							} else if (playerCount < MIN_PLAYERS) {
								System.out.println("Not enouth players, minimum is " + MIN_PLAYERS);
							}
						} while (playerCount > MAX_PLAYERS || playerCount < MIN_PLAYERS);
						Player[] players = new Player[playerCount];
						for (int i = 0; i < playerCount; i++) {
							String name;
							System.out.println("Please enter the name of player n°" + (i + 1) + ":");
							name = scanner.next();
							players[i] = new Player(name);
						}
						do {
							System.out.println("Please select the map:");
							for (int i = 0; i < BOARD_NAMES.length; i++) {
								System.out.print((i + 1) + ":" + BOARD_NAMES[i] + " ");
							}
							System.out.print("\n");
							boardName = scanner.nextInt();
							if (boardName <= 0 || boardName > BOARD_NAMES.length) {
								System.out.println("No such map");
							}
						} while (boardName <= 0 || boardName > BOARD_NAMES.length);
						boardName = boardName - 1;
						do {
							System.out.println("Please select the map size (between " + MIN_MAP_SIZE + " and " + MAX_MAP_SIZE + " ):");
							mapSize = scanner.nextInt();
							if (mapSize < MIN_MAP_SIZE) {
								System.out.println("Too short");
							} else if (mapSize > MAX_MAP_SIZE) {
								System.out.println("Too big");
							}
						} while (mapSize < MIN_MAP_SIZE || mapSize > MAX_MAP_SIZE);
						Board board = new Board(BOARD_NAMES[boardName], mapSize);
						board.generateSquares();
						Game game1 = new Game(rand.nextInt(255) + 1, board, players);
						game1.start();
					}
					case 2 -> System.out.println("Here you'll be able to load a game you saved");
					case 3 -> {
						System.out.println("Exiting the game.. See ya next time !");
						return;
					}
					default -> System.out.println("not implemented yet");
				}
			}
		}
	}
}