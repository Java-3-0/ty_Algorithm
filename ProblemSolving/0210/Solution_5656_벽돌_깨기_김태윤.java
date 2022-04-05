package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 87532kb
//시간 : 954ms

public class Solution_5656_벽돌_깨기_김태윤 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, W, H;
	static int[][] board;
	static int[][] copyboard;
	static int[] cases;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			board = new int[H][W];
			copyboard = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cases = new int[N];

			dfs(0);

			System.out.println("#" + t + " " + answer);
		}
	}

	static void dfs(int idx) {
		if (idx == N) {
				calc();
			
			return;
		}

		for (int i = 0; i < W; i++) {
			cases[idx] = i;
			dfs(idx + 1);
		}
	}

	static void calc() {

		/**
		 * 1. board 복사 2. cases 하나씩 계산 2-1. cases에서 1 이상의 값이 나오면 queue에 넣는다. 3. 배열 당기기
		 * 
		 * 4. 모든 계산이 끝난 이후 남은 벽돌 세기
		 */

		for (int i = 0; i < H; i++)
			copyboard[i] = Arrays.copyOf(board[i], W);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <H; j++) {
				if (copyboard[j][cases[i]] != 0) {
					if (copyboard[j][cases[i]] == 1)
						copyboard[j][cases[i]] = 0;
					else {

						Queue<int[]> q = new LinkedList<int[]>();

						q.offer(new int[] { j, cases[i], copyboard[j][cases[i]] });
						copyboard[j][cases[i]] = 0;

						while (!q.isEmpty()) {
							int[] explode = q.poll();

							
							for (int k = 0; k < 4; k++) {
								int cnt = 1;
								while (true) {
									int tx = explode[0] + dx[k] * cnt;
									int ty = explode[1] + dy[k] * cnt;
									
									cnt++;

									if (tx < 0 || ty < 0 || tx >= H || ty >= W)
										break;

									if (copyboard[tx][ty] == 1)
										copyboard[tx][ty] = 0;

									if (copyboard[tx][ty] > 1) {
										q.offer(new int[] { tx, ty, copyboard[tx][ty] });
										copyboard[tx][ty] = 0;
									}
									
									if (cnt == explode[2])
										break;
								}
							}
						}
						// 배열 당기기
						poolArray(copyboard);
					}
					break;
				}
			}
			
		}

		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyboard[i][j] != 0)
					cnt++;
			}
		}

		answer = Math.min(answer, cnt);
	}

	static void poolArray(int[][] copyboard) {

		for (int j = 0; j < W; j++) {
			int idx = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (copyboard[i][j] != 0) {
					copyboard[idx][j] = copyboard[i][j];
					if (idx-- != i)
						copyboard[i][j] = 0;
				}
			}
		}
	}

}
