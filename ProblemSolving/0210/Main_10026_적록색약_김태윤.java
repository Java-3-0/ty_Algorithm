package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//메모리 : 12640kb
//시간 : 108ms

public class Main_10026_적록색약_김태윤 {

	static int N;
	static char[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
//			System.out.println(s);
			for(int j = 0; j<N; j++) {
				arr[i][j] = s.charAt(j);
//				System.out.print(arr[i][j]+" ");
			}
//			System.out.println(i);
		}
		
		System.out.println(bfs1() + " " + bfs2());
	}
	
	//정상인
	static int bfs1() {
		
		int answer = 0;
		boolean[][] isChecked = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j= 0; j<N; j++) {
				if(!isChecked[i][j]) {
					answer++;
					
					isChecked[i][j] = true;
					char a = arr[i][j];
					
					Queue<int[]> q = new LinkedList<int[]>();
					
					q.offer(new int[] {i,j});
					
					while(!q.isEmpty()) {
						for(int k = 0; k<4; k++) {
							int tx = q.peek()[0] + dx[k];
							int ty = q.peek()[1] + dy[k];

							
							if(tx<0 || ty<0 || tx>=N || ty>=N)
								continue;
							
							if(arr[tx][ty] == a && !isChecked[tx][ty]) {
								q.offer(new int[] {tx,ty});

//								System.out.println(tx+" "+ty);
								isChecked[tx][ty] = true;
							}
						}
						q.poll();
					}
				}
			}
		}
		
		return answer;
	}

	//적록색약
	static int bfs2() {
		
		int answer = 0;
		boolean[][] isChecked = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j= 0; j<N; j++) {
				if(!isChecked[i][j]) {
					answer++;
					
					isChecked[i][j] = true;
					boolean flag = false;
					if(arr[i][j] == 'B')
						flag = true;
					
					Queue<int[]> q = new LinkedList<int[]>();
					
					q.offer(new int[] {i,j});
					
					while(!q.isEmpty()) {	
						for(int k = 0; k<4; k++) {
							int tx = q.peek()[0] + dx[k];
							int ty = q.peek()[1] + dy[k];
							
							if(tx<0 || ty<0 || tx>=N || ty>=N)
								continue;
							
							if(flag && arr[tx][ty] == 'B' && !isChecked[tx][ty]) {
								q.offer(new int[] {tx,ty});
								isChecked[tx][ty] = true;
							}else if(!flag && (arr[tx][ty] == 'R' || arr[tx][ty]=='G') && !isChecked[tx][ty]) {
								q.offer(new int[] {tx,ty});
								isChecked[tx][ty] = true;
							}
						}

						q.poll();
					}
				}
			}
		}
		
		return answer;
	}
	
	
}
