package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_23306_binary는_호남선_김태윤 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println("? 1");
		System.out.flush();
		int a = Integer.parseInt(br.readLine());
		
		System.out.println("? "+N);
		System.out.flush();
		int b = Integer.parseInt(br.readLine());
		
		if(a==1 && b == 0) {
			System.out.println("! -1");
			System.out.flush();
		}else if(a==0 && b == 1) {
			System.out.println("! 1");
			System.out.flush();
		}else {
			System.out.println("! 0");
			System.out.flush();
		}
		
	}

}
