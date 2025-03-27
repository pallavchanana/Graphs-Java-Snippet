import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//BFS Disconnected graph logic
public class BFS02{
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        // init graph else it will be null 
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
       
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
       
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
       
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
       
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
       
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,6,1));
        

    }
    public static void bfs(ArrayList<Edge> graph[],int V,boolean vis[],int start){
        Queue<Integer> q= new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(start);
        while(!q.isEmpty()){
            int curr= q.remove();
            if(visited[curr] ==  false){
                System.out.print("curr" + curr);
                visited[curr]=true;

                for(int i =0;i<graph[curr].size();i++){
                    Edge e =graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }


    //O(V+E)
public static void main(String[] args) {
    System.out.println("-------Program Started");
    int V=7;

    ArrayList<Edge> graph[]= new ArrayList[V];
    createGraph(graph);

    boolean vis[] = new boolean[V];
    for(int i =0;i<V;i++){
        if(vis[i] == false){
            bfs(graph,V,vis,i);
        }
    }

    System.out.println(" ------ Program End");
}
}