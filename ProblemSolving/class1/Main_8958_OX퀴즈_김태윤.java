package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8958_OX퀴즈_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			int answer = 0;
			int score = 0;
			for(int j = 0; j<arr.length; j++) {
				if(arr[j] == 'O') {
					score++;
					answer+=score;
				}else {
					score = 0;
				}
			}
			System.out.println(answer);
		}

	}

}
