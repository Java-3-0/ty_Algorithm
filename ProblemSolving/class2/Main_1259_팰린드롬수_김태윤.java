package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1259_팰린드롬수_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		loop:while(true) {
			String s = br.readLine();
			if(s.equals("0"))
				break;
			
			for(int i = 0; i<s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length()-(i+1))){
					System.out.println("no");
					continue loop;
				}
			}
			System.out.println("yes");
		}
	}

}
