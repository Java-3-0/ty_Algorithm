package algo_ex;

import java.util.Scanner;

//메모리 : 12852kb
//시간 : 116ms

public class Main_2193_이친수_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

        if(N==1){
            System.out.println("1");
            return;
        }
        
		long[] dp = new long[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i<=N; i++) 
			dp[i] = dp[i-1]+dp[i-2];
		
		System.out.println(dp[N]);
	}
	

}
