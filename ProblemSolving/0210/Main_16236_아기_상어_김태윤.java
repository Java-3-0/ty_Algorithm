package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 12884kb
//시간 : 104ms

public class Main_16236_아기_상어_김태윤 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int size;
		int cnt = 0;
		
		public Fish(int x, int y, int size, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}

		public Fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Fish o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
		
		public void eat(){
			cnt++;
			if(cnt == size) {
				size++;
				cnt=0;
			}
		}
	}
	
	static int[][] map;
	static Fish shark;
	static int N;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer str;

		for(int i = 0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j] == 9)
					shark = new Fish(i,j,2);
			}
		}
		
		int answer = 0;
		while(true) {
			ArrayList<Fish> fish = findFish();
			if(fish.size() == 0)
				break;
			
			Collections.sort(fish);
			
			shark.eat();
			map[shark.x][shark.y]= 0; 
			int xx = fish.get(0).x;
			int yy = fish.get(0).y;
			map[xx][yy] = 0;
			shark.x = xx;
			shark.y = yy;
			map[shark.x][shark.y]= 9;
			answer += fish.get(0).cnt;
		}
		
		System.out.println(answer);
		
	}
	
	static ArrayList<Fish> findFish(){
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<Fish> fish = new ArrayList<Fish>();
		
		q.offer(new int[] {shark.x,shark.y,0});
		
		boolean[][] isChecked = new boolean[N][N];
		
		isChecked[shark.x][shark.y] = true;
		
		boolean flag = false;
		int temp = -1;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt= q.peek()[2];
			q.poll();
			
			if(flag) {
				if(cnt > temp)
					continue;
			}
			
			if(map[x][y] != 0 && map[x][y] != 9 && map[x][y] < shark.size) {
				fish.add(new Fish(x,y,map[x][y], cnt));
				flag = true;
				temp = cnt;
			}
			
			for(int i = 0; i<4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx<0 || ty<0 || tx>=N || ty>=N)
					continue;
				
				if(map[tx][ty] > shark.size)
					continue;
				
				if(isChecked[tx][ty])
					continue;
				
				q.offer(new int[] {tx,ty,cnt+1});
				isChecked[tx][ty] = true;
			}
		}
		return fish;
	}
}
