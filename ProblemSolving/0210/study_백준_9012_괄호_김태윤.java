package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_백준_9012_괄호_김태윤 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			String s = br.readLine();
			int cnt = 0;
			for(int j = 0; j<s.length(); j++) {
				if(s.charAt(j) == '(') cnt++;
				else cnt--;
				
				if(cnt<0)
					break;
			}
			
			if(cnt==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
