package algo_ex;

import java.util.Scanner;

//메모리 : 164652kb
//시간 : 980ms
public class Main_14696_딱지놀이_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int t = 0; t<N; t++) {
			
			int[] arr1 = new int[5];
			int A_num = sc.nextInt();
			for(int i = 0; i<A_num; i++) {
				arr1[sc.nextInt()]++;
			}
			
			
			int[] arr2 = new int[5];
			int B_num = sc.nextInt();
			for(int i = 0; i<B_num; i++) {
				arr2[sc.nextInt()]++;
			}
			
			int i = 4;
			for(; i>0; i--) {
				if(arr1[i] == arr2[i])
					continue;
				
				if(arr1[i] > arr2[i]) {
					System.out.println("A");
					break;
				}else {
					System.out.println("B");
					break;
				}
			}
			
			if(i==0)
				System.out.println("D");
		}
	}

}
