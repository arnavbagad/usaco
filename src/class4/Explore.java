package class4;

import java.io.*;
import java.util.*;
public class Explore {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class4/explore.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int timeLeft = Integer.parseInt(strs[0]);
		int numLoc = Integer.parseInt(strs[1]);
		int[] ogLoc = new int[numLoc];
		int[] locations = new int[numLoc];
		int bessieLoc = 0;
		int counter = 0;

		for(int i=0; i<numLoc; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			ogLoc[i] = Integer.parseInt(strs[0]);
			if(Integer.parseInt(strs[0])<0){
				locations[i] = -1*Integer.parseInt(strs[0]);
			}
			else{
				locations[i] = Integer.parseInt(strs[0]);
			}
		}

		int index = 0;
		Arrays.sort(locations);
		Arrays.sort(ogLoc);
		int [] finalLocation = locations.clone();
		
		for(int i=0; i<numLoc; i++){
			if(ogLoc[i]<0){
				index = Arrays.binarySearch(locations, -1*ogLoc[i]);
				if(index>=0){
					finalLocation[index] = ogLoc[i];
				}
				index = 0;
			}
		}

		for(int i=0; i<numLoc; i++){
			if(finalLocation[i]>bessieLoc){
				timeLeft = timeLeft-(finalLocation[i] - bessieLoc);
				bessieLoc = finalLocation[i];
				if(timeLeft>=0){
					counter ++;
				}
				else{
					break;
				}
			}
			else if(finalLocation[i]<bessieLoc){
				timeLeft = timeLeft-(bessieLoc - finalLocation[i]); 
				bessieLoc = finalLocation[i];
				if(timeLeft>=0){
					counter ++;
				}
				else{
					break;
				}
			}
			else if(finalLocation[i]==bessieLoc){
				bessieLoc = finalLocation[i];
				if(timeLeft>=0){
					counter ++;
				}
				else{
					break;
				}
			}
		}
		System.out.println(counter);
	}
}
