package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class study_백준_4949_균형잡힌_세상_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals("."))
				break;
			
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			for(int i = 0; i<s.length(); i++) {
				switch (s.charAt(i)) {
				case '(':
					stack.push(s.charAt(i));
					break;
				case ')':
					if(stack.isEmpty()) {
						flag = false; break;
					}
					if(stack.peek() == '(') {
						stack.pop();
					}else flag = false;
					break;
				case '{':
					stack.push(s.charAt(i));
					break;
				case '}':
					if(stack.isEmpty()) {
						flag = false; break;
					}
					if(stack.peek() == '{') {
						stack.pop();
					}else flag = false;
					break;
				case '[':
					stack.push(s.charAt(i));
					break;
				case ']':
					if(stack.isEmpty()) {
						flag = false; break;
					}
					if(stack.peek() == '[') {
						stack.pop();
					}else flag = false;
					break;
				default:
					break;
				}
			}
			
			if(flag && stack.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}
