import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {
	int n;
	static List<Integer> neighbors[];
	Graph(int n) { 
		this.n = n;
		neighbors = new ArrayList[n];
		for(int i=0;i<n;i++) {
			neighbors[i] = new ArrayList<Integer>();
		}
	}
	
	void addEdge(int from, int to) {
		neighbors[from].add(to);
	}

	public static void dfs(int v, boolean[] visited) {
		System.out.println(v);
		visited[v] = true;
		Iterator<Integer> it = neighbors[v].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n])
				dfs(n, visited);
		}		
	}
	
	public static void bfs(int v, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while(!q.isEmpty()) {
			v = q.remove();
			if(!visited[v]) {
				System.out.println(v);
				visited[v] = true;				
				for(int i=0;i<neighbors[v].size();i++) {
					q.add(neighbors[v].get(i));
				}
			}
		}
	}
	
	public static void shortestPath(int v1, int v2) {
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		q.add(v1);
		map.put(v1, null);
		while(!q.isEmpty()) {
			int v = q.remove();
			if(v == v2)
				break;			
				
			for(int i=0;i<neighbors[v].size();i++) {
				int j = neighbors[v].get(i);
				if(!map.containsKey(j)) {			
					q.add(j);
					map.put(j, v);
				}
			}
		}
		if(map.get(v2) == null)
			return;
		StringBuilder path = new StringBuilder();
		Integer k = map.get(v2);
		path.append(v2 + " ");
		while(k != null) {
			path.append(k + " ");
			k = map.get(k);
		}
		System.out.println(path.reverse().toString());
		
		
	}
	
	public static void main(String[] args) {
		int v =4;
		Graph a = new Graph(v);
		a.addEdge(0, 1);
		//a.addEdge(1, 2);
		a.addEdge(0, 3);
		a.addEdge(3, 2);
		boolean visited[] = new boolean[v];
		//dfs(0, visited);
		//bfs(0, visited);
		shortestPath(0, 2);
	}
}
