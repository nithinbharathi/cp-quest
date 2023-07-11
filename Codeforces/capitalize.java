import java.util.*;
public class capitalize{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.print(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
    }
}
