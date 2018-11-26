package class10;

import java.io.*;

public class Mirror {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/Documents/JrJavaMacNeon/eclipseWS/USACO/src/class10/mirror.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		int row = Integer.parseInt(strs[0]);
		int col = Integer.parseInt(strs[1]);
		String[] mirrorWrong = new String[row];
		char[][] mirrors = new char[row][col];

		for(int i=0; i<row; i++){
			lines = br.readLine(); 
			strs = lines.trim().split("\\s+");
			mirrorWrong[i] = strs[0];
		}
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				mirrors[i][j] = mirrorWrong[i].charAt(j);
			}
		}
		
		int maxLength = 0;
		int length = 0;
		for(int i=0; i<row; i++){
			length = travel(mirrors, i, row, col-1, col, "left");
			if(maxLength<length) maxLength = length;
			length = travel(mirrors, i, row, 0, col, "right");
			if(maxLength<length) maxLength = length;
		}
		for(int i=0; i<col; i++){
			length = travel(mirrors, 0, row, i, col, "down");
			if(maxLength<length) maxLength = length;
			length = travel(mirrors, row-1, row, i, col, "up");
			if(maxLength<length) maxLength = length;
		}
		System.out.println(maxLength);
	}
	
	public static int travel(char[][] mirrors, int row, int rowMax, int col, int colMax, String direction){
		int counter = 0;
		while(row>=0 && row<rowMax && col>=0 && col<colMax){
			if(mirrors[row][col]=='/'){
				counter++;
				if(direction == "left") {
					direction = "down";
					row++;
				}
				else if(direction == "right") {
					direction = "up";
					row--;
				}
				else if(direction == "up") {
					direction = "right";
					col++;
				}
				else if(direction == "down") {
					direction = "left";
					col--;
				}
			}
			else{
				counter++;
				if(direction == "left") {
					direction = "up";
					row--;
				}
				else if(direction == "right") {
					direction = "down";
					row++;
				}
				else if(direction == "up") {
					direction = "left";
					col--;
				}
				else if(direction == "down") {
					direction = "right";
					col++;
				}
			}
		}
		return counter;
	}
	
}