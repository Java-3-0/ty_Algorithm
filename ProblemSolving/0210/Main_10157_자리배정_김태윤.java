package algo_ex;

import java.util.Scanner;

//메모리 : 16788kb
//시간 : 140ms

public class Main_10157_자리배정_김태윤 {
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		
		int num = sc.nextInt();
		
		if(num > R*C || num <= 0) {
			System.out.println("0");
			return;
		}
		
		int[][] map = new int[R][C];
		
		int x = 0;
		int y = 0;
		int cnt = 1;
		
		int default_direction = 0;
		
		while(true) {
			map[x][y] = cnt++;
			
			if(cnt>num)
				break;
			
			for(int i = 0; i<4; i++) {
				default_direction += i;
				default_direction%=4;
				int tx = x + dx[default_direction];
				int ty = y + dy[default_direction];
				
				if(tx<0 || ty<0 || tx>=R || ty>=C)
					continue;
				
				if(map[tx][ty] != 0)
					continue;
				
				x = tx;
				y = ty;
				break;
			}
		}
		
		System.out.println((y+1)+" "+(x+1));
		
	}

}
