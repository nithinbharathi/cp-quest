import java.util.*;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @submission : Nithin Bharathi 28-May-2023
 *
 *
 */

public class Problem {
	static int N = 200005;
	static boolean vis[][];
	static LinkedHashSet<Integer>graph[];
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		Template t = new Template();		
		//int test = t.readInt();
		Comparator<Pair>cmp = new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return (o1.x-o1.y) - (o2.x-o2.y);
			}
			
		};
		
		int n = t.readInt();
		int m = t.readInt();
		char c[][] = new char[n][m];
		vis  = new boolean[n][m];
		int count = 0;
		for(int i = 0;i<n;i++)c[i] = t.read().toCharArray();
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				//if(vis[i][j])continue;
				if(c[i][j] == '*'){
					int size = go(i,j,n,m,c);
					if(size>0){
						vis[i][j] = true;
						vis(i,j,size);
							sb.append((i+1)+" "+(j+1)+" "+size+"\n");
							count++;

						
					}
				}
			}
		}
		boolean ok = true;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				if(!vis[i][j] && c[i][j] == '*')ok = false;
				
			}
		}
		if(ok){
			System.out.println(count);
			System.out.println(sb);
		}else System.out.println(-1);
		

	}
	public static void vis(int row,int col,int size){
		for(int i = 1;i<=size;i++)vis[row-i][col] = true;
		for(int i = 1;i<=size;i++)vis[row+i][col] = true;
		for(int i = 1;i<=size;i++)vis[row][col+i]  = true;
		for(int i = 1;i<=size;i++)vis[row][col-i]  = true;

	}
	public static int go(int row,int col, int n, int m,char c[][]){
		int u=0,d=0,r=0,l =0;
		for(int i = 1;i<n;i++){
			if(row-i>=0 && c[row-i][col] == '*')u++;
			else break;
		}
		for(int i = 1;i<n;i++){
			if(row+i<n && c[row+i][col] == '*')d++;
			else break;
		}
		
		for(int i = 1;i<m;i++){
			if(col+i<m && c[row][col+i] == '*')r++;
			else break;
		}
		
		for(int i = 1;i<m;i++){
			if(col-i>=0 && c[row][col-i] == '*')l++;
			else break;
		}
		
		return Math.min(Math.min(u, d),Math.min(l, r));
		
	}
	public static boolean ok(ArrayList<Long>l,long s, int n){
		long ans = 0;boolean ok = true;
		for(int i = 0;i<l.size();i++){
			long val = Math.abs(l.get(i) - (i-1>=0?l.get(i-1):1));
			ok&=(val>0);
			ok&=(l.get(i)>=1 && l.get(i)<=n);
			ans+=val;
		}
		return ans == s && ok;
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
		int x,y,ind;
		long lx,ly;
		boolean z;
		public Pair(int a,int y){
			this.x = a;
			this.y = y;
			this.ind = ind;
		}
		public Pair(long a,long y){
			this.lx = a;
			this.ly = y;
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
 
