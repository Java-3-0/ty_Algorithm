package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 22620kb
//시간 : 224ms

public class Main_1806_부분합_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;

		int prev = 0;

		int sum = 0;
		for (int next = 0; next < N; next++) {
			sum += arr[next];
			
			if (sum < S)
				continue;
			
//			System.out.println(prev+" "+next);
			while (prev < next && sum - arr[prev] >= S) {
				sum -= arr[prev++];
			}
//			System.out.println(prev+" "+next);
			answer = Math.min(answer, next - prev + 1);
		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

}
