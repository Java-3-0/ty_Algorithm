package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 : 134328kb
//시간 : 1540ms

public class Main_1202_보석_도둑_김태윤 {

	static class Jewelry implements Comparable<Jewelry> {
		int m;
		int v;

		public Jewelry(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return o.v - this.v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Jewelry> jewelry = new ArrayList<Jewelry>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewelry.add(new Jewelry(M, V));
		}

		Collections.sort(jewelry, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o1.m - o2.m;
			}
		});

		PriorityQueue<Integer> bags = new PriorityQueue<Integer>();

		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine());
			bags.offer(C);
		}

		long answer = 0l;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int i = 0;
		while (!bags.isEmpty()) {
			int bag = bags.poll();

			while (i < N && jewelry.get(i).m <= bag) {
				pq.offer(-1 * jewelry.get(i++).v);
			}

			if (!pq.isEmpty())
				answer += -1 * pq.poll();
		}

		System.out.println(answer);

	}

}
