package algo_ex;

import java.util.Scanner;

//메모리 : 18700kb
//시간 : 264ms

public class Main_10163_색종이_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[1001][1001];
		for(int t = 1; t<=N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x_len = sc.nextInt();
			int y_len = sc.nextInt();
			
			for(int i = x; i<x+x_len; i++) {
				for(int j = y; j<y+y_len; j++) {
					arr[i][j] = t;
				}
			}
		}
		
		int[] sum = new int[N+1];
		for(int i = 0; i<1001; i++) {
			for(int j = 0; j<1001; j++) {
				if(arr[i][j] != 0)
					sum[arr[i][j]]++;
			}
		}
		
		for(int i = 0; i<N; i++) {
			System.out.println(sum[i+1]);
		}
	}

}
