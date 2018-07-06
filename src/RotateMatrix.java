
public class RotateMatrix {
	
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/multiarray/RotateImage.java
	// link and I have j and i reversed
	/*
	 * In each Iteration, we are working on complete outer layer consisting of 2 rows 
(Example: Row 0 and Row 4 for Layer 1)
So, while coding we need to take care of this and need to iterate our outer loop from 0 to rowLength/2 and not till rowLength. 
For Inner loop, it should starts from where outer loop starts and decrements end layer in each iteration because in each iteration, 
Left wall and Right wall of matrix is getting rotated, so no need to touch it in next iteration. 
	 */
	public static void rotate90(int[][] a, int n) {
		for(int i=0;i<n/2;i++) {
			for(int j=i;j<n-i-1;j++) {
				int temp = a[i][j];
				a[i][j] = a[n-j-1][i];
				a[n-j-1][i] = a[n-i-1][n-j-1];
				a[n-i-1][n-j-1] = a[j][n-i-1];
				a[j][n-i-1] = temp;
			}
		}
	}
	
	
	/*int temp = a[i][j];
	a[i][j] = a[n-j-1][i];
	a[n-j-1][i] = a[n-i-1][n-j-1];
	a[n-i-1][n-j-1] = a[i][n-i-1];
	a[i][n-i-1] = temp; */
	
	//https://github.com/mission-peace/interview/blob/master/src/com/interview/multiarray/MatrixInDiagonalOrder.java
	//https://www.youtube.com/watch?v=T8ErAYobcbc
	public static void printMatrixDiagonally(int[][] a, int m, int n) {
		for(int i=0;i<m;i++) {
			int start = i;
			int end = 0;
			while(start >=0 && end < n) {
				System.out.print(a[start][end] +" ");
				start = start-1; 
				end = end+1; 
			}
			System.out.println();
		}
		
		for(int i=1;i<n;i++) {
			int start = m-1;
			int end = i;
			while(start >= 0 && end < n) {
				System.out.print(a[start][end] +" ");
				start = start -1;
				end = end+1;
			}
			System.out.println();
		}
	}
	
	/* https://www.geeksforgeeks.org/rotate-matrix-elements/
	 * Input
		1    2    3
		4    5    6
		7    8    9
		
		Output:
		4    1    2
		7    5    3
		8    9    6
	 */
	// doesn't work correctly, one edge case is missing somewhere
	public static void rotateMatrixElem(int[][] a, int m, int n) {
		int k=0,l=0, lastrow = m-1, lastcol = n-1;
		int i=0;
		int prev, curr;
		
		while(k <= lastrow && l <= lastcol) {
			//if (k + 1 == lastrow || l + 1 == lastcol)
              //  break;
			prev = a[k+1][l];
			
			// print first row
			for(i=l;i<=lastcol;i++) {
				curr = a[k][i];
				a[k][i] = prev;
				prev = curr;
			}
			k++;
			
			//print lastcol
			for(i=k;i<=lastrow;i++) {
				curr = a[i][lastcol];
				a[i][lastcol] = prev;
				prev = curr;
			}
			lastcol--;
			
			//print last row
			if(k <= lastrow) {
				for(i=lastcol;i>=l;i--)  {
					curr = a[lastrow][i];
					a[lastrow][i] = prev;
					prev = curr;
				}
				lastrow--;
			}
			
			//print first col
			if(l <= lastcol) {
				for(i=lastrow;i>=k;i--) {
					curr = a[i][l];
					a[i][l] = prev;
					prev = curr;
				}
				l++;
			}
		}
	}
	
	//https://www.youtube.com/watch?v=TmweBVEL0I0
	//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
	public static void printMatrixSpiralOrder(int[][] a, int m, int n) {
		int k=0,l=0, lastrow = m-1, lastcol = n-1;
		int i=0;
		
		while(k <= lastrow && l <= lastcol) {
			// print first row
			for(i=l;i<=lastcol;i++)
				System.out.print(a[k][i] + " ");
			k++;
			
			//print lastcol
			for(i=k;i<=lastrow;i++)
				System.out.print(a[i][lastcol] + " ");
			lastcol--;
			
			//print last row
			if(k <= lastrow) {
				for(i=lastcol;i>=l;i--) 
					System.out.print(a[lastrow][i] +" ");
				lastrow--;
			}
			
			//print first col
			if(l <= lastcol) {
				for(i=lastrow;i>=k;i--)
					System.out.print(a[i][l] +" ");
				l++;
			}
		}
	}
	
	public static void printMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
        int n = 6;
       /* int a[][] = { {1,  2,  3,  4,  5,  6},
	                  {7,  8,  9,  10, 11, 12},
	                  {13, 14, 15, 16, 17, 18}
	                };
	                */
		//printMatrixSpiralOrder(a, m, n);
        //rotateMatrixElem(a, m, n);
        //printMatrix(a);
        
        //printMatrixDiagonally(a, m, n);
        
        /*int a[][] = { { 5, 1, 9,11},
		        		  { 2, 4, 8,10},
		        		  {13, 3, 6, 7},
		        		  {15,14,12,16}
        				}; */
        int a[][] = {  {1,2,3},
		      		  {4,5,6},
		      		  {7,8,9}
					};
        rotate90(a, m);
        printMatrix(a);
	}

}
