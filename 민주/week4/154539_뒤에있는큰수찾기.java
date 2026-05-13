import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--){
            if(stk.isEmpty()){
                answer[i] = -1;
            }
            else{
                while(!stk.isEmpty() && stk.peek() <= numbers[i]){
                    int pop = stk.pop();
                }
                answer[i] = stk.isEmpty()? -1 : stk.peek();
            }
            stk.push(numbers[i]);
        }
        
        return answer;
    }
}