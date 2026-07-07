import java.util.*;

class Solution {
    class Node{
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }
        
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
        
        Node root = nodes[0];
        for(int i=1; i<nodes.length; i++){
            insert(root, nodes[i]);
        }
        
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        
        preorder(root, pre);
        postorder(root, post);
        
        answer[0] = pre.stream().mapToInt(i->i).toArray();
        answer[1] = post.stream().mapToInt(i->i).toArray();

        
        
        return answer;
    }
    
    void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }
            else{
                insert(parent.left, child);
            }
        }
        else{
            if(parent.right == null){
                parent.right = child;
            }
            else{
                insert(parent.right, child);
            }
        }
    } // insert
    
    void preorder(Node node, List<Integer> list){
        if (node == null) return;
        list.add(node.value);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    void postorder(Node node, List<Integer> list){
        if (node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.value);
    }
}