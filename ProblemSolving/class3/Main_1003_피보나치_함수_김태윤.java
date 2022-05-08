package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1003_피보나치_함수_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int arr[][] = new int[41][2];
		arr[0] = new int[] {1,0};
		arr[1] = new int[] {0,1};
		for(int i = 2; i<41; i++) {
			arr[i] = new int[] {arr[i-1][0]+arr[i-2][0], arr[i-1][1]+arr[i-2][1]};
		}
		
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[n][0]+" "+arr[n][1]);
		}
	}

}
