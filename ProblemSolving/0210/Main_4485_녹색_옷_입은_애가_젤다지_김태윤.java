package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 : 17800kb
//시간 : 184ms

public class Main_4485_녹색_옷_입은_애가_젤다지_김태윤{

	static int[][] board;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int N;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int sum;
		
		public Node(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.sum - o.sum;
		}
		
	}
	public static void main(String[] args) throws IOException{
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		int testcase = 0;
		
		while(true) {
			testcase++;
			N = Integer.parseInt(br.readLine());
			
//			System.out.println(N);
			if(N==0)
				break;
			
			board = new int[N][N];
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				str = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					board[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			
			for(int i = 0; i<N; i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			
			map[0][0] = board[0][0];
			pq.offer(new Node(0,0,board[0][0]));
			
			while(!pq.isEmpty()) {
				int x = pq.peek().x;
				int y = pq.peek().y;
				int sum = pq.peek().sum;
				
				
				pq.poll();
				
				if(map[x][y] != sum)
					continue;
				
				
				for(int i = 0; i<4; i++) {
					int tx = x + dx[i];
					int ty = y + dy[i];
					
					if(tx<0 || ty<0 || tx>=N || ty>=N)
						continue;
					
					if(map[tx][ty] > board[tx][ty] + sum) {
						map[tx][ty] = board[tx][ty] + sum;
						pq.offer(new Node(tx,ty,map[tx][ty]));
					}
				}
			}
			
			
			
			System.out.println("Problem "+testcase+": "+map[N-1][N-1]);
			
			
		}
		 
	}
}
