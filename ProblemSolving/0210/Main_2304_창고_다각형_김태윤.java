package algo_ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 17172kb
//시간 : 272ms

public class Main_2304_창고_다각형_김태윤 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		
		
		
		int[][] arr = new int[N][2];
		
		int maxHeight = 0;
		int maxH_idx = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
			
			if(arr[i][1] > maxHeight) {
				maxHeight = arr[i][1];
				maxH_idx = i;
			}
		}
		
		boolean[][] map = new boolean[1001][1001];
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[maxH_idx][0] > arr[i][0]) {
				for(int j = arr[i][0]; j<arr[maxH_idx][0]; j++) {
					for(int k = 0; k<arr[i][1]; k++) {
						map[j][k] = true;
					}
				}
			}else if(arr[maxH_idx][0] < arr[i][0]) {
				for(int j = arr[i][0]; j>arr[maxH_idx][0]; j--) {
					for(int k = 0; k<arr[i][1]; k++) {
						map[j][k] = true;
					}
				}
			}else {
				for(int j = 0; j<arr[i][1]; j++) {
					map[arr[i][0]][j] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<1001; i++) {
			for(int j = 0; j<1001; j++) {
				if(map[i][j])
					cnt++;
			}
		}
		
		System.out.println(cnt); 
	}

}
