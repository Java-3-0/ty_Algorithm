package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4153_직각삼각형_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[3];
			arr[0] =Integer.parseInt(st.nextToken());
			arr[1] =Integer.parseInt(st.nextToken());
			arr[2] =Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			
			if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1])
				System.out.println("right");
			else
				System.out.println("wrong");
		}
		 
	}

}
