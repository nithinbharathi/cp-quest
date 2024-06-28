	import java.util.*;
	import java.io.*;
	
	public class Problem {
		private static Template t;
	
		public static void main(String[] args) {
			t = new Template();
			int test = t.readInt();
			StringBuilder sb = new StringBuilder();
			
			while(test-->0) {
				int n = t.readInt();
				int k = t.readInt();
				
				int a[] = new int[n];
				HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
				for(int i = 0;i<n;i++) {
					a[i] = t.readInt();
					int rem = a[i]%k;
					
					ArrayList<Integer>l = map.getOrDefault(rem, new ArrayList<>());
					l.add(a[i]);
					map.put(rem, l);
				
				}
				
				
				long ans = 0;
				boolean ok = true;
				int cnt = 0;
				
				for(Map.Entry<Integer, ArrayList<Integer>> mp:map.entrySet()) {
					if(mp.getValue().size()%2 == 1)
						cnt++;					
					if(cnt>1)
						ok = false;
					if(ok) {
						ArrayList<Integer>l = mp.getValue();
						Collections.sort(l);
						
						int N = mp.getValue().size();
						if(N%2 == 1) {
							long suf[] = new long[N];
							for(int i = N-2;i>=0;i-=2) {
								suf[i] = (l.get(i+1) - l.get(i))/k;
								if(i+2<N)suf[i]+=suf[i+2];
							}
							long cur = Long.MAX_VALUE;
							long pref = 0;
							for(int i = 0;i<N;i+=2) {
								cur = Math.min(cur, pref+(i+1<N?suf[i+1]:0));
								if(i+1<N)
									pref+= (l.get(i+1) - l.get(i))/k;
							}
							ans+=cur;
						}else {
							for(int i = 0;i<l.size()-1;i+=2) {
								ans+= (l.get(i+1) - l.get(i))/k;
							}
						}
					}
				}
				
				
				sb.append(ok?ans:-1);
				
				sb.append("\n");

			}
			
			System.out.println(sb);
		}
		
		public static void go(char c[], int ind, char sign, long cur) {
			
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
