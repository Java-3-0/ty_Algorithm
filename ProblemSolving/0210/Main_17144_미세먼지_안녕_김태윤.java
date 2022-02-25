package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 27484kb
//시간 : 316ms

public class Main_17144_미세먼지_안녕_김태윤 {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int M,N,T;
	static int airpurifier_x, airpurifier_y;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[M][N];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					airpurifier_x = i;
					airpurifier_y = j;
				}
			}
		}

		
		
		for(int t = 1; t<=T; t++) {
			int[][] arr_temp = new int[M][N];
			
			spread(arr,arr_temp);
			arr = arr_temp;
			
			air_purifying(arr);
		}
		
		int sum = 0;
		for(int i = 0; i<M; i++) {
			for(int j= 0; j<N; j++)
				sum += arr[i][j];
		}
		System.out.println(sum+2);
	}
	
	static void spread(int[][] arr, int[][] arr_temp) {
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				
				if(arr[i][j] <5) {
					arr_temp[i][j] += arr[i][j];
					continue;
				}
				int spread_cnt = 0;
				for(int k = 0; k<4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];
					
					if(tx<0 || ty<0 || tx>=M || ty>=N)
						continue;
					
					if(arr[tx][ty] == -1)
						continue;
					
					spread_cnt++;
					arr_temp[tx][ty] += arr[i][j]/5;
				}
				
				arr_temp[i][j] += arr[i][j] - arr[i][j]/5 * spread_cnt;
				
				
			}
		}
	}
	
	static void air_purifying(int[][] arr) {
		
		//위 공기청정기, 반시계방향
		airpurifier_x--;
		for(int i = airpurifier_x-2; i>=0; i--) 
			arr[i+1][airpurifier_y] = arr[i][airpurifier_y];
		
		for(int j = 1; j<N; j++) 
			arr[0][j-1] = arr[0][j];
		
		for(int i = 1; i<=airpurifier_x; i++) 
			arr[i-1][N-1] = arr[i][N-1];
		
		for(int j = N-2; j>0; j--)
			arr[airpurifier_x][j+1] = arr[airpurifier_x][j];
		
		arr[airpurifier_x][airpurifier_y+1] = 0;
		
		//아래 공기청정기, 시계방향
		airpurifier_x++;
		for(int i = airpurifier_x+2; i<M; i++) 
			arr[i-1][airpurifier_y] = arr[i][airpurifier_y];
		
		for(int j = 1; j<N; j++) 
			arr[M-1][j-1] = arr[M-1][j];
		
		for(int i = M-2; i>=airpurifier_x; i--) 
			arr[i+1][N-1] = arr[i][N-1];
		
		for(int j = N-2; j>0; j--) 
			arr[airpurifier_x][j+1] = arr[airpurifier_x][j];
		
		arr[airpurifier_x][airpurifier_y+1] = 0;
	}

}
