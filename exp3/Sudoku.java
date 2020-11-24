package exp3;

import java.util.Scanner;
public class Sudoku
{
    public static void printSudo(int[][] sudo)
    {
        for(int i = 0;i<9;i++)
        {   
            for(int j = 0;j<9;j++)
            {
                System.out.print(' ');
                System.out.print(sudo[i][j]);
                System.out.print(' ');
                if(j%3 == 2)
                System.out.print('|');
            }
            System.out.println();
            if(i%3 == 2)
                System.out.println("-- --- --|-- --- --|-- --- --|");
        }       
    
    }

    public static boolean isValid(int r,int c,int n,int[][] sudo)
    {
        //check row
        for(int column = 0;column<9;column++)
            if(sudo[r][column] == n)
                return false;
        //check column
        for(int row = 0;row<9;row++)
            if(sudo[row][c] == n)
                return false;
        //check 3x3 box
        for(int row = r/3*3,i = 0;i<3;i++)
            for(int column = c/3*3,j = 0;j<3;j++)
                if(sudo[row+i][column+j] == n)
                    return false;
        return true;
    }
    public static int getRemain(int[][] sudo)
    {
        int remain = 0;
        for(int i = 0;i<9;i++)
            for(int j = 0;j<9;j++)
                if(sudo[i][j] == 0)
                    remain++;
        return remain;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[][] sudo = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,0,0,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}};
        int remain = getRemain(sudo);
        printSudo(sudo);
        while (remain>0) 
        {
            System.out.println("Enter row, column and number([1-9] [1-9] [1-9]):");
            int r = input.nextInt()-1;
            int c = input.nextInt()-1;
            int n = input.nextInt();
            if(r<0 || r>8 || c<0 || c>8)
            {
                System.out.println("Out of range");
                printSudo(sudo);
            }
            else
            {   
                if(sudo[r][c]!=0)            
                {System.out.println("The cell is not empty!");printSudo(sudo);}
                else
                {
                    if(isValid(r, c, n, sudo))
                    {
                        sudo[r][c] = n;
                        remain--;
                        System.out.println("The current state of gird:");
                        printSudo(sudo);
                    }
                    else
                    {
                        System.out.println("The number is irrational");
                        printSudo(sudo);
                    }
                }
            }
        }
        System.out.println("Game complete!");
        printSudo(sudo);
        input.close();
    }
}