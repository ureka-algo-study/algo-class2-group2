import java.util.*;

class Solution {
    public int solution(int storey) {
        /*
        버림을 해야 빠를까 올림을 해야 빠를까
        0~4 -> 내림 
        5 앞자리 확인
        6~9 -> 올림
         int storey -> String storey -> character[] storey 
        */
        
//         String stringStorey = String.valueOf(storey);
//         char[] charStorey = stringStorey.toCharArray();
        
        
        
//         for(int i = charStorey.length - 1; i >= 0; i --) {
            
//             int cur = charStorey[i] - '0';
            
//             if(i == 0) {
//                 answer += cur;
//                 break;
//             }
            
//             if(cur >= 0 && cur < 5) {
//                 answer += cur;
//             } else if(cur >= 6 && cur <= 9) {
//                 answer += (10 - cur);
//                 charStorey[i - 1] = (char) (charStorey[i - 1] - '0' + 1) + '0'); //  한자리 올림
//             } 
//             else {
//                 answer += 5;
//                 if(charStorey[i - 1] >= '5') {
//                     charStorey[i - 1] = (char) ((charStorey[i - 1] - '0' + 1) + '0');//  한자리 올림
//                 }
//             }
//             System.out.println(answer);
//         
        int answer = 0;
        
        while(storey > 0) {
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            
            if(cur < 5) {
                answer += cur;
            } else if(cur > 5) {
                answer += 10 - cur;
                storey += 10;
            } else {
                answer += 5;
                
                if(next % 10 >= 5) {
                    storey += 10;
                }
                
            }
            
            storey /= 10;
        }
        return answer;
        
        
    }
}
