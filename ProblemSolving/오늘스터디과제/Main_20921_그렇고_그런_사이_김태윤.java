package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//메모리 : 13800kb
//시간 : 184ms

public class Main_20921_그렇고_그런_사이_김태윤 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i =0; i<N; i++) {
			arr.add(i+1);
		}
		
		
		int val = N-1;
		while(val!=0 && K>=val) {
			K-=val--;
			answer.add(arr.remove(arr.size()-1));
		}
		
		if(K!=0) {
			arr.add(arr.size()-1-K, arr.remove(arr.size()-1));
		}
		
		for(int i = 0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+" ");
		}
		for(int i = 0; i<arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
	}

}
