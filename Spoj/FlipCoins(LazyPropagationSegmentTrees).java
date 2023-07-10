
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int segment_tree[];
    static int arr[];
    static int lazy_tree[];
	public static void main (String[] args) throws java.lang.Exception
	{
	    OutputWriter out = new OutputWriter(System.out);
	    InputReader input = new InputReader(System.in);
	    int n = input.readInt();
	    int q = input.readInt();
	    arr  =new int[n];
	    lazy_tree = new int[4*n];
	    segment_tree  =new int[4*n];
	    build(0,n-1,0);
	    while(q-->0){
	        int t = input.readInt();
	        int ql =input.readInt();
	        int qr = input.readInt();
	        if(t == 1){
	            out.printLine(lazyQuery(ql,qr,0,n-1,0));
	        }else{
	            lazyUpdate(ql,qr,0,n-1,0);
	            
	        }
	        
	    }
	}
	public static void build(int l,int r,int pos){
	    if(l == r){
	        segment_tree[pos] = arr[l];
	        return;
	    }int mid = (l+r)/2;
	    build(l,mid,2*pos+1);
	    build(mid+1,r,2*pos+2);
	    segment_tree[pos] = segment_tree[2*pos+1]+segment_tree[2*pos+2];
	}
	public static int query(int ql,int qr,int l,int r,int pos){
	    if(r<ql || l>qr)return 0;
	    if(l>=ql && r<=qr)return segment_tree[pos];
	    int mid = (l+r)/2;
	    int left = query(ql,qr,l,mid,2*pos+1);
	    int right = query(qr,ql,mid+1,r,2*pos+2);
	    return left+right;
	}
	public static void lazyUpdate(int ql,int qr,int l,int r,int pos){
	    if(l>r)return;
	    if(lazy_tree[pos] != 0){
	        segment_tree[pos]  = r-l+1-segment_tree[pos];
	        if(l != r){
	            lazy_tree[2*pos+1]=1-lazy_tree[2*pos+1];
	            lazy_tree[2*pos+2]=1-lazy_tree[2*pos+2];
	            
	        }
	        lazy_tree[pos] = 0;
	    }
	    if(r<ql || qr<l)return;
	    if(l>=ql && r<=qr){
	        segment_tree[pos] = r-l+1-segment_tree[pos];
	        if(l != r){
	            lazy_tree[2*pos+1]=1- lazy_tree[2*pos+1];
	            lazy_tree[2*pos+2]=1-lazy_tree[2*pos+2];
	        }
	        return;
	    }
	    int mid = (l+r)/2;
	    lazyUpdate(ql,qr,l,mid,2*pos+1);
	    lazyUpdate(ql,qr,mid+1,r,2*pos+2);
	    segment_tree[pos] = segment_tree[2*pos+1]+segment_tree[2*pos+2];
	   
	}
	public static int lazyQuery(int ql,int qr,int l,int r,int pos){
	    if(l>r)return 0;
	    if(lazy_tree[pos]!= 0){
	        segment_tree[pos] = (r-l+1 - segment_tree[pos]);
	        if(l != r){
	            lazy_tree[2*pos+1]=1-lazy_tree[2*pos+1];
	            lazy_tree[2*pos+2]=1-lazy_tree[2*pos+2];
	        }
	        lazy_tree[pos] = 0;
	    }
	    if(r<ql || qr<l)return  0;
	    if(l>=ql && r<=qr)return segment_tree[pos];
	    int mid = (l+r)/2;
	    int left = lazyQuery(ql,qr,l,mid,2*pos+1);
	    int right = lazyQuery(ql,qr,mid+1,r,2*pos+2);
	    return left+right;
	    
	}
	
}
class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		
		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		
		public String next() {
			return readString();
		}
		
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	
class OutputWriter {
		private final PrintWriter writer;
		
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
