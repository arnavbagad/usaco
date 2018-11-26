package class4;

import java.io.*;
public class Marathon {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class4/marathon.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int runners = Integer.parseInt(strs[0]);
		int[][] time = new  int[runners][3];
		int[][] sortedTime = new  int[runners][2];

		for(int i=0; i<runners; i++){		
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			time[i][0] = Integer.parseInt(strs[0]);
			time[i][1] = Integer.parseInt(strs[1]); 
			time[i][2] = Integer.parseInt(strs[2]); 
		}

		for(int i=0; i<runners; i++){
			for(int j=0; j<2; j++){
				if(j==0){
					sortedTime[i][j] = time[i][j]*60*60 + time[i][j+1]*60 + time[i][j+2];
				}
				else{
					sortedTime[i][j] = i;
				}
			}
		}

		int n = sortedTime.length; 
		for (int i = 0; i < n-1; i++){
			for (int j = 0; j < n-i-1; j++){
				if (sortedTime[j][0] > sortedTime[j+1][0]){ 
					int temp = sortedTime[j][0]; 
					sortedTime[j][0] = sortedTime[j+1][0]; 
					sortedTime[j+1][0] = temp; 
					temp = sortedTime[j][1]; 
					sortedTime[j][1] = sortedTime[j+1][1]; 
					sortedTime[j+1][1] = temp; 
				} 
			}
		}

		for(int i=0; i<runners; i++){
			System.out.println(time[sortedTime[i][1]][0] + " " + time[sortedTime[i][1]][1] + " " + time[sortedTime[i][1]][2]);
		}
	}
}
