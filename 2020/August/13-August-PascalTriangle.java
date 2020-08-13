/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/
class PascalTriangle {
	public List<Integer> getRow(int rowIndex) {
		int n = rowIndex + 1;
		int[][] arr = new int[n][n];

		List<Integer> dataList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {

				if (i == j || j == 0)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

				if (i == (n - 1))
					dataList.add(arr[i][j]);
			}
		}
		return dataList;
	}
}
