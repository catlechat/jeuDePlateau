package fr.esgi.jeu;

import java.util.Random;

public class Player {
	private static final int MINIMUM_COINS = 0;
	private static final int START_POSITION = 0;

	private static final Random rand = new Random();

	private String name;
	private int position;
	private int coins;

	public Player(String name) {
		this.name = name;
		this.position = START_POSITION;
		this.coins = MINIMUM_COINS;
	}

	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public String useDice(){
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+" ..rolling a dice\n");
		int res = rand.nextInt(6)+1;
		sb.append("you got " + res + " !");
		setPosition(getPosition()+res);
		return sb.toString();
	}

	public int getCoins() {
		return this.coins;
	}

	public void setCoins(Effect effect) {
		if (effect.equals(Effect.LOOSE) || effect.equals(Effect.PEN4A)) {
			//Math.max(a;b) si a est plus grand que b alors montre a sinon montre b
			this.coins = Math.max(this.coins - effect.getCoins(), MINIMUM_COINS);
		} else if(effect.equals(Effect.BONUS) || effect.equals(Effect.BEGIN)){
			this.coins += effect.getCoins();
		}
	}

	@Override
	public String toString() {
		return getName() + "'s position: " + getPosition() + " with: " + getCoins() + " coins\n";
	}

}