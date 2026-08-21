import java.util.*;


class Solution {
    int n;
    int[] info;
    int maxScore = 0;
    int[] answer;
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        
        answer = new int[info.length];
        
        dfs(0, n, new int[11]);
        
        if (maxScore <= 0){
            return new int[] {-1};
        }
        return answer;
    }
    
    boolean isBetter(int[] ryan){
        for(int i=10; i>=0; i--){
            if(ryan[i] > answer[i]){
                return true;
            }
            else if(ryan[i] < answer[i]){
                return false;
            }
        }
        return false;
    }
    
    void dfs(int idx, int remain, int[] ryan){
        if(idx == 11){
            
            ryan[10] += remain;
            
            int score_r = 0;
            int score_a = 0;
            
            for(int i=0; i<11; i++){
                if(ryan[i] > info[i]){
                    score_r += (10-i);
                }
                else if(info[i] > 0 ){
                    score_a += (10-i);
                }
            } // for
            
            int diff = score_r - score_a;
            if(diff > maxScore){
                maxScore = diff;
                answer = ryan.clone();
            }
            else if(diff == maxScore && isBetter(ryan)){
                answer = ryan.clone();
            }
            
            ryan[10] -= remain;
            return;
        }
        
        if(remain >= info[idx]+1){
            ryan[idx] = info[idx] + 1;
            dfs(idx+1, remain - (info[idx] + 1), ryan);
        
            ryan[idx] = 0;
        }
        
        
        
        dfs(idx+1, remain, ryan);
        
    }
}