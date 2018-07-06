
public class TicTacToe {
	char[][] board = null;
	TicTacToe(int n) {
		board = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public int addToken(int i, int j, char in) {
		if(board[i][j] == '-')
			board[i][j] = in;
		else
			return -1;
		return 1;
	}
	public void addToken(char in) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == '-') {
					board[i][j] = in;
					return;
				}
			}
		}
	}
	
	public void printBoard(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j == n-1)
					sb.append(board[i][j]);
				else
					sb.append(board[i][j] + "|");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public boolean isFull() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == '-')
					return false;  // not full
			}
		}
		return true; // full
	}
	
	public void makeAIMove() throws Exception {
		boolean isFull = isFull();
		if(!isFull) {
			addToken('O');
		} else
			throw new Exception("Board is full");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe tc = new TicTacToe(3);
		
		tc.addToken(0, 1, 'X');
		tc.printBoard(3);
		boolean ret = tc.isFull();
		System.out.println("ret=" + ret);
		
		Scanner sc = new Scanner();
		
		
		
		while(!tc.isFull()) {
			makeHumanMove(i, j, 'X');
			tc.printBoard(3);
		}
		
		/*try {
			for(int i=0;i<9;i++) {
				tc.makeAIMove();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tc.printBoard(3);
		*/
		

	}

}
