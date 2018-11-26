package class2;

import java.io.*;

public class Transform {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/Arnav/git/JrJava/Arnav/src/class2/transform.in"));
		String value = br.readLine(); 	
		String[] strs = value.trim().split("\\s+");
		int sideLength = Integer.parseInt(strs[0]);
		int[][] original = new int[sideLength][sideLength];
		int[][] result = new int[sideLength][sideLength];

		for(int i=0; i<sideLength; i++){
			for(int j=0; j<sideLength; j++){
				original[i][j] = br.read();
			}
			br.skip(1);
		}
		for(int i=0; i<sideLength; i++){
			for(int j=0; j<sideLength; j++){
				result[i][j] = br.read();
			}
			br.skip(1);
		}	

		if(compare(rotation(original, sideLength), result, sideLength)){
			System.out.println("1");
		}
		else if(compare(rotation2(original, sideLength), result, sideLength)){
			System.out.println("2");
		}
		else if(compare(rotation3(original, sideLength), result, sideLength)){
			System.out.println("3");
		}
		else if(compare(reflection(original, sideLength), result, sideLength)){
			System.out.println("4");
		}
		else if(compare(rotation(reflection(original, sideLength), sideLength), result, sideLength)){
			System.out.println("5");
		}
		else if(compare(rotation2(reflection(original, sideLength), sideLength), result, sideLength)){
			System.out.println("5");
		}
		else if(compare(rotation3(reflection(original, sideLength), sideLength), result, sideLength)){
			System.out.println("5");
		}
		else if(compare(original, result, sideLength)){
			System.out.println("6");
		}
		else{
			System.out.println("7");
		}
	}

	public static int[][] rotation(int[][] original, int n){
		int[][] temp = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				temp[j][n-i-1] = original[i][j];
			}	
		}
		return temp;
	}

	public static int[][] rotation2(int[][] original, int n){
		original = rotation(original, n);
		original = rotation(original, n);
		return original;
	}

	public static int[][] rotation3(int[][] original, int n){
		original = rotation(original, n);
		original = rotation(original, n);
		original = rotation(original, n);
		return original;
	}

	public static int[][] reflection(int[][] original, int n){
		int[][] temp = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				temp[i][j] = original[i][n-j-1];
			}	
		}
		return temp;
	}

	public static boolean compare(int[][] original, int[][] result, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(original[i][j] != result[i][j]){
					return false;
				}
			}	
		}
		return true;
	}

}
