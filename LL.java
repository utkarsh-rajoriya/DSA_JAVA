public class LL {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;   
    }

    public Node removeFirst(){
        if(isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        Node result = head;
        head = head.next;
        return result;
    }

    public Node removeLast(){
        if(isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        
        Node secondLast = head;
        Node last = head.next;
        while(last.next != null){
            last = last.next;
            secondLast = secondLast.next;
        } 
        secondLast.next = null;
        return last;
    }

    public void printList(){
        if(isEmpty()){
           System.out.println("List is empty");
            return;
        }

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.println("Null");
    }

    public void revList(){
       if(head == null || head.next == null){
        return;
       }
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            
            //updation
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }

    public Node RevList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node result = RevList(head.next);
        head.next.next = head;
        head.next = null;
        
        return result;
    }


    public static void main(String args[]) {
        LL list = new LL();
        list.addFirst(6);
        list.addFirst(2);
        list.addFirst(4);
        list.addLast(9);

        // list.removeFirst();
        // list.removeLast();

        list.head = list.RevList(list.head);
        list.printList();
        
    }
}
