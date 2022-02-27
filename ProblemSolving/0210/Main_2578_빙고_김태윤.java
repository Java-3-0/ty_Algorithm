package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 11556kb
//시간 : 80ms

public class Main_2578_빙고_김태윤 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		
		int[][] board = new int[5][5];
		boolean[] bingo = new boolean[12];
		
		for(int i = 0; i<5; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j= 0; j<5; j++) {
				board[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		int[] arr = new int[25];
		
		for(int i = 0; i<5; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j= 0; j<5; j++) {
				arr[i*5+j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int t = 0; t<25; t++) {
			LOOP:for(int i = 0; i<5; i++) {
				for(int j= 0; j<5; j++) {
					if(board[i][j] == arr[t]) {
						board[i][j] = -1;
						func1(board,i,j,bingo);
						break LOOP;
					}
				}
			}
			if(cnt >= 3) {
				System.out.println(t+1);
				break;
			}
		}
	}
	
	static void func1(int[][] board, int x, int y, boolean[] bingo){
		int i = 0;
		for(; i<5; i++) {
			if(board[x][i] != -1)
				break;
		}
		if(i==5) {
			if(!bingo[x]) {
				cnt++;
				bingo[x] = true;
			}
		}
		
		
		
		i = 0;
		for(; i<5; i++) {
			if(board[i][y] != -1)
				break;
		}
		if(i==5) {
			if(!bingo[y+5]) {
				cnt++;
				bingo[y+5] = true;
			}
		}
		
		
		if(x==y) {
			i = 0;
			for(; i<5; i++) {
				if(board[i][i] != -1)
					break;
			}
			if(i==5) {
				if(!bingo[10]) {
					cnt++;
					bingo[10] = true;
				}
			}
		}
		
		
		if(x==4-y) {
			i = 0;
			for(; i<5; i++) {
				if(board[i][4-i] != -1)
					break;
			}
			if(i==5) {
				if(!bingo[11]) {
					cnt++;
					bingo[11] = true;
				}
			}
		}
	}

}
