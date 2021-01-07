package fr.esgi.jeu;

import java.util.Random;

public class Board {
	private static final Random RANDOM = new Random();
	private final String name;
	private final int size;
	private Square[] squares;

	public Board(String name, int size) {
		this.name = name;
		this.size = size;
		this.squares = generateSquares();
	}

	public int getSize() {
		return this.size;
	}

	public Square[] getSquares() {
		return this.squares;
	}


	public Square[] generateSquares() {
		Square[] boardSquares = new Square[size];
		boardSquares[0] = new Square(Effect.BEGIN);
		for (int i = 1; i < size; i++) {
			boardSquares[i] = new Square(generateEffect());
		}
		return this.squares = boardSquares;
	}

	public Effect generateEffect() {
		return Effect.values()[RANDOM.nextInt(Effect.values().length - 1) + 1];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|_");
		sb.append(this.name);
		sb.append("|\n");
		for (int j = 0; j < this.size; j++) {
			sb.append(this.squares[j].toString(j));
		}
		return sb.toString();
	}
}
