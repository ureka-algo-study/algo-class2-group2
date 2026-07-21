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
    
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (a,b) -> a.x - b.x);

        Arrays.sort(nodes, (a,b) -> b.y - a.y);
        
        Node p = nodes[0];
        
        for(int i=1; i<nodes.length; i++){
            insert(p, nodes[i]);
        }
        
        
        
        preOrder(p);
        postOrder(p);
        answer[0] = pre.stream().mapToInt(i->i).toArray();
        answer[1] = post.stream().mapToInt(i->i).toArray();
        return answer;
    }
    
    void insert(Node p, Node c){
        if(p.x > c.x){
            if(p.left == null){
                p.left = c;
                return;
            }
            else{
                insert(p.left, c);
            }
        }
        else{
            if(p.right == null){
                p.right = c;
                return;
            }
            else{
                insert(p.right, c);
            }
        }
    }
    
    void preOrder(Node h){
        if(h == null) return;
        
        pre.add(h.value);
        preOrder(h.left);
        preOrder(h.right);
        
    }
    
    void postOrder(Node h){
        if(h == null) return;
        
        postOrder(h.left);
        postOrder(h.right);
        post.add(h.value);  
    }
}