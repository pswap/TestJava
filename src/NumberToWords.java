
public class NumberToWords {
	static String[] unitsArray = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight","nine","ten", "eleven","twelve","thirteen",
			"fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String[] tensArray = {"zero", "ten", "twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	
	public static String NumberToWordsFn(int n) {
		String s = new String();
		if(n == 0)
			return "zero";
		if(n / 1000000 > 0) {
			s += NumberToWordsFn(n/1000000) + " million ";
			n %= 1000000;
		}
		if(n / 1000 > 0) {
			s += NumberToWordsFn(n/1000) + " thousand ";
			n %= 1000;
		} 
		if(n / 100 > 0) {
			s += NumberToWordsFn(n/100) + " hundred ";
			n %= 100;
		} 
		if(n < 20 )
		{
			s += unitsArray[n]; 
		} else {
			s += tensArray[n/10] + " " + NumberToWordsFn(n%10);
			
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2134567;
		System.out.println(NumberToWordsFn(n));

	}

}
