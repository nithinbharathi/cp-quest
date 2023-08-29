import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.*;

/**
 * @submission : Nithin Bharathi 29-Aug-2023
 *
 *
 */

public class Problem{
	static long MOD = 998244353;
	static int dp[][];
	static int result[];
	static boolean vis[];
	static ArrayList<Integer> graph[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Template t = new Template();
		int test = t.readInt();
		ArrayList<Integer>l[] = new ArrayList[test];
		ArrayList<Integer>list = new ArrayList<>();
		for(int i = 0;i<test;i++)l[i] = new ArrayList<>();
		for(int i = 0;i<test;i++) {
			int n = t.readInt();
			for(int j =0;j<n;j++) {
				int val = t.readInt();
				l[i].add(val);
				list.add(val);
			}
		}
		Collections.sort(list);
		int split = 0,blk = test;
		TreeMap<Integer,Integer>map = new TreeMap<>();
		for(int i = 0;i<list.size();i++) {
			map.put(list.get(i),i);
		}
		for(int i = 0;i<test;i++) {
			for(int j = 1;j<l[i].size();j++) {
				int ind1 = map.get(l[i].get(j-1));
				int ind2 = map.get(l[i].get(j));
				if(ind2<ind1 || ind2-ind1>1)split++;
			}
		}
		blk+=split;
		sb.append(split+" "+(blk-1)+"\n");
		System.out.println(sb);	


	}
	public static boolean check(long n, long m) {
		for(long i = 2;i<=m && i*i<=n;i++) {
			if(n%i == 0)return true;
		}
		return false;
	}

	public static int lsearch(ArrayList<Integer> li, int index) {
		int l = 0, r = li.size() - 1;
		int ind = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (li.get(mid) > index) {
				ind = mid;
				r = mid - 1;
			} else
				l = mid + 1;

		}
		return ind;
	}

	public static int rsearch(ArrayList<Integer> li, int index) {
		int l = 0, r = li.size() - 1;
		int ind = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (li.get(mid) < index) {
				ind = mid;
				l = mid + 1;
			} else
				r = mid - 1;

		}
		return ind;
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
