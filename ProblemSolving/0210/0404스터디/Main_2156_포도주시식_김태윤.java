package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (N == 1)
			System.out.println(arr[0]);
		else {
			int[][] dp = new int[N][4];

			dp[0][0] = arr[0];

			dp[1][0] = arr[0] + arr[1];
			dp[1][1] = arr[0];
			dp[1][2] = arr[1];
			
			for(int i = 2; i<N; i++) {
				dp[i][0] = dp[i-1][2] + arr[i];
				
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]);
				
				dp[i][2] = Math.max(dp[i-1][1], dp[i-1][3]) + arr[i];
				
				dp[i][3] = Math.max(dp[i-1][1], dp[i-1][3]);
			}
			
			System.out.println(Math.max(Math.max(dp[N-1][0], dp[N-1][1]), Math.max(dp[N-1][2], dp[N-1][3])));
		}
	}

}