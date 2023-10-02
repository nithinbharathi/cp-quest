import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.*;

/**
 * @submission : Nithin Bharathi 06-Sept-2023
 *
 *
 */

public class Problem{
	static int MOD = 998244353;
	static long fact[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Template t = new Template();
		int test = t.readInt();
		while(test-->0) {
			int n = t.readInt();
			int m = t.readInt();
			char c[][] = new char[n][m];
			for(int i =0;i<n;i++)c[i] = t.read().toCharArray();
			boolean ok = true;
			for(int i =0;i<n;i++) {
				int cnt = 0;
				for(int j = 0;j<m;j++) {
					if(c[i][j] == 'U') {
						cnt++;
					}
				}
				if(cnt%2 == 1)ok = false;
				cnt = 0;
				for(int j =0;j<m;j++) {
					if(c[i][j] == 'U') {
						if(cnt%2 == 0) {
							c[i][j] = 'B';
							c[i+1][j] = 'W';
						}else {
							c[i][j] = 'W';
							c[i+1][j] ='B';
						}
						cnt++;
					}
				}
			}
			for(int i =0;i<m;i++) {
				int cnt = 0;
				for(int j = 0;j<n;j++) {
					if(c[j][i] == 'L') {
						cnt++;
					}
				}
				if(cnt%2 == 1)ok = false;
				cnt = 0;
				for(int j =0;j<n;j++) {
					if(c[j][i] == 'L') {
						if(cnt%2 == 0) {
							c[j][i] = 'B';
							c[j][i+1] = 'W';
						}else {
							c[j][i] = 'W';
							c[j][i+1] ='B';
						}
						cnt++;
					}
				}
			}

			if(ok) {
				for(int i = 0;i<n;i++) {
					for(char it:c[i])sb.append(it);
					sb.append("\n");
				}
			}else sb.append(-1+"\n");

		}
		System.out.println(sb);
	}


	static class Pair {
		int x,y;

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
