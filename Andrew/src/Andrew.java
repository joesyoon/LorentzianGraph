//Joseph Yoon 09/06/17
//Lorentzian Output Generator
//
//This program takes in input values and utilizes the Lorentzian function to
//output coordinate points.

import java.util.*;
import java.io.*;
public class Andrew {
	public static void main(String []args) throws FileNotFoundException{
		Queue<Double> q = new LinkedList<Double>();
		PrintStream output = new PrintStream(new File("output.txt"));
		Scanner change = new Scanner(new File("inputfile.txt"));
		double increment = 0;
		double pi = 3.14159265358979;
		double constant = 0;
		double min = 0;
		double max = 0;
		double yMax = 0;
		double yImp = 0;
		boolean stop = true;
		while(change.hasNextLine() && stop) {
			String line = change.nextLine();
			if(line.equals("#step-size, min freq and max freq")) {
				increment = change.nextDouble();
				min = change.nextDouble();
				max = change.nextDouble();
				while(change.hasNext() && stop) {
					String token = change.next();
					if(token.equals("fwhm")) {
						change.nextDouble();
						constant = change.nextDouble();
						stop = false;
					}
				}
			}
		}
		//
		output.println("x-coordinate  y-coordinate");
		double center = 0;
		double intensity = 0;
		Scanner input = new Scanner(new File("inputfile.txt"));
		while(input.hasNext()) {
			String word = input.next();
			if(word.equals("intensity")) {
				while(input.hasNext()) {
					center = input.nextDouble();
					intensity = input.nextDouble();
					q.add(center);
					q.add(intensity);
				}
			}
		}
		for(double i = min; i < max; i+=increment) {
			double function = 0;
			for(int j = 0; j < q.size(); j+=2) {
				center = q.remove();
				intensity = q.remove();
				function = function + (intensity)*(1/pi)*((constant/2)/(((i - center)*(i - center)) + ((constant/2)*(constant/2))));
				q.add(center);
				q.add(intensity);
			}
			if(function > yMax) {
				yMax = function;
				yImp = i;
			}
			output.println(i + " " + function);
		}
		output.println("Y-max: " + yMax);
		output.println("X-max: " + max);
		output.println("Y-Important: " + yImp);
	}
}
