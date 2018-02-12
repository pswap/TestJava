
// https://www.geeksforgeeks.org/?p=25621
public class PascalTriangle {
	public static int getBinomialCoefficient(int n, int k) {
		int res=1;
		if(k>n-k)
			k = n-k;
		for(int i=0;i<k;i++) {
			res *= (n-i);
			res /= (i+1);
		}
		return res;
	}
	public static void printPascalTriangle(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int bc = getBinomialCoefficient(i, j);
				System.out.print(bc + " ");
			}
			System.out.println();
		}
	}
	
	public static int ptRecursive(int n, int k) {
		if(k==0 || k ==n)
			return 1;
		return ptRecursive(n-1, k-1) + ptRecursive(n-1, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		printPascalTriangle(n);
		System.out.println(ptRecursive(n, 2));

	}

}
