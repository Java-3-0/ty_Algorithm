package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11055_가장_큰_증가_부분_수열_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS_sum = new int[N];
		
		LIS_sum[0] = arr[0];
		
		for(int i = 1; i<N; i++) {
			LIS_sum[i] = arr[i];
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					LIS_sum[i] = Math.max(LIS_sum[i], LIS_sum[j] + arr[i]);
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i<N; i++)
			answer = Math.max(answer, LIS_sum[i]);
		
		System.out.println(answer);
		
	}

}
