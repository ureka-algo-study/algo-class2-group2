import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int idx = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int cur=1; cur<=order.length; cur++){
            if(idx >= order.length){
                return answer;
            }
            
            while(!stk.isEmpty() && stk.peek() == order[idx]){
                
                stk.pop();
                // System.out.println("pop: " + order[idx]);
                answer++;
                idx++;
                // System.out.println("next: " + order[idx]);
            }
            
            if(cur == order[idx]){
                // System.out.println("add: " + order[idx]);
                idx++;
                
                // System.out.println("next: " + order[idx]);
                answer++;
                
            }
            else{
                // System.out.println("push: " + cur);
                stk.push(cur);
            }
            
            
        } // for
        
        while(idx < order.length && !stk.isEmpty() && stk.peek() == order[idx]){

            stk.pop();
            answer++;
            idx++;
        }
        
        return answer;
    }
}