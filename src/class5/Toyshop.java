package class5;

import java.io.*;
import java.util.*;
public class Toyshop {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class5/toyshop.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numToys = Integer.parseInt(strs[0]);
		int[] joy = new int[numToys];
		int[] price = new int[numToys];
		float[] hfm = new float[numToys];

		for(int i=0; i<numToys; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			joy[i] = Integer.parseInt(strs[0]);
			price[i] = Integer.parseInt(strs[1]);
		}


		for(int i=0; i<numToys; i++){
			hfm[i] = (float)joy[i]/price[i];
		}

		float[] hfm2 = new float[numToys];
		for(int i=0; i<numToys; i++){
			hfm2[i] = hfm[i]; 
		}

		Arrays.sort(hfm);
		int m1 = hfm.length-1;
		int m2 = hfm.length-2;
		int m3 = hfm.length-3;
		int n1 = -1;
		int n2 = -1;
		int n3 = -1;

		for(int i=0; i<numToys; i++){
			if(n1==-1){
				if(hfm[m1]==hfm2[i]){
					n1 = i;
				}
			}
			if(n2==-1){
				if(hfm[m2]==hfm2[i]){
					n2 = i;
				}
			}
			if(n3==-1){
				if(hfm[m3]==hfm2[i]){
					n3 = i;
				}
			}
		}

		int totalPrice = price[n1]+price[n2]+price[n3];
		System.out.println(totalPrice);	
		System.out.println(n1+1);
		System.out.println(n2+1);
		System.out.println(n3+1);
	}
}
