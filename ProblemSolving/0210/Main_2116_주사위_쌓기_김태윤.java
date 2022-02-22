package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 21024kb
//시간 : 200ms

public class Main_2116_주사위_쌓기_김태윤 {

	static int answer = -1;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][6];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
			arr[i][2] = Integer.parseInt(str.nextToken());
			arr[i][4] = Integer.parseInt(str.nextToken());
			arr[i][5] = Integer.parseInt(str.nextToken());
			arr[i][3] = Integer.parseInt(str.nextToken());
			
		}
		
		for(int i = 0; i<6; i++) {
			int start = arr[0][i];
			
			dfs(arr, start, 1, N, find_max(arr[0], i));
		}
		System.out.println(answer);
	}
	
	
	static int find_max(int[] arr, int idx) {
		int max = 0;
		
		for(int i = 0; i<6; i++) {
			if(i%3 == idx%3)
				continue;
			
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}
	static void dfs(int[][] arr, int curr, int cnt, int N, int sum) {
		if(cnt==N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i = 0; i<6; i++) {
			if(arr[cnt][i] == curr)
				dfs(arr, arr[cnt][(i+3)%6], cnt+1, N, sum + find_max(arr[cnt], i));
		}
	}

}
