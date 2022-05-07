package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2562_최댓값_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int idx = -1;
		int max_val = 0;
		
		for(int i = 0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(max_val<num) {
				idx = i+1;
				max_val = num;
			}
		}
		System.out.println(max_val);
		System.out.println(idx);
		

	}

}
