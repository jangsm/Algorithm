package ps.bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		String str = input.readLine();
		str = str.replaceAll("c=", "1");
		str = str.replaceAll("c-", "1");
		str = str.replaceAll("dz=", "1");
		str = str.replaceAll("d-", "1");
		str = str.replaceAll("lj", "1");
		str = str.replaceAll("nj", "1");
		str = str.replaceAll("s=", "1");
		str = str.replaceAll("z=", "1");
		
		System.out.println(str.length());
	}

}
