	import java.util.*;
	import java.io.*;
	
	public class Problem {
		private static Template t;
	
		public static void main(String[] args) {
			t = new Template();
			int test = t.readInt();
			StringBuilder sb = new StringBuilder();
			while(test-->0) {
				int l1 = t.readInt();
				int r1 = t.readInt();
				int l2 = t.readInt();
				int r2 = t.readInt();
				int min = Math.min(l1, l2);
				int mx = Math.max(r1, r2);
				int x = Math.max(l1, l2);
				int y = Math.min(r1, r2);
				int ans = 1;
				if(x<=y) {
					ans = y-x;
					if(min<x)ans++;
					if(mx>y)ans++;
				}
				sb.append(ans+"\n");
				
			}	
						
			System.out.println(sb);
		}
		public static int left(ArrayList<Integer>ls, int index) {
			int ind = -1;
			int l = 0, r = ls.size()-1;
			while(l<=r) {
				int mid = (l+r)>>1;
				if(ls.get(mid)<=index) {
					ind = mid;
					l = mid+1;
				}else
					r = mid-1;
					
			}
			return ind;
		}
		
		public static int right(ArrayList<Integer>rs, int index) {
			int ind = -1;
			int l = 0, r = rs.size()-1;
			while(l<=r) {
				int mid = (l+r)>>1;
				if(rs.get(mid)>=index) {
					ind = mid;
					r = mid-1;
				}else
					l = mid+1;
					
			}
			return ind;
		}
		
		static class Pair{
			int x,y;
			Pair(int x, int y){
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
			
			public void sort(char arr[]) {
				ArrayList<Character> list = new ArrayList<>();
				for (char it : arr)
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
