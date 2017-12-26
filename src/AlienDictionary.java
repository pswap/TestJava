import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	class Graph {
		Character val;
		List<Graph> neighbors;
		Graph(Character c) {
			this.val = c;
			neighbors = new ArrayList<Graph>();			
		}
		void addEdge(Graph from, Graph to) {
			from.neighbors.add(to);
		} 
	};
	public static void genGraph(List<String> list, List<Graph> graphList) {
		for(int i=0;i<list.size();i++) {
			String s1 = list.get(i);
			String s2 = list.get(i+1);
			int j =0;
			while(j < s1.length() && j < s2.length()) {
				if(s1.charAt(j) != s2.charAt(j)) {
					//graphList.
					//s1.charAt(j).addEdge(s2.charAt(j));
				} 
				j++;
			}
		}
	}
	public static void main(String[] args) {
		int n = 4;
		AlienDictionary ad = new AlienDictionary();
		List<Graph> graphList = new ArrayList<Graph>();
		for(int i=0;i<n;i++) {
			Graph g = ad.new Graph((char) (i + 'a'));
			graphList.add(g);
		}		
		List<String> list = new ArrayList<String>();
		list.add("baa");
		list.add("abcd");
		list.add("abca");
		list.add("cab");
		list.add("cad");
	}
}
