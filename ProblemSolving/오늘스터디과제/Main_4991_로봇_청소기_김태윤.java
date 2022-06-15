package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 24736kb
//시간 : 728ms

public class Main_4991_로봇_청소기_김태윤 {
	static int count;
	static char[][] grid;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	
	static int arr_size;
	static int answer = Integer.MAX_VALUE;
	static int[][] closest;
	static int robot_idx = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		StringBuffer sb = new StringBuffer();

		while (true) {
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			grid = new char[h][w];

			ArrayList<int[]> arr = new ArrayList<int[]>(); // 먼지 + 청소기 좌표

			for (int i = 0; i < h; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					grid[i][j] = temp[j];
					if (temp[j] == 'o' || temp[j] == '*') {
						arr.add(new int[] { i, j });
						if (temp[j] == 'o')
							robot_idx = arr.size() - 1;
					}
				}
			}

			arr_size = arr.size();
			closest = new int[arr_size][arr_size];

			boolean isNoPath = false;
			
			BREAK_IF_PATH_DOESNT_EXIST:
			for (int i = 0; i < arr_size; i++) {
				for (int j = i + 1; j < arr_size; j++) {

					Queue<int[]> q = new ArrayDeque<int[]>();

					int[] src = arr.get(i);
					q.offer(new int[] { src[0], src[1], 0 });

					int[] dest = arr.get(j);

					boolean isChecked[][] = new boolean[h][w];
					isChecked[src[0]][src[1]] = true;

					LOOP:
					while (!q.isEmpty()) {
						int[] temp = q.poll();

						for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];

							while (x >= 0 && y >= 0 && x < h && y < w && !isChecked[x][y] && grid[x][y] != 'x') {
								q.offer(new int[] { x, y, temp[2] + 1 });
								if (x == dest[0] && y == dest[1]) {
									closest[i][j] = temp[2] + 1;
									closest[j][i] = temp[2] + 1;
									break LOOP;
								}
								isChecked[x][y] = true;
							}
						}
					}

					if (closest[i][j] == 0) {
						isNoPath = true;
						break BREAK_IF_PATH_DOESNT_EXIST;
					}
				}
			}

			if (isNoPath) {
				sb.append("-1\n");
			} else {
				
				boolean[] isChecked = new boolean[arr_size];
				isChecked[robot_idx] = true;
				
				int[] order = new int[arr_size-1];
				permutation(0, isChecked, order);
				
				sb.append(answer + "\n");
			}

		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	static void permutation(int cnt, boolean[] isChecked, int[] order) {
		if(cnt == arr_size-1) {
			int my_answer = 0;
			
			my_answer += closest[robot_idx][order[0]];
			
			for(int i = 1; i<order.length; i++) {
				my_answer += closest[order[i-1]][order[i]];
			}
			
			answer = Math.min(answer, my_answer);
			return;
		}
		
		for(int i = 0; i<arr_size; i++) {
			if(!isChecked[i]) {
				isChecked[i] = true;
				order[cnt] = i;
				permutation(cnt+1, isChecked, order);
				isChecked[i] = false;
			}
		}
	}

}
