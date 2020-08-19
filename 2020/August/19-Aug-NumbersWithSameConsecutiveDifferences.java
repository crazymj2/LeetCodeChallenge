/*
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
*/
public class NumbersWithSameConsecutiveDifferences {

	public static void main(String[] args) {
		System.out.println("Data "+Arrays.toString(numsSameConsecDiff(3, 7)));
	}

	private static int[] numsSameConsecDiff(int N, int K) {
		Set<Integer> dataSet = new HashSet<>();
		for (int i = N == 1 ? 0 : 1; i < 10; i++) {
			genNums(i, N, K, dataSet);
		}

		int[] ans = new int[dataSet.size()];
		int i = 0;
		for (int num : dataSet) {
			ans[i++] = num;
		}
		Arrays.sort(ans);
		return ans;
	}

	private static void genNums(int i, int N, int K, Set<Integer> dataSet) {
		if (dataSet.contains(i))
			return;
		if (N == 1) {
			dataSet.add(i);
			return;
		}
		int digit = (i % 10);

		if (digit + K < 10)
			genNums(i * 10 + digit + K, N - 1, K, dataSet);
		if (digit - K >= 0)
			genNums(i * 10 + digit - K, N - 1, K, dataSet);
	}
}
