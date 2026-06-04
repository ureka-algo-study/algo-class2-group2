import java.util.*;

class Solution {
    String[] words;
    String target;
    int answer;
    boolean[] isSelected;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        answer = 0;
        isSelected = new boolean[words.length];
        boolean exists = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                exists = true;
            }
        }
        
        if(!exists){
            return answer;
        }
        
        dfs(begin, 0);
        
        return answer;
    }
    
    void dfs(String now, int depth){
        if(now.equals(target)){
            answer = depth;
            return;
        }
        
        for(int i=0; i<words.length; i++){
            int cnt = 0;
            for(int j=0; j<now.length(); j++){
                if(now.charAt(j) != words[i].charAt(j)){
                    cnt++;
                }
            } // for
            
            if(cnt == 1 && !isSelected[i]){
                isSelected[i] = true;
                dfs(words[i], depth+1);
                isSelected[i] = false;
            }
        }
    }
}