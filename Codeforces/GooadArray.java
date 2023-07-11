import java.util.*;
import java.io.*;
public class GoodArray{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line[] = br.readLine().split(" ");
		long sum  = 0;
		long result[] = new long[n];
		int count =0;
		HashMap<Long,Integer>map = new HashMap<>();
		for(String s:line) {
			map.put(Long.parseLong(s),map.getOrDefault(Long.parseLong(s),0)+1);
			sum += Long.parseLong(s);
			
		}
		
		//System.out.println(sum);
		for(int i =0;i<n;i++) {
			long k = sum-Integer.parseInt(line[i]);
			map.put(Long.parseLong(line[i]), map.get(Long.parseLong(line[i]))-1);
			if(k%2 == 0){
				k = k/2;
				if(map.containsKey(k)) {
					if(map.get((k))>0){
					result[count] = i+1;
					count++;						
					}
				}
			}
			map.put(Long.parseLong(line[i]), map.get(Long.parseLong(line[i]))+1);

		}
		System.out.println(count);
		for(int i =0;i<count;i++) {
			System.out.print(result[i]+" ");
		}
		
		
		
	}
}
