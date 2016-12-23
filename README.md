# Compare algorithms to check if a string is a palindrome

A string is a palindrome if the string matches the reverse of string.
Example: 
 - 1221 is a palindrome
 - 1121 is not a palindrome
 
 
# Three palindrome checking algorithms

Implementation is located [PolindromChecker](/src/main/java/PolindromChecker.java) class
## Char array based

```java
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
```

## String Builder based

```java
	public static boolean isPalindromeWithStringBuilder(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}
```

## String Buffer based

```java
	public static boolean isPalindromeWithStringBuffer(String str) {
		return str.equals(new StringBuffer(str).reverse().toString());
	}
```

# Compare results


Repeat | String Length | StringBuilder | StringBuffer | CharArray
--- | --- | --- | --- | ---
1000000 | 100 chars | 182 ms | 148 ms | 71 ms
100000 | 1000 chars | 161 ms | 94 ms | 79 ms
10000 | 10000 chars | 135 ms | 83 ms | 67 ms
1000 | 100000 chars | 90 ms | 82 ms | 71 ms

Where:
 - **Repeat** is the number of execution algorithm
 - **String Length** - length of string to check is palindrome
 - **StringBuilder** - time spent with StringBuilder algorithm
 - **StringBuffer** - time spent with StringBuffer algorithm
 - **CharArray** - time spent with char array based algorithm
 