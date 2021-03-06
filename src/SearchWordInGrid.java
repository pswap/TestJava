/*
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class SearchWordInGrid {
	public static boolean searchWord(char[][] grid, String str, boolean[][] visited, int i, int j, int k, int m, int n) {
		if(i < 0 || j < 0 || i >= m || j >=n )
			return false;
		if(!visited[i][j] && grid[i][j] == str.charAt(k) ) {
			if(k == str.length()-1)
				return true;
			visited[i][j] = true;
			if(searchWord(grid, str, visited, i+1, j, k+1, m, n) ||
					searchWord(grid, str, visited, i, j+1, k+1, m, n) ||
					searchWord(grid, str, visited, i-1, j, k+1, m, n) ||
					searchWord(grid, str, visited, i, j-1, k+1, m, n))
				return true;
			visited[i][j] = false;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3, n=4;
		boolean[][] visited = new boolean[m][n];
		char[][] grid = { {'A', 'B','C','E'}, 
						  {'S', 'F', 'C','S'},
						  {'A', 'D', 'E', 'E'}};
		String str = "ABCB";
		boolean ret = false;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(searchWord(grid, str, visited, i, j, 0, m, n))
					ret = true;
			}
		}
		System.out.println("ret=" + ret);
	}

}
