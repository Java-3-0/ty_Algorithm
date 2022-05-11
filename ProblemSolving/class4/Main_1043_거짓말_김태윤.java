package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//메모리 : 11880kb
//시간 : 80ms

public class Main_1043_거짓말_김태윤 {

	static boolean relationship[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		relationship = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());

		Set<Integer> truth = new HashSet<Integer>();
		Queue<Integer> q = new ArrayDeque<Integer>();

//		int truth[] = new int[Integer.parseInt(st.nextToken())];

		int num = Integer.parseInt(st.nextToken());

		for (int i = 0; i < num; i++) {
			int temp = Integer.parseInt(st.nextToken());
			truth.add(temp);
			q.offer(temp);
		}

		ArrayList<Integer> party[] = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			num = Integer.parseInt(st.nextToken());
			
			party[i] = new ArrayList<Integer>();
			for (int j = 0; j < num; j++) {
				
				party[i].add(Integer.parseInt(st.nextToken()));
			}

			make_relationship(party[i]);
		}

		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 1; i<N+1; i++) {
				if(relationship[temp][i] && !truth.contains(i)) {
					truth.add(i);
					q.offer(i);
				}
			}
		}

		int answer = 0;
		for(int i = 0; i<M; i++) {
			boolean isKnowing = false;
			for(int j = 0; j<party[i].size(); j++) {
				if(truth.contains(party[i].get(j)))
					isKnowing = true;
			}
			if(!isKnowing)
				answer++;
		}
		
		System.out.println(answer);

	}

	static void make_relationship(ArrayList<Integer> party) {

		int[] arr = new int[party.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = party.get(i);

		for (int i = 0; i < party.size(); i++) {
			for (int j = 0; j < party.size(); j++) {
				relationship[arr[i]][arr[j]] = true;
			}
		}

	}

}
