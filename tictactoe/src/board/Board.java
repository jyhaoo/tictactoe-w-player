package board;

import java.util.ArrayList;

public class Board {
	
	/* Basic parameters for tic tac toe */
	private static final int DEFAULT_ROWS = 3;
	private static final int DEFAULT_COLUMNS = 3;
	private static final int DEFAULT_IN_ROW_TO_WIN = 3;
	
	private int rows;
	private int columns;
	private int inRowToWin;
	private Cell[][] cells;
	private BoardView view;
	private ArrayList<Sequence> sequences;
	private Sequence winningSequence;
	
	/**
	 * Constructor for board
	 * Initialize all parts of the board 
	 */
	public Board() {
		rows = DEFAULT_ROWS;
		columns = DEFAULT_COLUMNS;
		inRowToWin = DEFAULT_IN_ROW_TO_WIN;
		winningSequence = null;
		view = new BoardView(rows, columns);
		
		cells = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(view, i, j);
			}
		}
		
		/* All sequences for tictactoe */
		sequences = new ArrayList<Sequence>();
		/* Rows and diagonals from left column */
		for (int i = 0; i < rows; i++) {
			sequences.add(new Sequence(i, 0, i, columns - 1));
			if (rows - i >= inRowToWin) {
				/* Down diagonals */
				sequences.add(new Sequence(i, 0, rows - 1, i + rows - 1));
			}
			if (i + 1 >= inRowToWin) {
				/* Up diagonals */
				sequences.add(new Sequence(i, 0, 0, i));
			}
		}
		
		/* Columns & additional diagonals from top or bottom */
		for (int i = 0; i < columns; i++) {
			sequences.add(new Sequence(0, i, rows - 1, i));
			if (i != 0 && columns - 1 >= inRowToWin) {
				/* Down diagonals from top */
				sequences.add(new Sequence(0, i, i + columns - 1, columns - 1));
			}
			if (i != 0 && columns - i + 1 >= inRowToWin) {
				/* Up diagonals from bottom */
				sequences.add(new Sequence(rows - 1, i, i, columns - 1));
			}
		}
	}
	
	/**
	 * 
	 * @param type Type of marker
	 * @param row Row
	 * @param column Column
	 * @return True if able to play marker at the spot
	 */
	public boolean playMarker(MarkerType type, int row, int column) {
		if (row < 0 || row >= rows || column < 0 || column >= columns) {
			return false;
		}
		if (cells[row][column].isFilled()) {
			return false;
		}
		cells[row][column].setType(type);
		return true;
	}
	
	/**
	 * 
	 * @return True if there is a winning sequence
	 */
	public boolean hasWinner() {
		if (winningSequence != null) {
			return true;
		}
		for (Sequence sequence : sequences) {
			winningSequence = sequence.getWinner(cells, inRowToWin);
			if (winningSequence != null) {
				view.declareWinner(winningSequence);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Resets the board (cells)
	 */
	public void reset() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j].setType(null);
			}
		}
		winningSequence = null;
		view.resetWinner();
	}
	
	/**
	 * 
	 * @return True if there isn't a winner and there are still remaining spots on board
	 */
	public boolean hasNextPlay() {
		if (hasWinner()) {
			return false;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (cells[i][j].getType() == null) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return Returns number to win in a row
	 */
	public int getInRowToWin() {
		return inRowToWin;
	}
	
	/**
	 * 
	 * @return Returns the cells (board)
	 */
	public Cell[][] getCells() {
		return cells;
	}
	
	/**
	 * 
	 * @return Sequences
	 */
	public ArrayList<Sequence> getSequences() {
		return sequences;
	}	
}


