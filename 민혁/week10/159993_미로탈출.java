import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int row = maps.length;
        int column = maps[0].length();

        int count = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        int[] s = null;
        int[] e = null;
        int[] l = null;

        boolean[][] visited = new boolean[row][column];

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < column; j ++) {
                if(maps[i].charAt(j) == 'S') {
                    s = new int[] {i,j};
                }

                if(maps[i].charAt(j) == 'E') {
                    e = new int[] {i,j};
                }

                if(maps[i].charAt(j) == 'L') {
                    l = new int[] {i,j};
                }
            }
        } //for

        q.add(new int[] {s[0],s[1],0});
        visited[s[0]][s[1]] = true;
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];

            if(maps[curR].charAt(curC) == 'L') {
                count += dist;
            }

            for(int i = 0; i < 4; i ++) {
                int nextR = curR + dx[i];
                int nextC = curC + dy[i];

                if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= column) {
                    continue;
                }

                if(maps[nextR].charAt(nextC) == 'X' || visited[nextR][nextC]) {
                    continue;
                }
                visited[nextR][nextC] = true;
                q.offer(new int[] {nextR,nextC, dist+1});
            } //for
        } //while

        if(!visited[l[0]][l[1]]) {
            return -1;
        }

        visited = new boolean[row][column];

        q.add(new int[] {l[0],l[1],0});
        visited[l[0]][l[1]] = true;
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];

            if(maps[curR].charAt(curC) == 'E') {
                count += dist;
                return count;
            }

            for(int i = 0; i < 4; i ++) {
                int nextR = curR + dx[i];
                int nextC = curC + dy[i];

                if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= column) {
                    continue;
                }
                if(maps[nextR].charAt(nextC) == 'X' || visited[nextR][nextC]) {
                    continue;
                }
                visited[nextR][nextC] = true;
                q.offer(new int[] {nextR,nextC, dist+1});
            } //for
        } //while

        return -1;

    }
}