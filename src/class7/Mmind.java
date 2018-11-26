package class7;

import java.io.*;

public class Mmind {

	static int[] guess;
	static int[] pos;
	static int[] neg;
	static int[] value;
	static int[] seperatedValue;
	static int[] seperatedGuess;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class7/mmind.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numGuess = Integer.parseInt(strs[0]);
		guess = new int[numGuess];
		pos = new int[numGuess];
		neg = new int[numGuess];
		value = new int[9000];
		seperatedValue = new int[4];
		seperatedGuess = new int[4];

		for(int i=0; i<numGuess; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			
			guess[i] = Integer.parseInt(strs[0]);
			pos[i] = Integer.parseInt(strs[1]);
			neg[i] = Integer.parseInt(strs[2]);
		}
		
		int k = 1000;
		for(int i=0; i<=8999; i++ ){
			value[i] = k;
			k++;
		}
		
		for(int i=0; i<numGuess; i++){
			for(int j=0; j<8999; j++){
				seperatedValue[0] = value[j]%10;
				seperatedValue[1] = (value[j]/10)%10;
				seperatedValue[2] = (value[j]/100)%10;
				seperatedValue[3] = (value[j]/1000)%10;
				seperatedGuess[0] = guess[i]%10;
				seperatedGuess[1] = (guess[i]/10)%10;
				seperatedGuess[2] = (guess[i]/100)%10;
				seperatedGuess[3] = (guess[i]/1000)%10;
				
				if(posCheck()!=pos[i] || negCheck()!=neg[i]){
					value[j] = 0;
				}
			}
		}
		
		for(int i=0; i<8999; i++){
			if(value[i]!=0){
				System.out.println(value[i]);
				System.exit(0);
			}
		}
		System.out.println("NONE");
	}
	
	public static int posCheck(){
		int counter = 0;
		for(int i=0; i<4; i++){
			if(seperatedGuess[i]==seperatedValue[i]){
				counter++;
				seperatedValue[i] = -1;
				seperatedGuess[i] = -1;
			}
		}
		return counter;
	}
	
	public static int negCheck(){
		int counter = 0;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(i!=j && seperatedValue[i]>=0 && seperatedGuess[j]>=0 && seperatedValue[i]==seperatedGuess[j]){
					counter++;
					seperatedValue[i] = -1;
					seperatedGuess[j] = -1;
				}
			}
		}
		return counter;
	}
}
