package fr.esgi.jeu;

public class Game {	
	private static final int CONDITION_COINS_TO_WIN = 20;
	private int id;
	private Board board;
	private Player[] players;
	private int turn;
	public Boolean conditionToWinIsMet;

	public Game(int id, Board board, Player[] players) {
		this.id = id;
		this.board = board;
		this.players = players;
		this.turn = 1;
		this.conditionToWinIsMet = false;
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
		sb.append("Here the current state of the game:\n"
				+ "turn " + this.turn + "\n");
		for (Player player : players) {
			sb.append(player + "\n");
		}
		sb.append(board);
		for (Player player : players) {
			sb.append(player.getName() + "'s turn: rolling the dice... ");
			Square currentSquare = this.board.getSquares()[player.getPosition()];
			int diceResult = player.move();
			sb.append("you got " + diceResult + "\n");
			int afterMovePosition = player.getPosition();
			int lastSquarePosition = this.board.getSize()-1;
			int coinsPlayer = player.getCoins();
			currentSquare.removePlayer(player);
			if(afterMovePosition >= lastSquarePosition) {
				if(coinsPlayer >= CONDITION_COINS_TO_WIN) {
					this.conditionToWinIsMet = true;
					sb.append("Winner is " + player.getName() + ", congratulations!\n");
					break;
				}
				else {
					afterMovePosition = afterMovePosition - lastSquarePosition;
					player.setPositionToBegin(afterMovePosition);
				}
			}
			Square afterMoveSquare = this.board.getSquares()[afterMovePosition];
			afterMoveSquare.setPlayer(player);
			Effect afterMoveSquareEffect = afterMoveSquare.getEffect();
			player.setCoins(afterMoveSquareEffect);
			sb.append(afterMoveSquareEffect.getMessage() + "\n");		
		}
		sb.append(board);
		this.turn++;
		return sb.toString();
	}
}
