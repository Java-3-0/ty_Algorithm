package algo_ex;

import java.io.*;
import java.util.*;

public class study_백준_18258_큐_2_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		int last = -1;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			switch (s.charAt(1)) {
			case 'u':
				q.offer(Integer.parseInt(s.substring(5)));
				break;
			case 'o':
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.poll());
				break;
			case 'i':
				System.out.println(q.size());
				break;
			case 'm':
				if(q.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				break;
			case 'r':
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.peek());
				break;
			case 'a':
				if(q.isEmpty())
					System.out.println("-1");
				else
					System.out.println(q.getLast());
				break;

			default:
				break;
			}
		}
	}
}
