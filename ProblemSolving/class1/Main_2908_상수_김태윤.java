package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908_상수_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(new StringBuffer(st.nextToken())
				.reverse().toString());
		int b = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());
		
		if(a>b) System.out.println(a);
		else System.out.println(b);
	}

}
