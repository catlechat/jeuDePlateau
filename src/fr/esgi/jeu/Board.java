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
		this.squares = generateSquares();
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
		Square[] boardSquares = new Square[size];
		boardSquares[0] = new Square(Effect.BEGIN);
		for (int i = 1; i < size; i++) {
			boardSquares[i] = new Square(generateEffect());
		}
		return this.squares = boardSquares;
	}

	public Effect generateEffect() {
		/** revoir sur l'équilibre des effets penalty sinon ça va prendre 
		 * beaucoups de tours pour finir une game **/
		
		
		/**version random sur la liste des effets en excluant 
		 * BEGIN (attention si décommente la ligne)**/
		Effect effect = Effect.values()[RANDOM.nextInt(Effect.values().length - 1) + 1];
		
		/**version soft de la générération des effets ( que des bonus)**/
		//Effect effect = Effect.BONUS;
		return effect;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|_"+this.name+"|\n");
		for (int j = 0; j < this.size; j++) {
			sb.append(this.squares[j].toString(j));
		}
		return sb.toString();
	}
}
