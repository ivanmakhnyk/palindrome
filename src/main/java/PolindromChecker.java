public class PolindromChecker {

	public static boolean isPalindromEfficient(String str) {
		char[] word = str.toCharArray();
		int head = 0;
		int tail = word.length - 1;
		while (tail > head) {
			if (word[head] != word[tail]) {
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}

	public static void main(String[] args) {
		StringBuffer testString = new StringBuffer();
		System.out.println("Repeat\tLength\tBuilder\tsBuffer\tcharArray");

		//100 chars
		testString = new StringBuffer();
		for(int i=0;i<100;i++){
			testString.append("a");
		}
		compareTime(testString.toString(), 1000000);

		//1000 chars
		testString = new StringBuffer();
		for(int i=0;i<1000;i++){
			testString.append("a");
		}
		compareTime(testString.toString(), 100000);

		//10000 chars
		testString = new StringBuffer();
		for(int i=0;i<10000;i++){
			testString.append("a");
		}
		compareTime(testString.toString(), 10000);

		//100000 chars
		testString = new StringBuffer();
		for(int i=0;i<100000;i++){
			testString.append("a");
		}
		compareTime(testString.toString(), 1000);
	}

	public static void compareTime(String str, long repeat) {
		// string builder
		long start = System.currentTimeMillis();
		for (long i = 0; i < repeat; i++) {
			isPalindromeWithStringBuilder(str);
		}
		long stringBuilderTime = System.currentTimeMillis() - start;

		// string buffer
		start = System.currentTimeMillis();
		for (long i = 0; i < repeat; i++) {
			isPalindromeWithStringBuffer(str);
		}
		long stringBufferTime = System.currentTimeMillis() - start;

		// char array (Efficient)
		start = System.currentTimeMillis();
		for (long i = 0; i < repeat; i++) {
			isPalindromEfficient(str);
		}
		long charArrayTime = System.currentTimeMillis() - start;
	
		System.out.println(""+repeat + "\t" + str.length() +"\t" + stringBuilderTime + "\t" + stringBufferTime + "\t" + charArrayTime);
	}

	public static boolean isPalindromeWithStringBuilder(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static boolean isPalindromeWithStringBuffer(String str) {
		return str.equals(new StringBuffer(str).reverse().toString());
	}
}
