package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class study_백준_1966_프린터_큐_김태윤 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		for(int ii = 1; ii<=T; ii++) {
			// { 우선순위, idx }
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			Queue<int[]> q = new LinkedList<int[]>();
			
			st =  new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(N+" "+M);
			
			
			st =  new StringTokenizer(br.readLine());
//			System.out.println(st.toString());
			
			for(int i = 0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				pq.add(temp);
				q.offer(new int[]{temp, i});
			}
			
			// { 우선순위, idx }			
			int cnt = 0;
			while(!q.isEmpty()) {
				if(q.peek()[0] == pq.peek()) {
					cnt++;
					if(q.peek()[1] == M) {
						System.out.println(cnt);
						break;
					}else {
						q.poll();
						pq.poll();
					}
				}else {
					q.offer(q.poll());
				}
			}
			
			
			
		}
		
	}
	

}
