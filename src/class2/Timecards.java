package class2;

import java.io.*;

public class Timecards {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class2/timecards.in"));
		String num = br.readLine();
		String[] strs = num.trim().split("\\s+");
		int cows = Integer.parseInt(strs[0]);
		int lines = Integer.parseInt(strs[1]);
		int[] cowNum = new int[lines];
		int[] cowNum2 = new int[cows];
		String[] keyword = new String[lines];
		int[] hour = new int[lines];
		int[] min = new int[lines];
		int[] hourDone = new int[cows];
		int[] minDone = new int[cows];
		for(int i=0; i<lines; i++){
			num = br.readLine(); 
			strs = num.trim().split("\\s+");

			cowNum[i] = Integer.parseInt(strs[0]);
			keyword[i] = strs[1];
			hour[i] = Integer.parseInt(strs[2]);
			min[i] = Integer.parseInt(strs[3]);
		}

		for(int i=0; i<lines; i++){
			if(keyword[i].equals("START")){
				cowNum2[cowNum[i]-1] -= hour[i]*60+min[i];
			}
			else if(keyword[i].equals("STOP")){
				cowNum2[cowNum[i]-1] += hour[i]*60+min[i];
			}
		}
		
		for(int i=0; i<cows; i++){
			hourDone[i] = cowNum2[i]/60;
			minDone[i] = cowNum2[i]%60;
		}
		for(int i=0; i<cows; i++){
			System.out.println(hourDone[i] + " " + minDone[i]);
		}
		
	}

}
