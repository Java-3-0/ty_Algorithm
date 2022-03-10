package algo_ex;

import java.util.PriorityQueue;
import java.util.Scanner;

//메모리 : 41668kb
//시간 : 688ms

public class Main_1774_우주신과의_교감_김태윤 {

	static int[] parent;
	static double answer = 0;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		double length;
		
		public Node(int x, int y, double length) {
			super();
			this.x = x;
			this.y = y;
			this.length = length;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.length - o.length > 0)
				return 1;
			else if(this.length-o.length<0)
				return -1;
			else
				return 0;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i = 0; i<=N; i++)
			parent[i] = i;
		

		int[][] god = new int[N+1][2];
		
		for(int i = 0;i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			god[i+1][0] = x;
			god[i+1][1] = y;
		}

		
		for(int i = 0; i<M; i++) {
			int point1 = sc.nextInt();
			int point2 = sc.nextInt();
			
			union(point1, point2);
		}
		
		
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 1; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				pq.offer(new Node(i,j,Math.sqrt(Math.pow(god[i][0]-god[j][0],2)
												+Math.pow(god[i][1]-god[j][1],2))));
			}
		}
		
		while(!pq.isEmpty()) {
			Node t = pq.poll();
//			System.out.println(t.x+" "+t.y+" "+t.length);
			if(union(t.x, t.y)) {
				answer += t.length;
			}
		}
		
//		System.out.println(answer);
		System.out.printf("%.2f",answer);
		
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b)
			return false;
		else {
			parent[b] = a;
			return true;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

}
