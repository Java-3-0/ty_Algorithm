package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 12740kb
//시간 : 100ms

public class Main_14890_경사로_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;

		// 가로획부터 계산
		for (int i = 0; i < N; i++) {
			int j = 1; // j가 반복문을 정상적으로 모두 훑으면 모든 칸이 안전하단거니까 answer++할거임
			boolean[] isRamp = new boolean[N];
      LOOP: for (; j < N; j++) {
				if (board[i][j] - board[i][j - 1] == 1) { // 1칸 오르막 이라면
					if (j - L < 0) // 왼쪽으로 놓을 자리가 없다면(앞에 L칸 검사할거니까)
						break LOOP;
					for (int k = j - L; k < j; k++) {
						if (board[i][k] != board[i][j] - 1 || isRamp[k])
							break LOOP;
					}
					for (int k = j - L; k < j; k++)
						isRamp[k] = true;
				} else if (board[i][j] - board[i][j - 1] == -1) { // 1칸 내리막 이라면
					if (j + L > N) // 오른쪽으로 놓을 자리가 없다면(뒤에 L칸 검사할거니까)
						break LOOP;
					for (int k = j; k < j + L; k++) {
						if (board[i][k] != board[i][j - 1] - 1 || isRamp[k])
							break LOOP;
					}
					for (int k = j; k < j + L; k++)
						isRamp[k] = true;
				} else if (board[i][j] != board[i][j - 1]) { // 2칸 이상 차이나면
					break;
				}
			}

			if (j == N)
				answer++;
		}

		// 세로획 계산
		for (int i = 0; i < N; i++) {
			int j = 1; // j가 반복문을 정상적으로 모두 훑으면 모든 칸이 안전하단거니까 answer++할거임
			boolean[] isRamp = new boolean[N];
      LOOP: for (; j < N; j++) {
				if (board[j][i] - board[j-1][i] == 1) { // 1칸 오르막 이라면
					if (j - L < 0) // 왼쪽으로 놓을 자리가 없다면(앞에 L칸 검사할거니까)
						break LOOP;
					for (int k = j - L; k < j; k++) {
						if (board[k][i] != board[j][i] - 1 || isRamp[k])
							break LOOP;
					}
					for (int k = j - L; k < j; k++)
						isRamp[k] = true;
				} else if (board[j][i] - board[j-1][i] == -1) { // 1칸 내리막 이라면
					if (j + L > N) // 오른쪽으로 놓을 자리가 없다면(뒤에 L칸 검사할거니까)
						break LOOP;
					for (int k = j; k < j + L; k++) {
						if (board[k][i] != board[j-1][i] - 1 || isRamp[k])
							break LOOP;
					}
					for (int k = j; k < j + L; k++)
						isRamp[k] = true;
				} else if (board[j][i] != board[j-1][i]) { // 2칸 이상 차이나면
					break;
				}
			}

			if (j == N)
				answer++;
		}
		
		System.out.println(answer);
	}

}
