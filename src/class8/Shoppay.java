package class8;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Shoppay {

	static int[] guess;
	static int[] pos;
	static int[] neg;
	static int[] value;
	static int[] seperatedValue;
	static int[] seperatedGuess;

	public static void main(String[] args) throws IOException {

		File file = new File("./src/class8/shoppay.in");
		Scanner sc = new Scanner(file);
		int numReg = sc.nextInt();
		Queue[] register = new Queue[numReg];
		Queue<Integer> line = new LinkedList<Integer>();
		String[] thing = new String[10000];
		int[] number = new int[10000];
		
		int l = 0;
		while(sc.hasNextLine()){
			thing[l] = sc.next();
			number[l] = sc.nextInt();
			l++;
		}
		
		for(int i=0; i<numReg; i++){
			register[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<l; i++){
			if(thing[i].equals("C")){
				line.add(number[i]);
			}
			else{
				for(int j=1; j<=numReg; j++){
					if(number[i]==j){
						register[number[i]-1].add(line.poll());
						break;
					}
				}
			}
		}

		for(int i=0; i<numReg; i++){
			int size = register[i].size();
			System.out.print(size + " ");
			for(int j=0; j<size; j++){
				System.out.print(register[i].poll() + " ");
			}
			System.out.println();
		}

	}
}