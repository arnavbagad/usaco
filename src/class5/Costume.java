package class5;

import java.io.*;
import java.util.*;
public class Costume {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class5/costume.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCows = Integer.parseInt(strs[0]);
		int pairMax = Integer.parseInt(strs[1]);
		int[] cowValue = new int[numCows];

		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			cowValue[i] = Integer.parseInt(strs[0]);
		}

		Arrays.sort(cowValue);
		int high = cowValue.length-1;
		int low = 0;
		int ans=0;
		
		while (low < high){
			if(cowValue[low]>=pairMax) break;
			while (low<high && (cowValue[low] + cowValue[high])>pairMax)high--;
			if (low<high) ans += (high-low);
			low++;
		}
		
		System.out.println(ans);
	}

	

}
