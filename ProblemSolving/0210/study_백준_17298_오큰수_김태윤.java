package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class study_백준_17298_오큰수_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		// {idx, height} 넣을 거임
		Stack<int[]> stack = new Stack<int[]>();
		
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		
		for(int i = 0; i<N; i++) {
			int item = Integer.parseInt(str.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[1] < item) {
					answer[stack.peek()[0]] = item;
					stack.pop();
				}else
					break;
			}
			stack.push(new int[] {i,item});
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
