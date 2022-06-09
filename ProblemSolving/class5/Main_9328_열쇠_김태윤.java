package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 18784kb
//시간 : 164ms

public class Main_9328_열쇠_김태윤 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			char[][] grid = new char[h][w];
			for (int i = 0; i < h; i++)
				grid[i] = br.readLine().toCharArray();

			char[] key_temp = br.readLine().toCharArray();
			boolean[] key = new boolean[26];
			if (key_temp[0] != '0') {
				for (int i = 0; i < key_temp.length; i++)
					key[(int) (key_temp[i] - 'a')] = true;
			}

			int cnt = 0;
			Queue<int[]> q = new ArrayDeque<int[]>(); // 대문자만 넣을 큐

			boolean[][] isChecked = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (grid[i][j] != '*' && !isChecked[i][j]) { // . 소문자 대문자
						Queue<int[]> queue = new ArrayDeque<int[]>();
						queue.offer(new int[] { i, j });
						isChecked[i][j] = true;
						while (!queue.isEmpty()) {
							int[] cur = queue.poll();

							if (grid[cur[0]][cur[1]] >= 'A' && grid[cur[0]][cur[1]] <= 'Z') {
								q.offer(new int[] { cur[0], cur[1] });
								isChecked[cur[0]][cur[1]] = true;
								continue;
							} else {
								if (grid[cur[0]][cur[1]] == '$') {
									cnt++;
								} else if (grid[cur[0]][cur[1]] >= 'a' && grid[cur[0]][cur[1]] <= 'z')
									key[(int) (grid[cur[0]][cur[1]] - 'a')] = true;
							}

							for (int k = 0; k < 4; k++) {
								int x = cur[0] + dx[k];
								int y = cur[1] + dy[k];

								if (x >= 0 && y >= 0 && x < h && y < w && !isChecked[x][y] && grid[x][y] != '*') {
									queue.offer(new int[] { x, y });
									isChecked[x][y] = true;
								}
							}
						}
					}

					if (i > 0 && i < h - 1)
						j += (w - 2);
				}
			}

			int qsize = q.size();
			while (true) {
				boolean isOpen = false;
				while (qsize-- > 0) {
					int[] lock = q.poll();
					if (key[(int) (grid[lock[0]][lock[1]] - 'A')]) { // 열쇠가 존재한다면

						isOpen = true;

						Queue<int[]> queue = new ArrayDeque<int[]>();
						queue.offer(new int[] { lock[0], lock[1] });
						while (!queue.isEmpty()) {
							int[] cur = queue.poll();
							for (int k = 0; k < 4; k++) {
								int x = cur[0] + dx[k];
								int y = cur[1] + dy[k];

								if (x >= 0 && y >= 0 && x < h && y < w && !isChecked[x][y] && grid[x][y] != '*') {
									if (grid[x][y] >= 'A' && grid[x][y] <= 'Z')
										q.offer(new int[] { x, y });
									else {
										if (grid[x][y] == '$')
											cnt++;
										else if (grid[x][y] >= 'a' && grid[x][y] <= 'z')
											key[(int) (grid[x][y] - 'a')] = true;
										isChecked[x][y] = true;
										queue.offer(new int[] { x, y });
									}
								}
							}
						}
					} else {
						q.offer(lock);
					}
				}

				if (!isOpen)
					break;
				qsize = q.size();
			}

			System.out.println(cnt);
		}
	}

}