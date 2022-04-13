package algo_ex;

import java.util.Scanner;

//메모리 : 39324kb
//시간 : 1208ms

public class Main_1929_소수_구하기_김태윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] prime = new boolean[N+1];
		
		prime[1] = true;
		for(int i = 2; i<=Math.sqrt(N); i++) {
			for(int j = 2; i*j <= N; j++) {
				prime[i*j] = true;
			}
		}
		
		for(int i = M; i<=N; i++) {
			if(!prime[i])
				System.out.println(i);
		}
		
	}

}
