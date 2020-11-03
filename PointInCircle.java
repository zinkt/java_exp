import java.util.Scanner;
public class PointInCircle
{
    public static void main(String[] args)
    {
        final double R = 10.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the two coordinate of your point:");
        double x = input.nextDouble();
        double y = input.nextDouble();
        if(x*x+y*y>R*R)
            System.out.printf("Point(%4.1f, %4.1f) is outside the circle.\n",x,y);
        else if(x*x+y*y<R*R)
            System.out.printf("Point(%4.1f, %4.1f) is in the circle.\n",x,y);
        else
        System.out.printf("Point(%4.1f, %4.1f) is on the circle.\n",x,y);

        input.close(); 
            
    }
}