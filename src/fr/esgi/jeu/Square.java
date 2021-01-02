package fr.esgi.jeu;

import java.util.ArrayList;

public class Square {
	private static final String POSITION_ZERO = "000";
	private Effect effect;
	private ArrayList<Player> players;

	public Square(Effect effect) {
		this.effect = effect;
		this.players = new ArrayList<Player>();
	}

	public Effect getEffect() {
		return this.effect;
	}

	public void setPlayer(Player player) {
		this.players.add(player);
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public String toString(int position) {
		//Une caise est sur 9 caracteres; La position est sur 3; l'effet est sur 5;
		StringBuilder sb = new StringBuilder();
		//numCase
		sb.append("|__"+stringifyPosition(position)+"__|");
		//effectCase
		sb.append("|_"+this.effect+"_|");
		//players
		for (Player p : players) {
			sb.append("|__"+p.getName()+"__|");
		}
		sb.append("\n");
		return sb.toString();
	}

	public String stringifyPosition(Integer position){
		String str = POSITION_ZERO;
		if (position == 0){
			return str;
		}else if(position/100 == 1){
			return str = "100";
		}else if(position/100 == 0){
			if (position/10==0){
				return str = "00"+position.toString();
			}else{
				return str = "0"+position.toString();
			}
		}
		return str;
	}
}
