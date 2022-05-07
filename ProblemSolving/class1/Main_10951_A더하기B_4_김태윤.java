package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10951_A더하기B_4_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String str;
		while((str=br.readLine()) != null  ){
			st = new StringTokenizer(str);
			
			System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
		}
	}

}
