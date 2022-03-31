package algo_ex;

import java.util.Scanner;

//메모리 : 14556kb
//시간 : 136ms

public class Main_2011_암호코드_김태윤 {

	static String s;
	static char[] s2;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next().trim();
		s2 = s.toCharArray();
		
		long[] dp = new long[s.length()+1];
		dp[0] = 1;
		
		if(s2[0] != '0')
			dp[1] = 1;
		
		
			
		
		for(int i = 2; i<dp.length; i++) {
			if(Integer.parseInt(s.substring(i-2,i)) <= 26 && s2[i-2] != '0')
				dp[i] += dp[i-2];
			
			if(s2[i-1] != '0')
				dp[i] += dp[i-1];
			
			dp[i]%=1000000;
		}
		
		System.out.println(dp[s.length()]);
	}
	
	

}