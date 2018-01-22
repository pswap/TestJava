/*
 * Given a maze, NxN matrix. A rat has to find a path from source to des�ti�na�tion. maze[0][0] (left top corner)is the source and maze[N-1][N-1](right bot�tom cor�ner) is des�ti�na�tion.
 *  There are few cells which are blocked, means rat can�not enter into those cells. Rat can move in any direc�tion ( left, right, up and down).

Input: A 2D-matrix with 0�s and 1�s fill in it. 0 means that cell is blocked and 1 means rat can move to that cell.
 */
public class RatInaMaze {
	
	public static boolean ratInMaze(int[][] maze, int[][] sol, int i, int j, int N) {
		if(i == N-1 && j == N-1 && maze[i][j]==1) {
			sol[i][j] = 1;
			return true;
		}
		if(i<0 || j<0 || i>N-1 || j>N-1 || maze[i][j]==0)
			return false;
		sol[i][j] = 1;
		if(ratInMaze(maze, sol, i+1, j, N) ||
				ratInMaze(maze, sol, i, j+1, N))
			return true;
		sol[i][j] = 0;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int[][] maze = { {1, 0, 0, 0},
						 {1, 1, 0, 1},
						 {0, 1, 0, 0},
						 {1, 1, 1, 1}}; 
		/*int[][] maze = { {1, 0, 1, 1, 1},
				 {1, 1, 1, 0, 1},
				 {0, 0, 0, 1, 1},
				 {0, 0, 0, 1, 0},
				 {0, 0, 0, 1, 1} }; */
		int[][] sol = new int[N][N];
		boolean ret = ratInMaze(maze, sol, 0, 0, N);
		System.out.println("ret = " + ret);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(sol[i][j] +" ");
			}
			System.out.println("");
		}
	}

}
