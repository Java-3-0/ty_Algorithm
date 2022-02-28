package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13038_교환학생_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = null;
		
//		new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			str = new StringTokenizer(br.readLine());
			int[] arr = new int[7];
			
			for(int i = 0; i<7; i++)
				arr[i] = Integer.parseInt(str.nextToken());
			
			
			int answer = Integer.MAX_VALUE;
			for(int i = 0; i<7; i++) {
				int N = n;
				int num = i;
				int cnt = 0;
				while(true) {
					cnt++;
					if(arr[num] == 1)
						N--;
					
					if(N==0)
						break;
					
					num++;
					num%=7;
				}
				answer = Math.min(cnt, answer);
						
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}

}
