package class1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Lonesome {

	public static void main(String[] args) throws IOException{

		int a = 0;
		int b = 0;

		BufferedReader br = new BufferedReader(new FileReader("./src/class1/lonesome.in"));
		String stuff = br.readLine(); 
		String line = null; 		
		int numCows = Integer.parseInt(stuff);
		int[] x = new int[numCows];
		int[] y = new int[numCows];

		for(int i=0; i<numCows; i++){
			line = br.readLine();  
			String[] strs = line.trim().split("\\s+");
			x[i] = Integer.parseInt(strs[0]);
			y[i] = Integer.parseInt(strs[1]);
		}
		double lonesom = Math.sqrt((x[0]-x[1])*(x[0]-x[1])+(y[0]-y[1])*(y[0]-y[1]));
		for(int j=numCows-1; j>0; j--){
			for(int i=0; i<numCows; i++){
				double temp = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
				if(temp>lonesom){
					lonesom = temp;
					a = i+1;
					b = j+1;
				}
				else{
					continue;
				}
			}
		}
		System.out.println(a +" "+ b);

	}

}
