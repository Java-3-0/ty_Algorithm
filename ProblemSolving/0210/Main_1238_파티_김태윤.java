package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 : 19040kb
//시간 : 2208ms

public class Main_1238_파티_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int X = Integer.parseInt(str.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}
		
		for(int i = 0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int length = Integer.parseInt(str.nextToken());
			arr[start][end] = length;
		}
		
		//플로이드 워셜
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=N; k++) {
					if(i==k || j==k || i==j) continue;
					
					if(arr[j][i] == Integer.MAX_VALUE || arr[i][k] == Integer.MAX_VALUE)
						continue;
					
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		
		int max_time = 0;
		
		for(int i = 1; i<=N; i++) {
			max_time = Math.max(max_time, arr[i][X] + arr[X][i]);
		}
		
		System.out.println(max_time);
		
	}

}
