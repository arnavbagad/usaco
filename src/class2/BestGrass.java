package class2;

import java.io.*;

public class BestGrass {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class2/bestgrasses.in"));
		String gp = br.readLine(); 	
		String[] strs = gp.trim().split("\\s+");
		int rows = Integer.parseInt(strs[0]);
		int collumns = Integer.parseInt(strs[1]);
		int[][] grassPatch = new int[rows][collumns];
		int counter = 0;
		for(int i=0; i<rows; i++){
			for(int j=0; j<collumns; j++){
				grassPatch[i][j] = br.read();
			}
			br.skip(1);
		}

		for(int i=0; i<rows; i++){
			for(int j=0; j<collumns; j++){
				if(grassPatch[i][j] == 35){		
					counter++;
					if(j+1<collumns && grassPatch[i][j+1] == 35){
						grassPatch[i][j+1] = 46;
					}
					else if(i+1<rows && grassPatch[i+1][j] == 35){
						grassPatch[i+1][j] = 46;
					}
				}

			}
		}
		System.out.println(counter);
	}
}

