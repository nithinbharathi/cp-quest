
import java.util.*;
import java.io.*;

public class Problem {
static int ans = Integer.MAX_VALUE;
static int dp[][];
static int recur = 0;
	public static void main(String[] args) throws Exception {
		Template t = new Template();
		int test = t.readInt();
		StringBuilder sb = new StringBuilder();

		while(test-->0) {
			int n = t.readInt();
			int cnt[] = new int[n+1];

			for(int i = 0;i<n;i++) {
				int val = t.readInt();
				cnt[val]++;
			}
			
			int unique = 0,dup = 0;
			
			for(int i = 0;i<=n;i++) {
				if(cnt[i]>0) {
					if(cnt[i] == 1)unique++;
					else dup++;
				}
			}
			
			int ans = unique/2;
			if(unique%2 == 1)ans++;
			ans*=2;
			
			ans += dup;
			
			sb.append(ans+"\n");
			
		}
		
		System.out.println(sb);

		
	}
	
	private static int solve(int a[][], int n, int m, int row, int col1, int col2) {	
		int dp[][][] = new int[n][m][m];
		
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<m;j++) {
				int sum = a[n-1][i] + a[n-1][j];
				if(i == j)
					sum-= a[n-1][i];
				
				dp[n-1][i][j] = sum;
			}
		}
		
		for(int i = n-2;i>=0;i--) {
			for(int j1 = 0;j1<m;j1++) {
				for(int j2 = 0; j2<m;j2++) {
					int curr = a[i][j1]  + a[i][j2];
					if(j1 == j2)
						curr -= a[i][j1];
					int mx = Integer.MIN_VALUE;
					for(int j = -1;j<=1;j++) {
						for(int k = -1;k<=1;k++) {
							if(j1+j<0 || j1+j>=m || j2+k<0 || j2+k>=m) continue;
							mx = Math.max(curr+dp[i+1][j1+j][j2+k], mx);
						}
					}
					
					dp[i][j1][j2] = mx;
				}
			}
		}
		
		return dp[0][0][m-1]; 
		
		
	}
	
	public static int get(int i, int j, int a[]) {
		int cnt = 0;
		
		if(i-1>=0 && a[i] == a[i-1])cnt++;
		if(i+1<a.length && a[i] == a[i+1])cnt++;
		if(j-1>=0 && a[j] == a[j-1])cnt++;
		if(j+1<a.length && a[j] == a[j+1])cnt++;
		
		return cnt;
		
	}
	
	public static void go(int a[][], int n ,int m) {
		
		dp = new int[n][m];
		
		for(int i = 0;i<m;i++)
			dp[n-1][i] = a[n-1][i];
		
		for(int i = n-2;i>=0;i--) {
			for(int j = 0;j<m;j++) {			

				dp[i][j] = a[i][j]+dp[i+1][j];
				if(j-1>=0)
					dp[i][j] = Math.max(dp[i][j], a[i][j] + dp[i+1][j-1]);
				
				if(j+1<m)
					dp[i][j] = Math.max(a[i][j]+dp[i+1][j+1],dp[i][j]);
			
			}
		}

	}
	
	public static void print(int a[], ArrayList<Integer>l, int ind) {
		if(ind>=a.length) {
			System.out.println(l);
			return;
		}
		l.add(a[ind]);
		print(a,l,ind+1);
		l.remove(l.size()-1);
		print(a,l,ind+1);
	}
		
	static class runnable implements Runnable{
		public int count = 0;
		@Override
		public void run() {
			for(int i = 0;i<10000;i++) {
				count++;
			}
			
			System.out.println("Execued by "+Thread.currentThread().getName()+" count: "+count);

		}	
		
		public int getCount() {
			return count;
		}
	}
	
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Template {
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		private StringTokenizer st;

		public int last(int a[], int target) {
			int ind = -1;
			int l = 0, r = a.length - 1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (a[mid] <= target) {
					ind = mid;
					l = mid + 1;
				} else
					r = mid - 1;
			}
			return ind;
		}

		public boolean isSorted(int a[]) {
			for (int i = 0; i < a.length; i++) {
				if (i + 1 < a.length && a[i] > a[i + 1])
					return false;
			}
			return true;
		}

		public boolean isPrime(int n) {
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}

		public long factorial(int n) {
			long fac = 1;
			for (int i = 1; i <= n; i++)
				fac *= i;
			return fac;
		}

		public ArrayList<Integer> factors(int n) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i = 1; i * i <= n; i++) {
				if (n % i == 0) {
					l.add(i);
					if (n / i != i)
						l.add(n / i);
				}

			}
			return l;
		}

		public void build(int seg[], int ind, int l, int r, int a[]) {
			if (l == r) {
				seg[ind] = a[l];
				return;
			}
			int mid = (l + r) / 2;
			build(seg, (2 * ind) + 1, l, mid, a);
			build(seg, (2 * ind) + 2, mid + 1, r, a);
			seg[ind] = Math.min(seg[(2 * ind) + 1], seg[(2 * ind) + 2]);
		}

		public long gcd(long a, long b) {
			return b == 0 ? a : gcd(b, a % b);
		}

		public int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}

		public void swap(int a[], int i, int j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		public void swap(char a[], int i, int j) {
			char t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		public void swap(ArrayList<Integer> l, int i, int j) {
			int t = l.get(i);
			l.set(i, l.get(j));
			l.set(j, t);
		}

		public void sort(int arr[]) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int it : arr)
				list.add(it);
			Collections.sort(list);
			int z = 0;
			for (int i = 0; i < arr.length; i++)
				arr[z++] = list.get(i);
		}

		public void sort(long arr[]) {
			ArrayList<Long> list = new ArrayList<>();
			for (long it : arr)
				list.add(it);
			Collections.sort(list);
			int z = 0;
			for (int i = 0; i < arr.length; i++)
				arr[z++] = list.get(i);
		}

		public String read() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int readInt() {
			return Integer.parseInt(read());
		}

		public long readLong() {
			return Long.parseLong(read());
		}

		public double readDouble() {
			return Double.parseDouble(read());
		}

	}

}
