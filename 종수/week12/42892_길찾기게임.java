package 종수.week12;

import java.util.*;

class Solution {

    class Node {
        int x;
        int y;
        int number;
        Node left;
        Node right;

        Node(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        ArrayList<Node> list = new ArrayList<>();

        // 좌표만 있으면 몇 번 노드인지 모르니까 번호까지 같이 저장
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            list.add(new Node(x, y, i + 1));
        }

        // y가 큰 노드가 위쪽 노드니까 y 내림차순
        // y가 같으면 x가 작은 노드가 왼쪽에 있으니까 x 오름차순
        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.y == b.y) {
                    return a.x - b.x;
                }
                return b.y - a.y;
            }
        });

        // 제일 위에 있는 노드가 루트
        Node root = list.get(0);

        // 나머지 노드들을 하나씩 트리에 넣기
        for (int i = 1; i < list.size(); i++) {
            Node now = root;
            Node insertNode = list.get(i);

            while (true) {
                // x좌표가 작으면 왼쪽으로 가야 함
                if (insertNode.x < now.x) {
                    if (now.left == null) {
                        now.left = insertNode;
                        break;
                    } else {
                        now = now.left;
                    }
                }
                // x좌표가 크면 오른쪽으로 가야 함
                else {
                    if (now.right == null) {
                        now.right = insertNode;
                        break;
                    } else {
                        now = now.right;
                    }
                }
            }
        }

        // 전위순회
        preorder(root);

        // 후위순회
        postorder(root);

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }

        // 전위순회는 현재 노드 먼저
        pre.add(node.number);

        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }

        // 후위순회는 현재 노드를 마지막에 넣음
        postorder(node.left);
        postorder(node.right);

        post.add(node.number);
    }
}