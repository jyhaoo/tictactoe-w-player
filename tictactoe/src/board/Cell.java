package board;

public class Cell {
	
	private BoardView view;
	private int row;
	private int column;
	private MarkerType type;
	private Marker marker;
	
	/**
	 * 
	 * @param view Boardview
	 * @param row Rows on board
	 * @param column Columns on board
	 */
	Cell(BoardView view, int row, int column) {
		this.view = view;
		this.row = row;
		this.column = column;
		type = null;
	}
	
	/**
	 * 
	 * @param type Set cell to type
	 */
	void setType(MarkerType type) {
		if (marker != null && this.type != type) {
			marker.delete();
			marker = null;
		}
		this.type = type;
		if (type != null) {
			marker = view.displayMarker(this);
		}
	}
	
	/**
	 * 
	 * @return True if cell is filled
	 */
	public boolean isFilled() {
		return type != null;
	}
	
	/**
	 * 
	 * @return Type of marker for the cell
	 */
	public MarkerType getType() {
		return type;
	}
	
	/**
	 * 
	 * @return Number of row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * 
	 * @return Number of column
	 */
	public int getColumn() {
		return column;
	}
}





