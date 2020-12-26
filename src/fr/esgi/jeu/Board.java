package fr.esgi.jeu;

import java.util.Random;

public class Board {
	private static final Random RANDOM = new Random();
	private String name;
	private int size;
	private Square[] squares;

	public Board(String name, int size) {
		this.name = name;
		this.size = size;
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
		/** revoir sur l'équilibre des effets penalty sinon ça va prendre 
		 * beaucoups de tours pour finir une game **/
		
		
		/**version random sur la liste des effets en excluant 
		 * BEGIN (attention si décommente la ligne)**/
		//Effect effect = Effect.values()[RANDOM.nextInt(Effect.values().length - 1) + 1];
		
		/**version soft de la générération des effets ( que des bonus)**/
		Effect effect = Effect.BONUS;
		return effect;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int size = getSize();
		for (int i = 0; i < size; i++) {
			Square square = getSquares()[i];
			if (i == size - 1) {
				sb.append("|END|\n");
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
