package class2;

import java.io.*;

public class SpeedReading {

	public static void main(String[] args) throws IOException {



		BufferedReader br = new BufferedReader(new FileReader("./src/class2/speedreading.in"));
		String num = br.readLine();
		String[] strs = num.trim().split("\\s+");
		int pages = Integer.parseInt(strs[0]);
		int cows = Integer.parseInt(strs[1]);
		int[] reading = new int[cows];
		int[] continues = new int[cows];
		int[] breaks = new int[cows];
		int[] minTake= new int[cows];
		int counter = 0;
		int readingMinutes = 0;
		int restingMinutes=0;
		int pagesLeft=0;
		pagesLeft=pages;


		for(int i=0; i<cows; i++){
			num = br.readLine(); 
			strs = num.trim().split("\\s+");

			reading[i] = Integer.parseInt(strs[0]);
			continues[i] = Integer.parseInt(strs[1]);
			breaks[i] = Integer.parseInt(strs[2]);
		}

		for(int i=0; i<cows; i++){
			while (pagesLeft>reading[i]){
				pagesLeft = pagesLeft-reading[i]*continues[i];
				readingMinutes += continues[i];
				
				if(pagesLeft>0){
					restingMinutes += breaks[i];
				}
			}
			if(pagesLeft%reading[i]==0){
				readingMinutes += pagesLeft/reading[i];
			}
			else{
				readingMinutes += pagesLeft/reading[i]+1;
			}

			counter = readingMinutes + restingMinutes;
			minTake[i] = counter;
			counter = 0;
			restingMinutes=0;
			readingMinutes=0;
			pagesLeft=pages;
		}
		for(int i=0; i<cows; i++){
			System.out.println(minTake[i]);
		}
	}
}
