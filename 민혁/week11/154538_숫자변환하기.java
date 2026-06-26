import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // +n / *2 /*3
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        q.add(new int[]{x,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
            
            // if(cur[0] > y) {
            //     continue;
            // }
            
            if(cur[0] == y) {
                return cur[1];
            }
            
            if (cur[0] * 2 <= y && !visited[cur[0] * 2]) {
                q.add(new int[]{cur[0] * 2, cur[1] + 1});
            }
            if (cur[0] * 3 <= y && !visited[cur[0] * 3]) {
                q.add(new int[]{cur[0] * 3, cur[1] + 1});
            }
            if (cur[0] + n <= y && !visited[cur[0] + n]) {
                q.add(new int[]{cur[0] + n, cur[1] + 1});
            }
            
            // q.add(new int[]{cur[0] * 3, cur[1] + 1});
            // q.add(new int[]{cur[0] * 2, cur[1] + 1});
            // q.add(new int[]{cur[0] + n, cur[1] + 1});
            
        }
        
        return -1;
    }
}
