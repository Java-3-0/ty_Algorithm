package algo_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//메모리 : 12940kb
//시간 : 112ms

public class Main_2628_종이자르기_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		
		int zero_cnt = 0;
		
		ArrayList<Integer> arr0 = new ArrayList<Integer>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		
		for(int i = 0; i<N; i++) {
			
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
			if(arr[i][0] == 0)
				arr0.add(arr[i][1]);
			else
				arr1.add(arr[i][1]);
		}
		
		arr0.add(C);
		arr1.add(R);
		
		Collections.sort(arr0);
		Collections.sort(arr1);
		
//		System.out.println(arr0.toString());
//		System.out.println(arr1.toString());
		
		for(int i = arr0.size()-1; i>0; i--) {
			arr0.set(i, arr0.get(i) - arr0.get(i-1));
		}
		

		for(int i = arr1.size()-1; i>0; i--) {
			arr1.set(i, arr1.get(i) - arr1.get(i-1));
		}
		

//		System.out.println(arr0.toString());
//		System.out.println(arr1.toString());
		

		Collections.sort(arr0, Collections.reverseOrder());
		Collections.sort(arr1, Collections.reverseOrder());
		
		System.out.println(arr0.get(0)*arr1.get(0));
		
	}

}
