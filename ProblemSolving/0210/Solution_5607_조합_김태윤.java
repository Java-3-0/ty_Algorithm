package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합_김태윤 {

	/**
	 * nCr = n! / ((n-r)! * r!) = n! * 1/(n-r)! * 1/r!
	 * 
	 * - 위의 문제에서는 nCr % p를 구하라고 함
	 * 
	 * nCr % p = (n! / ((n-r)! * r!)) % p
	 * = (n!%p * (1/(n-r)!)%p * (1/r!)%p)%p\
	 * = * (n!%p * (n-r)!^(p-2)%p * r!^(p-2)%p)%p
	 * 
	 * n! / a   ->   a = (n-r)! * r!
	 * = n! * a^(-1)
	 * (>>페르마의 소정리 활용>>)
	 * = n! * a^(p-2)
	 * n! * a^p-2
	 */

	static final int MOD = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long factorial[] = new long[N + 1];
			factorial[0] = 1;
			for (int i = 1; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % MOD;
			}

			long bunmo = (factorial[R] * factorial[N - R]) % MOD;

			long reverse_bunmo = fermat(bunmo, MOD - 2);

			System.out.println("#"+t+" "+(factorial[N] * reverse_bunmo) % MOD);

		}
	}
	
	/**
	 * x^y = x^(y/2) * x^(y/2) (y는 짝수)
	 * x^y = x^(y-1/2) * x^(y-1/2) * x (y는 홀수)
	 * 
	 * x^10 = x^5, x^2
	 * x^20 = x^10, x^5, x^2
	 */
	static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		if (x % 2 == 0)
			return (tmp * tmp) % MOD;
		else
			return ((tmp * tmp) % MOD * n) % MOD;
	}

}
