package algo_ex;

public class Solution_프로그래머스_괄호_변환_김태윤 {
	
	public String solution(String p) {
        return func1(p);
    }
    
    public static String func1(String p){
        
        if(p.isEmpty())
            return p;
        
        return func2(p);
    }
    
    
    public static String func2(String p){
        int cnt = 0;
        
        int i = 0;
        for(; i<p.length(); i++){
            if(p.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            
            if(cnt==0)
                break;
        }
        
        String u = p.substring(0,i+1);
        String v = p.substring(i+1);
        
        if(p.charAt(0) == '(')
            return u.concat(func3(v));
        
        return func4(u,v);
    }
    
    public static String func3(String s){
        return func1(s);
    }

    public static String func4(String u, String v){
    	
        StringBuilder sb = new StringBuilder();
        
        sb.append("(").append(func1(v)).append(")");
        
        for(int i = 1; i<u.length()-1; i++){
            if(u.charAt(i) == ')')
                sb.append("(");
            else
                sb.append(")");
        }
        
        return sb.toString();
    }
}
