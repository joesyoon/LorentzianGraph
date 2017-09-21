import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GraphData {
	
	public static void main(String[] args) throws FileNotFoundException{
		int x = 445;
		int y = 605;
		JFrame frame = new JFrame("Lorentzian Data");
		frame.setPreferredSize(new Dimension(x, y));
		frame.setMaximumSize(new Dimension(x, y));
		frame.setMinimumSize(new Dimension(x, y));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new GraphDataPanel());
	}
}
