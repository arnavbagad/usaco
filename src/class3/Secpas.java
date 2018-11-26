package class3;

import java.io.*;
public class Secpas {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class3/secpas.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int area = Integer.parseInt(strs[0]);
		int counter = 0;
		for(int a=0; a<=Math.sqrt(area); a++){
			for(int b=0; b<=Math.sqrt(area); b++){
				for(int c=0; c<=Math.sqrt(area); c++){
					int d = area-(a*a+b*b+c*c);
					int i = (int)Math.sqrt(d);
					i = i*i;
					if(i==d){
						if(a*a+b*b+c*c+d==area){
							counter++;
						}
					}
					else{
						if(a*a+b*b+c*c==area){
							counter++;
						}
					}
				}
			}
		}
		System.out.println(counter);
	}
}
