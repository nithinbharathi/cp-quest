import java.util.*;
public class FrogJumping{
    
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n-->0) {
			long a = input.nextInt();
			long b = input.nextInt();
			long c = input.nextInt();
				if(c%2 == 0) {
					System.out.println((a-b)*(c/2));
				}else {
					System.out.println((a-b)*(c/2)+a);
				}
			}
		input.close();
		}
}
