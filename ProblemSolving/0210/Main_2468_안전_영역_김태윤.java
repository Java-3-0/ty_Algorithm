package algo_ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 54108kb
//시간 : 332ms

public class Main_2468_안전_영역_김태윤 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		int maxval = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(str.nextToken());
				if(board[i][j] > maxval)
					maxval = board[i][j];
			}
		}
		
		// 잠긴부분=true, 안잠긴부분=false
		boolean[][] isChecked = new boolean[N][N];
		
		int answer = -1;
		for(int i = maxval-1; i>=0; i--) {
			int cnt = 0;
			
			for(int j = 0; j<N; j++)
				Arrays.fill(isChecked[j], false);
			
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(board[j][k] <= i)
						isChecked[j][k] = true;
				}
			}
			
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(!isChecked[j][k]) {
						bfs(board, isChecked, j, k);
						cnt++;
					}
				}
			}
			
			if(answer < cnt)
				answer = cnt;
		}
		System.out.println(answer);
	}
	
	public static void bfs(int[][] board, boolean[][] isChecked, int x, int y) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {x,y});
		isChecked[x][y] = true;
		
		while(!q.isEmpty()) {
			int tx = q.peek()[0];
			int ty = q.peek()[1];
			q.poll();
			for(int i = 0; i<4; i++) {
				int new_x = tx+dx[i];
				int new_y = ty+dy[i];
				
				if(new_x < 0 || new_y < 0 || new_x >= N || new_y >= N)
					continue;
				
				if(isChecked[new_x][new_y])
					continue;
				
				isChecked[new_x][new_y] = true;
				q.offer(new int[] {new_x,new_y});
			}
		}
	}

}
