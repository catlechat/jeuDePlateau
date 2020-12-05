package fr.esgi.jeu;

import java.util.Random;

public class Board {
	private static final Random RANDOM = new Random();
	private String name;
	private int size;
	//private int[] caises;
	private Square[] squares;
	
	public Board(String name, int size){
		this.name = name;
		this.size = size;
		//this.caises = caises;
	}
	public String getName() {
		return this.name;
	}
	public int getSize() {
		return this.size;
	}
	public Square[] getSquares() {
		return this.squares;
	}
	public Square getFirstSquare() {
		return this.squares[0];
	}
	public Square[] generateSquares() {
		int size = this.getSize();
		Square[]squaresTemp = new Square[size];
		squaresTemp[0] = new Square();
		for (int i = 1 ; i < size-1; i++) {
			squaresTemp[i] = new Square(i, generateEffect());
		}
		squaresTemp[size-1] = new Square(size-1);
		return this.squares = squaresTemp;
	}
	public Effect generateEffect() {
		//TODO verif de l'équilibre du nombre de types d'effets
		//int size = this.board.getSize();
		Effect effect = Effect.values()[RANDOM.nextInt(Effect.values().length)];		
		return effect;
	}
}
