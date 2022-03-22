package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//메모리 : 225580kb
//시간 : 1108ms

public class Main_17952_과제는_끝나지_않아_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		Stack<int[]> stack = new Stack<int[]>();
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int flag = Integer.parseInt(st.nextToken());
			if(flag == 1) {
				stack.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			if(stack.isEmpty())
				continue;
			
			int[] temp = stack.pop();
			if(temp[1] == 1)
				answer+=temp[0];
			else
				stack.add(new int[] {temp[0],temp[1]-1});
		}
		System.out.println(answer);
	}

}
