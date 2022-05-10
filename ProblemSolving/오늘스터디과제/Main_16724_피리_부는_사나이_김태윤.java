package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 95508kb
//시간 : 448ms

public class Main_16724_피리_부는_사나이_김태윤 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		/*
		 * 상 0 하 1 좌 2 우 3
		 */
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				switch (s[j]) {
				case 'U':
					arr[i][j] = 0;
					break;
				case 'D':
					arr[i][j] = 1;
					break;
				case 'L':
					arr[i][j] = 2;
					break;
				case 'R':
					arr[i][j] = 3;
					break;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				
				if (arr[i][j] != -1) {
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] { i, j, arr[i][j] });
					arr[i][j] = -1;
					answer++;
					while (!q.isEmpty()) {
						int[] temp = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];

							if (x < 0 || y < 0 || x >= N || y >= M)
								continue;
							if (arr[x][y] == -1)
								continue;
							if (k == temp[2]) {
								q.offer(new int[] { x, y, arr[x][y] });
								arr[x][y] = -1;
							} else {
								if(temp[0] == x+dx[arr[x][y]] && temp[1] == y+dy[arr[x][y]]) {
									q.offer(new int[] {x,y,arr[x][y] });
									arr[x][y] = -1;
								}
							}
						}
					}
				}
				
				
			}
		}
		
		System.out.println(answer);

	}

}
