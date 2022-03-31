package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 시간초과
public class Main_16235_나무_재테크_김태윤 {

	static int N, M, K; // N*N 보드 판을 만들거고, M개 나무가 입력으로 주어질거고, K년을 셀 거임
	static int[][] A; // 로봇 S2D2가 겨울에 추가할 양분
	static int[][] board; // 현재 판에 남은 양분 양
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Tree implements Comparable<Tree> { // 나무 클래스
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayList<Tree> tree = new ArrayList();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}

		Collections.sort(tree);

		board = new int[N][N];
		for (int i = 0; i < N; i++) // 모든 칸은 5로 시작한다
			Arrays.fill(board[i], 5);

		while (K-- > 0) {
			int size = tree.size();
			
			
			// 봄
			for (int i = 0; i < size; i++) {
				Tree t = tree.get(i);
				if (board[t.x][t.y] >= t.age) {
					board[t.x][t.y] -= t.age;
					tree.get(i).age++;
				} else {
					tree.get(i).age = (t.age / 2) * -1;
				}
			}
			
			
			// 여름 && 가을
			for (int i = 0; i < size; i++) {
				Tree t = tree.get(i);
				if (t.age <= 0) {
					board[t.x][t.y] += t.age * -1;
				} else if (t.age % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						int tx = t.x + dx[j];
						int ty = t.y + dy[j];

						if (tx < 0 || ty < 0 || tx >= N || ty >= N)
							continue;

						tree.add(new Tree(tx, ty, 1));
					}
				}
			}
			
			for(int i = 0; i<tree.size(); i++) {
				if(tree.get(i).age <= 0) {
					tree.remove(i);
					i--;
				}
			}
			
			Collections.sort(tree);
			
			
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] += A[i][j];
				}
			}

		}
		
		System.out.println(tree.size());
	}

}
