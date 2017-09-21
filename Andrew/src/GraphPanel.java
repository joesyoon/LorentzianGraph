import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class GraphPanel extends JPanel{
	private ArrayList<Integer> values;
	private int xBound;
	private int yBound;
	private int scale;
	private double yMin;
	private double xMin;
	private double xMax;
	private double yImp;
	private double yMax;
	
	public GraphPanel(ArrayList<Integer> values, int xBound, int yBound, double
			yMin, double xMin, double xMax, double yImp, double yMax, int scale) throws FileNotFoundException{
		this.values = values;
		this.xBound = xBound;
		this.yBound = yBound;
		this.scale = scale;
		this.yMin = yMin;
		this.xMin = xMin;
		this.xMax = xMax;
		this.yImp = yImp;
		this.yMax = yMax;
		setLayout(null);
		JLabel x = new JLabel("Wave Numbers cm^-1");
		x.setForeground(Color.WHITE);
		x.setBounds((xBound / 2) + 50, yBound + 100, 200, 10);
		JButton but = new JButton("Data");
		but.setBounds((xBound /3) + 50, yBound + 100, 150, 20);
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraphData stats = new GraphData();
				try {
					stats.main(null);
				} catch(FileNotFoundException ex) {
					System.err.println("Invalid file.");
				}
			}
		});
		JLabel peak = new JLabel("(" + yImp + ", " + yMax + ")");
		int xImp = (int)((yImp + 50) - xMin);
		peak.setBounds(xImp + 10, 15, 500, 10);
		peak.setForeground(Color.WHITE);
		add(peak);
		add(x);
		add(but);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawLine(50, 20, 50, yBound + 20); //y axis
		double yMax = yBound;
		yMax = yBound * Math.pow(10, -1 * (scale + .5));
		double x = (yMax - yMin)/20;
		double test = yMin + x;
		for(int i = yBound + (20 - (yBound/20)); i >= 20; i-=(yBound/20)) { //y axis increment of 10
			g.drawLine(45, i, 55, i);
			g.drawString("" + test, 20, i);
			test = test + x;
		}
		g.drawLine(50, yBound + 20, xBound + 50, yBound + 20); //x axis
		for(int i = 50; i <= xBound; i+=(xBound/20)) { //x axis increment of 100
			g.drawLine(i + 50, yBound + 10, i + 50, yBound + 30);
			g.drawString("" + (xMin + i), i + 50, yBound + 50);
		}
		int x1 = 50 + values.get(0);
		int y1 = (yBound + 20) - values.get(1);
		g.setColor(Color.GREEN);
		for(int i = 2; i < values.size(); i +=2) {
			int x2 = 50 + values.get(i);
			int y2 = (yBound + 20) - values.get(i + 1);
			g.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;
		}
		g.setColor(Color.WHITE);
		int xImp = (int) ((yImp + 50) - xMin);
		g.fillOval(xImp - 5, 15, 10, 10);
		
	}
}
