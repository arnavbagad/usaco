package class7;

import java.io.*;

public class Stringe {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class7/stringe.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numString = Integer.parseInt(strs[0]);
		int[] whereEdit = new int[numString];
		int[] numEdits = new int[numString];
		String[] string = new String[numString];
		String s;

		for(int i=0; i<numString; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			whereEdit[i] = Integer.parseInt(strs[0]);
			numEdits[i] = Integer.parseInt(strs[1]);
			string[i] = strs[2];
		}
		
		for(int i=0; i<numString; i++){
			for(int j=0; j<numEdits[i]; j++){
				s = string[i].substring(whereEdit[i]);
				string[i] = s + string[i];
			}
			System.out.println(string[i]);
		}
		
	}
}