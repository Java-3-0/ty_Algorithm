package algo_ex;

import java.util.Scanner;

//메모리 : 16192kb
//시간 : 132ms

public class Main_12904_A와_B_김태윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		StringBuffer sb = null;
		
		while(s1.length() < s2.length()) {
			if(s2.charAt(s2.length()-1) == 'A')
				s2 = s2.substring(0,s2.length()-1);
			else if(s2.charAt(s2.length()-1) == 'B') {
				sb = new StringBuffer(s2.substring(0,s2.length()-1));
				sb.reverse();
				s2 = sb.toString();
			}
		}
		
		if(s1.equals(s2))
			System.out.println(1);
		else
			System.out.println(0);
	}

}
