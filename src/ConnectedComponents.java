import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
	private static boolean[] visited;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean done=false;
        
        while(!done){
        	int nextV=-1;
        	for (int i=0; i<visited.length;i++){
        		if(!visited[i]){
        			nextV=i;
        			break;
        		}
        	}
        	if(nextV==-1)
        		return result;
        	
        	result++;
        	recurse(adj,nextV);
        	
        }
        
        return result;
    }
    private static void recurse(ArrayList<Integer>[] adj, int v){
    	visited[v]=true;
    	
    	for (int i: adj[v]){
    		if (visited[i])
    			continue;
    		recurse(adj,i);
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        visited= new boolean[n];
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

