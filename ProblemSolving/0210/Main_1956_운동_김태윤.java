package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 101900kb
//시간 : 3272ms

public class Main_1956_운동_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int arr[][] = new int[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < V + 1; i++) {
			Queue<int[]> q = new ArrayDeque<int[]>();

			q.offer(new int[] { i, 0 });
			int[] isChecked = new int[V + 1];

			while (!q.isEmpty()) {
				int[] temp = q.poll();

				for (int j = 1; j < V + 1; j++) {

					if (arr[temp[0]][j] != 0 && i == j) {
						answer = Math.min(answer, (temp[1] + arr[temp[0]][j]) );
						continue;
					}
					
					if (arr[temp[0]][j] != 0 && (isChecked[j]==0 || isChecked[j] > temp[1] + arr[temp[0]][j])) {
						isChecked[j] = temp[1] + arr[temp[0]][j];
						q.offer(new int[] { j, temp[1] + arr[temp[0]][j] });
					}
				}
			}
		}
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

}
