import java.util.*;
import java.io.*;

/**
 * @submission : Nithin Bharathi 23-Sept-2023
 *
 *
 */

public class ProblemB {
	static long MOD = (long)1e9+7;
	static boolean vis[];
	private static int N = (int)1e5;
	static int cnt = 0;
	private static long dp[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Template t = new Template();
		int test = t.readInt();
		while(test-->0) {
			int n = t.readInt();
			int a[] = new int[n];
			int b[] = new int[n];
			
			ArrayList<Pair>l = new ArrayList<>();
			
			for(int i = 0;i<n;i++) {
				a[i] = t.readInt();
			}
			for(int i = 0;i<n;i++) {
				b[i] = t.readInt();
			}
			
			for(int i = 0;i<n;i++)l.add(new Pair(a[i]+b[i],i));
			
			Collections.sort(l,(x,y)->x.x-y.x);
			
			long ans = 0;
			byte bit = 0;
			for(int i = n-1;i>=0;i--) {
				if(bit == 0)ans+=(a[l.get(i).y]-1);
				else ans-=(b[l.get(i).y]-1);
				
				bit^=1;
			}
			sb.append(ans+"\n");
		}
			
		System.out.println(sb);
	}
	
	private static int search(ArrayList<Long>li,long key) {
		int l = 0, h = li.size()-1,ind = li.size()-1;
		
		while(l<=h) {
			int mid = (l+h)>>1;
			
			if(li.get(mid)>=key) {
				ind = mid;
				h = mid-1;
			}else l = mid+1;
		}
		
		return ind;
	}
	
	private static long go(int ind, int groups, int a[]) {
		if(ind>=a.length)
			return 0;
		//if(dp[groups] != Integer.MIN_VALUE)
			//return dp[groups];
		
		System.out.println(ind+" "+groups);
		long first = (a[ind]*groups)+go(ind+1,groups,a);
		long second = ind-1>=0 ?(a[ind]*(groups+1))+go(ind+1,groups+1,a):0;
		
		return dp[groups] = Math.max(first,second);
	}
	
	public static int lowerBound(ArrayList<Integer>li,int tar) {
		int l  =0;
		int r = li.size()-1;
		int ind = -1;
		while(l<=r) {
			int mid = (l+r)>>1;
			if(li.get(mid)>=tar) {
				ind = mid;
				r = mid-1;
			}else l = mid+1;
		}
		return ind;
	}
	
	public static int upperBound(ArrayList<Integer>li,int tar) {
		int l  =0;
		int r = li.size()-1;
		int ind = -1;
		while(l<=r) {
			int mid = (l+r)>>1;
			if(li.get(mid)<=tar) {
				ind = mid;
				l = mid+1;
			}else r = mid-1;
		}
		return ind;
	}

	static class Pair {
		int x,y,z;
		public Pair() {
			
		}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return x == other.x && y == other.y;
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
