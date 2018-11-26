package class1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Ride{
	//build alphabet string to find value of character
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class1/ride.in"));
		String  lines1 = br.readLine(); 
		String  lines2 = br.readLine(); 
		
		
		//Comet value same as group value then return go else stay
		if(ConvertNameToNumber(lines1) % 47 == ConvertNameToNumber(lines2) % 47){
			System.out.println("GO");
		}
		else{
			System.out.println("STAY");
		}
		
	}
	
	//function to convert name to value
	public static int ConvertNameToNumber(String name){
		int value = 1;
		for(int i = 0; i < name.length(); i++){
			value *= ConvertCharToNumber(name.charAt(i));
		}
		return value;
	}
	
	//function to convert char to value
	public static int ConvertCharToNumber(char c){
		return alphabet.indexOf(c) + 1;
	}

}
