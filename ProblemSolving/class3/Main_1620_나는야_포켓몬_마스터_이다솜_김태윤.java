package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야_포켓몬_마스터_이다솜_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> s_i = new HashMap<String, Integer>();
		Map<Integer, String> i_s = new HashMap<Integer, String>();
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			s_i.put(temp, i);
			i_s.put(i, temp);
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9')
				System.out.println(i_s.get(Integer.parseInt(temp)));
			else
				System.out.println(s_i.get(temp));
		}
	}
}