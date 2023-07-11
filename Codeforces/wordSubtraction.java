import java.util.Scanner;
public class WordSubtraction{
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int i =0;
		input.close();
		while(i<k) {
			if(n%10 >0) {
				n--;
			}else {
				n/=10;
			}
			i++;
		}
		System.out.println(n);
		
	}

}
