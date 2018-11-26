package class10;

import java.io.*;

public class Dinner {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class10/dinner.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCows = Integer.parseInt(strs[0]);
		int numTables = Integer.parseInt(strs[1]);
		int[] cowsX = new int[numCows];
		int[] cowsY = new int[numCows];
		int[] tablesX = new int[numTables];
		int[] tablesY= new int[numTables];
		int[] cowTaken= new int[numCows];
		long dist = 0;

		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			cowsX[i] = Integer.parseInt(strs[0]);
			cowsY[i] = Integer.parseInt(strs[1]);
		}
		for(int i=0; i<numTables; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			tablesX[i] = Integer.parseInt(strs[0]);
			tablesY[i] = Integer.parseInt(strs[1]);
		}

		long shortD = 922337203685477580L;
		int shortI = 0;
		for(int i=0; i<numTables;i++){
			for(int j=0; j<numCows;j++){
				if (cowTaken[j]!=1){
					long p1 = (long)(cowsX[j] - tablesX[i])*(cowsX[j] - tablesX[i]);
					long p2 = (long)(cowsY[j] - tablesY[i])*(cowsY[j] - tablesY[i]);
					long sum = (p1+p2);
					dist = (long)Math.sqrt(sum);
					if(dist<shortD){
						shortD = dist;
						shortI = j;
					}
				}
			}
			cowTaken[shortI] = 1;
			shortD = 922337203685477580L;
			dist=0;
		}

		int counter = 0;
		for(int i=0; i<numCows;i++){
			if(cowTaken[i]!=1){
				System.out.println(i+1);
				counter++;
			}
		}
		if(counter==0){
			System.out.println("0");
		}
	}
}