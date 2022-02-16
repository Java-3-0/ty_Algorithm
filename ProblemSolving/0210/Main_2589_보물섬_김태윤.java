package algo_ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 292856kb (292mb) / 제한 512mb
//시간 : 520ms

public class Main_2589_보물섬_김태윤 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		//true면 땅, false면 바다
		boolean[][] map = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();	
			for(int j= 0; j<M; j++) {
				if(s.charAt(j) == 'L')
					map[i][j] = true;
			}
		}
		
		int answer = -1;
		for(int i = 0; i<N; i++) {
			for(int j =0; j<M; j++) {
				if(map[i][j]) {
					Queue<int[]> q = new LinkedList<int[]>();
					boolean[][] isChecked = new boolean[N][M];
					
					q.offer(new int[] {i,j,0});
					isChecked[i][j] = true;
					
					while(!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.peek()[1];
						int cnt = q.peek()[2];
						q.poll();
						
						if(cnt > answer)
							answer = cnt;
						
						for(int ii = 0; ii<4; ii++) {
							int tx = x + dx[ii];
							int ty = y + dy[ii];
							
							if(tx<0 || ty<0 || tx>=N || ty>=M)
								continue;
							
							if(isChecked[tx][ty])
								continue;
							
							if(map[tx][ty]) {
								q.offer(new int[] {tx,ty,cnt+1});
								isChecked[tx][ty] = true;
							}
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
