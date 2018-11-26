package class3;

import java.io.*;
public class Mnoteb {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class3/mnoteb.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int n = Integer.parseInt(strs[0]);
		int q = Integer.parseInt(strs[1]);
		int[] beats = new int[n];
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
		int seperatedBeats[] = new int [totalBeats];
		int notes = 1;
		int temp = 0;
		for(int i=0; i<n; i++){
			for(int j=temp; j<totalBeats; j++){

				seperatedBeats[j] = notes;
			}
			notes++;
			temp += beats[i];
		}
		
		int[] answers = new int[q];
		for(int i=0; i<q; i++){
			answers[i] = seperatedBeats[questions[i]];
		}
		for(int i=0; i<q; i++){
			System.out.println(answers[i]);
		}
	}
}
