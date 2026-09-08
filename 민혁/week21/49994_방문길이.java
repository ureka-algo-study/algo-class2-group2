class Solution {
    public int solution(String dirs) {
        /*
        visited true -> true 면 이미 걸었던길 + 방향도 알아야함
        position을 가질까?
        visited 만들기
        */
        
        int[] current = new int[] {0,0};
        boolean[][][] visited = new boolean[11][11][4];
        
        int[] reverse = new int[] {1,0,3,2};
        
        int count = 0;
        
        
        for(int i = 0; i < dirs.length(); i ++) {
            int[] next = new int[] {current[0], current[1]};
            int direction;
            
            if(dirs.charAt(i) == 'U') {
                direction = 0;
                next = new int[] {next[0], next[1] + 1};
            } else if(dirs.charAt(i) == 'D') {
                direction = 1;
                next = new int[] {next[0], next[1] - 1};
            } else if(dirs.charAt(i) == 'R') {
                direction = 2;
                next = new int[] {next[0] + 1, next[1]};
            } else {
                direction = 3;
                next = new int[] {next[0] - 1, next[1]};
            }
            
            if(next[0] > 5 || next[0] < -5 || next[1] > 5 || next[1] < -5) {
                continue;
            }
            
            if(!visited[current[0] + 5][current[1] + 5][direction]) {
                count++;
                
                visited[current[0] + 5][current[1] + 5][direction] = true;
                visited[next[0] + 5][next[1] + 5][reverse[direction]] = true;
            }
            current = next;
        }
        
        return count;
    
        
        
        
    }
}
