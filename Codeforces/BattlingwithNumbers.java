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
			int lcmn = t.readInt();
			HashMap<Integer,Integer>lcm = new HashMap<>();
			HashMap<Integer,Integer>gcd = new HashMap<>();
			int a[] = new int[lcmn];
			for(int i = 0;i<lcmn;i++)a[i] = t.readInt();
			for(int i = 0;i<lcmn;i++) {
				lcm.put(a[i],t.readInt());
			}
			int gcdn = t.readInt();
			int b[] = new int[gcdn];
			for(int i = 0;i<gcdn;i++)b[i] = t.readInt();
			for(int i = 0;i<gcdn;i++) {
				gcd.put(b[i],t.readInt());
			}
			boolean ok = true;
			long ans = 0;
			int cnt = 0;
			for(Map.Entry<Integer,Integer>mp:gcd.entrySet()) {
				int key = mp.getKey();
				int val = mp.getValue();
				if(!lcm.containsKey(key) || lcm.get(key)<val)ok = false;
			}
			if(ok) {
				for(Map.Entry<Integer,Integer>mp:lcm.entrySet()) {
					int key = mp.getKey();
					int val = mp.getValue();
					if(!gcd.containsKey(key) || val>gcd.get(key))cnt++;
				}
				ans = pow(cnt);
			}

			
			sb.append(ans);
			sb.append("\n");

		System.out.println(sb);
	}

	private static long pow(int n) {
		if(n == 0)return 1;
		if(n == 1) return 2;
		if(n%2 == 0) {
			long ans = pow(n/2);
			return (ans*ans)%MOD;
		}
		return (2*pow(n-1))%MOD;
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
