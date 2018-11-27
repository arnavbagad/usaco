package class3;

import java.io.*;
public class Crosswords {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class3/crosswords.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
	}
}
