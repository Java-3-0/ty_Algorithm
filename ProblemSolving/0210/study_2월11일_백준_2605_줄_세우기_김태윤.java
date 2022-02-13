package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class study_2월11일_백준_2605_줄_세우기_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		for(int i = 1; i<=N; i++) {
			int priority = Integer.parseInt(st.nextToken());
			ll.add(priority, i);
		}
		
		for(int i = ll.size()-1; i>=0; i--) {
			System.out.print(ll.get(i)+" ");
		}
		
	}

}
