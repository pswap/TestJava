
public class NQueens {
	public static int N = 4;
	
	public static void printBoard(int[][] grid) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isSafe(int[][] grid, int row, int col) {
		int i, j;
		// check rows till this column
		for(i=0;i<col;i++)
			if(grid[row][i] == 1)
				return false;
		// check upper left diagonal
		for(i=row, j=col; i>=0 && j>=0;i--, j--) {
			if(grid[i][j] == 1)
				return false;
		}
		// check lower left diagonal
		for(i=row, j=col; j>=0 && i<N;i++, j--) {
			if(grid[i][j] == 1)
				return false;
		}
		return true;
	}
	
	public static boolean NQueens_util(int[][] grid, int col) {
		if(col >= N)
			return true;
		for(int i=0;i<N;i++) {			
			if(isSafe(grid, i, col)) {
				grid[i][col] = 1;
				boolean ret = NQueens_util(grid, col+1);
				if(ret)
					return true;
				else
					grid[i][col] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int board[][] = {{0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0}
	        };
	 
        if (NQueens_util(board, 0) == false)
        {
            System.out.print("Solution does not exist");
        }
 
        printBoard(board);	        
	}

}
