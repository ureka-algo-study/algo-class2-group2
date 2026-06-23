class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 시작점
        int curR = 0;
        int curC = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    curR = i;
                    curC = j;
                }
            }
        }// 시작점 찾기

        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0); //이동방향
            int move = Integer.parseInt(String.valueOf(routes[i].charAt(2))); //이동할 거리

            int nextR = curR;
            int nextC = curC;
            boolean canMove = true;

            for (int j = 0; j < move; j++) {
                switch (direction) {
                    case 'N':
                        nextR--;
                        break;

                    case 'S':
                        nextR++;
                        break;

                    case 'W':
                        nextC--;
                        break;

                    case 'E':
                        nextC++;
                        break;
                }

                if (nextR < 0 || nextR >= park.length ||
                        nextC < 0 || nextC >= park[0].length() ||
                        park[nextR].charAt(nextC) == 'X') {

                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                curR = nextR;
                curC = nextC;
            }
        }

        return new int[] {curR, curC};
    }
}