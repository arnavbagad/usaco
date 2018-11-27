package class9;

import java.io.*;

public class Digits {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class9/digits.in"));
		String wrongBase2 = br.readLine(); 
		String wrongBase3 = br.readLine(); 

		for(int i=0; i<wrongBase2.length(); i++){

			char[] myBase2 = wrongBase2.toCharArray();
			if(myBase2[i] =='0') myBase2[i] ='1';
			else myBase2[i] ='0';

			String newBase2 = String.valueOf(myBase2);
			int newBase2Int= Integer.parseInt(newBase2, 2);
			for(int j=0; j<wrongBase3.length(); j++){
				char[] myBase3 = wrongBase3.toCharArray();
				String newBase3 = null;
				int newBase3Int=0;

				myBase3[j] ='1';
				newBase3= String.valueOf(myBase3);
				newBase3Int= Integer.parseInt(newBase3, 3);
				if (newBase2Int==newBase3Int){
					System.out.println(newBase2Int);
					System.exit(0);
				}
				myBase3[j] ='2';
				newBase3= String.valueOf(myBase3);
				newBase3Int= Integer.parseInt(newBase3, 3);
				if (newBase2Int==newBase3Int){
					System.out.println(newBase2Int);
					System.exit(0);
				}

				myBase3[j] ='0';
				newBase3= String.valueOf(myBase3);
				newBase3Int= Integer.parseInt(newBase3, 3);
				if (newBase2Int==newBase3Int){
					System.out.println(newBase2Int);
					System.exit(0);
				}
			}

		}
	}
}
