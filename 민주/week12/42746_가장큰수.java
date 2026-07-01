import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] str = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            str[i] = numbers[i] + "";
        }
        
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        // System.out.println(Arrays.toString(str));
        if(str[0].equals("0")) return "0";
        
        for(int i=0; i<str.length; i++){
            answer += str[i];
        }
        
        return answer;
    }
}