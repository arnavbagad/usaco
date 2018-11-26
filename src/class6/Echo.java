package class6;

import java.io.*;
public class Echo {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class6/echo.in"));
		String lines = br.readLine();  
		String[] strs = lines.trim().split("\\s+"); 
		String voice = strs[0];
		lines = br.readLine();  
		strs = lines.trim().split("\\s+"); 
		String echo = strs[0];
		char[] og = new char[voice.length()];
		char[] eko = new char[echo.length()];
		int counter = 0;
		int max = 0;

		for(int i=0; i<echo.length(); i++){
			eko[i] = echo.charAt(i); 
		}
		for(int i=0; i<voice.length(); i++){
			og[i] = voice.charAt(i); 
		}
		for(int i=0; i<80; i++){
			if(og.length>i && eko.length>i){
				if(og[i]==eko[i]){
					counter++;
				}
				else if(counter>max){
					max = counter;
					counter = 0;
				}
			}
			else{
				break;
			}
		}
		System.out.println(counter);
	}
}