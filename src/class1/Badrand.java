package class1;

import java.io.*;

public class Badrand {

	public static int[] middleNumbers = new int[10000];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class1/badrand.in"));
		String num = br.readLine(); 		
		int randNum = Integer.parseInt(num);
		newNum(randNum);
	}

	public static void newNum(int num){
		int midNum = 0;
		for(int i=0; i<10000; i++){
			midNum = ((num%1000)-(num%1000)%10);
			midNum = midNum/10;
			middleNumbers[i] = num;
			num = midNum*midNum;
			for(int j=0; j<i; j++){
				if(middleNumbers[j]==middleNumbers[i]){
					System.out.println(i);
					System.exit(0);
				}
				else{
					continue;
				}
			}

		}
	}
}
