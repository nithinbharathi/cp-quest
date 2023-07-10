import java.util.*;
import java.lang.*;


/*
The Maximum area is given by a shape that has the most number of sides so in this case circle has infinite number of sides but since the ends have to connected to the wall
it can be a semi circle 

area of a semi cirlce = pi*r*r/2;

perimeter of the semi circle L = pi*r
                             L/pi = r
       Substituting in the area formula we get,
                             area = (pi*L/pi*L/pi)/2
                               A   => L*L/2*pi
        

*/
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
        while(true){
            int n = input.nextInt();
            if(n == 0)break;
            float pi = 3.14159f;
            float result = (n*n)/(2*pi);
            System.out.printf("%.2f\n",result);
            
        }
	}
}
