package algo_ex;

import java.util.Scanner;

//메모리 : 13292kb
//시간 : 132ms

public class Main_1244_스위치_켜고_끄기_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int num = sc.nextInt();
		for(int i = 0; i<num; i++) {
			int sex = sc.nextInt();
			int idx = sc.nextInt();
			
			if(sex == 1) {
				for(int j = idx-1; j<N; j+=idx) {
					if(arr[j] == 1)
						arr[j] = 0;
					else arr[j] = 1;
				}
			}else {
				int diff = 0;
				idx--;
				while(true) {
					
//					System.out.println(diff);
					if(idx-diff < 0) {
						diff--;
//						System.out.println("yes");
						break;
					}
					
					if(idx+diff >= N) {
						diff--;
						break;
					}
//					System.out.println("HI");
					
					if(arr[idx-diff] != arr[idx+diff]) {
						diff--;
						break;
					}
					
					diff++;
				}
				
				for(int j = idx-diff; j<=idx+diff; j++) {
					if(arr[j] == 1)
						arr[j] = 0;
					else arr[j] = 1;
				}
			}
			

//			for(int ii = 0; ii<N; ii++) {
//				if(ii!=0 && ii%20 == 0)
//					System.out.println();
//				System.out.print(arr[ii]+" ");
//			}
//			System.out.println();
		}
		

		for(int ii = 0; ii<N; ii++) {
			if(ii!=0 && ii%20 == 0)
				System.out.println();
			System.out.print(arr[ii]+" ");
		}
		System.out.println();
	}
	
	

}
