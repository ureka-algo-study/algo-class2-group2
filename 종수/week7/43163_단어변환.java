package 종수.week7;

import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {

        boolean exist = false;
        for (String word : words) {
            if (word.equals(target)) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(cur.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], cur.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean canChange(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}