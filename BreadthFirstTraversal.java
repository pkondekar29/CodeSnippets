import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int a){
        this.data = a;
        this.left = this.right = null;
    }
}

public class BreadthFirstTraversal{

    public static void main(String[] args) {
        /**
         * Naive solution -
         *  for each level till the height of tree, print that level 
         */
        /**
         * Optimal solution -
         *  Put node in a queue
         *  while(queue is not empty){
         *      node = poll queue
         *      if(left node is not empty){
         *          add left node to queue
         *      }
         *      if(right node is not empty){
         *          add right node to queue
         *      }
         *  }
         */
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(10);
        root.right.right = new Node(5);

        BFS(root);
    }

    private static void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
			System.out.print(temp.data + " ");

            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
    }
}