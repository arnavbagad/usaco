package class4;

import java.io.*;
public class Binarysearch {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class4/binarysearch.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numNum = Integer.parseInt(strs[0]);
		int numQuestions = Integer.parseInt(strs[1]);
		int[] num = new int[numNum];
		int question = 0;

		if (numNum!=0){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			for(int i=0; i<numNum; i++){
				num[i] = Integer.parseInt(strs[i]);
			}
		}
		strs = null;
		for(int i=0; i<numQuestions; i++){
			lines = br.readLine();
			strs = lines.trim().split("\\s+");

			question = Integer.parseInt(strs[0]);
			int answer= FindPosition(num,question);
			while (answer>0 && num[answer-1]==question){
				answer--;
			}

			System.out.println(answer);

		}
		strs = null;
		br.close();


	}

	static int FindPosition(int[] inputArray ,int query ){

		int high = inputArray.length-1;
		int low = 0;
		int mid = (low+high)/2;


		for(int j=0; j<inputArray.length; j++){
			mid = (low+high)/2;
			if(inputArray[low]==query) return low;
			else if(inputArray[mid]==query) return mid;	
			else if(inputArray[high]==query) return high;
			else if(mid==low || mid==high) return -1;

			else if(inputArray[mid]>query){
				high = mid;
			}
			else if(inputArray[mid]<query){
				low = mid;

			}
		}

		return -1;



	}


}
