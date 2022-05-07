package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920_음계_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[8];
		for(int i = 0; i<8; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		boolean isAscending = false;
		boolean isDescending = false;
		
		int i = 0;
		for(; i<8; i++) {
			if(arr[i] != i+1)
				break;
		}
		
		if(i==8)
			isAscending = true;
		
		i = 0;
		for(; i<8; i++) {
			if(arr[i] != 8-i)
				break;
		}
		
		if(i==8)
			isDescending = true;
		
		if(isAscending)
			System.out.println("ascending");
		else if(isDescending)
			System.out.println("descending");
		else
			System.out.println("mixed");
		
		
	}

}
