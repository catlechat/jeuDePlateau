package fr.esgi.jeu;

import java.util.Random;

public class Board {
	private static final Random RANDOM = new Random();
	private String name;
	private int size;
	// private int[] caises;
	private Square[] squares;

	public Board(String name, int size) {
		this.name = name;
		this.size = size;
		// this.caises = caises;
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
		Square[] squaresTemp = new Square[size];
		squaresTemp[0] = new Square(Effect.BEGIN);
		for (int i = 1; i < size - 1; i++) {
			squaresTemp[i] = new Square(generateEffect());
		}
		squaresTemp[size - 1] = new Square(Effect.NEUTRAL);
		return this.squares = squaresTemp;
	}

	public Effect generateEffect() {
		// TODO verif de l'équilibre du nombre de types d'effets
		// int size = this.board.getSize();
		Effect effect = Effect.values()[RANDOM.nextInt(Effect.values().length)];
		return effect;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int size = getSize();
		for (int i = 0; i < size; i++) {
			Square square = getSquares()[i];
			if (i == size - 1) {
				sb.append("|END|");
			} else {
				sb.append("| " + square.getEffect().name() + " ");
				for (Player player : square.getPlayers()) {
					sb.append(player.getName() + " ");
				}
				sb.append("|");
			}
		}
		return sb.toString();
	}
}
