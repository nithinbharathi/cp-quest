import java.io.*;
public class DisturbedPeople{
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String houses[] = br.readLine().trim().split(" ");
		int min =0;
		for(int i =0;i<n-1;i++) {
			if(i>0 && houses[i].equals("0") && houses[i-1].equals("1") && houses[i+1].equals("1")) {
				houses[i+1] = "0";
				min++;
			}
		}
		System.out.println(min);
		
	}
	
}
