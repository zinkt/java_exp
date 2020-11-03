import java.util.Scanner;

public class Gomoku {
    public static class Stone { 
        // data
        public final static int WHITE = 0;
        public final static int BLACK = 1;
        private int color;
        // constructor
        public Stone(int color) {this.color = color;}
        // accessor and mutator
        public int getColor() {return color;}
        public void setColor(int color) {this.color = color;}
        // other
        public static String colorToString(int color) {return color == WHITE ? "white" : "black";}
        public char getShape() {return color == WHITE ? '\u25CB' : '\u25CF';}
    }
    public static class Player { 
        // data
        private String name;
        private int color;
        // func
        public Player(String name, int color) {this.name = name;this.color = color;}
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public int getColor() {return color;}
        public void setColor(int color) {this.color = color;}
        public void play(Board board,Scanner input) {
            System.out.printf("Player %s[%s] put a stone at:",this.getName(),Stone.colorToString(color));
            int row = input.nextInt()-1;
            int col = input.nextInt()-1;
            boolean success = board.putAStone(row, col, new Stone(color));
            if(!success)
            {    
                System.out.println("Illegal input!");
                play(board, input);
            }
        }
    }
    
    public static class Board {
            public final static int SIZE = 15;
            private Stone[][] board;
            private int remain = SIZE * SIZE;
            private int whichColorToPlay;
            private int winColor = -1;

            // func
            public Board() {
                board = new Stone[SIZE][SIZE];
                whichColorToPlay = (int) (Math.random() * 2);
            }

            public void printBoard() {
                for(int count = 0;count<=SIZE;count++)
                {
                    if(count==0)
                        System.out.printf("   ");
                    else
                    System.out.printf("%2d ",count);
                }
                System.out.println();
                for(int i = 0;i<SIZE;i++)
                {    
                    for(int j = 0;j<=SIZE;j++)
                    {
                        if(j == 0)
                            System.out.printf("%2d ",i+1);
                        else
                        {
                            if(board[i][j-1]==null)
                                System.out.printf(" + ");
                            else
                                System.out.printf(" %c ",board[i][j-1].getShape());
                        }
                    }
                        System.out.println();
                }
            }
            public boolean putAStone(int row, int col, Stone newStone) {
                if (row < 0 || col < 0 || row >= SIZE || col >= SIZE || (board[row][col] != null))
                    return false;
                else {
                    board[row][col] = newStone;
                    remain--;
                    whichColorToPlay = newStone.getColor() == Stone.WHITE ? Stone.BLACK : Stone.WHITE;
                    winColor = judge(row, col);
                    return true;
                }
            }
            public int judge(int row, int col) {
                String kernel = new String(new char[5]).replace("\0", String.valueOf(board[row][col].getColor()));
                //X
                StringBuffer lineX = new StringBuffer();
                for (int i = 0; i < SIZE; i++) {
                    if (board[row][i] != null)
                        lineX.append(board[row][i].getColor());
                    else
                        lineX.append("N");
                }
                if(lineX.indexOf(kernel)>=0)
                    return board[row][col].getColor();
                //Y
                StringBuffer lineY = new StringBuffer();
                for(int i = 0;i<SIZE;i++){
                    if(board[i][col]!=null)
                        lineY.append(board[i][col].getColor());
                    else
                        lineY.append("N");
                }
                if(lineY.indexOf(kernel)>=0)
                    return board[row][col].getColor();
                //main diagonal
                StringBuffer lineDiagA = new StringBuffer();
                int headRow = row, headCol = col;
                for(;headRow>0&&headCol>0;headRow--,headCol--);
                for (; headRow < SIZE&&headCol<SIZE; headRow++,headCol++) {
                    if (board[headRow][headCol] != null)
                        lineDiagA.append(board[headRow][headCol].getColor());
                    else
                        lineDiagA.append("N");
                }
                if(lineDiagA.indexOf(kernel)>=0)
                    return board[row][col].getColor();
                //back diagonal
                StringBuffer lineDiagB = new StringBuffer();
                headRow = row; headCol = col;
                for(;headRow>0&&headCol<SIZE-1;headRow--,headCol++);
                for (; headRow < SIZE&&headCol>=0; headRow++,headCol--) {
                    if (board[headRow][headCol] != null)
                        lineDiagB.append(board[headRow][headCol].getColor());
                    else
                        lineDiagB.append("N");
                }
                if(lineDiagB.indexOf(kernel)>=0)
                    return board[row][col].getColor();
                //other
                return -1;
            }
            public int getRemain(){return remain;}
            public void setRemain(int remain){this.remain = remain;}
            public int getWhichColorToPlay(){return whichColorToPlay;}
            public int getWinColor(){return winColor;}
            public void setWinColor(int winColor){this.winColor = winColor;}
        }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("**************Welcome to Gomoku Game**************");
        Board gamebBoard = new Board();
        
        System.out.print("Enter player1 name:");
        String player1Name = input.next();
        System.out.print("Enter player2 name:");
        String player2Name = input.next();
        int player1Color = (int)(Math.random()*2);
        int player2Color = Math.abs(player1Color-1);
        Player player1 = new Player(player1Name,player1Color);
        Player player2 = new Player(player2Name,player2Color);
        System.out.printf("Player1[%s, %s] VS Player2[%s, %s]\n",player1.getName(),player1.getColor(),player2.getName(),player2.getColor());
        while(gamebBoard.winColor == -1)
        {
            if(gamebBoard.getWhichColorToPlay() == player1.getColor())
                player1.play(gamebBoard,input);
            else
                player2.play(gamebBoard, input);
            gamebBoard.printBoard();
        }
        if(gamebBoard.getRemain() == 0)
            System.out.println("************Game Draw************");
        else if(gamebBoard.getWinColor() == player1.getColor())
            System.out.printf("Player1 %s[%s] won the game\n",player1.getName(),Stone.colorToString(player1.getColor()));
        else
            System.out.printf("Player2 %s[%s] won the game\n",player2.getName(),Stone.colorToString(player2.getColor()));
        
        input.close();
    } 
}