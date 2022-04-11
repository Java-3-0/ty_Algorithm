package algo_ex;

import java.util.Scanner;

public class Main_10844_쉬운_계단_수_김태윤 {

	/**
	 * 1 2 3 4 5 6 7 8 9
	 * 
	 * <<9개>>
	 * -------------------------
	 * 10 12
	 * 21 23
	 * ...
	 * 87 89
	 * 98
	 * 
	 * <<17개>>
	 * -------------------------
	 * 101
	 * 123 121
	 * 
	 * 210 212
	 * 232 234
	 * 
	 * ...
	 * 
	 * 876 878
	 * 897
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N+1][10];
		
		for(int i=1; i<=9; i++) {
			arr[1][i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			arr[i][1] += arr[i-1][0];
			for(int j = 1; j<9; j++) {
				arr[i][j-1] += arr[i-1][j];
				arr[i][j+1] += arr[i-1][j];
			}
			arr[i][8] += arr[i-1][9];
			
			for(int j = 0; j<10; j++) {
				arr[i][j]%=1000000000;
			}
		}
		
		int answer = 0;
		for(int j = 0; j<10; j++) {
			answer += arr[N][j];
			answer %= 1000000000;
		}
		
		System.out.println(answer);
	}

}
