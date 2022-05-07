package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11720_숫자의_합_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		char[] arr = br.readLine().toCharArray();
		
		for(int i = 0; i<N; i++) {
			answer += arr[i]-'0'; 
		}
		System.out.println(answer);
	}

}
