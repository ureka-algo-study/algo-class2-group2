import java.util.*;

class Solution {
    class Edge{
        int w;
        int v;
        Edge(int v, int w){
            this.w = w;
            this.v = v;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        ArrayList<Edge>[] edges = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        
        
        for(int[] fare : fares){
            int nodea = fare[0];
            int nodeb = fare[1];
            int w = fare[2];
            
            edges[nodea].add(new Edge(nodeb,w));
            edges[nodeb].add(new Edge(nodea,w));
        }
        
        int[] startNode = {s, a, b};
        int[][] dist = new int[3][n+1];
        for(int idx=0; idx<startNode.length; idx++){
            int start = startNode[idx];
            
            Arrays.fill(dist[idx], 987654321);
        
            int cur = start;
            dist[idx][cur] = 0;
            boolean[] visited = new boolean[n+1];
            for(int cnt=0; cnt<n; cnt++){
                visited[cur] = true;

                for(Edge edge: edges[cur]){
                    if(visited[edge.v]) continue;

                    dist[idx][edge.v] = Math.min(dist[idx][edge.v], dist[idx][cur] + edge.w);

                }

                int next = 0;
                for(int i=1; i<=n; i++){
                    if(visited[i]) continue;
                    next = dist[idx][next] > dist[idx][i] ? i : next;

                }
                if(dist[idx][next] == 987654321){
                    next = 1;
                };
                cur = next;

            }
        }
        
        answer = 987654321;
        for(int i=1; i<=n; i++){
            int sum = 0 ;
            for(int j=0; j<startNode.length; j++){
                if(dist[j][i] == 987654321) continue;
                sum += dist[j][i];
            }
            if(sum == 0) continue;
            answer = Math.min(sum, answer);
        }
        
        return answer;
        
    }
}