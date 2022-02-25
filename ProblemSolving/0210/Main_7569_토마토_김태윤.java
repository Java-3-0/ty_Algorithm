package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 122156kb
//시간 : 700ms

public class Main_7569_토마토_김태윤 {

	static int N,M,H;
	static int[][] dir = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{-1,0,0},{1,0,0}};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		//5 3 1
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());
		
		int[][][] arr = new int[H][M][N];
		
		for(int i = 0; i<H; i++) { // 1
			for(int j= 0; j<M; j++) { // 3
				str = new StringTokenizer(br.readLine().trim(), " ");
				for(int k = 0; k<N; k++) { // 5
					arr[i][j][k] = Integer.parseInt(str.nextToken());
//					System.out.print(arr[i][j][k]+" ");
				}
//				System.out.println();
			}
//			System.out.println();
		}
		
		System.out.println(bfs(arr));
	}
	
	static int bfs(int[][][] arr) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int cnt = 0;
		
		for(int i = 0; i<H; i++) { // 1
			for(int j= 0; j<M; j++) { // 3
				for(int k = 0; k<N; k++) { // 5
					if(arr[i][j][k] == 1) {
						q.offer(new int[] {i,j,k});
						cnt++;
					}else if(arr[i][j][k] == -1) {
						cnt++;
					}
				}
			}
		}
		
//		System.out.println(q.size());
		int day = 0;
		while(!q.isEmpty() && cnt != N*M*H) {
			
			int qSize = q.size();
			
			while(qSize-->0) {
				for(int i = 0; i<6; i++) {
					int dz = q.peek()[0] + dir[i][0];
					int dy = q.peek()[1] + dir[i][1];
					int dx = q.peek()[2] + dir[i][2];
//					System.out.println(dz+" "+dy+" "+dx);
					if(dz<0 || dy<0 || dx<0 || dz>=H || dy>=M || dx >=N)
						continue;
					
					if(arr[dz][dy][dx] != 0)
						continue;
					
					q.offer(new int[] {dz,dy,dx});
					arr[dz][dy][dx] = 1;
					cnt++;
				}
				q.poll();
			}
			
			
//			for(int i = 0; i<H; i++) { // 1
//				for(int j= 0; j<M; j++) { // 3
//					for(int k = 0; k<N; k++) { // 5
//						System.out.print(arr[i][j][k]+" ");
//					}
//					System.out.println();
//				}
//			}
//
//			System.out.println();
			
			day++;
		}
		
		return cnt==N*M*H?day:-1;
	}

}
