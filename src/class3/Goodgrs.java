package class3;

import java.io.*;
public class Goodgrs {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class3/goodgrs.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int rows = Integer.parseInt(strs[0]);
		int columns = Integer.parseInt(strs[1]);
		int[][] grass = new int[rows][columns];
		int max = 0;
		int keepI = 0;
		int keepJ = 0;

		for(int i=0; i<rows; i++){
			for(int j=0; j<1; j++){
				lines = br.readLine(); 
				strs = lines.trim().split("\\s+");

				for(int k=0; k<columns; k++){
					grass[i][k] = Integer.parseInt(strs[k]);
				}
			}
		}

		for(int i=0; i<rows-2; i++){
			for(int j=0; j<columns-2; j++){
				int sum = grass[i][j]+grass[i][j+1]+grass[i][j+2]+grass[i+1][j]+grass[i+2][j]+grass[i+1][j+1]+grass[i+1][j+2]+grass[i+2][j+1]+grass[i+2][j+2];
				if(sum>max){
					max = sum;
					keepI = i+1;
					keepJ = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(keepI + " " + keepJ);
	}
}
