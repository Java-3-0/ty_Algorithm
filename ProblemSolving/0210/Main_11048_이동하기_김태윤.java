package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기_김태윤 {
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][M];
		dp[0][0] = arr[0][0];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 3; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];

					if (tx < 0 || ty < 0 || tx >= N || ty >= M)
						continue;

					dp[tx][ty] = Math.max(dp[tx][ty], dp[i][j] + arr[tx][ty]);
				}

//				System.out.print(dp[i][j] + " ");
			}
//			System.out.println();
		}

		System.out.println(dp[N - 1][M - 1]);

	}

}
