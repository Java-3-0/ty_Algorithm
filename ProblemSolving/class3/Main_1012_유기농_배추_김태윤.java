package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농_배추_김태윤 {

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());

			int M, N, K;
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			boolean grid[][] = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				grid[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			
			int count = 0;
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					if(grid[i][j]) {
						count++;
						grid[i][j] = false;
						Queue<int[]> q = new ArrayDeque<int[]>();
						q.add(new int[] {i,j});
						
						while(!q.isEmpty()) {
							int[] temp = q.poll();
							for(int k = 0; k<4; k++) {
								int x = temp[0] + dx[k];
								int y = temp[1] + dy[k];
								
								if(x>=0 && y>=0 && x<M && y<N &&grid[x][y]) {
									grid[x][y] = false;
									q.add(new int[] {x,y});
								}
							}
						}
						
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
