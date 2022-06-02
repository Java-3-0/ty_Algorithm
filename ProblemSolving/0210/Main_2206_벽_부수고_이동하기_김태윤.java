package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 90524kb
//시간 : 528ms

public class Main_2206_벽_부수고_이동하기_김태윤 {

	static int N, M;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		// 벽뿌전 갔는지 체크
		boolean[][] before = new boolean[N][M];
		// 벽뿌후 갔는지 체크
		boolean[][] after = new boolean[N][M];

		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { 0, 0, 0, 1 }); // i,j,벽뿌,거리
		before[0][0] = true;

		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] val = q.poll();

			if (val[0] == N - 1 && val[1] == M - 1) {
				answer = Math.min(answer, val[3]);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int x = val[0] + dx[i];
				int y = val[1] + dy[i];

				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (val[2] == 1 && !after[x][y] && !before[x][y] && grid[x][y] == 0) {
						after[x][y] = true;
						q.offer(new int[] { x, y, val[2], val[3] + 1 });
					} else if (val[2] == 0) {
						if (grid[x][y] == 1) {
							after[x][y] = true;
							q.offer(new int[] { x, y, val[2] + 1, val[3] + 1 });
						} else if (grid[x][y] == 0 && !before[x][y]) {
							before[x][y] = true;
							q.offer(new int[] { x, y, val[2], val[3] + 1 });
						}
					}
				}
			}

		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

}
