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

	public void move() {
		this.position += RANDOM.nextInt(DICE_SIZE)+1;
	}

	public int getCoins() {
		return this.coins;
	}

	public void setCoins(Effect effect) {
		if (effect.equals(Effect.PENALTY) || effect.equals(Effect.PENALTY_FOR_EVERYONE)) {
			int temp = this.coins;
			temp -= effect.getCoins();
			// si le joueur après le malus a un nombre négatif de pièces, on le met à 0
			this.coins = temp < 0 ? 0 : temp;
		} else {
			this.coins += effect.getCoins();
		}
	}

	@Override
	public String toString() {
		return getName() + " : " + getCoins() + " coins";
	}

}