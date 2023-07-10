/* Bell Triangle
1
1 2
2 3 5
5 7 10 15

The nth bell number is at nth row and 1st column
Time Complexity = O(N*N) in case of queries precomputation takes O(N*N) and queries can be answered in O(1)
Space Complexity = O(N*N)
*/

class BellNumber{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter n to get the nth Bell Number");
	    int n = input.nextInt();
		int dp[][] = new int[n+1][n+1];
		if(n == 1){
		    System.out.println("1");
		    return;
		}
		dp[0][0] = 1;
		for(int i =1;i<=n;i++){
		    dp[i-1][0] = dp[i-1][i-1];  //First column of ith row contains the last element of the previous row
		    for(int j =1;j<=n;i++){
		        dp[i][j] = dp[i-1][j-1]+dp[i][j-1]; // current row element is the sum of previous row previous column element and current row previous column
		    }
		}
		System.out.println(dp[n][0]);
	}
}
