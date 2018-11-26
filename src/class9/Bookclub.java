package class9;

import java.io.*;

public class Bookclub {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class9/bookclub.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numCows = Integer.parseInt(strs[0]);
		int numQuestions = Integer.parseInt(strs[1]);
		int query = Integer.parseInt(strs[2]);
		int[][] QA = new int[numCows][numQuestions];
		int[] question = new int[query];
		int[] answer = new int[query];
		int counter = 0;
		int tempCounter = 0;
		
		for(int i=0; i<numCows; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			for(int j=0; j<numQuestions; j++){
				QA[i][j] = Integer.parseInt(strs[j]);
			}
		}
		for(int i=0; i<query; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			
			question[i] = Integer.parseInt(strs[0]);
			answer[i] = Integer.parseInt(strs[1]);
		}
		
		for(int i=0; i<numCows; i++){
			for(int j=0; j<query; j++){
				if(QA[i][question[j]-1]==answer[j]){
					tempCounter++;
				}
				else{
					break;
				}
			}
			if(tempCounter==query){
				counter++;
			}
			tempCounter = 0;
		}
		System.out.println(counter);
	}
}