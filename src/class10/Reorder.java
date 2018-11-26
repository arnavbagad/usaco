package class10;

import java.io.*;

public class Reorder {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class10/reorder.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCows = Integer.parseInt(strs[0]);
		int[] a = new int[numCows];
		int[] b = new int[numCows];

		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			a[i] = Integer.parseInt(strs[0]);
		}
		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			b[i] = Integer.parseInt(strs[0]);
		}

		int current = 0;
		int length = 0;
		int maxLength = 0;
		int cycles = 0;
		int position = 0;
		int temp = 0;
		for(int i=0; i<numCows; i++){
			if(a[i]!=b[i]){
				current = a[i];
				a[i] = 0;
				while(current!=0){
					position = fpb(current, numCows, b);
					temp = a[position];
					a[position] = current;
					current = temp;
					length++;
				}
				if(length>maxLength){
					maxLength = length;
				}
				length = 0;
				cycles++;
			}
		}
		if(maxLength!=0){
			System.out.println(cycles + " " + maxLength);
		}
		else{
			System.out.println(cycles + " -1");
		}
	}

	public static int fpb(int current, int numCows, int[] b){
		for(int i=0; i<numCows; i++){
			if(current==b[i]) return i;
		}
		return -1;
	}

}