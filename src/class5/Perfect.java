package class5;

import java.io.*;
import java.util.*;
public class Perfect {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class5/perfect.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int length = Integer.parseInt(strs[0]);
		int[][] cows = new int[length][length];
		int[] temp = new int[length];
		int[] medians = new int[length];
		int median;
		
		for(int i=0; i<length; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			for(int j=0; j<length; j++){	
				cows[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				temp[j] = cows[i][j];
			}
			Arrays.sort(temp);
			medians[i] = temp[length/2];
		}
		
		Arrays.sort(medians);
		median = medians[length/2];
		System.out.println(median);
		
	}
}
