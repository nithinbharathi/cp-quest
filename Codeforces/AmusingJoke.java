import java.io.*;
import java.util.HashMap;
public class AmusingJoke{
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine().toLowerCase();
		String b = br.readLine().toLowerCase();
		String c = br.readLine().toLowerCase();
		
		int cache[] = new int[256];
		for(int i = 0;i<a.length();i++) {
			cache[a.charAt(i)]++;
		}
		for(int i = 0;i<b.length();i++) {
			cache[b.charAt(i)]++;
		}
		for(int i = 0;i<c.length();i++) {
			if(cache[c.charAt(i)]==0) {
				System.out.println("NO");
				return;
			}
			cache[c.charAt(i)]--;
		}
		for(int i =1;i<cache.length;i++) {
			if(cache[i]>0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}
}
