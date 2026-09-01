class Solution {
    int cnt = 0;
    int answer = 0;
    String word;
    public int solution(String word) {
        this.word = word;
        dfs("");
        
        return answer;
    }
    
    void dfs(String str){
        // System.out.println(str);
        if(str.equals(word)){
            answer = cnt;
            return ;
        }
        if(str.length() >= 5){
            return;
        }
        cnt++;
        dfs(str+"A");
        cnt++;
        dfs(str+"E");
        cnt++;
        dfs(str+"I");
        cnt++;
        dfs(str+"O");
        cnt++;
        dfs(str+"U");
    }
}