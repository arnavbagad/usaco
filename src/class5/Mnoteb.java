package class5;

import java.io.*;
import java.util.Arrays;
public class Mnoteb {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class5/mnoteb.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int n = Integer.parseInt(strs[0]);
		int q = Integer.parseInt(strs[1]);
		int[] beats = new int[n];
		int[] endBeats = new int[n];
		int[] questions = new int[q];

		for(int i = 0; i<n; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			beats[i] = Integer.parseInt(strs[0]);
		}

		for(int i = 0; i<q; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			questions[i] = Integer.parseInt(strs[0]);
		}

		int totalBeats = 0;
		for(int i=0; i<n; i++){        
			totalBeats += beats[i];
		}

		for(int i=n-1; i>=0; i--){        
			endBeats[i] = totalBeats;
			totalBeats -= beats[i];
		}

		int question;
		for(int i=0; i<q; i++){
			question = questions[i];	
			int x = findPosition(endBeats, question, beats);
			System.out.println(x);
			
		}
		
	}

	static int findPosition(int[] endBeats, int question, int[] beats){

		int high = endBeats.length-1;
		int low = 0;
		int mid = (low+high)/2;
		for(int i=0; i<endBeats.length; i++){
			mid = (low+high)/2;
			
			if(high-low == 1 || low-high == 1){
				mid = (low+high)/2;
				if(endBeats[low]>question){
					return low+1;
				}
				else{
					return high+1;
				}	
			}
			else if(endBeats[low]==question) return low+2;
			else if(endBeats[mid]==question) return mid+2;	
			else if(endBeats[high]==question) return high+2;
			else if(endBeats[mid]>question){
				high = mid;
			}
			else if(endBeats[mid]<question){
				low = mid;
			}
		}
		return -1;
	}
}
