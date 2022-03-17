package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

//메모리 : 15076kb
//시간 : 140ms

public class Main_17471_게리맨더링_김태윤 {

	static int N, total, answer;
	static ArrayList<HashSet<Integer>> arr;
	static int[] people;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		total = 0;
		answer = Integer.MAX_VALUE;
		
		people = new int[N];
		for(int i = 0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}
		
		arr = new ArrayList<HashSet<Integer>>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new HashSet<Integer>());
			
			int length = Integer.parseInt(st.nextToken());
			for(int j = 0; j<length; j++) {
				arr.get(i).add(Integer.parseInt(st.nextToken())-1);
				
			}
		}
		
		for(int i = 0; i<N/2; i++) {
			int[] comb = new int[i+1];
			make_combination(0,0,i+1, comb);
		}
		
		if(answer == Integer.MAX_VALUE)
			answer=-1;
		
		System.out.println(answer);
	}
	
	static void make_combination(int start, int cnt, int total_cnt, int[] comb) {
		if(cnt == total_cnt) {			
			calc(comb, total_cnt);
			return;
		}
		
		for(int i = start; i<N; i++) {
			comb[cnt] = i;
			make_combination(i+1, cnt+1, total_cnt, comb);
		}
	}
	
	static void calc(int[] comb, int total_cnt) {
		int[] opp_comb = new int[N-total_cnt];
		
		int j = 0, k = 0;
		for(int i = 0; i<N; i++) {
			if(k == opp_comb.length) break;
			
			if(j == comb.length) {
				opp_comb[k++] = i;
				continue;
			}
			if(comb[j] != i)
				opp_comb[k++] = i;
			else
				j++;
		}
		
		HashSet<Integer> s1 = new HashSet<Integer>();
		for(int i = 0; i<comb.length; i++) {
			s1.add(comb[i]);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(comb[0]);
		s1.remove(comb[0]);
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i : arr.get(temp)) {
				if(s1.contains(i)) {
					s1.remove(i);
					q.offer(i);
				}
			}		
		}
		
		if(s1.size() != 0)
			return;
		
		
		
		HashSet<Integer> s2 = new HashSet<Integer>();
		for(int i = 0; i<opp_comb.length; i++) {
			s2.add(opp_comb[i]);
		}
		Queue<Integer> q2 = new LinkedList<Integer>();
		q2.offer(opp_comb[0]);
		s2.remove(opp_comb[0]);
		while(!q2.isEmpty()) {
			int temp = q2.poll();
			for(int i : arr.get(temp)) {
				if(s2.contains(i)) {
					s2.remove(i);
					q2.offer(i);
				}
			}		
		}
		
		if(s2.size() != 0)
			return;
		
		int sum = 0;
		
		for(int i = 0; i<comb.length; i++)
			sum+=people[comb[i]];
		
		answer = Math.min(answer, Math.abs(total-sum*2));
	}
}