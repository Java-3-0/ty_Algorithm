package algo_ex;

import java.util.Scanner;
import java.util.Stack;

public class study_백준_1874_스택_수열_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) 
			arr[i] = sc.nextInt();
		
	
		Stack<Integer> stack = new Stack<Integer>();
		
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			
			stack.push(i);
			sb.append("+");
			
			if(cnt==N)
				break;
			
			while(stack.peek() == arr[cnt]) {
				sb.append("-");
				stack.pop();
				cnt++;
				
				if(stack.isEmpty())
					break;
			}
			
		}

		if(stack.isEmpty()) {
			for(int i = 0; i<sb.length(); i++) {
				System.out.println(sb.charAt(i));
			}
		}else
			System.out.println("NO");

	}

}
