package algo_ex;

public class Main_프로그래머스_도둑질_김태윤 {

	static class Solution {
		public int solution(int[] money) {
			int answer = 0;
			
			if(money.length == 3)
				return Math.max(money[0], Math.max(money[1], money[2]));
			
			//첫 집 턴다
			int[] dp = new int[money.length];
			dp[0] = money[0];
			dp[1] = money[1];
			dp[2] = money[0]+money[2];
			for(int i = 3; i<money.length-1; i++) {
				dp[i] = Math.max(dp[i-3] + money[i], dp[i-2] + money[i]);
			}
			answer = Math.max(dp[money.length-2], dp[money.length-3]);
			
			//첫 집 안 턴다
			dp = new int[money.length];
			dp[1] = money[1];
			dp[2] = money[2];

			for(int i = 3; i<money.length; i++) {
				dp[i] = Math.max(dp[i-3] + money[i], dp[i-2] + money[i]);
			}
			answer = Math.max(answer, Math.max(dp[money.length-1], dp[money.length-2]));
			
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sss = new Solution();

		int[] money = { 1, 2, 3, 1 };
		System.out.println(sss.solution(money));
	}

}
