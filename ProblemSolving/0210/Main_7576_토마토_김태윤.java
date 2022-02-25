package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 128600kb
//시간 : 612ms

public class Main_7576_토마토_김태윤 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(M,N,arr));
		
	}
	
	static int bfs(int M, int N, int[][] arr) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] isChecked = new boolean[M][N];
		
		int cnt = 0;
		
		for(int i = 0; i<M; i++) {
			for(int j= 0; j<N; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i,j,0});
					isChecked[i][j] = true;
				}else if(arr[i][j] == -1) {
					isChecked[i][j] = true;
					cnt++;
				}
			}
		}
		
		
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int num = q.peek()[2];
			q.poll();
			cnt++;
			
			
			if(cnt == M*N)
				return num;
			
			for(int i = 0; i<4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				
				if(tx<0 || ty<0 || tx>=M || ty>=N)
					continue;
				
				if(isChecked[tx][ty])
					continue;
				
				isChecked[tx][ty] = true;
				q.offer(new int[] {tx,ty,num+1});
			}
		}
		
		
		return -1;
	}

}
