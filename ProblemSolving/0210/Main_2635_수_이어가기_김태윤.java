package algo_ex;

import java.util.Scanner;

//메모리 : 12868kb
//시간 : 108ms

public class Main_2635_수_이어가기_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int max_cnt = 3;
		int num = N;
		for(int i = N; i>N/2; i--) {
			int cnt = 2;
			
			int n1 = N;
			int n2 = i;
			while(true) {
				
				if(n1-n2<0)
					break;
//				System.out.print(n1+" ");
				cnt++;
				int temp = n2;
				n2 = n1-n2;
				n1 = temp;
			}
//			System.out.println();
			
			if(max_cnt<cnt) {
				max_cnt = cnt;
				num = i;
			}
		}
		
		System.out.println(max_cnt);
		
		int n1 = N;
		int n2 = num;
		while(true) {
			
			if(n1<0)
				break;
			System.out.print(n1+" ");
//			cnt++;
			int temp = n2;
			n2 = n1-n2;
			n1 = temp;
		}
	}

}
