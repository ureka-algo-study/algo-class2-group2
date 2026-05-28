import java.util.*;

class Solution {
    ArrayList<Integer>[] edges;
    int count;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = 987654321;
        
        for(int idx=0; idx<wires.length; idx++){
            
            edges = new ArrayList[n+1];
        
            for(int i=1; i<=n; i++){
                edges[i] = new ArrayList<>();
            }
            
            for(int i=0; i<wires.length; i++){
                if(i==idx) continue;
                edges[wires[i][0]].add(wires[i][1]);
                edges[wires[i][1]].add(wires[i][0]);
            }
            
            visited = new boolean[n+1];
            count = 0;
            
            dfs(1);
            
            int diff = n - count;
            answer = Math.min(answer, Math.abs(count - diff));
            
        }
        return answer;
    }
    
    void dfs(int n){
        visited[n] = true;
        count ++;
        
        for(int next : edges[n]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}