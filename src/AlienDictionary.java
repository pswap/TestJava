import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * Generate a graph with nodes : Compare two strings one char at a time. If the chars are different, check if the graph node exists in map, 
 * if not create one create the neighbor/adjacency list for that pair. 
 * Do topological sort afterwards
 */

public class AlienDictionary {
	int val;
	List<AlienDictionary> neighbors;
	AlienDictionary(int c) {
		this.val = c;
		neighbors = new ArrayList<AlienDictionary>();			
	}
	void addEdge(AlienDictionary from, AlienDictionary to) {
		from.neighbors.add(to);
	} 
	
	// Topological sort
	public static void dfsTopoSort(AlienDictionary v, boolean[] visited, Stack<AlienDictionary> stack) {
		visited[v.val] = true;		
		for(int i=0;i<v.neighbors.size();i++) {
			if(!visited[v.neighbors.get(i).val])
				dfsTopoSort(v.neighbors.get(i), visited, stack);
		}
		stack.push(v);
	}
	public static String topologicalSort(List<AlienDictionary> list, int n) {
		Stack<AlienDictionary> stack = new Stack<AlienDictionary>();
		boolean[] visited = new boolean[n];
		for(int i=0;i<list.size();i++) {
			if(!visited[list.get(i).val]) {				
				dfsTopoSort(list.get(i), visited, stack);
			}
		}
		
		String ret = "";
		while(!stack.isEmpty()) {
			//System.out.print((char)(stack.pop().val + 'a') + ",");
			ret += ((char)(stack.pop().val + 'a') + ",");
		}
		return ret;
		// 5,0,2,3,1,
	}
	public static Map<Integer, AlienDictionary> genAlienDictionary(List<String> list) {
		Map<Integer, AlienDictionary> map = new HashMap<Integer, AlienDictionary>();
		for(int i=0;i<list.size()-1;i++) {
			String s1 = list.get(i);
			String s2 = list.get(i+1);
			int j =0;
			while(j < s1.length() && j < s2.length()) {
				if(s1.charAt(j) != s2.charAt(j)) {
					int c1 = s1.charAt(j) - 'a';
					int c2 = s2.charAt(j) - 'a';
					AlienDictionary g1 = map.get(c1);	
					AlienDictionary g2 = map.get(c2);	
					if(g1 == null) {
						g1 = new AlienDictionary(c1);
						map.put(c1, g1);
					}
					if(g2 == null) {
						g2 = new AlienDictionary(c2);
						map.put(c2,  g2);
					}
					
					g1.addEdge(g1, g2);
					break;
				} 
				j++;
			}
		}
		return map;
	}
	public static void main(String[] args) {
		int n = 4;	
		List<String> list = new ArrayList<String>();
		list.add("baa");
		list.add("abcd");
		list.add("abca");
		list.add("cab");
		list.add("cad");
		
		Map<Integer, AlienDictionary> map = genAlienDictionary(list);
		@SuppressWarnings("rawtypes")
		List<AlienDictionary> mapList = new ArrayList<>(map.values());
		String ret = topologicalSort(mapList, n);
		System.out.println(ret);
	}
}
