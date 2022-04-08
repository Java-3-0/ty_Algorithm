package algo_ex;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2747_피보나치_수_김태윤 {

	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp = new long[N + 1];

		Arrays.fill(dp, -1l);

		dp[0] = 0;
		dp[1] = 1;

		System.out.println(fibonacci(N));
	}

	static long fibonacci(int N) {
		if (N <= 1)
			return N;
		
		if (dp[N] == -1) {
			dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
		}
			return dp[N];
	}
}
