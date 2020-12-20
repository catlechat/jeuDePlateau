package fr.esgi.jeu;

public class Game {
	private int id;
	private Board board;
	private Player[] players;

	public Game(int id, Board board, Player[] players) {
		this.id = id;
		this.board = board;
		this.players = players;
	}

	public Player[] getAllPlayers() {
		return this.players;
	}

	public Board getPlateau() {
		return this.board;
	}

	public void setPlayersInBeginning() {
		Square first = this.board.getSquares()[0];
		for (Player player : this.players) {
			first.setPlayer(player);
			player.setCoins(Effect.BEGIN);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Here the current state of the game:\n");
		for (Player player : players) {
			sb.append(player + "\n");
		}
		sb.append(board);
		return sb.toString();
	}
}
