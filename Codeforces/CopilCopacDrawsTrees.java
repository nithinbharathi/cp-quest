import java.util.*;
import java.util.stream.Collectors;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * 
 * @submission : Nithin Bharathi 010-June-2023
 * 
 */

public class ProblemB {
	static int dp[];
	static int res[];
	static int n,m;
	static int N = 200005;
	static ArrayList<Pair>graph[];
	static boolean vis[];
	static int index[];
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		Template t = new Template();		
		Comparator<Pair>cmp = new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.x-o1.x;
			}
			
		};
		int test = t.readInt();

		while(test-->0){
			int n = t.readInt();
			graph = new ArrayList[n];
			vis = new boolean[n];
			dp = new int[n];dp[0] = 1;
			index = new int[n];
			for(int i = 0;i<n;i++)graph[i] = new ArrayList<>();
			for(int i = 0;i<n-1;i++){
				int a  = t.readInt()-1;
				int b = t.readInt()-1;
				graph[a].add(new Pair(b,i));graph[b].add(new Pair(a,i));
			}
			dfs(0);
			int max = Arrays.stream(dp).max().getAsInt();
			sb.append(max+"\n");
			
		}
		System.out.println(sb);

		

	}
	public static void dfs(int par){
		vis[par]  = true;
		for(Pair p:graph[par]){
			int child = p.x;
			if(!vis[child]){	
				if(index[par]<= p.y || index[par]<=p.y)dp[child] = dp[par];
				else dp[child] =dp[par]+1;
				index[child] = p.y;
				dfs(child);
				
			}
		}
	}
	public static long ncr(long n,long r){
		long nf = 1,rf = 1,nrf=1;
		for(int i=1;i<=n;i++)nf*=i;
		for(int i =1;i<=r;i++)rf*=i;
		for(int i = 1;i<=(n-r);i++)nrf*=i;
		return nf/(rf*(nrf));
	}


	public static int lsearch(ArrayList<Integer>li,int index){
		int l = 0, r = li.size()-1;
		int ind = -1;
		while(l<=r){
			int mid = (l+r)/2;
			if(li.get(mid)>index){
				ind = mid;
				r = mid-1;
			}else l = mid+1;

		}
		return ind;
	}
	public static int rsearch(ArrayList<Integer>li,int index){
		int l = 0, r = li.size()-1;
		int ind = -1;
		while(l<=r){
			int mid = (l+r)/2;
			if(li.get(mid)<index){
				ind = mid;
				l = mid+1;
			}else r = mid-1;

		}
		return ind;
	}

	static class Pair{
		int x,y,ind;
		boolean z;
		public Pair(int x,int y){
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
	}
	 static class Template {
		private  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		private  StringTokenizer st;
		public int last(int a[],int target){
			int ind = -1;
			int l = 0,r = a.length-1;
			while(l<=r){
				int mid = (l+r)/2;
				if(a[mid]<=target){
					ind = mid;l =mid+1;
				}else r = mid-1;
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

		public void swap(int a[], int i, int j) {
			int t = a[i];
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

		public String readLine() throws Exception {
			return br.readLine();
		}

	}



}
 
