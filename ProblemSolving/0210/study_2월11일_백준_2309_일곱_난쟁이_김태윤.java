package algo_ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//메모리 : 17648kb
//시간 : 228ms
public class study_2월11일_백준_2309_일곱_난쟁이_김태윤 {
	
	public static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		for(int i = 0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean[] isCheck = new boolean[9];
		Arrays.fill(isCheck, false);
		
		dfs(arr, isCheck, 0, 0, 0);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 0; i<9; i++) {
			if(isCheck[i]) {
				al.add(arr[i]);
			}
		}
		
		Collections.sort(al);
		
		for(int i = 0; i<7; i++) {
			System.out.println(al.get(i));
		}
	}
	
	
	public static void dfs(int arr[], boolean isCheck[], int idx_start, int cnt, int sum) {
		if(flag)
			return;
		
		if(cnt == 7) {
			if(sum == 100)
				flag = true;
			return;
		}
		
		for(int i = idx_start; i<9; i++) {
			isCheck[i] = true;
			dfs(arr, isCheck, i+1, cnt+1, sum+arr[i]);
			if(flag)
				break;
			isCheck[i] = false;
			dfs(arr, isCheck, i+1, cnt, sum);
			if(flag)
				break;
		}
	}
	
}
