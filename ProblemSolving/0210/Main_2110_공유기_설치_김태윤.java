package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 : 28384kb
//시간 : 264ms

public class Main_2110_공유기_설치_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N,C;
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		

		int l,r;
		
		l = 1;
		r = arr[N-1] - arr[0];
		
		int answer = 0;
		while(l<=r) {
			int mid = (l+r)/2; // 2
		
			int count = 1;
			
			int last_wifi = arr[0];
			int i = 1;
			for(; i<N; i++) {
				if(last_wifi + mid <= arr[i]) {
					count++;
					last_wifi = arr[i];
				}
				
				if(count == C)
					break;
			}
			
			if(count == C) {
				answer = mid;
				l = mid+1;
			}else {
				r = mid-1;
			}
		
		}
//		System.out.println(r);
		System.out.println(answer);
		

	}

}
