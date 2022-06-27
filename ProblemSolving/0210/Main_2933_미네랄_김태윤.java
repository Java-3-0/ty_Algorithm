package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄_김태윤 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] grid;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		grid = new char[R][C];

		for (int i = 0; i < R; i++)
			grid[i] = br.readLine().toCharArray();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] stick = new int[N];
		for (int i = 0; i < N; i++)
			stick[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < C; j++) {
				int point = j;
				if (i % 2 == 1)
					point = C - j - 1;
				if (grid[R - stick[i]][point] == 'x') {
					grid[R - stick[i]][point] = '.';
					
					print();
					boolean[][] isChecked = new boolean[R][C];
					for (int k = 0; k < C; k++) {
						Queue<int[]> q = new ArrayDeque<int[]>();
						if (grid[R - 1][k] == 'x' && !isChecked[R - 1][k]) {
							isChecked[R - 1][k] = true;
							q.offer(new int[] { R - 1, k });

							while (!q.isEmpty()) {
								int[] cur = q.poll();

								for (int l = 0; l < 4; l++) {
									int x = cur[0] + dx[l];
									int y = cur[1] + dy[l];
									
									if (x >= 0 && y >= 0 && x < R && y < C && grid[x][y] == 'x' && !isChecked[x][y]) {
										isChecked[x][y] = true;
										q.offer(new int[] { x, y });
									}
								}
							}
						}
					}
					doGravity(isChecked);
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb);

	}
	
	static void print() {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	static void doGravity(boolean[][] isChecked) {
		
	}

}
