import java.io.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.*;

public class GraphDataPanel extends JPanel{
	
	public GraphDataPanel() throws FileNotFoundException{
		setLayout(null);
		Scanner input = new Scanner(new File("output.txt"));
		String info = "";
		while(input.hasNext()) {
			info = info + input.next() + " | ";
			info = info + input.next() + " \n"; 
		}
		JTextArea text = new JTextArea(info);
		Font font = new Font("Century Gothic", Font.CENTER_BASELINE, 24);
		text.setFont(font);
		JScrollPane scroll = new JScrollPane(text);
		text.setEditable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0, 0, 440, 580);
		add(scroll);
	}
	
}
