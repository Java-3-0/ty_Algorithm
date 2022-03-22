package algo_ex;

import java.util.Scanner;

//메모리 : 12820kb
//시간 : 112ms

public class Main_1541_잃어버린_괄호_김태윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		s = s + "+";
		char[] arr = s.toCharArray();
		int idx = 0;
		
		int sum = 0;
		boolean flag = false;
		int temp = 0;
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == '+' || arr[i] == '-') {
				temp = Integer.parseInt(s.substring(idx, i));
				idx = i+1;
			}else
				continue;
			
			if(flag)
				sum-=temp;
			else
				sum+=temp;
			

			if(arr[i] == '-')
				flag = true;
			
		}
		
		System.out.println(sum);
	}
}