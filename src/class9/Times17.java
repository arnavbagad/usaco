package class9;

import java.io.*;

public class Times17 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("./src/class9/times17.in"));
		String lines = br.readLine(); 
		String[] strs = lines.trim().split("\\s+");
		String s = strs[0];
		String updated = strs[0];

		updated = s + "0000";
		System.out.println(binaryAddition(updated, s));
	}
	
	public static String binaryAddition(String s1, String s2) {

		int first = s1.length() - 1;
		int second = s2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (first >= 0 || second >= 0) {
			int sum = carry;
			if (first >= 0) {
				sum += s1.charAt(first) - '0';
				first--;
			}
			if (second >= 0) {
				sum += s2.charAt(second) - '0';
				second--;
			}
			carry = sum >> 1;
			sum = sum & 1;
			sb.append(sum == 0 ? '0' : '1');
		}
		if (carry > 0)
			sb.append('1');

		sb.reverse();
		return String.valueOf(sb);
	}	
}