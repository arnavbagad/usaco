package class6;

import java.io.*;
import java.util.*;
public class Shelf {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class6/shelf.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCows = Integer.parseInt(strs[0]);
		int shelfHeight = Integer.parseInt(strs[1]);
		int[] cowHeight = new int[numCows];

		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			cowHeight[i] = Integer.parseInt(strs[0]);
		}	

		Arrays.sort(cowHeight);
		int newHeight = 0;
		int counter = 0;

		for(int i=0; i<numCows; i++){
			newHeight += cowHeight[cowHeight.length-1-i];
			counter++;
			if(newHeight>=shelfHeight){
				break;
			}
		}

		System.out.println(counter);
	}
}
