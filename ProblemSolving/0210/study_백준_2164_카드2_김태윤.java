package algo_ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_백준_2164_카드2_김태윤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
