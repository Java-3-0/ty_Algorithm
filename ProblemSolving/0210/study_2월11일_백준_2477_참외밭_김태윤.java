package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study_2월11일_백준_2477_참외밭_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int koreanMelon_per_Square_meter = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] arr = new int[6];
		
		int max_val = -1;
		int max_idx = -1;
		
		for(int i = 0 ;i<6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(max_val < arr[i]) {
				max_val = arr[i];
				max_idx = i;
			}
		}
		
		int a1 = (max_idx+1)%6;
		int a2 = (max_idx+5)%6;
		int second_idx = arr[a1] > arr[a2] ? a1 : a2;
		
		int big_square = arr[max_idx]*arr[second_idx];
		int small_square = arr[(max_idx+3)%6]*arr[(second_idx+3)%6];

		System.out.println((big_square - small_square) * koreanMelon_per_Square_meter);
		
		
	}

}
