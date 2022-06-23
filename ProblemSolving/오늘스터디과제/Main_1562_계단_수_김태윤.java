package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 : 21092kb
//시간 : 136ms

public class Main_1562_계단_수_김태윤 {

	static int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * 
		 * 1,2,3,4,5,6,7,8,9
		 * 
		 * 11
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		int N = Integer.parseInt(br.readLine());
		
		long[][][] dp = new long[N+1][10][1<<10]; //N 자리수, 0~9, 0000000000 ~ 1111111111
		
		
		for(int i = 1; i<10; i++) {
			dp[1][i][1<<i] = 1;      // 한자릿수, 끝이 i로 끝나는 수, 비트마스킹 체크함
									 //1~9까지 1개 체크됨을 알 수 있음
		}
		
		
		for(int i = 2; i<=N; i++) { //2자리수부터 시작해서 목표인 N자리수까지 갈거야
			for(int j = 0; j<10; j++) { //마지막 숫자는 j 야
				for(int k = 0; k<1024; k++) { //0000000000 부터 1111111111 까지
					int bit = k | (1<<j);
					
					
					if(j==0) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k])%MOD;
					}else if(j==9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % MOD;
					}
					else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]+ dp[i-1][j-1][k]) % MOD;
					}
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i<10; i++) {
			sum = (sum+dp[N][i][1023]) % MOD;
		}
		System.out.println(sum);
		
	}

}

