package fr.esgi.jeu;

import java.util.ArrayList;

public class Square {
	private static final String POSITION_ZERO = "000";
	private Effect effect;
	private final ArrayList<Player> players;

	public Square(Effect effect) {
		this.effect = effect;
		this.players = new ArrayList<>();
	}

	public Effect getEffect() {
		return this.effect;
	}

	public void setEffect(Effect effect){
		this.effect = effect;
	}

	public void setPlayer(Player player) {
		this.players.add(player);
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
	}

	public String toString(int position) {
		//Une caise est sur 9 caracteres; La position est sur 3; l'effet est sur 5;
		StringBuilder sb = new StringBuilder();
		//numCase
		sb.append("|__").append(stringifyPosition(position)).append("__|");
		//effectCase
		sb.append("|_").append(this.effect).append("_|");
		//players
		for (Player p : players) {
			sb.append("|__").append(p.getName()).append("__|");
		}
		sb.append("\n");
		return sb.toString();
	}

	public String stringifyPosition(Integer position){
		String str = POSITION_ZERO;
		if (position == 0){
			return str;
		}else if(position/100 == 1){
			return "100";
		}else if(position/100 == 0){
			if (position/10==0){
				return "00"+position.toString();
			}else{
				return "0"+position.toString();
			}
		}
		return str;
	}
}
