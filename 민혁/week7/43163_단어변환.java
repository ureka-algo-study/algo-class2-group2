import java.util.*;

class Solution {

    class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        // 변환 가능한 단어를 찾기
        Deque<Word> q = new ArrayDeque<>();

        q.offer(new Word(begin,0));

        while(!q.isEmpty()) {
            Word cur = q.poll();

            if(cur.word.equals(target)) {
                return cur.count;
            }

            //words를 보면서 방문하지 않았고 변환할수있으면 후보에 추가 추가하면서 방문처리
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canTransform(cur.word,words[i])) {
                    q.offer(new Word(words[i],cur.count + 1));
                    visited[i] = true;
                }
            }

        }

        return 0;


    }

    // 변환할수있는지 변환할수없는지 체크 (한글자만 달라야함)
    public static boolean canTransform(String curWord, String targetWord) {
        int count = 0;
        for(int i = 0; i < curWord.length(); i++) {
            if(curWord.charAt(i) != targetWord.charAt(i)) {
                count++;
            }
            if(count == 2) {
                return false;
            }
        }

        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }
}