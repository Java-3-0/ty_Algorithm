package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와_최소공배수_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int a = Math.max(A, B);
		int b = Math.min(A, B);
		
		while(a%b != 0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		
		System.out.println(b+"\n"+A*B/b);
	}

}
