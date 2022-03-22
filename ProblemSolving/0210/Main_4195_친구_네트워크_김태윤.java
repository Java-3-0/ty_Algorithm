package algo_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

//미완
//시간초과
// 시간 : 
// 메모리 : 

public class Main_4195_친구_네트워크_김태윤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		

		int a = -1;
		int b = -1;
		
		for(int t = 1; t<=testcase; t++) {
			
			int F = Integer.parseInt(br.readLine());

			ArrayList<HashSet<String>> arr = new ArrayList<HashSet<String>>();
			
			for(int num = 0; num<F; num++) {

				a = -1;
				b = -1;
				
				st = new StringTokenizer(br.readLine());
				
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				
				for(int i = 0; i<arr.size(); i++) {
					if(arr.get(i).contains(s1)) {
						a = i;
						break;
					}
				}
				
				for(int i = 0; i<arr.size(); i++) {
					if(arr.get(i).contains(s2)) {
						b = i;
						break;
					}
				}
				
				if(a==-1 && b==-1) {
					arr.add(new HashSet<String>());
					arr.get(arr.size()-1).add(s1);
					arr.get(arr.size()-1).add(s2);
				}
				
				else if(a==-1) {
					arr.get(b).add(s1);
				}
				
				else if(b==-1) {				
					arr.get(a).add(s2);
				}
				
				else {
					if(a==b) {
						
					}else if(a<b) {
						for(String j : arr.get(b))
							arr.get(a).add(j);
						
						arr.remove(b);
					}else {
						
						for(String j : arr.get(a))
							arr.get(b).add(j);
						
						arr.remove(a);
					}
				}
				sb.append(arr.get(0).size());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
