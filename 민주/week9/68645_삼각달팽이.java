import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        
        int[][] arr = new int[n][n];
        
        // int nn = n;
        int cnt = 0;
        
        int dx = 0;
        int[] di = {1, 0, -1}; // D R U L
        int[] dj = {0, 1, -1};
        int i = 0;
        int j = 0;
        
        for(int idx=1; idx<=n * (n+1)/2; idx++){
            arr[i][j] = idx;
            cnt++;
            
            if(cnt>=(n-dx)){
                dx++;
                cnt=0;
            }
            
            i += di[dx % 3];
            j += dj[dx % 3];
            
        }
        
        // for(int k=0; k<n; k++){
        //     System.out.println(Arrays.toString(arr[k]));
        // }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(arr[x][y] == 0) continue;
                ans.add(arr[x][y]);
            }
        }
        
        answer = ans.stream().mapToInt(k->k).toArray();
        
        return answer;
    }
}