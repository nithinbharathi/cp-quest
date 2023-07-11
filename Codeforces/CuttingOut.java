	import java.util.*;
	import java.io.*;
	
	/**
	 * @submission : Nithin Bharathi 06-June-2023
	 *
	 *
	 */
	
	public class Problem {
		static int N = 200005,time = 0;
		static boolean vis[];
		static ArrayList<Integer>graph[];
		public static void main(String[] args) throws Exception{
			StringBuilder sb = new StringBuilder();
			Template t = new Template();	
			int n = t.readInt();
			int k = t.readInt();
			int a[] = new int[n];
			int count[] = new int[N];
			for(int i = 0;i<n;i++){
				a[i] = t.readInt();
				count[a[i]]++;
			}
			ArrayList<Pair>l = new ArrayList<>();
			ArrayList<Integer>res = new ArrayList<>();
			for(int i =0;i<N;i++){
				if(count[i] == 0)continue;
				l.add(new Pair(i,count[i]));
			}
			Comparator<Pair>cmp = new Comparator<Pair>(){
				public int compare(Pair a,Pair b){
					return a.y - b.y;
				}
			};
			Collections.sort(l,cmp);
			int left = 1,right = N;
			int ans = 1;
			while(left<=right){
				int mid = (left+right)/2;
				if(ok(mid,l,k)){
					ans = mid;
					left = mid+1;
				}else right = mid-1;
			}
			int lz = l.size()-1;
			while(res.size() != k){
				if(lz<0)break;
				int cnt = l.get(lz).y/ans;
				for(int j = 0;j<cnt && res.size()<k;j++){
					res.add(l.get(lz).x);
				}
				lz--;
			}
			for(int it:res)sb.append(it+" ");
			System.out.println(sb);
			
		}
		public static boolean ok(int ans,ArrayList<Pair>l,int k){
			ArrayList<Integer>res = new ArrayList<>();
			int lz = l.size()-1;
			while(res.size() != k){
				if(lz<0)break;
				int cnt = l.get(lz).y/ans;
				for(int j = 0;j<cnt && res.size()<k;j++){
					res.add(l.get(lz).x);
				}
				lz--;
			}
			return res.size() == k;
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
			String a;
			int x,y,sz;
			long lx,ly;
			boolean z;
			public Pair(int a,int y){
				this.x = a;
				this.y = y;
			}
			public Pair(long a,long y){
				this.lx = a;
				this.ly = y;
				this.sz = sz;
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
	 
