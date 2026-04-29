import java.util.*;

class Solution {
    int[] numbers;
    int target;
    int answer;
    String[] oper;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        oper = new String[numbers.length];
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    void dfs(int sum, int idx){
        if(sum == target && idx == numbers.length){
            answer++;
            // System.out.println(Arrays.toString(oper));
            return;
        }
        if(idx >= numbers.length){
            return;
        }
        
        // oper[idx] = "+";
        dfs(sum+numbers[idx], idx+1);
        // oper[idx] = "-";
        dfs(sum-numbers[idx], idx+1);
        
    }
}