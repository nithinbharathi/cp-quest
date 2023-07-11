
import java.io.*;
public class PetyaandStrings{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String a = br.readLine();
      String b = br.readLine();
      String n1 = a.toLowerCase();
      String n2 = b.toLowerCase();
      if(n1.compareTo(n2)>0) {
    	  System.out.println("1");
      }else if(n1.compareTo(n2)<0) {
    	  System.out.println("-1");
      }else {
    	  System.out.println("0");
      }

	}

}
