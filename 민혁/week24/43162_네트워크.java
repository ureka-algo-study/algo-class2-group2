import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        /*
        모든 컴퓨터는 기본적으로 자기자신과 연결되어 있음 -> 0은 자기자신과 연결되어있는 상태로 당연히 시작
        computers[][] check
        
        -> checked[] boolean 
        queue 생성 
        인접한 노드 offer -> if q.isEmpty() -> count ++
        1 1 0
        1 1 0
        0 0 1
        */
        int count = 0;
        boolean[] checked = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int a = 0; a < n; a ++) {
            
            if(checked[a]) continue;
            
            q.add(a);
            count++;
            
            while(!q.isEmpty()) {
                
                int current = q.poll(); // 0을 꺼냄
                
                if(!checked[current]) { // 0은 아직 확인 안함
                    checked[current] = true;
                    for(int i = 0; i < n; i ++) {
                        if(computers[current][i] == 1) { // 0이랑 연결된 모든 노드들 가져다가 q에 넣기
                            q.add(i);
                        }
                    }
                } 
             }
        }
        return count;
    } // solution 
} // class
