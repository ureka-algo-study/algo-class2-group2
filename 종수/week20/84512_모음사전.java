package 종수.week20;

class Solution {
    public int solution(String word) {
        int answer = 0;

        String m = "AEIOU";
        int[] g = {781, 156, 31, 6, 1};
        //   aaaaa
        for(int i = 0; i < word.length(); i++){
            
            int k = 0;
            for (int j = 0; j < m.length(); j++) {
                if (m.charAt(j) == word.charAt(i)) {
                    k = m.indexOf(m.charAt(j));
                }
            }
            answer += k * g[i] + 1;
        }
        return answer;
    }
}