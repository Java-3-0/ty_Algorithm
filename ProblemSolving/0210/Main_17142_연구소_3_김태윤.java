package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 41484kb
//시간 : 220ms

public class Main_17142_연구소_3_김태윤 {

	static int[][] board;
	static int[][] board_copy;
	static LinkedList<int[]> virus;
	static boolean[] isChecked;

	static int N, M;
	static int capable_place = 0; // 0 인 칸
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		board_copy = new int[N][N];
		
		virus = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					virus.add(new int[] { i, j });
				
				if(board[i][j] == 0)
					capable_place++;
			}
		}

		isChecked = new boolean[virus.size()];
		dfs(0, 0);

		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		System.out.println(answer);
	}

	static void dfs(int idx, int cnt) {
		if (cnt == M) {
			bfs();
			return;
		}

		for (int i = idx; i < virus.size(); i++) {
			isChecked[i] = true;
			dfs(i + 1, cnt + 1);
			isChecked[i] = false;
		}
	}

	static void bfs() {
		for(int i = 0; i<N; i++) {
			board_copy[i] = board[i].clone();
		}
		
		Queue<int[]> q = new LinkedList<int[]>();

		int cnt = 0;
		
		for (int i = 0; i < isChecked.length; i++) {
			if (isChecked[i]) {
				int[] temp = virus.get(i);
				q.offer(temp);
				board_copy[temp[0]][temp[1]] = -1;
			}
		}
		
		int stage = 0;
		while (!q.isEmpty() && cnt<capable_place) {
			stage++;
			int q_size = q.size();

			while (q_size-- > 0) {
				int[] val = q.poll();
				for (int i = 0; i < 4; i++) {
					int x = val[0] + dx[i];
					int y = val[1] + dy[i];

					if (x < 0 || y < 0 || x >= N || y >= N)
						continue;

					if (board_copy[x][y] == 1 || board_copy[x][y] == -1) // 벽이거나 이미 바이러스가 있다면
						continue;

					if(board_copy[x][y] == 0)
						cnt++;
					board_copy[x][y] = -1;
					q.offer(new int[] {x,y});
				}
			}
		}
		
		if(cnt < capable_place)
			return;
		
		answer = Math.min(answer, stage);
	}

}
