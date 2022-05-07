package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_문자열_반복_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int recur = Integer.parseInt(st.nextToken()); 
			char[] S = st.nextToken().toCharArray();
			for(int j = 0; j<S.length; j++) {
				for(int k = 0; k<recur; k++) {
					System.out.print(S[j]);
				}
			}
			System.out.println();
		}

	}

}
