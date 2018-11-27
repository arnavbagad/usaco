package class7;

import java.io.*;

public class Dance2 {

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new FileReader("./src/class7/dance2.in"));
		String lines = br.readLine();  
		String[] strs = lines.trim().split("\\s+");
		int numSongs = Integer.parseInt(strs[0]);
		int numCows;
		String[] bows;
		int counter = 0;

		for(int i=0; i<numSongs; i++){
			lines = br.readLine();
			strs = lines.trim().split("\\s+");
			numCows = Integer.parseInt(strs[0]);
			if(numCows%2!=0) System.out.println("illegal");
			else{
				bows = new String[numCows];
				bows = strs[1].trim().split("(?!^)");
				counter = 0;
				for(int k=0; k<numCows; k++){
					if(bows[k].equals(">"))counter++;
					else if(bows[k].equals("<"))counter--;
					if (counter<0) break;	
				}
				if(counter==0)System.out.println("legal");
				else System.out.println("illegal");
			}
		}
		br.close();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}
}