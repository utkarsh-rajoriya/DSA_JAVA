import java.util.*;

public class binaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            } else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
        
    }

    static int count = 0;
    public int countNodes(Node root){
        if(root == null){
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    
    public int sumOfnodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfnodes(root.left);
        int rightSum =sumOfnodes(root.right);

            return leftSum + rightSum + root.data;
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight);
        return myHeight + 1;
    }

    public int Diameter(Node root){
        if(root == null){
            return 0;
        }
        int dia1 = Diameter(root.left);
        int dia2 = Diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        int myDiam = Math.max(Math.max(dia2, dia1), dia3);
        return myDiam;
    }

    static int idx = -1;
    public Node builtTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = builtTree(nodes);
        newNode.right = builtTree(nodes);
        return newNode;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        Node root = tree.builtTree(nodes);

       // System.out.println(tree.sumOfnodes(root));
       System.out.println(tree.height(root));
        System.out.println(tree.Diameter(root));
    }
}
