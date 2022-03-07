package algo_ex;

import java.util.PriorityQueue;
import java.util.Scanner;

//메모리 : 13072kb
//시간 : 124ms

public class Main_1446_지름길_김태윤 {
	
	static class ShortCut implements Comparable<ShortCut>{
		int start;
		int end;
		int distance;
		
		public ShortCut(int start, int end, int distance) {
			super();
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(ShortCut o) {
			return this.start - o.start;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int D = sc.nextInt();
		
		int[] arr = new int[D+1];
		
		for(int i = 0; i<=D; i++)
			arr[i] = i;
		
		PriorityQueue<ShortCut> pq = new PriorityQueue<ShortCut>();
		
		for(int i = 0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int distance = sc.nextInt();
			
			if(end>D)
				continue;
			
			if(distance >= end-start)
				continue;
			
			pq.offer(new ShortCut(start, end, distance));
			
			
		}
		
		while(!pq.isEmpty()) {
			int start = pq.peek().start;
			int end = pq.peek().end;
			int distance = pq.peek().distance;
			
			if(arr[start] + distance < arr[end]) {
				arr[end] = arr[start] + distance;
				for(int j = 0; end+j<=D; j++) {
					arr[end+j] = arr[end]+j < arr[end+j] ? arr[end]+j : arr[end+j];
				}
			}
			
			pq.poll();
		}
		
		System.out.println(arr[D]);
		
	}

}
