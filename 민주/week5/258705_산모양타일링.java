import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp3 = new int[n];
        int[] dp2 = new int[n];
        final int MOD = 10007;
        
        dp3[0] = (tops[0] == 1? 3 : 2);
        dp2[0] = 1;
        
        for(int i=1; i<n; i++){
            if(tops[i] == 1){
                dp3[i] = (dp3[i-1] * 3 + dp2[i-1] * 2) % MOD;
            }
            else{
                dp3[i] = (dp3[i-1] * 2 + dp2[i-1]) % MOD;
            }
            dp2[i] = (dp3[i-1] + dp2[i-1]) % MOD;
        }
        return (dp3[n-1] + dp2[n-1]) % MOD;
    }
}