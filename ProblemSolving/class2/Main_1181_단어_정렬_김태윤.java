package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1181_단어_정렬_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		String[] str = new String[set.size()];
		int i = 0;
		for (String s : set) {
			str[i++] = s;
		}

		Arrays.sort(str, (x, y) -> y.length() == x.length() ? x.compareTo(y) : x.length() - y.length());
		
		for( i = 0; i<str.length; i++) {
			System.out.println(str[i]);
		}
	}

}
