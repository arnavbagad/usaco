package class1;

import java.io.*;

public class Flower{

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader("./src/class1/flowers.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numFlowers = Integer.parseInt(strs[0]);
		int typesFlowers =Integer.parseInt(strs[1]);
		int[] starts = new int[typesFlowers];
		int[] interval = new int[typesFlowers];
		int[] flowers = new int[numFlowers];

		for(int i = 0; i<typesFlowers; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			starts[i] = Integer.parseInt(strs[0]);
			interval[i] = Integer.parseInt(strs[1]);
		}

		int counter = 0;
		for(int j=0; j<typesFlowers; j++){
			for(int i=0; i<flowers.length; i++){
				if((i-starts[j])%interval[j]==0){
					flowers[i] = 1;
				}
			}
		}
		for(int i=0; i<flowers.length; i++){
			if(flowers[i]==0){
				counter++;
			}
		}
		System.out.println(counter);
	}
}
 