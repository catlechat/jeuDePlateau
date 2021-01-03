package fr.esgi.jeu;

import java.util.Scanner;

public class Game {
	private static final int CONDITION_COINS_TO_WIN = 20;
	private boolean GAMEOVER = false;
	private static final int FIRST_BOARD_CASE = 0;
	private int id;
	private Board board;
	private Player[] players;
	private int turn;

	public Square previousSquare;
	public Square curentSquare;

	public Game(int id, Board board, Player[] players) {
		this.id = id;
		this.board = board;
		this.players = players;
		this.turn = 1;
	}

	public Player[] getAllPlayers() {
		return this.players;
	}

	public Board getPlateau() {
		return this.board;
	}

	public void setPlayersInBeginning() {
		for (Player player : this.players) {
			this.board.getSquares()[FIRST_BOARD_CASE].setPlayer(player);
			player.setCoins(Effect.BEGIN);
		}
	}

	//fonction qui va faire le jeu et qui va retourner le nom du joueur gagnant
	public void start() {
		setPlayersInBeginning();
		System.out.println(board.toString());
		while (!GAMEOVER) {
			for (Player player : players) {
				int positionBeginTurn = player.getPosition();
				//player is moving
				Scanner scanner = new Scanner(System.in);
				//les cases vont etres utiles quand il y aura du choix par exemple acheter les bonus
				//par defaut si tu choisis un truc diff ca va lancer le dé
				boolean waiting = true;
				while(waiting){
					System.out.println(player.getName() + " what do you want to do ?");
					System.out.println("1. Use dice 2. Use coins 3. Print board 4. Exit");
					System.out.print("Select : >");
					switch (scanner.nextInt()) {
						case 1 ->{
							System.out.println(player.useDice());
							waiting = false;
							break;
						}
						case 2 -> {
							//ici on mets une fonction qui va demander ce qu'il veut faire avec ces points
							//Acheter et transformer une caise negative ou positive
							//
							System.out.println("Achat des trucs bla bla pas encore pret");
							break;
						}
						case 3 -> {
							System.out.println("Printing board..");
							System.out.println(board.toString());
							break;
						}
						case 4 -> {
							System.out.println("Do you want to save the game before exit ?");
							System.out.println("1. Yes 2. NO");
							int rep = scanner.nextInt();
							if(rep==1){
								//ici on enregistre la game dans la bdd et on lui retourne un code de la game
								return;
							}else{
								return;
							}
						}
						default -> System.out.println("Not implemented yet..");
					}
				}
				if (player.getPosition() >= board.getSize()) {
					player.setPosition(player.getPosition() - board.getSize());
				}
				//youre on new case, what effect do you get ??
				previousSquare = board.getSquares()[positionBeginTurn];
				previousSquare.removePlayer(player);
				curentSquare = board.getSquares()[player.getPosition()];
				curentSquare.setPlayer(player);
				Effect currentEfect = curentSquare.getEffect();
				System.out.println(currentEfect.getMessage()+"\n");
				player.setCoins(currentEfect);

				if (player.getCoins() >= CONDITION_COINS_TO_WIN) {
					System.out.println("Game Over, the winner is: "
							+player.getName()+" with: "+player.getCoins()+" coins.");
					return;
				}
			}
			this.turn++;
			System.out.println(this.toString());
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//on affiche les info utiles comme le tour
		sb.append("Here the current state of the game: Turn " + this.turn + ":\n");
		sb.append("-----------------------------\n");
		//pour chaque joueur on affiche sa position, ses coins et la caise sur laquelle il est
		for (Player player : players) {
			sb.append(player.toString());
			sb.append(this.board.getSquares()[player.getPosition()].toString(player.getPosition()));
			sb.append("-----------------------------\n");
		}
		return sb.toString();
	}
}
