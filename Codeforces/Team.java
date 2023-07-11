import java.util.Scanner;
public class Team{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a=0,b=0,c=0,count=0;
        for(int i=0;i<n;i++){
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            if(a+b+c>=2){
                count++;
            }
        }
        System.out.print(count);

    }
}
