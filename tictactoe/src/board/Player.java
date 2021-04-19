package board;

import polygon.Point;
import java.util.ArrayList;

abstract public class Player {
	
	/* Arraylist of players */
	private static ArrayList<Player> players = new ArrayList<>();
	
	/* Name of player */
	private String name;
	
	/**
	 * 
	 * @return Returns the players
	 */
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * 
	 * @param name Adds players
	 */
	protected Player(String name) {
		this.name = name;
		players.add(this);
	}
	
	/* gets play from player */
	abstract public Point getPlay(MarkerType type, Board board);
	
	/**
	 * 
	 * @return Name of player
	 */
	public String getName() {
		return name;
	}
}