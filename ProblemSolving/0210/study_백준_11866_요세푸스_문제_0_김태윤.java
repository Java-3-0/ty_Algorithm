package algo_ex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_백준_11866_요세푸스_문제_0_김태윤 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 1; i<=N; i++)
			q.offer(i);
		
		sb.append("<");
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			cnt%=K;
			if(cnt==0)
				sb.append(q.poll()+", ");
			else
				q.offer(q.poll());
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
		
	}
}
