class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        //=======게임 참가자 수 n, a번 참가자와 b번 참가자는 몇번째 라운드에서 만나게 될까?==

        while(!(a==b)) {
            if(a % 2 == 0) {
                a /= 2;
            } else {
                a = a / 2 + 1;
            }

            if(b % 2 == 0) {
                b /= 2;
            } else {
                b = b / 2 + 1;
            }

            answer++;
        }

        return answer;
    }
}