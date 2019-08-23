import java.util.ArrayList;
import java.util.Scanner;


public class Reachability {
	public static boolean[] visited;
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
    	visited[x]=true;
    	if (x==y){
    		return 1;
    	}
    	
    	for (int i: adj[x]){
    		if(visited[i])
    			continue;
    		if(reach(adj,i,y)==1){
    			return 1;
    		}
    	}
    	
    	return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[])new ArrayList[n];
		ArrayList<Integer>[] adj = arrayLists;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
            
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

