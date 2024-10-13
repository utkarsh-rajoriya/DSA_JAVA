import java.util.*;
public class BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public Node builtTree(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = builtTree(root.left, val);
        } else {
            root.right = builtTree(root.right, val);
        }

        return root;
    }

    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public Node deletNode(Node root, int val) {
        if (root.data > val) {
            root.left = deletNode(root.left, val);
        } else if (root.data < val) {
            root.right = deletNode(root.right, val);
        }

        else {
            // case 1
            if (root.right == null && root.left == null) {
                return null;
            }

            // case 2
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }

            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deletNode(root.right, IS.data);
            
        }
        
        return root;
    }

    public Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public void printPath(ArrayList<Integer> list){
        for(int i : list){
            System.out.print(i + "-->");
        }
        System.out.println();
    }

    public void root2endpaths(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.data);
        if(root.left == null && root.right == null){
            printPath(list);
        }else{
            root2endpaths(root.left, list);
            root2endpaths(root.right, list);
        }

        list.remove(list.size()-1);
    }

    public void printRange(Node root , int x , int y){
        if(root == null){
            return;
        }
        if(x > root.data){
            printRange(root.right, x, y);
        }
        else if(y < root.data){
            printRange(root.left, x, y);
        }
        else if(x <= root.data && root.data <= y){
            printRange(root.left, x, y);
            System.out.print(root.data + " ");
            printRange(root.right, x, y);
        }

    }


    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        BST tree = new BST();
        Node root = null;
        for (int i : values) {
            root = tree.builtTree(root, i);
        }

       
        tree.inOrder(root);
        System.out.println();

        System.out.println(tree.deletNode(root , 3).data);
        tree.inOrder(root);
       
    }
}

