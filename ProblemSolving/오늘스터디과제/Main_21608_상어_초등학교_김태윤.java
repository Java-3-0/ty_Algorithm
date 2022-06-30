package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 : 26052kb
//시간 : 316ms
public class Main_21608_상어_초등학교_김태윤 {
	static int N;
	static int[][] grid;
	static int[][] seat;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] pow = { 0, 1, 10, 100, 1000 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		grid = new int[N * N][5];
		seat = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}

			/**
			 * 모든 seat 좌표를 돌되, 1~4를 검사하며, 그 값이면 4방에 점수 부여 이미 자리에 사람 있으면 점수 부여X
			 * 
			 * 모든 seat 돌며 점수 pq에 넣고, 가장 높은 점수 그룹만 뽑기
			 * 
			 * 그룹 인원이 한명이면 거기에 박고, 아니면 가장 왼쪽, 가장 위에 박음
			 */

			scoring(i);
		}

		int answer = 0;

		boolean[][] isBF = new boolean[N * N + 1][N * N + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];

					if (x >= 0 && y >= 0 && x < N && y < N) {
						isBF[seat[i][j]][seat[x][y]] = true;
					}
				}
			}
		}

		for (int i = 0; i < N * N; i++) {
			int cnt = 0;
			for (int j = 1; j < 5; j++) {
				if (isBF[grid[i][0]][grid[i][j]])
					cnt++;
			}
			answer += pow[cnt];
		}
		
		System.out.println(answer);
	}

	static void scoring(int num) {
		int[][] scoreboard = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 1; k < 5; k++) {
					if (seat[i][j] == grid[num][k]) {
						for (int l = 0; l < 4; l++) {
							int x = i + dx[l];
							int y = j + dy[l];

							if (x >= 0 && y >= 0 && x < N && y < N) {
								scoreboard[x][y]++;
							}
						}
						break;
					}
				}
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				if (o1[3] == o2[3]) {
					if (o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o2[3] - o1[3];
			}
			return o2[0] - o1[0];
		});

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (seat[i][j] > 0)
					continue;

				int blank = 0;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];

					if (x >= 0 && y >= 0 && x < N && y < N && seat[x][y] == 0) {
						blank++;
					}
				}

				pq.offer(new int[] { scoreboard[i][j], i, j, blank });
			}
		}

		int[] point = pq.poll();
		seat[point[1]][point[2]] = grid[num][0];
	}

}
