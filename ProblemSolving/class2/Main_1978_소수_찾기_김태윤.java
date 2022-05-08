package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수_찾기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		boolean isNotPrime[] = new boolean[1001];
		
		isNotPrime[0] = isNotPrime[1] = true;
		
		for(int i = 2; i<Math.sqrt(1000); i++) {
			if(!isNotPrime[i]) {
				for(int j = 2; i*j<=1000; j++) {
					isNotPrime[i*j] = true;
				}
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(!isNotPrime[Integer.parseInt(st.nextToken())]) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
