/*
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
*/

class CombinationIterator {
	List<String> dataList = new ArrayList<>();
	Iterator<String> dataIterator;

	public CombinationIterator(String characters, int combinationLength) {
		dataList = new ArrayList<>();
		char arr[] = characters.toCharArray();
		combination(arr, arr.length, combinationLength);
		dataIterator = dataList.iterator();
	}

	private void combinationUtil(char arr[], char data[], int start, int end, int index, int r) {
		if (index == r) {
			StringBuilder b = new StringBuilder();
			for (int j = 0; j < r; j++) {
				b.append(Character.toString(data[j]));
			}
			dataList.add(b.toString());
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	private void combination(char arr[], int n, int r) {
		char data[] = new char[r];
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	public String next() {
		return dataIterator.next();
	}

	public boolean hasNext() {
		return dataIterator.hasNext();
	}
}
