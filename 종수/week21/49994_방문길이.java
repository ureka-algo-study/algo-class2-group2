package 종수.week21;

import java.util.*;


class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;

        Set<String> visited = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'R') nx++;
            else if (dir == 'L') nx--;

            // 범위 벗어나면 이동 자체를 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 양방향을 같은 길로 처리하기 위해 둘 다 저장
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            visited.add(path1);
            visited.add(path2);

            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }
}