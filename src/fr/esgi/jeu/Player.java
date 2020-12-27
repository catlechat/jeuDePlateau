package fr.esgi.jeu;

import java.util.Random;

public class Player {
	private static final Random RANDOM = new Random();
	private static final int DICE_SIZE = 6;

	private String name;
	private int position;
	private int coins;

	public Player(String name) {
		this.name = name;
		this.position = 0;
		this.coins = 0;
	}

	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return this.position;
	}

	public int getCoins() {
		return this.coins;
	}
	
	
	//deplacement des joueurs
	public int move() {
		int diceResult = RANDOM.nextInt(DICE_SIZE)+1;
		this.position += diceResult;
		return diceResult;
	}
	public void setPositionToBegin(int remainMoves) {
		this.position = 0 + remainMoves;
	}
	
	//mise à jour des pieces après atteinte d'une case
	public void setCoins(Effect effect) {
		if (effect.equals(Effect.LOOSE) || effect.equals(Effect.PEN4A)) {
			int temp = this.coins;
			temp -= effect.getCoins();
			// si le joueur après le malus a un nombre négatif de pièces, on le met à 0
			this.coins = temp < 0 ? 0 : temp;
		} else if(effect.equals(Effect.BONUS) || effect.equals(Effect.BEGIN)){
			this.coins += effect.getCoins();
		}
	}

	@Override
	public String toString() {
		return getName() + " : " + getCoins() + " coins";
	}

}