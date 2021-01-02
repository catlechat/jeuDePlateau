package fr.esgi.jeu;


import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Launcher {

	private static final int MIN_MAP_SIZE = 20;
	private static final int MAX_MAP_SIZE = 60;

	private static final String[] BOARD_NAMES = {"Jungle","Temple"}; //les noms doivent etre sur 6 caises !

	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 8;

	public static void main(String args[]) {
		try ( Scanner scanner = new Scanner( System.in ) ) {
			Random rand = new Random();
			System.out.println("Welcome to the game!");
			int playerCount = 0;
			int boardName = 0;
			int mapSize = 0;
			//HOW MUCH PLAYERS
			do {
				System.out.println("Please enter the number of players:");
				playerCount = scanner.nextInt();
				if (playerCount>MAX_PLAYERS){
					System.out.println("Too much players, maximum is "+MAX_PLAYERS);
				}else if(playerCount<MIN_PLAYERS){
					System.out.println("Not enouth players, minimum is "+MIN_PLAYERS);
				}
			}while(playerCount>MAX_PLAYERS || playerCount < MIN_PLAYERS);
			//PLAYERS NAMES
			Player[] players = new Player[playerCount];
			for(int i = 0; i<playerCount;i++) {
				String name = "";
				System.out.println("Please enter the name of player n°"+(i+1)+":");
				name = scanner.next();
				players[i] = new Player(name);
			}
			//MAP SELECTION
			//MAP NAME
			do {
				System.out.println("Please select the map:");
				for (int i = 0; i < BOARD_NAMES.length; i++) {
					System.out.print((i+1)+":"+BOARD_NAMES[i]+" ");
				}
				System.out.print("\n");
				boardName = scanner.nextInt();
				if (boardName<=0 || boardName>BOARD_NAMES.length) {
					System.out.println("No such map");
				}
			}while(boardName<=0 || boardName>BOARD_NAMES.length);
			boardName = boardName -1;
			//MAP SIZE
			do {
				System.out.println("Please select the map size (between "+MIN_MAP_SIZE+" and "+MAX_MAP_SIZE+" ):");
				mapSize = scanner.nextInt();
				if (mapSize<MIN_MAP_SIZE){
					System.out.println("Too short");
				}else if(mapSize>MAX_MAP_SIZE){
					System.out.println("Too big");
				}
			}while(mapSize<MIN_MAP_SIZE || mapSize>MAX_MAP_SIZE);
			//BOARD GENERATION
			Board board = new Board(BOARD_NAMES[boardName],mapSize);
			board.generateSquares();
			//GAME INIT
			Game game1 = new Game(rand.nextInt(255)+1, board, players);
			//GAME START
			game1.start();
		}
	}
}