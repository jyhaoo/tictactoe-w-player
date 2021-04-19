package polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author jasonhao
 * Draws the tic tac toe board
 */
public class DrawableLine extends JComponent {
	
	static private final String FRAME_TITLE = "Tic Tac Toe";
	static private final Dimension START_FRAME_DIMS = new Dimension(420, 420);
	static private final int VERTEX_SIZE = 10;
	static private final int LINE_WIDTH = 3;
	static private final int BOUNDS_BUFFER = 5;
	
	static private Random rand = new Random(10);
	static private JFrame frame = null;
	
	private final Point topLeft;
	private Point[] points;
	private Color color;
	private boolean withVertices;
	private boolean removed;
	
	/**
	 * 
	 * Draws the line given a starting and ending position
	 * @param start Starting point
	 * @param end Ending point
	 */
	DrawableLine (Point start, Point end) {
		this(start, end, true);
	}
	
	/**
	 * 
	 * @param start Starting point
	 * @param end Ending point
	 * @param withVertices 
	 */
	DrawableLine (Point start, Point end, boolean withVertices) {
		if (frame == null) {
			initializeFrame();
		}
		
		points = new Point[] {start, end};
		this.withVertices = withVertices;
		
		color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
		removed = false;
		
		topLeft = new Point (
			start.getX() < end.getX() ? start.getX() : end.getX(), 
			start.getY() < end.getY() ? start.getY() : end.getY());
		
		setBounds(
					topLeft.getX() - BOUNDS_BUFFER,
					topLeft.getY() - BOUNDS_BUFFER,
					Math.abs(start.getX() - end.getX()) + 2 * BOUNDS_BUFFER,
					Math.abs(start.getY() - end.getY()) + 2 * BOUNDS_BUFFER);
		frame.add(this, 0);
		
		frame.validate();
		frame.repaint();
	}
	
	/**
	 * Initialize the frame for the tictactoe board
	 */
	private static void initializeFrame() {
		frame = new JFrame();
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setPreferredSize(START_FRAME_DIMS);
		frame.setContentPane(contentPane);
		contentPane.setOpaque(true);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Remove 
	 */
	void remove() {
		removed = true;
		frame.revalidate();
		frame.repaint();
	}
	
	/**
	 * 
	 * @return Starting point
	 */
	Point getStart() {
		return points[0];
	}
	
	/**
	 * 
	 * @return Ending point
	 */
	Point getEnd() {
		return points[1];
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (removed) {
			return;
		}
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(LINE_WIDTH));
		g2.draw(new Line2D.Float(
					points[0].getX() - topLeft.getX() + BOUNDS_BUFFER,
					points[0].getY() - topLeft.getY() + BOUNDS_BUFFER,
					points[1].getX() - topLeft.getX() + BOUNDS_BUFFER,
					points[1].getY() - topLeft.getY() + BOUNDS_BUFFER));
		g2.setColor(Color.black);
		if (withVertices) {
			for (int i = 0; i < 2; i++) {
				Ellipse2D.Double circle = new Ellipse2D.Double(
						points[i].getX() - topLeft.getY() - VERTEX_SIZE / 2 + BOUNDS_BUFFER,
						points[i].getY() - topLeft.getY() - VERTEX_SIZE / 2 + BOUNDS_BUFFER,
						VERTEX_SIZE, VERTEX_SIZE);
				g2.fill(circle);
			}
		}
	}
}






