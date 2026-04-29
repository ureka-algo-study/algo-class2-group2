package 종수.week3;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        //방향 배열
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        int dist[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];

        Queue<int []> queue = new ArrayDeque<>();

        queue.offer(new int[]{0,0});

        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()){

            int now[] = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 가려는 길이
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 맵 밖이라면
                if(maps[nx][ny] == 0) continue; // 벽이라면 (0 이면 벽)
                if(visited[nx][ny] == true) continue; //방문을 했었다면

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

                queue.offer(new int[]{nx,ny});

            }

        }

        if (dist[n-1][m-1] == 0){
            answer = -1;
        }else{
            answer = dist[n-1][m-1];
        }
        


        return answer;
    }
}

//참고한 수도 코드
/* 
입력: maps (2차원 배열)

n = 행 길이
m = 열 길이

방향 배열:
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

dist[n][m] 생성 (거리 저장)
visited[n][m] 생성

큐 생성

시작점:
queue에 (0,0) 넣기
visited[0][0] = true
dist[0][0] = 1

while 큐가 비어있지 않으면:

    현재 좌표 (x, y) = queue.poll()

    for 방향 4개 반복:

        nx = x + dx[i]
        ny = y + dy[i]

        if 범위 밖이면 continue

        if maps[nx][ny] == 0 이면 continue  // 벽

        if visited[nx][ny] == true 이면 continue

        visited[nx][ny] = true
        dist[nx][ny] = dist[x][y] + 1

        queue에 (nx, ny) 추가

끝나고:

if dist[n-1][m-1] == 0:
    return -1   // 도착 못함
else:
    return dist[n-1][m-1]
    */