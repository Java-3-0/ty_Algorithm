package algo_ex;

import java.util.Scanner;

//미완

public class Main_2527_직사각형_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();
			
			
			if((x2==x3 && y2==y3) || (x1==x4 && y1==y4) || (x1==x4 && y2==y3) || (x2==x3&&y1==y4))
				System.out.println("c");
			else if ( (y1==y4  ) )
			
//			if(x1)
		}
	}

}
