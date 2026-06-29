import java.util.*;


class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, 987654321);
        
        dp[x] = 0;
        
        for(int i=x; i<=y; i++){
            if(dp[i] == 987654321) continue;
            
            if(i+n <= y){
                dp[i+n] = Math.min(dp[i] + 1, dp[i+n]);
            }
            
            if(i * 2 <= y){
                dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
            }
            if(i*3 <= y){
                dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
            }
        }
        return (dp[y] == 987654321) ? -1 : dp[y] ;
    }
}