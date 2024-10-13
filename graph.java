import java.util.*;

public class graph {
    static class edge {
        int src;
        int dest;

        edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 4));
       

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));
        graph[1].add(new edge(1, 4));

        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 2));

        
        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));
        graph[4].add(new edge(4, 5));
        
        graph[5].add(new edge(5, 4));
    }

    public static void search_neighbour(ArrayList<edge> graph[], int n) {
        ArrayList<edge> list = graph[n];
        for (int i = 0; i < list.size(); i++) {
            System.out.println(n + "-->" + list.get(i).dest);
        }
    }

    public static void bfs(ArrayList<edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                ArrayList<edge> ll = graph[curr];
                for (int i = 0; i < ll.size(); i++) {
                    q.add(ll.get(i).dest);
                }
            }

        }
    }

    public static void dfs(ArrayList<edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        ArrayList<edge> ll = graph[curr];
        for (int i = 0; i < ll.size(); i++) {
            edge edge = ll.get(i);
            if (vis[edge.dest] == false) {
                dfs(graph, edge.dest, vis);
            }
        }
    }

    public static void solve_by_dfs(ArrayList<edge> graph[], String path, boolean vis[], int curr, int tar) {
        if (curr == tar) {
            System.out.println(path);
            return; 
        }

        ArrayList<edge> ll = graph[curr];
        for (int i = 0; i < ll.size(); i++) {
            edge edge = ll.get(i);
            if (vis[edge.dest] == false) {
                vis[curr] = true;
                solve_by_dfs(graph, path + " " + edge.dest, vis, edge.dest, tar);
                vis[curr] = false;
            }
        }
    }

    public static void solve_by_df(ArrayList<edge> graph[], String path, boolean vis[], int curr, int tar) {
        if(curr == tar){
            System.out.println(path);
            return;
        }

        vis[curr] = true;
        path += " " +curr;
        for(int i=0 ; i<graph.length ; i++){
            edge e = graph[i].get(i);
            if(!vis[e.dest]){
                solve_by_df(graph, path, vis, e.dest, tar);
                vis[curr] = false;
            }
        }
    }


    public static boolean detectCycle_dfs(ArrayList<edge> graph[] , boolean vis[],int curr){
        vis[curr] = true;
        boolean ans = false;
        for(int i=0 ; i<graph[curr].size(); i++){
            edge e = graph[curr].get(i);
            if(vis[e.dest]){
                return ans = true;
            }else{
                ans = detectCycle_dfs(graph, vis, e.dest);
            }
        }
        return ans;
    }
    
    public static void tp_sortutil(ArrayList<edge> graph[] , int curr , boolean vis[] , java.util.Stack<Integer> stack){
        vis[curr] = true;
        for(int i=0 ; i<graph[curr].size() ; i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
              tp_sortutil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void tpSort(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int i=0 ; i<graph.length ; i++){
            if(!vis[i]){
                tp_sortutil(graph , i , vis , stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean Un_cycle(ArrayList<edge> graph[] , boolean vis[] , int parent ,int curr){
        vis[curr] = true;
        boolean ans= false;
        for(int i=0 ; i<graph[curr].size() ; i++){
            edge e = graph[curr].get(i);
            if( vis[e.dest]&& parent != e.dest ){
                return ans = true;
            }
            else if(!vis[e.dest]){
                ans = Un_cycle(graph, vis, curr, e.dest);
            }
        }
        return ans;
    }
    // public static void solve_by_bfs(ArrayList<edge> graph[] , boolean vis[] , int
    // s, int e ){
    // Queue<Integer> q = new LinkedList<>();
    // q.add(s);
    // while
    // }
    
    public static void main(String[] args) {
        // int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<edge> graph[] = new ArrayList[6];
        boolean vis[] = new boolean[graph.length];
        createGraph(graph);
        boolean ans = Un_cycle(graph, vis, -1, 0);
        System.out.println(ans);
    }
}
