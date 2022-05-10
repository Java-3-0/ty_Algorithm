package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프_옮기기_1_김태윤 {

	//메모리 : 11744kb
	//시간 : 76ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		boolean[][] isWall = new boolean[N][N];
		int[][][] arr = new int[N][N][3]; // 가로, 세로, 대각선
		arr[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					isWall[i][j] = true;
			}
		}

		// 첫 번째 행만 따로 계산
		for (int i = 2; i < N; i++) {
			if (isWall[0][i])
				break;
			arr[0][i][0] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {

				if (isWall[i][j])
					continue;

				// 가로 계산
				if (!isWall[i][j - 1]) {
					arr[i][j][0] += arr[i][j - 1][0] + arr[i][j - 1][2];
				}

				// 세로 계산
				if (!isWall[i - 1][j]) {
					arr[i][j][1] += arr[i - 1][j][1] + arr[i - 1][j][2];
				}

				// 대각선 계산
				if (!isWall[i][j - 1] && !isWall[i - 1][j] && !isWall[i - 1][j - 1]) {
					arr[i][j][2] += arr[i - 1][j - 1][0] + arr[i - 1][j - 1][1] + arr[i - 1][j - 1][2];
				}
			}
		}
		
		System.out.println(arr[N - 1][N - 1][0] + arr[N - 1][N - 1][1] + arr[N - 1][N - 1][2]);

	}

}
