import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i=numbers.length-1; i>=0; i--){
            if(stk.isEmpty()){
                answer[i] = -1;
                stk.push(numbers[i]);
                continue;
            }
            
            while(!stk.isEmpty() && stk.peek() <= numbers[i]){
                int p = stk.pop();
            } //while
            
            if(stk.isEmpty()){
                answer[i] = -1;
            }
            else{
                answer[i] = stk.peek();
            }
            stk.push(numbers[i]);
        }
        return answer;
    }
}