import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;

/**
 * @submission : Nithin Bharathi 17-Feb-2024
 *
 *
 */

public class Problem {
	static long MOD = (long)1e9+7;
	static boolean vis[];
	private static int N = (int)1e5;
	static int cnt = 0;
	private static long dp[];
	static int res[];
	static int arr[];

	private static long startTime;
	private static long endTime;
	public static void main(String[] args) throws Exception {
		Template t = new Template();
		int test = t.readInt();
		StringBuilder sb = new StringBuilder();
		while(test-->0) {
			int n = t.readInt();
			char trumpSuit = t.read().charAt(0);
			HashMap<Character,List<Integer>> map = new HashMap<>();
			for(int i = 0;i<2*n;i++) {
				String s = t.read();
				List<Integer> l = map.getOrDefault(s.charAt(1),new ArrayList<>());
				l.add(s.charAt(0)-'0');
				map.put(s.charAt(1), l);
			}
			//System.out.println(map);
			StringBuilder res = new StringBuilder();
			boolean ok = true;
			for(Map.Entry<Character,List<Integer>> mp:map.entrySet()) {
				char key = mp.getKey();
				List<Integer> l = mp.getValue();
				
				if(key == trumpSuit)
					continue;
								
				if(l.size()%2 == 1) {
					List<Integer> trumpSuits = map.getOrDefault(trumpSuit, new ArrayList<>());
					int index = trumpSuits.size()>0?0:-1;					
					
					if(index != -1) {
						res.append(l.get(index)+""+key+" "+trumpSuits.get(index)+trumpSuit+"\n");
						l.remove(index); trumpSuits.remove(index);
						map.put(trumpSuit, trumpSuits);
					}					
				}	
			}
			
			for(Map.Entry<Character,List<Integer>>mp:map.entrySet()) {
				char key = mp.getKey();
				List<Integer> l= mp.getValue();
				Collections.sort(l);
				
				if(l.size()%2 == 0){
					for(int i =0;i<l.size()/2;i++) {
						res.append(l.get(i)+""+key+" "+l.get(l.size()-i-1)+key+"\n");
					}
				}else ok = false;
			}
			sb.append(ok?res:"IMPOSSIBLE\n");
		}
		
		System.out.println(sb);
	}
	
	public static int what(int tar, int num, int m) {
		int l = 0, r = m-1,ans = -1;
		while(l<=r) {
			int mid = (l+r)/2;
			if((mid*num)%m >= tar) {
				ans = mid;
				r = mid-1;
			}else {
				l = mid+1;
			}	
		}
		return ans;
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
