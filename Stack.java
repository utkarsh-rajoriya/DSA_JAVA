import java.util.*;

// Stack through arrayList & Link list
public class Stack {

    public static class ByAL {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if(list.isEmpty()){
                System.out.println("Stack is empty ");
                return -1;
            }
            int result = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return result;
        }

        public int peek() {
            if(list.isEmpty()){
                System.out.println("Stack is empty ");
                return -1;
            }
            return list.get(list.size() - 1);
        }

        public void printData(){
            if(list.isEmpty()){
                System.out.println("Stack is empty ");
                return ;
            }
            int i=0;
            while(list.size() != i){
                System.out.print(list.get(i) +" ");
                i++;
            }
        }
    }

    public static class ByLL{
        LinkedList<Integer> l = new LinkedList<>();

        public boolean isEmpty(){
            return l.isEmpty();
        }

        public void push(int data){
            l.add(data);
        }

        public int pop(){
            if(l.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int result = l.get(l.size()-1);
            l.removeLast();
            return result;
        }

        public int peek(){
            if(l.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return l.get(l.size()-1);
        }

        public void printData(){
            if(l.isEmpty()){
                System.out.println("Stack is empty");
                return;
            }
            int i=0;
            while(l.size() != i){
                System.out.print(l.get(i) +" ");
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ByLL s = new ByLL();
        s.push(6);
        s.push(9);
        s.push(4);

        s.pop();
        s.pop();
        s.pop();

        s.printData();
      
    }
}