package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 : 40628kb
//시간 : 488ms

public class Main_16471_작은_수_내기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq_me = new PriorityQueue<Integer>();
		for(int i = 0; i<N; i++) {
			pq_me.add(Integer.parseInt(st.nextToken()));
		}
		
		PriorityQueue<Integer> pq_sajang = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			pq_sajang.add(Integer.parseInt(st.nextToken()));
		}
		
		
		int cnt = 0;
		while(!pq_me.isEmpty() && !pq_sajang.isEmpty()) {
			int jueon = pq_me.peek();
			int sajang = pq_sajang.peek();
			
			if(jueon < sajang) {
				cnt++;
				pq_me.poll();
			}
			pq_sajang.poll();
		}
		
		if(cnt >= (N+1)/2)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
