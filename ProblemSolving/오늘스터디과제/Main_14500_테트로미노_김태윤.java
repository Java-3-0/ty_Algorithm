package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 31408kb
//시간 : 352ms

public class Main_14500_테트로미노_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int sum = 0;

		for (int i = 0; i <= N - 1; i++) {
			for (int j = 0; j <= M - 4; j++) {
				sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i][j + 3];
				answer = Math.max(sum, answer);
			}
		}

		for (int i = 0; i <= N - 4; i++) {
			for (int j = 0; j <= M - 1; j++) {
				sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 3][j];
				answer = Math.max(sum, answer);
			}
		}

		for (int i = 0; i <= N - 2; i++) {
			for (int j = 0; j <= M - 2; j++) {
				sum = grid[i][j] + grid[i + 1][j] + grid[i][j + 1] + grid[i + 1][j + 1];
				answer = Math.max(sum, answer);
			}
		}

		int multi_2_3;
		for (int i = 0; i <= N - 2; i++) {
			for (int j = 0; j <= M - 3; j++) {
				multi_2_3 = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
				
				sum  = multi_2_3 - (grid[i][j] + grid[i][j+1]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j+1] + grid[i][j+2]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+1][j] + grid[i+1][j+1]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+1][j+1] + grid[i+1][j+2]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j] + grid[i+1][j+2]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j+2] + grid[i+1][j]);
				answer = Math.max(sum, answer);
				
				sum  = multi_2_3 - (grid[i][j] + grid[i][j+2]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+1][j] + grid[i+1][j+2]);
				answer = Math.max(sum, answer);
			}
		}

		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 2; j++) {
				multi_2_3 = grid[i][j] + grid[i][j+1] +grid[i+1][j] + grid[i+1][j+1] +grid[i+2][j] + grid[i+2][j+1];
				
				sum  = multi_2_3 - (grid[i][j] + grid[i+1][j]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+1][j] + grid[i+2][j]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j+1] + grid[i+1][j+1]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+1][j+1] + grid[i+2][j+1]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j] + grid[i+2][j+1]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i+2][j] + grid[i][j+1]);
				answer = Math.max(sum, answer);
				
				sum  = multi_2_3 - (grid[i][j] + grid[i+2][j]);
				answer = Math.max(sum, answer);
				

				sum  = multi_2_3 - (grid[i][j+1] + grid[i+2][j+1]);
				answer = Math.max(sum, answer);
			}
		}
		
		System.out.println(answer);

	}

}
