package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066_파일_합치기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());

			int[][] dp = new int[K + 1][K + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				dp[i][i] = Integer.parseInt(st.nextToken());
			}

			int[] sum = new int[K+1];
			
			sum[1] = dp[1][1];
			for(int i = 2; i<=K; i++) {
				sum[i] = sum[i-1] + dp[i][i];
			}
			
			
			// 1칸씩, 2칸씩,, -> 1부터 시작, 2부터 시작 -> 가르기는 12 면 1<=k<2

			for (int i = 1; i < K; i++) { // 사이 간격, [1][2] 이면 1
				for (int j = 1; j <= K - i; j++) { // 시작점, [3(j)][4] 가 마지막이도록
					for (int k = j; k < i + j; k++) { //중간지
						System.out.println(i+" "+j+" "+k+"///"+"["+j+","+(j+i)+"]");
						if (dp[j][j + i] == 0)
							dp[j][j + i] = dp[j][k] + dp[k + 1][j + i];
						dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
					}
					if(i==1)
						continue;
					System.out.println(dp[j][j+i]);
					dp[j][j+i] += (sum[j+i] - sum[j-1]);
					System.out.println(dp[j][j+i]);
					System.out.println();
				}
			}
			
			System.out.println(dp[1][K]);
		}

	}

}
