import java.util.Scanner;
public class SRP {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int comWin = 0;
        int humWin = 0;

        System.out.println("**********Game Strat**********\n");
        while(comWin <2 && humWin<2)
        {
            int comN = (int)(Math.random()*3);
            System.out.print("scissor(0), rock(1), paper(2):");
            int humN = input.nextInt();
            switch (judge(comN, humN))
            {
                case -1: 
                    System.out.print("please input correct number!");
                    System.out.printf(",(computer:%2d, you:%2d)\n",comWin,humWin);
                    break;
                case 0:
                    comWin++;
                    System.out.printf(",(computer:%2d, you:%2d)\n",comWin,humWin);
                    break;
                case 1:
                    humWin++;
                    System.out.printf(",(computer:%2d, you:%2d)\n",comWin,humWin);
                    break;
                case 2:
                    System.out.printf(",(computer:%2d, you:%2d)\n",comWin,humWin); 
            }

        }
        if(humWin == 2)
            System.out.println("You won!!!!!");
        else
            System.out.println("Computer won...");
        input.close();
    }

    public static void declare(int x,int y)
    {
        switch (x) {
            case 0:
                System.out.print("The computer is scissor. ");
                break;
            case 1:
                System.out.print("The computer is rock. ");
                break;
            case 2:
                System.out.print("The computer is paper. ");
                break;
        }
        switch (y) {
            case 0:
                System.out.print("You are scissor  ");
                break;
            case 1:
                System.out.print("You are rock  ");
                break;
            case 2:
                System.out.print("You are paper  ");
                break;
        }
    }

    public static int judge(int x,int y)
    {
        if(x>2 || y>2 || x<0 || y<0)
        {
            return -1;
        }
        else
        {
            declare(x,y);
            if(x == y)
                return 2;
            if(x == 0 && y == 2)
                return 0;
            else if(y == 0 && x == 2)
                return 1;
            else if(x > y)
                return 0;
            else
                return 1;
            
        }
    }
}