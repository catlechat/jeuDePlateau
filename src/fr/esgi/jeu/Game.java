package fr.esgi.jeu;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Random;

public class Game {
	private static final Random RANDOM = new Random();
	private int id;
	private Board board;
	private Player[] players;
//	private ArrayList<Effect> effectsArray;
//	private HashMap<Effect, Integer> effectsMap;
	
	public Game(int id, Board board, Player[] players) {
		this.id = id;
		this.board = board;
		this.players = players;
	}
	public void getAllPlayers() {
		System.out.println("Those are the players of this game:");
		for(int i = 0; i < this.players.length; i++) {
			System.out.println((i+1)+": "+this.players[i].getName());
		}
	}
	public void getPlateau() {
		System.out.println("They are playing on: "+this.board.getName());
	}
	
	public void setPlayersInBeginning() {
		Square first = this.board.getFirstSquare();
		for (Player player : this.players) {
			first.setPlayer(player);
			player.setCoins(Effect.BEGIN);
		}
		System.out.println(Effect.BEGIN.getMessage());
	}
	public void printGame() {
		System.out.println("Here the current state of the game:");
		this.printPlayerCoins();
		this.printBoard();
	}
	public void printPlayerCoins() {
		for (Player player : this.players) {
			System.out.println(player.getName() + " : " + player.getCoins() + " coins");
		}
	}
	public void printBoard() {
		int size = this.board.getSize();
		for (int i = 0; i < size; i++) {
			Square square = this.board.getSquares()[i];
			if(i == size - 1) {
				System.out.print("|END|");	
			}
			else {
				System.out.print("| " + square.getEffect().name() + " ");
				for (Player player : square.getPlayers()) {
					System.out.print(player.getName() + " ");
				}	
				System.out.print("|");
			}
		}
	}
}
