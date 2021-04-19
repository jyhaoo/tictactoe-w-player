package polygon;

import java.util.ArrayList;

abstract public class LineList {
	
	private ArrayList<DrawableLine> lines;
	private boolean withVertices;
	
	protected LineList() {
		this(true);
	}
	
	/**
	 * 
	 * @param withVertices 
	 */
	protected LineList(boolean withVertices) {
		this.withVertices = withVertices;
		lines = new ArrayList<DrawableLine>();
	}
	
	/**
	 * 
	 * @param start Starting point of line
	 * @param end Ending point of line
	 */
	protected void addLine(Point start, Point end) {
		lines.add(new DrawableLine(start, end, withVertices));
	}
	
	/**
	 * 
	 * Finds and removes line specified
	 * @param start Starting point of line being removed
	 * @param end Ending point of line being removed
	 * @return True if line is found
	 */
	protected boolean removeLine(Point start, Point end) {
		for (DrawableLine line : lines) {
			if (line.getStart().equals(start) && line.getEnd().equals(end)) {
				line.remove();
				lines.remove(line);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param withVertices Sets withVertices true or false
	 */
	protected void setWithVertices(boolean withVertices) {
		this.withVertices = withVertices;
	}
	
	/**
	 * Remove all lines
	 */
	protected void removeAll() {
		for (DrawableLine line : lines) {
			line.remove();
		}
		lines.clear();
	}
	
}





