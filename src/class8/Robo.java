package class8;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked") 
public class Robo {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class8/robo.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCommands = Integer.parseInt(strs[0]);
		Stack barrels  = new Stack();
		Stack revBarrels  = new Stack();
		String[] commands = new String[numCommands];
		
		for(int i=0; i<numCommands; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			
			commands[i] = strs[0];
		}
		
		int counter = 1;
		for(int i=0; i<numCommands; i++){
			if(commands[i].equals("ADD")){
				barrels.push(counter);
				counter++;
			}
			else{
				barrels.pop();
			}
		}
		
		int barrelSize = barrels.size();
		for(int i=0; i<barrelSize; i++){
			revBarrels.add(barrels.pop());
		}
		
		int revBarrelSize = revBarrels.size();
		System.out.println(revBarrelSize);
		for(int i=0; i<revBarrelSize; i++){
			System.out.println(revBarrels.pop());
		}
	}
}
