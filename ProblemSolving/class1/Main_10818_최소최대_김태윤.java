package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10818_최소최대_김태윤 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int min = 1000001;
		int max = -1000001;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		
		System.out.println(min+" "+max);

	}

}
