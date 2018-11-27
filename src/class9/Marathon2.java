package class9;

import java.io.*;

public class Marathon2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class9/marathon2.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCP = Integer.parseInt(strs[0]);
		int[] x  = new int[numCP];
		int[] y  = new int[numCP];
		int[] distanceDirect  = new int[numCP];

		for(int i=0; i<numCP; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			x[i] = Integer.parseInt(strs[0]);
			y[i] = Integer.parseInt(strs[1]);
		}



		int worstCaseD = 0;
		int bestCaseD = 0;
		for(int i=0; i<numCP-1; i++){
			worstCaseD += Math.abs(x[i]-x[i+1]) + Math.abs(y[i]-y[i+1]);
		}

		int maxD = 0;
		for(int i=0; i<numCP-2; i++){
			distanceDirect[i] = (Math.abs(x[i]-x[i+1]) + Math.abs(y[i]-y[i+1])) + (Math.abs(x[i+1]-x[i+2]) + Math.abs(y[i+1]-y[i+2])) - (Math.abs(x[i]-x[i+2]) + Math.abs(y[i]-y[i+2])); 
			if(distanceDirect[i]>maxD){
				maxD = distanceDirect[i];
			}
		}

		bestCaseD = worstCaseD - maxD;

		if(worstCaseD>bestCaseD){
			System.out.println(bestCaseD);
		}
		else{
			System.out.println(worstCaseD);
		}
	}
}
