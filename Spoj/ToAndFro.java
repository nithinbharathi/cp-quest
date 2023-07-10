import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
			Scanner input = new Scanner(System.in);
		while(true){
			int n = input.nextInt();
			if(n == 0)break;
			input.nextLine();
			String str = input.nextLine();
			int row = str.length()/n;
			char matrix[][] = new char[row][n];
			int start =0;
			for(int i =0;i<row;i++){
				if(i%2 == 0){
					for(int j =0;j<n && start<str.length();j++){
						matrix[i][j] = str.charAt(start++);
					}
				}else{
					for(int j =n-1;j>=0 && start<str.length();j--){
						matrix[i][j] = str.charAt(start++);
					}
				}
			}
			for(int i =0;i<n;i++){
				for(int j =0;j<row;j++){
					System.out.print(matrix[j][i]);
				}
			}
			System.out.println();
		}
		
		input.close();
	}
}
