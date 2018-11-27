package class3;

import java.io.*;
public class Rollers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class3/rollers.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int numRollers = Integer.parseInt(strs[0]);
		int[] x = new int[numRollers];
		int[] y = new int[numRollers]; 
		int[] radius = new int[numRollers];
		int tempX = 0;
		int tempY = 0;
		int tempRadius = 0;

		for(int i=0; i<numRollers; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");

			x[i] = Integer.parseInt(strs[0]);
			y[i] = Integer.parseInt(strs[1]);
			radius[i] = Integer.parseInt(strs[2]);
		}

		for(int i=0; i<numRollers; i++){
			if(x[i]==0 && y[i]==0){
				tempX = x[i];
				tempY = y[i];
				tempRadius = radius[i];
				x[i] = -100000;
				y[i] = -100000;
				radius[i] = -100000;
				break;
			}
		}

		double distance = 0;
		for(int a=0; a<numRollers; a++){
			for(int i=0; i<numRollers; i++){
				distance = Math.sqrt((x[i]-tempX)*(x[i]-tempX)+(y[i]-tempY)*(y[i]-tempY));
				if(distance == radius[i]+tempRadius){
					tempX = x[i];
					tempY = y[i];
					tempRadius = radius[i];
					x[i] = -100000;
					y[i] = -100000;
					radius[i] = -100000;
					i = 0;
				}
			}
		}
		System.out.println(tempX + " " + tempY);
	}

}