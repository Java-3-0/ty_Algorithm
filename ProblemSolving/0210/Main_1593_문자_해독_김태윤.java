package algo_ex;

import java.util.HashSet;
import java.util.Scanner;

//메모리 : 49640kb
//시간 : 544ms

public class Main_1593_문자_해독_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int pattern_len = sc.nextInt();
		int string_len = sc.nextInt();
		
		String pattern = sc.next();
		String string = sc.next();
		
		int[] patternArray = new int[52];
		int[] matchArray = new int[52];
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<pattern_len; i++) {
			char ch = pattern.charAt(i);
			
			if(ch <= 'Z') { //대문자라면
				set.add((int)(ch-'A'));
				patternArray[(int)(ch-'A')]++;
			}else { //소문자라면
				set.add((int)(ch-'a'+26));
				patternArray[(int)(ch-'a'+26)]++;
			}
		}
		
		for(int i = 0; i<pattern_len; i++) {
			char ch = string.charAt(i);

			if(ch <= 'Z') { //대문자라면
				matchArray[(int)(ch-'A')]++;
			}else { //소문자라면
				matchArray[(int)(ch-'a'+26)]++;
			}
		}
		
		int answer = 0;
		if(isCorrect(patternArray, matchArray, set))
			answer++;
		
		for(int i = pattern_len; i<string_len; i++) {
			
			char ch = string.charAt(i);
			if(ch <= 'Z') { //대문자라면
				matchArray[(int)(ch-'A')]++;
			}else { //소문자라면
				matchArray[(int)(ch-'a'+26)]++;
			}
			
			ch = string.charAt(i-pattern_len);
			if(ch <= 'Z') { //대문자라면
				matchArray[(int)(ch-'A')]--;
			}else { //소문자라면
				matchArray[(int)(ch-'a'+26)]--;
			}
			

			if(isCorrect(patternArray, matchArray, set))
				answer++;
		}
		
		System.out.println(answer);
		
		
	}
	
	static boolean isCorrect(int[] patternArray, int[] matchArray, HashSet<Integer> set) {

		for(Integer t : set) {
			if(patternArray[t] != matchArray[t])
				return false;
		}
		
		return true;
	}

}
