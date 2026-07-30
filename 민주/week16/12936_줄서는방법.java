import java.util.*;


class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] fact = new long[n+1];
        ArrayList<Integer> list = new ArrayList<>();
        
        fact[0] = 1;
        for(int i=1; i<=n ; i++){
            fact[i] = i * fact[i-1];
            list.add(i);
        }
        
        k--;
        
        for(int i=0; i<n; i++){
            long groupSize = fact[n-1-i];
            int idx = (int) (k/groupSize);
            
            answer[i] = list.get(idx);
            list.remove(idx);
            
            k %= groupSize;
        }
        
        return answer;
    }
}