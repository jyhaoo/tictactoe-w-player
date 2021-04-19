package board;

public class Sequence {
	
	private int startRow;
	private int startColumn;
	private int endRow;
	private int endColumn;
	
	/**
	 * 
	 * @param startRow 
	 * @param startColumn
	 * @param endRow
	 * @param endColumn
	 */
	Sequence(int startRow, int startColumn, int endRow, int endColumn) {
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.endRow = endRow;
		this.endColumn = endColumn;
	}
	
	/**
	 * 
	 * Checks the board to see if there are any winners
	 * @param cells Board
	 * @param inRowToWin Number of in row to win
	 * @return Sequence for winner
	 */
	Sequence getWinner(Cell[][] cells, int inRowToWin) {
		Cell startCell = cells[startRow][startColumn];
		int deltaX = startRow == endRow ? 0 : (startRow < endRow ? 1 : -1);
		int deltaY = startColumn == endColumn ? 0 : (startColumn < endColumn ? 1 : -1);
		MarkerType currentType = startCell.getType();
		int count = 1;
		for (
				int row = startRow + deltaX, column = startColumn + deltaY;
				row <= endRow && column <= endColumn;
				row += deltaX, column += deltaY) {
			if (cells[row][column].getType() != currentType) {
				count = 0;
				startCell = cells[startRow][startColumn];
				currentType = startCell.getType();
				continue;
			}
			count++;
			if (currentType != null && count == inRowToWin) {
				return new Sequence(startCell.getRow(), startCell.getColumn(),
						cells[row][column].getRow(), cells[row][column].getColumn());
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return startRow
	 */
	public int getStartRow() {
		return startRow;
	}
	
	/**
	 * 
	 * @return startColumn
	 */
	public int getStartColumn() {
		return startColumn;
	}
	
	/**
	 * 
	 * @return endRow
	 */
	public int getEndRow() {
		return endRow;
	}
	
	/**
	 * 
	 * @return endColumn
	 */
	public int getEndColumn() {
		return endColumn;
	}
}





