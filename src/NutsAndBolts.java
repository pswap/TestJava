
public class NutsAndBolts {
	
	public static int partition(char[] a, int l, int h, char pivot) {	
		int i = l;
		int j = h;
		while(i < j) {
			if(a[i] < pivot)
				i++;
			if(a[j] > pivot)
				j--;
			if(i <= j) {
				char temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		// we dont need the last swap in orig qs because we are not comparing same array elements
		//char temp1 = a[l];
		//a[l] = a[j];
		//a[j] = temp1;
		return j;
	}
	
	public static void doQS(char[] nuts, char[] bolts, int low, int high) {
		if(low < high) {
			int nutsPivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[nutsPivot]);
			
			doQS(nuts, bolts, low, nutsPivot-1);
			doQS(nuts, bolts, nutsPivot+1, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] nuts = {'@', '#', '$','%', '^', '&'};
		char[] bolts = {'$', '%', '&', '^', '@', '#'};
		doQS(nuts, bolts, 0, nuts.length - 1);
		
		for(int i =0;i<nuts.length;i++)
			System.out.print(nuts[i] +",");
		System.out.println();
		for(int i =0;i<bolts.length;i++)
			System.out.print(bolts[i] +",");
	}

}
