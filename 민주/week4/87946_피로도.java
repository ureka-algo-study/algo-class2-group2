import java.util.*;

class Solution {
    int[] permu;
    boolean[] selected;
    int N;
    int k;
    int max = 0;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.k = k;
        N = dungeons.length;
        this.dungeons = dungeons;
        permu = new int[N];
        selected = new boolean[N];
        permutation(0);
        return max;
    }
    
    void permutation(int n){
        if(n >= N){
            
            // System.out.println(Arrays.toString(permu) + " : " + max + " , " + hp());
            max = Math.max(hp(), max);
            return;
        }
        for(int i=0; i<N; i++){
            if(selected[i]) continue;
            selected[i] = true;
            permu[n] = i;
            permutation(n+1);
            selected[i] = false;
        }
    }
    
    int hp(){
        int hp = k;
        int cnt  = 0;
        for(int i=0; i<N; i++){
            if(dungeons[permu[i]][0] > hp){
                return cnt;
            }
            cnt++;
            hp -= dungeons[permu[i]][1];
        }
        return cnt;
    }
}