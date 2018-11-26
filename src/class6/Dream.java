package class6;

import java.io.*;
public class Dream {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class6/dream.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int m = Integer.parseInt(strs[0]);
		int n = Integer.parseInt(strs[1]);
		int[] num = new int[n-m+1];
		int temp = m;
		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = 0;
		int eight = 0;
		int nine = 0;
	

		for(int i=0; i<n-m+1;i ++){
			num[i] = temp;
			temp++;
		}

		for(int i=0; i<n-m+1; i++){
			while(num[i]>0){
				if(num[i]%10==0){
					zero++;
					num[i] = (num[i]-0)/10;
				}
				else if(num[i]%10==1){
					one++;
					num[i] = (num[i]-1)/10;
				}
				else if(num[i]%10==2){
					two++;
					num[i] = (num[i]-2)/10;
				}
				else if(num[i]%10==3){
					three++;
					num[i] = (num[i]-3)/10;
				}
				else if(num[i]%10==4){
					four++;
					num[i] = (num[i]-4)/10;
				}
				else if(num[i]%10==5){
					five++;
					num[i] = (num[i]-5)/10;
				}
				else if(num[i]%10==6){
					six++;
					num[i] = (num[i]-6)/10;
				}
				else if(num[i]%10==7){
					seven++;
					num[i] = (num[i]-7)/10;
				}
				else if(num[i]%10==8){
					eight++;
					num[i] = (num[i]-8)/10;
				}
				else if(num[i]%10==9){
					nine++;
					num[i] = (num[i]-9)/10;
				}
			}
		}
		System.out.println(zero+" "+one+" "+two+" "+three+" "+four+" "+five+" "+six+" "+seven+" "+eight+" "+nine);	
	}
}