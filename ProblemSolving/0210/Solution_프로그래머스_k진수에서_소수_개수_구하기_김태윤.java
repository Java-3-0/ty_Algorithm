package algo_ex;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
		
        ArrayList<Long> arr = getNum(ten_to_N(n,k));
		
        //getNum 말고 new StringTokenizer(s,"0") 하면 더욱 편하다.
        
		for(long num : arr)
			if(isPrime(num)) answer++;
		
		return answer;
    }
    
    boolean isPrime(long num) {
    	if(num==1)
    		return false;
    	
    	long sqrt_num = (long)Math.sqrt(num);
    	for(long i = 2; i<=sqrt_num; i++)
    		if(num%i == 0) return false;
    	
    	return true;
    }
	
	String ten_to_N(int n, int k) {
		StringBuffer sb = new StringBuffer();
		
		while(n!=0) {
			sb.append(n%k);
			n/=k;
		}
		
		sb.reverse();
		return sb.toString();
	}
	
	ArrayList<Long> getNum(String s) {
		
		ArrayList<Long> arr = new ArrayList<Long>();
		
		char[] temp = s.toCharArray();
		
		boolean isNumber = false;
		
		//자르기 시작할 위치
		int idx = -1;
		if(temp[0] != '0') {
			isNumber = true;
			idx = 0;
		}
		
		for(int i = 1; i<temp.length; i++) {
			if(isNumber) { //숫자를 세는 중 이라면
				if(temp[i] == '0') {
					arr.add(Long.parseLong(s.substring(idx, i)));
					isNumber = false;
				}else if(i == temp.length-1){
					arr.add(Long.parseLong(s.substring(idx)));
				}
			}else { //숫자를 세는 중이 아니라면(0을 항해 중)
				if(temp[i] != '0') {
                    
					isNumber = true;
					idx = i;
                    if(i == temp.length-1){
					    arr.add(Long.parseLong(s.substring(idx)));
                    }
				}
			}
		}
        
        if(temp.length == 1 && isNumber)
            arr.add(Long.parseLong(s));
        
		return arr;
	}
}