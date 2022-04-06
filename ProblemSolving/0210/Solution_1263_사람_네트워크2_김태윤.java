package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 97148kb
//시간 : 1454ms

public class Solution_1263_사람_네트워크2_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && arr[i][j] == 0)
						arr[i][j] = 1001;
					
				}
			}
			
			
			for(int k = 0; k<N; k++) {
				for(int i = 0; i<N; i++) {
					for(int j = 0; j<N; j++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for(int i = 0; i<N; i++) {
				for(int j = 1; j<N; j++) {
					arr[i][0] += arr[i][j];
				}
				answer = Math.min(answer, arr[i][0]);
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}

}
