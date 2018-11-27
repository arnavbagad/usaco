package training;

import java.io.*;
import java.util.*;

/*
ID:arnav.b2
LANG: JAVA
TASK: test
*/

public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("./src/training/test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		out.println(x+y);
		out.close();
	}

}
