package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//메모리 : 16000kb
//시간 : 108ms

public class Main_9251_LCS_김태윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();

		int[][] LCS = new int[s1.length + 1][s2.length + 1];

		for (int i = 1; i < s1.length + 1; i++) {
			for (int j = 1; j < s2.length + 1; j++) {

				if (s1[i - 1] == s2[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < LCS.length; i++) {
			System.out.println(Arrays.toString(LCS[i]));
		}

		System.out.println(LCS[s1.length][s2.length]);

	}

}
