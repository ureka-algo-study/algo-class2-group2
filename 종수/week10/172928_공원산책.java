package 종수.week10;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int w = park[0].length();
        int h = park.length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer = new int[] { j, i };
                }

            }
        }

        for (int i = 0; i < routes.length; i++) {

            char op = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';

            boolean canMove = true;

            if (op == 'E') {
                for (int j = 1; j <= n; j++) {
                    if (answer[0] + j >= w) {
                        canMove = false;
                        break;
                    }

                    if (park[answer[1]].charAt(answer[0] + j) == 'X') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove)
                    answer[0] += n;
            }

            else if (op == 'W') {
                for (int j = 1; j <= n; j++) {
                    if (answer[0] - j < 0) {
                        canMove = false;
                        break;
                    }

                    if (park[answer[1]].charAt(answer[0] - j) == 'X') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove)
                    answer[0] -= n;
            }

            else if (op == 'S') {
                for (int j = 1; j <= n; j++) {
                    if (answer[1] + j >= h) {
                        canMove = false;
                        break;
                    }

                    if (park[answer[1] + j].charAt(answer[0]) == 'X') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove)
                    answer[1] += n;
            }

            else if (op == 'N') {
                for (int j = 1; j <= n; j++) {
                    if (answer[1] - j < 0) {
                        canMove = false;
                        break;
                    }

                    if (park[answer[1] - j].charAt(answer[0]) == 'X') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove)
                    answer[1] -= n;
            }

        }

        return new int[]{answer[1], answer[0]};
    }
}