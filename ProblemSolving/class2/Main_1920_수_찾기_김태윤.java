package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1920_수_찾기_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		Set<Integer> set = new HashSet<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

}
