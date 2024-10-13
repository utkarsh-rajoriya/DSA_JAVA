public class Trie {
    static class Node{
        Node children[];
        boolean eow;

        Node(){
            children = new Node[26];
            for(int i = 0; i<26 ; i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public void insert(String word){
        Node curr = root;
        for(int i=0 ; i<word.length() ; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
           
            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public boolean search(String word){
        Node curr = root;
        for(int i=0 ; i<word.length() ; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }

            if(i == word.length()-1 && curr.children[idx].eow == false){
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public boolean wordBreak(String word){
        if(word.length() == 0){
            return true;
        }

        for(int i=1 ; i<= word.length() ; i++){
            String firstHalf = word.substring(0, i);
            String seocndHalf = word.substring(i);

            if(search(firstHalf) && wordBreak(seocndHalf)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = {"the" , "there" , "a" , "their" , "any"};
        Trie tree = new Trie();
        for(String i : words){
            tree.insert(i);
        }

        System.out.println(tree.search("any"));
        
    }

}
