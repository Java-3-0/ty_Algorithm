package algo_ex;

import java.util.Scanner;

public class Main_2669_직사각형_네개의_합집합의_면적_구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		
		for(int t = 0; t<4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int i = x1; i<x2; i++) {
				for(int j = y1; j<y2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<100; i++) {
			for(int j= 0; j<100; j++) {
				if(arr[i][j] == 1)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
