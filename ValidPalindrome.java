/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Constraints:

s consists only of printable ASCII characters.
*/
class ValidPalindrome {
    public boolean isPalindrome(String s) {
		s = getString(s.toLowerCase());
		int i = 0, j = s.length() - 1;

		// While there are characters to compare
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}
		return true;
    } 
    
    public String getString(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0; 
		while (i <= s.length() - 1) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				stringBuilder.append(s.charAt(i));
			} 
			i++;
		}
		return stringBuilder.toString();
	}
}
