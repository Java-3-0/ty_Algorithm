package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//메모리 : 16592kb
//시간 : 136ms

public class Main_5567_결혼식_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		boolean arr[][] = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = true;
			arr[b][a] = true;
		}


		HashSet<Integer> set = new HashSet<Integer>();
		
		set.add(1);
		for (int i = 0; i < n + 1; i++) {
			if (arr[1][i]) {
				set.add(i);
				for(int j = 0; j<n+1; j++) {
					if(arr[i][j])
						set.add(j);
				}
			}
		}
		
//		System.out.println();

//		for (int t : set)
//			System.out.println(t);
		System.out.println(set.size()-1);
	}

}
