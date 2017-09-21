import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Graph {
	private static double yMax;
	private static double xMax;
	private static double xMin;
	private static double yMin;
	private static double yImp;
	private static int xBound;
	private static int yBound;
	
	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<Double> values = read();
		int scale = calc();
		ArrayList<Integer> intValues = new ArrayList<Integer>();
		xMin = values.get(0);
		yMin = values.get(1);
		for(int i = 0; i < values.size(); i+=2) {
			double num = values.get(i);
			int change = (int) (num - xMin);
			intValues.add(change);
			double num2 = values.get(i + 1);
			int change2 = (int) (num2 * Math.pow(10, scale + .5));
			intValues.add(change2);
		}
		xBound = (int)(xMax - xMin);
		yBound = (int)(yMax * Math.pow(10, scale + .5));
		JFrame frame = new JFrame("Lorentzian Graph");
		frame.setPreferredSize(new Dimension(xBound + 200, yBound + 200));
		frame.setMaximumSize(new Dimension(xBound + 200, yBound + 200));
		frame.setMinimumSize(new Dimension(xBound + 200, yBound + 200));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GraphPanel(intValues, xBound, yBound, yMin, xMin, xMax, yImp, yMax, scale));
		frame.setVisible(true);
		
	}
	
	public static int calc() {
		String temp = yMax + "";
		String constant = "";
		constant = constant + temp.charAt(temp.length() - 1);
		int scale = Integer.parseInt(constant);
		scale = scale + 2;
		return scale;
	}
	
	public static ArrayList<Double> read() throws FileNotFoundException{
		Scanner input = new Scanner(new File("output.txt"));
		ArrayList<Double> values = new ArrayList<Double>();
		input.nextLine();
		while(input.hasNextDouble()) {
			values.add(input.nextDouble());
		}
		input.next();
		yMax = input.nextDouble();
		input.next();
		xMax = input.nextDouble();
		input.next();
		yImp = input.nextDouble();
		return values;
	}
}