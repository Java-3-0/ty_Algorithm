package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_원재의_메모리_복구하기_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t<=T; t++) {
			int num = 1;
			int cnt = 0;
			char[] temp = br.readLine().trim().toCharArray();
			
			for(int i = 0; i<temp.length; i++) {
				if(temp[i] == num+'0') {
					cnt++;
					num = num==1?0:1;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
