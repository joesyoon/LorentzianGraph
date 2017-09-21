import java.util.*;
import java.awt.*;
import java.io.*;

public class Graph {
	public static void main(String []args) throws FileNotFoundException{
		intro();
		DrawingPanel panel = new DrawingPanel(500, 500);
		Graphics g = panel.getGraphics();
		g.drawLine(50, 50, 50, 450);
		g.drawLine(50, 450, 450, 450);
	}
	
	public static void intro() throws FileNotFoundException{
		Queue<Double> q = new LinkedList<Double>();
		double xMin = 0;
		double xMax = 0;
		double yMax = 0;
		Scanner input = new Scanner(new File("output.txt"));
		input.nextLine();
		while(input.hasNextDouble()) {
			q.add(input.nextDouble());
		}
		input.next();
		yMax = input.nextDouble();
	}
}
