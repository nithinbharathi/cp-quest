import java.util.*;
public class WayTooLongWords {
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			while(n-->0) {
				String str = input.next();
				if(str.length()>10) {
					char first = str.charAt(0);
					char last = str.charAt(str.length()-1);
					System.out.print(first);
					System.out.print(str.length()-2);
					System.out.print(last);
					System.out.println();
				}else {
					System.out.println(str);
				}
			}
			input.close();
	}	
}
