package exp5;

import java.util.InputMismatchException;
import java.util.Scanner;
public class InputMissmatch {
    public static void main(String[] args)
    {
        sumTwoIntegers();
    }

    private static void sumTwoIntegers()
    {
        
        Scanner input = null;
        try 
        {
            input = new Scanner(System.in);
            System.out.print("Input the 1st integer: ");
            int a = input.nextInt();
            System.out.print("Input the 2nd integer: ");
            int b = input.nextInt();
            System.out.printf("The sum of %d and %d is %d",a,b,a+b);
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Input is not match the integer type, please enter again");
            sumTwoIntegers();
        }
        finally
        {
            input.close();
        }
    }
    
}