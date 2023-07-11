import java.util.*;
import java.io.*;

/**
 * @submission : Nithin Bharathi 29-June-2023
 *
 *
 */

public class Problem {
	static int N = 200005,time = 0;
	static boolean vis[];
	static ArrayList<String>l;
	static HashMap<Integer,Long>map;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		Template t = new Template();	
		int test = t.readInt();
		while(test-->0){
			int n = t.readInt();
			long s = t.readInt();
			int a[] = new int[n];
			long pref[] = new long[n];
			for(int i = 0;i<n;i++){
				a[i] = t.readInt();
				pref[i] = a[i];
				if(i-1>=0)pref[i]+=pref[i-1];
			}
			int ans = 0,index = 0;
			if(pref[n-1]>s){				
				for(int i = 0;i<n;i++){
					int ind = go(i,pref,s,a);
					int cur = ind+1;
					if(ind>i)cur-=1;
					if(cur>ans){
						ans = cur;
						index = i+1;
					}
				}				
			}
			sb.append(index+"\n");

		}
		System.out.println(sb);


	}
	public static int go(int ind,long pref[],long s,int a[]){
		int l = 0,r = pref.length-1;
		int index = -1;
		while(l<=r){
			int mid = (l+r)/2;
			if(pref[mid]<=s || (ind<=mid && pref[mid]-a[ind]<=s)){
				index = mid; l = mid+1;
			}else r = mid-1;
		}
		return index;
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

