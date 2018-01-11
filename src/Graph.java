import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	int val;
	ArrayList<Graph> neighbors;
	Graph(int n) { 
		this.val = n;
		neighbors = new ArrayList<Graph>();
		//for(int i=0;i<n;i++) {
		//	neighbors[i] = new ArrayList<Integer>();
		//}
	}
	
	void addEdge(Graph from, Graph to) {
		from.neighbors.add(to);
	} 

	public static void dfs(Graph v, boolean[] visited) {
		System.out.println(v.val);
		visited[v.val] = true;
		for(int i=0;i<v.neighbors.size();i++) {
			if(!visited[v.neighbors.get(i).val])
				dfs(v.neighbors.get(i), visited);
		}	
	}
	
	public static void bfs(Graph v, boolean[] visited) {
		Queue<Graph> q = new LinkedList<Graph>();
		q.add(v);
		while(!q.isEmpty()) {
			v = q.remove();
			if(!visited[v.val]) {
				System.out.println(v.val);
				visited[v.val] = true;				
				for(int i=0;i< v.neighbors.size();i++) {
					q.add(v.neighbors.get(i));
				}
			}
		}
	}
	
	public static void shortestPath(Graph v1, Graph v2) {
		Queue<Graph> q = new LinkedList<Graph>();
		HashMap<Graph, Graph> map = new HashMap<Graph, Graph>();
		q.add(v1);
		map.put(v1, null);
		while(!q.isEmpty()) {
			Graph v = q.remove();
			if(v.val == v2.val)
				break;			
				
			// track the previous node or parent for each neighbor of the current node
			for(int i=0;i<v.neighbors.size();i++) {
				Graph j = v.neighbors.get(i);
				if(!map.containsKey(j)) {			
					q.add(j);
					map.put(j, v);
				}
			}
		}
		if(map.get(v2) == null)
			return;
		StringBuilder path = new StringBuilder();
		Graph k = map.get(v2);
		path.append(v2 + " ");
		while(k != null) {
			path.append(k.val + " ");
			k = map.get(k);
		}
		System.out.println(path.reverse().toString());
	}
	
	// something is wrong with this function. We are not using the map to store linkages
	public static Graph cloneGraph(Graph v, Map<Graph, Graph> map) {
		System.out.println(v.val);
		Graph clone = new Graph(v.val);
		map.put(v, clone);
		for(int i=0;i<v.neighbors.size();i++) {
			Graph tclone= cloneGraph(v.neighbors.get(i), map);
			clone.neighbors.add(tclone);
		}
		return clone;
	}
	public static Graph cloneUtil(Graph v) {
		Map<Graph, Graph> map = new HashMap<Graph, Graph>();
		return cloneGraph(v, map);
	}
	
	// ask SM about islands 2 in programcreek later
	public static void dfsIslands(int a[][], boolean visited[][], int i, int j, int n, int m) {
		if(i >= n || j >= m || i <0 || j <0 || visited[i][j] || a[i][j] ==0)
			return;
		visited[i][j] = true;
		dfsIslands(a, visited, i+1, j, n, m);
		dfsIslands(a, visited, i, j+1, n, m);
		dfsIslands(a, visited, i-1, j, n, m);
		dfsIslands(a, visited, i, j-1, n, m);
		dfsIslands(a, visited, i+1, j+1, n, m);
		dfsIslands(a, visited, i-1, j-1, n, m);
		dfsIslands(a, visited, i+1, j-1, n, m);
		dfsIslands(a, visited, i-1, j+1, n, m);
	}
	public static int countIslands(int a[][], int n, int m) {
		int count = 0;
		boolean visited[][] = new boolean[n][m];
		for(int i=0;i< n;i++) {
			for(int j=0;j< m; j++) {
				if(!visited[i][j] && a[i][j] == 1) {
					dfsIslands(a, visited, i, j, n, m);
					count++;
				}
			}
		}
		return count;
	}
	
	// Topological sort
	public static void dfsTopoSort(Graph v, boolean[] visited, Stack<Graph> stack) {
		visited[v.val] = true;		
		for(int i=0;i<v.neighbors.size();i++) {
			if(!visited[v.neighbors.get(i).val])
				dfsTopoSort(v.neighbors.get(i), visited, stack);
		}
		stack.push(v);
	}
	public static void topologicalSort(ArrayList<Graph> list, int n) {
		Stack<Graph> stack = new Stack<Graph>();
		boolean[] visited = new boolean[n];
		for(int i=0;i<list.size();i++) {
			if(!visited[list.get(i).val]) {				
				dfsTopoSort(list.get(i), visited, stack);
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop().val + ",");
		// 5,0,2,3,1,
	}
	
	public static boolean detectCycleUtil(Graph v, boolean[] visited, boolean[] stack) {
		if(stack[v.val] == true) 
			return true;
		visited[v.val] = true;
		stack[v.val] = true;
		for(int i=0;i<v.neighbors.size();i++) {
			if(!visited[v.neighbors.get(i).val] && detectCycleUtil(v.neighbors.get(i), visited, stack)) {
				//detectCycle(v.neighbors.get(i), v.val);
				return true;
			} 
			else if(stack[v.val])
				return true;
		}
		stack[v.val] = false;
		return false;
	}
	
	public static boolean detectCycle(Graph v, int src) {
		boolean visited[] = new boolean[4];
		boolean stack[] = new boolean[4];
		return detectCycleUtil(v, visited, stack);
	}
	
	public static void main(String[] args) {
		// basic initialization
		/*int v =4;
		Graph a = new Graph(0);
		Graph b = new Graph(1);
		Graph c = new Graph(2);
		Graph d = new Graph(3);
		a.addEdge(a, b);
		//a.addEdge(1, 2);
		a.addEdge(a, d);
		a.addEdge(d, c);
		boolean visited[] = new boolean[v];
		*/
		//dfs(a, visited);
		//bfs(0, visited);
		//shortestPath(0, 2);
		//Graph newClone = new Graph(0);
		// ---Graph clone------
		//Graph clone = cloneUtil(a);
		//dfs(clone, visited);
		// ---Count islands----
		/*int M[][]=  new int[][] {{1, 1, 0, 0, 0},
            						{0, 1, 0, 0, 1},
            						{1, 0, 0, 1, 1},
            						{0, 0, 0, 0, 0},
            						{1, 0, 1, 0, 1}
								};
		int ret = countIslands(M, 5, 5);
		System.out.println("countIslands=" + ret);
		*/
		
		/*
		// Topological sort
		Graph g = new Graph(5);
		Graph h = new Graph(0);
		Graph i = new Graph(1);
		Graph j = new Graph(2);
		Graph k = new Graph(3);
		Graph l = new Graph(4);
        g.addEdge(g, j);
        g.addEdge(g, h);
        g.addEdge(l, h);
        g.addEdge(l, i);
        g.addEdge(j, k);
        g.addEdge(k, i);
        ArrayList<Graph> list = new ArrayList<Graph>();
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        list.add(k);
        list.add(l);
        //4 5 2 3 1 0 or 5 4 2 3 1 0
		//topologicalSort(list, 6);
		//4,5,0,2,3,1  correct or not??
        */
		
		Graph a = new Graph(0);
		Graph b = new Graph(1);
		Graph c = new Graph(2);
		Graph d = new Graph(3);
	    a.addEdge(a, b);
	    a.addEdge(a, c);
	    a.addEdge(b, c);
	    a.addEdge(c, a);
	    a.addEdge(c, d);
	    a.addEdge(d, d);
        boolean ret = detectCycle(a, 2);
        System.out.println("cyclic DAG or not=" + ret);
	}
}